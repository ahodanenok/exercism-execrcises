#include <ctype.h>
#include <stddef.h>
#include <stdlib.h>
#include "phone_number.h"

#define NANPLEN 10

/**
 * Phone Number
 * https://exercism.org/tracks/c/exercises/phone-number
 */

char *phone_number_clean(const char *input)
{
    char *result = malloc(sizeof(char) * (NANPLEN + 1));
    size_t pos = 0;
    size_t i = 0;
    int codepassed = 0;
    char ch;

    while (1) {
        ch = input[i++];
        if (!ch || isalpha(ch)) {
            break;
        }

        if (ch == '1' && !codepassed) {
            codepassed = 1;
        } else if (isdigit(ch)) {
            codepassed = 1;

            if (pos == NANPLEN) {
                break;
            }

            // area and exchange codes start from any number from 2 through 9
            if ((pos == 0 || pos == 3) && ch < '2') {
                break;
            }

            result[pos++] = ch;
        }
    }

    if (pos != NANPLEN || isdigit(ch)) {
        for (i = 0; i < NANPLEN; i++) {
            result[i] = '0';
        }
    }
    result[NANPLEN] = '\0';

    return result;
}
