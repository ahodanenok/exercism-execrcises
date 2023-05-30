#include "grains.h"

#define SQUARE_MIN 1
#define SQUARE_MAX 64

/**
 * Grains
 * https://exercism.org/tracks/c/exercises/grains
 */

uint64_t square(uint8_t index)
{
    if (index < SQUARE_MIN || index > SQUARE_MAX) {
        return 0;
    }

    uint64_t res = 1;
    for (int i = SQUARE_MIN; i < index; i++) {
        res *= 2;
    }

    return res;
}

uint64_t total(void)
{
    uint64_t res = 0;
    uint64_t n = 1;
    for (int i = SQUARE_MIN; i <= SQUARE_MAX; i++) {
        res += n;
        n *= 2;
    }

    return res;
}
