#include "string6.h"
#include <ctype.h>

int all_letters(char *s){
    char *t = s;

    while (*t != '\0'){
        //abc7jk would return 0;
        //'\0' is null terminator, end of the string
        //isalpha function will return 0 if its not a alphabet else returns a int for alphabet

        if (isalpha(*t) == 0){//if there is no alphabet
            return 0;
        }
        t++;
    }
    return 1;
}