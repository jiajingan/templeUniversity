#include "string6.h"
#include <stdlib.h>

char *dedup(char *s1){
    char *dup = (char*) malloc(1000);
    int counter,k = 0;
    //find a unique sequence of letters
    for(int i = 0; i < str_len(s1); i++) {
        for (int j = 0; j < str_len(s1); j++) {
            if (s1[i] == dup[j]){
                counter++;
            }
        }
        if (counter == 0){
            dup[k] = s1[i];
            k++;
            counter=0;
        } else{
            counter=0;
        }
    }
    return dup;
}
