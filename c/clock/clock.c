#include <string.h>
#include "clock.h"

#define HOURS_PER_DAY 24
#define MINUTES_PER_HOUR 60

#define to_char(n) ('0' + (n))
#define to_digit(ch) ((ch) - '0')
#define get_hour(cl) (to_digit(cl.text[0]) * 10 + to_digit(cl.text[1]))
#define get_minute(cl) (to_digit(cl.text[3]) * 10 + to_digit(cl.text[4]))

/**
 * Clock
 * https://exercism.org/tracks/c/exercises/clock
 */

clock_t clock_create(int hour, int minute)
{
    int h, m;
    clock_t clock;

    h = hour;
    m = minute;
    if (m < 0) {
        h -= -m / MINUTES_PER_HOUR + 1;
        m = MINUTES_PER_HOUR - (-m % MINUTES_PER_HOUR);
    }
    h += m / MINUTES_PER_HOUR;
    m %= MINUTES_PER_HOUR;

    if (h < 0) {
        h = HOURS_PER_DAY - (-h % HOURS_PER_DAY);
    }
    h %= HOURS_PER_DAY;

    clock.text[0] = to_char(h / 10);
    clock.text[1] = to_char(h % 10);
    clock.text[2] = ':';
    clock.text[3] = to_char(m / 10);
    clock.text[4] = to_char(m % 10);
    clock.text[5] = '\0';

    return clock;
}

clock_t clock_add(clock_t clock, int minute_add)
{
    return clock_create(get_hour(clock), get_minute(clock) + minute_add);
}

clock_t clock_subtract(clock_t clock, int minute_subtract)
{
    return clock_create(get_hour(clock), get_minute(clock) - minute_subtract);
}

bool clock_is_equal(clock_t a, clock_t b)
{
    return strcmp(a.text, b.text) == 0;
}
