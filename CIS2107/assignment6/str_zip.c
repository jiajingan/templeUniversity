#include "string6.h"
#include <stdlib.h>

char *str_zip(char *s1, char *s2){
    /*
     * jack
     * pat
     * jpaactk
     */

    char *zip = (char*) malloc(1000);
    int i = 0;
    int j = 0;
    int k = 0;
    int zipLength = str_len(s1) + str_len(s2);

//    while (i < zipLength){
//        if (s1[j] != '\0'){
//            zip[i] = s1[j];
//            j++;i++;
//        }
//        if (s2[k] != '\0'){
//            zip[i] = s2[k];
//            k++; i++;
//        }
//    }

    for (i = 0; i < zipLength;) {
        if (s1[j] != '\0'){
            zip[i] = s1[j];
            j++; i++;
        }
        if (s2[k] != '\0'){
            zip[i] = s2[k];
            k++; i++;
        }
    }

    return zip ;
}