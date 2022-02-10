#include "string6.h"
#include <ctype.h>

void rm_right_space(char *s){
    /*
     *  "  asdasd"
     *  "asdasd" return
     */

    int newLength = str_len(s) -1; // so it doesn't count null

//    for (int i = newLength; i>=0; i--) {
//        if (s[i] == ' '){
//            newLength--;
//        }
//    }
    while (s[newLength] == ' '){ //"asd  \0"
        newLength--;
    }
    newLength = newLength +1;
    s[newLength] ='\0';

}
