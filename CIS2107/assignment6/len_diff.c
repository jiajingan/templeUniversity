#include "string6.h"

int len_diff(char *s1, char *s2){

    if ((str_len(s1)-str_len(s2)) >= 0){
        return str_len(s1) - str_len(s2);
    }else{//negative
        return 0;
    }


}