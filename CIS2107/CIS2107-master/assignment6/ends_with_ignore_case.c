#include "string6.h"
#include <ctype.h>

int ends_with_ignore_case(char *s, char *suff){
    int length = str_len(suff);
    int start = str_len(s) - length;

    for (int i = start; i < str_len(s); i++) {
        if (tolower(s[i]) == tolower(suff[i])){
            return 0;
        }
    }
    return 1;

    //idk why my method return the opposite but it works!
}