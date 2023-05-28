#include <ctype.h>
#include <stdlib.h>
#include "isogram.h"

bool is_isogram(const char phrase[])
{
    if (phrase == NULL) {
        return false;
    }

    for (int i = 0; phrase[i]; i++) {
        char ch = tolower(phrase[i]);
        if (ch == '-' || ch == ' ') {
            continue;
        }

        for (int j = i + 1; phrase[j]; j++) {
            if (tolower(phrase[j]) == ch) {
                return false;
            }
        }
    }

    return true;
}
