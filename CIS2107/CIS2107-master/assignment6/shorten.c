#include "string6.h"
#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>

void shorten(char *s, int new_len){
    char shorten1[] = "";
    /*
     *  alex
     *  2
     *  al
     *  Shortens the string s to new_len.
     *  If the original length of s is less than or equal to new_len, s is unchanged
     */

    if (str_len(s) > new_len){
        s[new_len] = '\0';//this will terminate at the new length
    }

//        if (str_len(s) <= new_len ){
//            //return; unchanged do nothing
//        } else{
//            for (int i = 0; i < new_len; i++) {
//                *(shorten1+i) = *(s+i);
//            }
//        }
}