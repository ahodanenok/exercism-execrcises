#include <math.h>
#include <stdlib.h>
#include "rational_numbers.h"

/**
 * Rational Numbers
 * https://exercism.org/tracks/c/exercises/rational-numbers
 */

rational_t add(rational_t a, rational_t b)
{
    rational_t res = {
        a.numerator * b.denominator + b.numerator * a.denominator,
        a.denominator * b.denominator
    };

    return reduce(res);
}

rational_t subtract(rational_t a, rational_t b)
{
    rational_t res = {
        a.numerator * b.denominator - b.numerator * a.denominator,
        a.denominator * b.denominator
    };

    return reduce(res);
}

rational_t multiply(rational_t a, rational_t b)
{
    rational_t res = {
        a.numerator * b.numerator,
        a.denominator * b.denominator
    };

    return reduce(res);
}

rational_t divide(rational_t a, rational_t b)
{
    rational_t res = {
        a.numerator * b.denominator,
        a.denominator * b.numerator
    };

    return reduce(res);
}

rational_t absolute(rational_t r)
{
    rational_t res = { abs(r.numerator), abs(r.denominator) };
    return reduce(res);
}

static int16_t gcd(int16_t p, int16_t q)
{
    int16_t r = p % q;
    if (r == 0) {
        return q;
    }

    return gcd(q, r);
}

rational_t reduce(rational_t r)
{
    int16_t p, q, d;

    if (r.numerator == 0) {
        rational_t res = r;
        res.denominator = 1;
        return res;
    }

    p = abs(r.numerator);
    q = abs(r.denominator);
    if (p > q) {
        d = gcd(p, q);
    } else {
        d = gcd(q, p);
    }

    if (d < 0) {
        exit(-1);
    }

    rational_t res = r;
    res.numerator /= d;
    res.denominator /= d;
    if (res.denominator < 0) {
        res.numerator *= -1;
        res.denominator *= -1;
    }

    return res;
}

rational_t exp_rational(rational_t r, int16_t exp)
{
    rational_t res = {
        pow(r.numerator, abs(exp)),
        pow(r.denominator, abs(exp))
    };

    if (exp < 0) {
        int16_t tmp = res.numerator;
        res.numerator = res.denominator;
        res.denominator = tmp;
    }

    return reduce(res);
}

static float root(float a, float n)
{
    float delta;
    float x = 1.0;
    while (1) {
        x = x * (n - 1) / n + a / (n * pow(x, n - 1));
        delta = a - pow(x, n);
        if (delta < 0) {
            delta *= -1;
        }
        if (delta < 0.000001) {
            break;
        }
    }

    return x;
}

float exp_real(float n, rational_t exp)
{
    return root(pow(n, exp.numerator), exp.denominator);
}
