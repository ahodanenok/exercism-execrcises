#include <stdlib.h>
#include <string.h>
#include "grade_school.h"

/**
 * Grade School
 * https://exercism.org/tracks/c/exercises/grade-school
 */

void init_roster(roster_t *actual)
{
    actual->count = 0;
}

int add_student(roster_t *actual, char *name, uint8_t grade)
{
    if (actual->count == MAX_STUDENTS) {
        return 0;
    }

    for (size_t i = 0; i < actual->count; i++) {
        if (strcmp(actual->students[i].name, name) == 0) {
            return 0;
        }
    }

    size_t pos = 0;
    while (pos < actual->count) {
        if (actual->students[pos].grade > grade) {
            break;
        }

        if (actual->students[pos].grade == grade
                && strcmp(actual->students[pos].name, name) > 0) {
            break;
        }

        pos++;
    }

    for (size_t i = actual->count; i > pos; i--) {
        actual->students[i] = actual->students[i - 1];
    }

    student_t *student = malloc(sizeof(student_t));
    student->grade = grade;
    strcpy(student->name, name);
    actual->students[pos] = *student;
    actual->count++;

    return 1;
}

roster_t get_grade(roster_t *actual, uint8_t grade)
{
    roster_t *result = malloc(sizeof(roster_t));
    result->count = 0;

    int pos = 0;
    for (size_t i = 0; i < actual->count; i++) {
        if (actual->students[i].grade == grade) {
            result->students[pos++] = actual->students[i];
            result->count++;
        }
    }

    return *result;
}
