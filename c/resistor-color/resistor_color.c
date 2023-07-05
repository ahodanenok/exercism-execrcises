#include "resistor_color.h"

/**
 * Resistor Color
 * https://exercism.org/tracks/c/exercises/resistor-color
 */

uint16_t color_code(resistor_band_t band)
{
    return band;
}

resistor_band_t *colors()
{
    static resistor_band_t colors[] = {
        BLACK,
        BROWN,
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE,
        VIOLET,
        GREY,
        WHITE
    };

    return colors;
}
