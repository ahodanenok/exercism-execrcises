#include <stdlib.h>
#include <errno.h>
#include "circular_buffer.h"

/**
 * Circular Buffer
 * https://exercism.org/tracks/c/exercises/circular-buffer
 */

#define READPOS_NODATA  ((size_t) -1)
#define WRITEPOS_NODATA ((size_t)  0)

extern int errno;

static void move_readpos(circular_buffer_t *buf)
{
    buf->readpos = (buf->readpos + 1) % buf->capacity;
}

static void move_writepos(circular_buffer_t *buf)
{
    buf->writepos = (buf->writepos + 1) % buf->capacity;
}

circular_buffer_t *new_circular_buffer(size_t capacity)
{
    circular_buffer_t *buf = malloc(
        sizeof(circular_buffer_t) + capacity * sizeof(buffer_value_t));
    if (buf == NULL) {
        return NULL;
    }

    buf->readpos = READPOS_NODATA;
    buf->writepos = WRITEPOS_NODATA;
    buf->capacity = capacity;
    buf->values = (buffer_value_t *) ((char *) buf + sizeof(circular_buffer_t));

    return buf;
}

void clear_buffer(circular_buffer_t *buf)
{
    buf->readpos = READPOS_NODATA;
    buf->writepos = WRITEPOS_NODATA;
}

void delete_buffer(circular_buffer_t *buf)
{
    clear_buffer(buf);
    free(buf);
}

int16_t read(circular_buffer_t *buf, buffer_value_t *value)
{
    if (buf->readpos == READPOS_NODATA) {
        errno = ENODATA;
        return EXIT_FAILURE;
    }

    *value = buf->values[buf->readpos];
    move_readpos(buf);
    if (buf->readpos == buf->writepos) {
        buf->readpos = READPOS_NODATA;
    }

    return EXIT_SUCCESS;
}

int16_t write(circular_buffer_t *buf, buffer_value_t value)
{
    if (buf->writepos == buf->readpos) {
        errno = ENOBUFS;
        return EXIT_FAILURE;
    }

    overwrite(buf, value);

    return EXIT_SUCCESS;
}

int16_t overwrite(circular_buffer_t *buf, buffer_value_t value)
{
    buf->values[buf->writepos] = value;
    if (buf->readpos == READPOS_NODATA) {
        buf->readpos = buf->writepos;
    } else if (buf->writepos == buf->readpos) {
        move_readpos(buf);
    }
    move_writepos(buf);

    return EXIT_SUCCESS;
}
