#include <math.h>
#include "armstrong_numbers.h"

bool is_armstrong_number(int candidate)
{
    int sum = 0;
    int count = 0;
    int n;

    for (n = candidate; n > 0; n /= 10) {
        count++;
    }

    for (n = candidate; n > 0; n /= 10) {
        sum += pow(n % 10, count);
    }

    return sum == candidate;
}
