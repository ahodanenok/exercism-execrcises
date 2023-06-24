#ifndef RATIONAL_NUMBERS_H
#define RATIONAL_NUMBERS_H

#include <stdint.h>

typedef struct {
    int16_t numerator;
    int16_t denominator;
} rational_t;

rational_t add(rational_t a, rational_t b);
rational_t subtract(rational_t a, rational_t b);
rational_t multiply(rational_t a, rational_t b);
rational_t divide(rational_t a, rational_t b);
rational_t absolute(rational_t r);
rational_t reduce(rational_t r);
rational_t exp_rational(rational_t r, int16_t exp);
float exp_real(float n, rational_t exp);

#endif
