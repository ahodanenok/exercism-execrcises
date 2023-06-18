#include "binary_search.h"

/**
 * Binary Search
 * https://exercism.org/tracks/c/exercises/binary-search
 */

const int *binary_search(int value, const int *arr, size_t length)
{
    int from, to, mid;

    from = 0;
    to = length;
    while (to > from) {
        mid = from + (to - from) / 2;
        if (arr[mid] < value) {
            from = mid + 1;
        } else if (arr[mid] > value) {
            to = mid;
        } else {
            return &arr[mid];
        }
    }

    return NULL;
}
