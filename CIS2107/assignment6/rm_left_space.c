#include "string6.h"
#include <ctype.h>

void rm_left_space(char *s){
    /*
     *  "  asdasd"
     *  "asdasd" return
     */

    int counter  = 0;
    for (int i = 0; i < str_len(s); i++) {
        if (s[i] == ' '){
            counter++;
        }
    }

    if (counter !=0){
        int newLength = str_len(s) - counter;
        for (int i = 0; i < newLength; i++) {
            s[i] = s[i+counter];//remove the spaces that are infront
        }
        s[newLength] = '\0';
    }
}
