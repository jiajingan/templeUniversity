#include "string6.h"
#include <stddef.h>

int is_empty(char *s){
    rm_space(s);
    if (*s == NULL){
        return 1;
    } else {
        return 0;
    }
}