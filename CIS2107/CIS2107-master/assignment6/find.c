#include "string6.h"
#include <stddef.h>
/*
 * alex
 * e
 * 2
 */

int find(char *h, char *n){
    int index= 0;
    while (*h != '\0'){
        if (*h != *n){
            index++;
        }
        h++;
    }
    if (str_len(h)-1 == index){
        return 0;
    } else{
        return index-1;
    }
}