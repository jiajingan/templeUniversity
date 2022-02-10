#include "string6.h"
#include <stdlib.h>


char **str_chop_all(char *s, char c) {
    int count = 1;//if it's blank it will always keep 1
    for (int i = 0; i < str_len(s); i++) {
        if (s[i] == c){
            count++;
        }
    }
    char **chop = (char**) malloc(sizeof(char*) * (count+2));
    //count + 2 because 1 for null and 1 for the extra space
    int wordLength = 0;
    int index  = 0;
    for (int i = 0; i < str_len(s); i++) {
        if (s[i] == c){
            chop[index] = malloc(sizeof (char) * wordLength);
            wordLength = 0;//reset when you find the new string
            index++;
        }
        wordLength++;//count the length
    }
    chop[index] = malloc(sizeof (char) * wordLength);
    //one more for the extra space

    chop[index+1] = NULL;
    index = 0;

    char *chop1 = chop[index];

    for (int i = 0; i < str_len(s); ++i) {
        if (s[i] != c && s[i] != '\0'){
            *chop1 = s[i];//add it back in
            chop1++;//increment array length
        } else {
            *chop1 = '\0';
            index++;
            chop1 = chop[index];
        }
    }
    return chop;
}