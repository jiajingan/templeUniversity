#include "string6.h"

void take_last(char *s, int n){

    for (int i = 0; i < n; i++) {
        int length = str_len(s);
        s[i] = s[length-n+i];
    }
    s[n] = '\0';
}