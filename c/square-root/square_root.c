#include "square_root.h"

/**
 * Square Root
 * https://exercism.org/tracks/c/exercises/square-root
 */
unsigned int square_root(unsigned int n)
{
    unsigned int x = n / 2 + 1;
    while (n / x < x) {
        x = (x + n / x) / 2;
    }

    if (x * x != n) {
        return -1;
    }

    return x;
}
