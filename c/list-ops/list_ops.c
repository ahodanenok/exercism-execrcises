#include <stdio.h>
#include <stdlib.h>
#include "list_ops.h"

/**
 * List Ops
 * https://exercism.org/tracks/c/exercises/list-ops
 */

static list_t *empty_list(size_t length)
{
    list_t *list;

    list = malloc(sizeof(list_t) + sizeof(list_element_t) * length);
    list->length = length;

    return list;
}

list_t *new_list(size_t length, list_element_t elements[])
{
    list_t *list;

    list = empty_list(length);
    if (length > 0) {
        for (size_t i = 0; i < length; i++) {
           list->elements[i] = elements[i];
        }
    }

    return list;
}

list_t *append_list(list_t *list1, list_t *list2)
{
    list_t *res;
    size_t pos;

    res = empty_list(list1->length + list2->length);

    pos = 0;
    for (size_t i = 0; i < list1->length; i++) {
        res->elements[pos++] = list1->elements[i];
    }
    for (size_t i = 0; i < list2->length; i++) {
        res->elements[pos++] = list2->elements[i];
    }

    return res;
}

list_t *filter_list(list_t *list, bool (*filter)(list_element_t))
{
    list_t *res;
    size_t pos;

    res = empty_list(list->length);
    pos = 0;
    for (size_t i = 0; i < list->length; i++) {
        if (filter(list->elements[i])) {
            res->elements[pos++] = list->elements[i];
        }
    }
    res->length = pos;

    return res;
}

size_t length_list(list_t *list) {
    return list->length;
}

list_t *map_list(list_t *list, list_element_t (*map)(list_element_t))
{
    list_t *res;

    res = empty_list(list->length);
    for (size_t i = 0; i < list->length; i++) {
        res->elements[i] = map(list->elements[i]);
    }

    return res;
}

list_element_t foldl_list(list_t *list, list_element_t initial,
                          list_element_t (*foldl)(list_element_t,
                                                  list_element_t))
{
    list_element_t res;

    res = initial;
    for (size_t i = 0; i < list->length; i++) {
        res = foldl(res, list->elements[i]);
    }

    return res;
}

list_element_t foldr_list(list_t *list, list_element_t initial,
                          list_element_t (*foldr)(list_element_t,
                                                  list_element_t))
{
    list_element_t res;

    res = initial;
    for (size_t i = list->length; i > 0; i--) {
        res = foldr(list->elements[i - 1], res);
    }

    return res;
}

list_t *reverse_list(list_t *list)
{
    list_t *res;

    res = empty_list(list->length);
    for (size_t i = 0, j = list->length - 1, mid = list->length / 2; i < mid; i++, j--) {
        res->elements[j] = list->elements[i];
        res->elements[i] = list->elements[j];
    }

    return res;
}

void delete_list(list_t *list)
{
    free(list);
}
