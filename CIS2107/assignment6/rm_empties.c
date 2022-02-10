#include "string6.h"
#include <stdio.h>
#include <stdlib.h>

char *rm_empties(char **words){
    int i =0;
    while (words[i] != NULL){
        while (*words[i] == '\0'){
            int temp = i;
            while (words[temp] != NULL){
                words[temp] = words[temp +1];
                temp++;
            }
        }
        i++;
    }
}