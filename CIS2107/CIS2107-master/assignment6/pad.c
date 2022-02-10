#include "string6.h"
#include <stdlib.h>
#include <stdio.h>
char *pad(char *s, int d){
    /*
     * sophia123456 7
     * 12%7 == 0
     * sophia 7
     */

    int mod = str_len(s);
    if (str_len(s)%d == 0){
        return s;
    }else {
        char *paddy = (char*) malloc(1000);
        for (int i = 0; i < str_len(s); ++i) {
            paddy[i] = s[i];
        }

        while (mod > 0){
            mod = mod - d;
        }
        mod = abs(mod);

        int length =  str_len(s);
        for (int i = 0; i < mod; i++) {
            paddy[length+i] = '_';
        }

        return paddy;
        //figure out what is needed to
        // add back to
    }
}