#include "string6.h"

int diff(char *s1, char *s2) {
    /*
     * alec
     * alex would return 1
     * the function will vary by the amount of differences
     */

    {

        int arr[256] = {0};
        int i = 0;
        while (s1[i] != '\0') {

            arr[s1[i]]++;

            i++;

        }

        i = 0;
        while (s2[i] != '\0') {
            arr[s2[i]]--;
            i++;
        }

        int count = 0;
        for (i = 0; i < 256; i++) {
            if (arr[i] < 0) {
                count = count - arr[i];
            } else
                count += arr[i];
        }
        return (count-1);
    }
}