#include "string6.h"

int str_len(char *s){
    char *t=s;
    while (*t != '\0'){
        t++;
    }
    return t-s;
}