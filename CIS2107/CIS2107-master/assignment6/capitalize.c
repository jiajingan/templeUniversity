#include <ctype.h>
#include "string6.h"


void capitalize(char *s){
    s[0] = toupper(s[0]);
    for (int i = 1; i < str_len(s); i++) {
        if (isspace(s[i])){
            while (isspace(s[i])){
                i++;
            }
            s[i]  = toupper(s[i]);
        }
    }
}
