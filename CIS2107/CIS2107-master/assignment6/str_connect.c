#include <stdlib.h>
#include "string6.h"
//with professor salvatore help
char *str_connect(char **strs, int n, char c) {
    char *temp;
    int i;
    char *ret_str = (char *) malloc(1000);
    char *actual_ret = ret_str;

    /* Iterate through each string in strs array */
    for (i = 0; i < n; i++){
        temp = strs[i]; // for i = 0 temp is "Washington" in the example
        int j;
        int len = str_len(temp);

        for (j = 0; j < len; j++) {
            *ret_str = *temp;
            ret_str++;
            temp++;
        }

        if (i != n-1) {
            *ret_str = c;
            ret_str++;
        }
    }

    *ret_str = '\0';
    return actual_ret;
}
