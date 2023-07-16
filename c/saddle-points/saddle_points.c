#include <stdlib.h>
#include "saddle_points.h"

/**
 * Saddle Points
 * https://exercism.org/tracks/c/exercises/saddle-points
 */

saddle_points_t *saddle_points(size_t rows, size_t columns, uint8_t matrix[rows][columns])
{
    saddle_points_t *points = malloc(sizeof(saddle_points_t) + rows * columns * sizeof(saddle_point_t));
    points->count = 0;

    uint8_t height_max;
    size_t row_min;
    for (size_t row = 0; row < rows; row++) {
        height_max = matrix[row][0];
        for (size_t col = 0; col < columns; col++) {
            if (matrix[row][col] > height_max) {
                height_max = matrix[row][col];
            }
        }

        for (size_t col = 0; col < columns; col++) {
            if (matrix[row][col] != height_max) {
                continue;
            }

            row_min = row;
            for (size_t r = 0; r < rows; r++) {
                if (matrix[r][col] < height_max) {
                    row_min = r;
                    break;
                }
            }

            if (row_min == row) {
                points->points[points->count].row = row + 1;
                points->points[points->count].column = col + 1;
                points->count++;
            }
        }
    }

    return points;
}

void free_saddle_points(saddle_points_t *points)
{
    free(points);
}
