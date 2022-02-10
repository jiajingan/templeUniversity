#include "string6.h"

void rm_space(char *s){
    /*
     *  "  asdasd"
     *  "asdasd" return
     */

    //https://stackoverflow.com/questions/1726302/removing-spaces-from-a-string-in-c
    const char* d = s;
    do {
        while (*d == ' ') {
            ++d;
        }
    } while (*s++ = *d++);

}
