#include <stdlib.h>
#include "string6.h"

char *repeat(char *s, int x, char sep) {
    int counter = 0;
    while (s[counter] != '\0') {
        counter++;
    }
    int size = (counter * x) + (counter * (x - 1)) + 1;
    char *word = calloc(size, sizeof(char));
    char *P = word;

    int i;
    for (i = 0; i < x; i++) {
        if (i != 0) {
            *P = sep;
            P++;
        }

        int j;
        for (j = 0; j < counter; j++) {
            *P = s[j];
            P++;
        }
    }

    *P = '\0';

    return word;

}