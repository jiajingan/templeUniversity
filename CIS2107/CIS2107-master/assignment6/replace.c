#include "string6.h"
#include <stdlib.h>
char *replace(char *s, char *pat, char *rep) {
    int size = 1;
    char *newSize = malloc(size * sizeof(char));
    char *Word = newSize;
    char *Iterator = s;
    char *Checker;
    char *patIterator = pat;
    char *repIterator = rep;

    while (*Iterator != '\0') {

        if (*Iterator == *pat) {

            int toggle = 1;
            Checker = Iterator;
            while (*patIterator != '\0') {

                if (*Checker == *patIterator) {
                    Checker++;
                    patIterator++;
                } else {
                    toggle = 0;
                    break;
                }
            }
            patIterator = pat;

            if (toggle == 0) {
                *Word = *Iterator;
                newSize = realloc(newSize, ++size * sizeof(char));
                Word++;
                Iterator++;
            } else {
                Iterator = Checker;
                while (*repIterator != '\0') {

                    *Word = *repIterator;
                    repIterator++;
                    Word++;
                    newSize = realloc(newSize, ++size * sizeof(char));
                }
                repIterator = rep;
            }

        } else {
            *Word = *Iterator;
            newSize = realloc(newSize, ++size * sizeof(char));
            Word++;
            Iterator++;
        }
    }

    *Word = '\0';

    return newSize;

}