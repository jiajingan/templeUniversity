#include "string6.h"

int num_in_range(char *s1, char b, char t){
    /*
     * s1 = alexandar
     * b = l
     * t = x
     * would return 4, contains l x n r in the same ascii decimal
     */
    int c = 0;


    while ((*s1 != '\0')){
        if ((*s1 >= b) && (*s1 <= t)){
            c++;
        }

        s1++;
    }
    return c;
}