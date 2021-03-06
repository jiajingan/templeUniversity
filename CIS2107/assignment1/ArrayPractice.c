#include <stdio.h>

#define LEN_A 10
/*
 * Jackie (Jiajin) Gan
 * CIS 2107
 * Sophia Salvatore
 * Assignment 1 Warm Up
 */

/* function declarations */
void print_array(int[], int);
void reverse(int[], int);
double average(int[], int);
void insert(int[], int, int, int);
int less_than_average(int[], int);
void rotate_right(int[], int, int);
void array_copy(int[], int[], int);
void initialize(int[], int, int);
void evens_on_left(int[], int);
int find(int A[], int len, int x);
int find_last(int A[], int len, int x);
int contains_dup(int A[], int len);

int secondLargest(int A[], int);

int main(int argc, char **argv)
{
    int A[] = {9, 505, 321, 117, 27, 64, 13, 9, 12, 208};
    int B[LEN_A+1];
    int newValue=505;

    printf("A[] is:\n");
    print_array(A, LEN_A);

    initialize(B, LEN_A+1, 0);
    printf("B[] is:\n");
    print_array(B, LEN_A+1);

    array_copy(B, A, LEN_A);
    printf("but now it's\n");
    print_array(B, LEN_A+1);


    printf("insert array\n");
    insert(B, newValue, 0, LEN_A);
    printf("and after inserting %d at the beginning it's\n", newValue);
    print_array(B, LEN_A+1);

    printf("The average of A[] is %f\n", average(A,LEN_A));
    printf("There are %d items in A[] less than this.\n", less_than_average(A,LEN_A));

    printf("Reserse Array: \n");
    reverse(A, LEN_A);
    print_array(A, LEN_A);

    printf("Second largest: %d\n", secondLargest(A, LEN_A));

    rotate_right(A, LEN_A, 3);
    print_array(A, LEN_A);

    printf("even on left\n");
    evens_on_left(A, LEN_A);
    print_array(A, LEN_A);

    printf("The index of the first occurrence of %d is %d.\n", 9, find(A, LEN_A, 9));
    printf("The index of the last occurrence of %d is %d.\n", 9, find_last(A, LEN_A, 9));

    if (contains_dup(A, LEN_A))
        printf("A[] contains a dup\n");
    else
        printf("A[] doesn't contain a dup\n");

    if (contains_dup(B, LEN_A+1))
        printf("B[] contains a dup\n");
    else
        printf("B[] doesn't contain a dup\n");

    return 0;
}

/* functions implementation */

/* prints A[] inside parentheses with each value separated
   by commas to stdout (which will be the screen). */
void print_array(int A[], int length) {
    int i=0;
    printf("(%d", A[i]);
    for (int i = 1; i < length-1; i++) {
        printf(",%d", A[i]);
    }
    printf(")\n");
}

/* returns the average of the items in A[] or 0.0 if A is empty */
double average(int A[], int length) {
    /* for now return 1.0 as a placeholder.  We do this just so that the program
       compiles without warning until we've finished */
    double total = 0;
    if (length == 0 ) {
        return 0.0;
    }
    for (int i = 0; i < length; i++) {
        total = total + A[i];
    }
    double average = total / length;
    return average;
}

/* returns the number of items in A that are less than the
   average of the items in A */
int less_than_average(int A[], int length) {
    /* for now return 0 as a placeholder.  We do this just so that the program
       compiles without warning until we've finished */

    double averArr = average(A, length);
    int count = 0;
    for (int i = 0; i < length; ++i) {
        if (A[i] < averArr){
            count++;
        }
    }

    return count;
}

/* Reverses the values in A[].  For example, if before the function,
   A[] contained [1,2,3,4,5], after the function, A[] contains
   [5,4,3,2,1] */
void reverse(int A[], int length) {

    for (int i = 0; i < length; i++) {
        int temp = A[i];
        A[i] = A[length-1];
        A[length-1] =temp;
    }

}

/* returns the second largest item in A[], or -1 if len < 2 */
int secondLargest(int A[], int length) {
    /* for now return 0 as a placeholder.  We do this just so that the program
       compiles without warning until we've finished */
    // does not work it needs to return the second largest item
    if (length < 2){
        return -1;
    }
    int temp;
    for (int i = 0; i < length; i++) {
        for (int j = i+1; j < length; j++) {
            if (A[i]>A[j]){
                temp = A[i];
                A[i]=A[j];
                A[j]=temp;
            }
        }
    }
    return A[length-2];
}

/* rotates the values in the array numPlaces to the right */
/* for example, if A[] is initially 10,20,30,40,50, and numPlaces=2 */
/* after the function finishes, A[] would be 40,50,10,20,30 */
void rotate_right(int A[], int length, int numPlaces) {

    for (int i = 0; i < length; ++i) {
        int last;
        last = A[length-1];
        for (int j = length-1; j >0 ; j--) {
            A[j]=A[j-1];
        }
        A[0]=last;
    }

}



/* inserts the value n in A[] at the given index and shifts
   all other values up one position.  A[] contains length items.

   It is up to the caller to make sure that there is enough space
   in A[] to accomodate the new item, and that the index is valid. */
void insert(int A[], int n, int index, int length) {
    //n is input index
    //[12345] 5(n) in index 3(index)
    //[123545]
    if (length <1){
        return;
    }

    if (length>1){
        for (int i = length; i > index; i--) {
            A[i]=A[i-1];
        }
    }
    A[index]=n;

}

/* copies the first numItems from S to D. */
void array_copy(int D[], int S[], int numItems) {
    for (int i = 0; i < numItems; i++) {
        D[i]=S[i];
    }
}


/* sets the first len elements of A to initialValue */
void initialize(int A[], int len, int initialValue) {
    for (int i = 0; i < len; ++i) {
        A[i]=A[initialValue];
    }
}

/* shuffles the values in A so that the even values
   are all to the left of the odd values */
void evens_on_left(int A[], int len) {
    int divider = -1;
    for (int i = 0; i < len; ++i) {
        if (A[i]%2==0){
            int temp = A[i];
            A[i] = A[divider + 1];
            A[divider + 1] = temp;
            divider ++;
        }
    }
}

/* returns the index of the first occurrence of
 * x in A[] or -1 if x doesn't exist in A[] */
int find(int A[], int len, int x) {

    for (int i = 0; i < len; i++) {
        if (A[i]==x){
            return i;
        }
    }
    return -1;
}

/* returns the index of the last occurrence of
 * x in A[] or -1 if x doesn't exist in A[] */
int find_last(int A[], int len, int x) {

    for (int i = len-1; i >= 0; i--) {
        if (A[i]==x){
            return i;
        }
    }
    return -1;
}

/* returns 1 if there is at least one element in A[]
   that is contained elsewhere in A[], or 0 if there isn't */
int contains_dup(int A[], int len) {
    for (int i = 0; i < len; i++) {
        for (int j = 0; j < len; j++) {
            if ((A[i]==A[j]) && i != j){
                return 1;
            }
        }
    }
    return 0;
}
