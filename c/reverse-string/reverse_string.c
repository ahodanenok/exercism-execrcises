#include <stdlib.h>
#include <string.h>
#include "reverse_string.h"

/**
 * Reverse String
 * https://exercism.org/tracks/c/exercises/reverse-string
 */

char *reverse(const char *value)
{
    char *res;
    size_t len;

    len = strlen(value);
    res = malloc(len + 1);
    for (size_t i = 0, mid = (len + 1) / 2; i < mid; i++) {
        res[len - i - 1] = value[i];
        res[i] = value[len - i - 1];
    }
    res[len] = '\0';

    return res;
}
