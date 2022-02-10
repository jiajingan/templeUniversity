#include "string6.h"
#include <stddef.h>

char *ptr_to(char *h, char *n){
//    int index= 0;
//    while (*h != '\0'){
//        if (*h != *n){
//            index++;
//        }
//        h++;
//    }
//
//    if (str_len(h)-1 == index){
//        return 0;
//    }
    int address = find(h,n);

    return address == -1 ? 0 : (h + address);
}