#include "string6.h"
#include <ctype.h>
int strcmp_ign_case(char *s1, char *s2){
    /*
    * 
    *
    *
    */

    for (int i = 0; i < str_len(s1); ++i) {
        if (tolower(s1[i]) > tolower(s2[i]) ){
            return 1;
        }else if (tolower(s1[i]) < tolower(s2[i])){
            return -1;
        }
    }
    return 0;
}