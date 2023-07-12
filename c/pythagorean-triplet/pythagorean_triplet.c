#include <stdlib.h>
#include "pythagorean_triplet.h"

#define MAX_TRIPLETS 10

/**
 * Pythagorean Triplet
 * https://exercism.org/tracks/c/exercises/pythagorean-triplet
 **/

triplets_t *triplets_with_sum(uint16_t sum)
{
    uint16_t a, b, c;
    triplet_t *t;

    triplets_t *res = malloc(sizeof(triplets_t) + MAX_TRIPLETS * sizeof(triplet_t));
    res->count = 0;
    for (a = 1; a < sum; a++) {
        for (b = a + 1; b < sum; b++) {
            c = sum - a - b;
            if (a * a + b * b == c * c) {
                t = &res->triplets[res->count];
                t->a = a;
                t->b = b;
                t->c = c;

                res->count++;
            }
        }
    }

    return res;
}

void free_triplets(triplets_t *triplets)
{
    free(triplets);
}
