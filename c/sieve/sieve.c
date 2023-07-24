#include "sieve.h"

/**
 * Sieve
 * https://exercism.org/tracks/c/exercises/sieve
 */

uint32_t sieve(uint32_t limit, uint32_t *primes, size_t max_primes)
{
    size_t count = 0;
    size_t n, k;
    uint32_t range[limit];

    for (n = 2; n <= limit; n++) {
        range[n - 1] = 0;
    }

    for (n = 2; n <= limit && count < max_primes; n++) {
        if (range[n - 1]) {
            continue;
        }

        for (k = n; k <= limit; k += n) {
            range[k - 1] = 1;
        }

        primes[count] = n;
        count++;
    }

    return count;
}
