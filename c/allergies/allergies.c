#include "allergies.h"

/**
 * Allergies
 * https://exercism.org/tracks/c/exercises/allergies
 */

bool is_allergic_to(allergen_t allergen, int score)
{
    return score & (1 << allergen);
}

allergen_list_t get_allergens(int score)
{
    allergen_list_t result;
    result.count = 0;
    for (allergen_t allergen = ALLERGEN_EGGS; allergen < ALLERGEN_COUNT; allergen++) {
        if (is_allergic_to(allergen, score)) {
            result.count++;
            result.allergens[allergen] = true;
        }
    }

    return result;
}
