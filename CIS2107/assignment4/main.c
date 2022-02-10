#include <stdio.h>

unsigned int add(unsigned int, unsigned int);
unsigned int sub(unsigned int, unsigned int);
unsigned int mul(unsigned int, unsigned int);
unsigned int lt(unsigned int, unsigned int);
unsigned int gt(unsigned int, unsigned int);
unsigned int getByte(unsigned int, unsigned int);

int main(int argc, char **argv)
{

    unsigned int i, j;

    printf("Enter an integer ");

    scanf("%u", &i);
    printf("\nEnter another integer ");
    scanf("%u", &j);
    printf("\ni + j = %u\n", add(i,j));
    printf("\ni - j = %u\n", sub(i,j));
    printf("\ni * j = %u\n", mul(i,j));
    printf("i > j = %s\n", (gt(i,j) ? "TRUE" : "FALSE"));
    printf("i < j = %s\n", (lt(i,j) ? "TRUE" : "FALSE"));
    printf("jth byte of i = %ux\n", getByte(i,j));

    return 0;
}

//i = 12 = 0B1100
//j = 15 = 0B1111

unsigned int add(unsigned int i, unsigned int j)
{
    //https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/



    while (j != 0){
        int carry = i & j;
        //adding is just carrying the 1 over
        i = i ^ j;
        //XOR is just adding without carrying
        j = carry << 1;
        //shifts everytime I carry for increment
    }
/* can be done in a total of 7 lines, including one to declare an unsigned int, */
/* two for a while loop, and one for the return */
    return i;
}

unsigned int sub(unsigned int i, unsigned int j)
{
/* Similar 7 lines, although there is a shorter way */

//very similar to add
    while (j != 0){
        int carry  = (~i) & j;
        i = i ^ j;
        j = carry << 1;
    }
    return i;
//    return add(i,-j);
}

unsigned int mul(unsigned int i, unsigned int j)
{
/* can be done in a total of 8 lines including one to declare unsigned ints */
/* two for a for loop, and one for the return */
    int temp = 0;
    int count = j;
    if ((i==0)||(j==0)){
        return temp;
    } else {
        while (count != 0){
            temp = add(temp,add(i,0));
            count = sub(count,1);
            //count = count - 1;
        }
//        for (int k = 0; k < j; k++) {
//            temp = temp + add(i,0);
//        }
    }
    return temp;
}

/* returns non-zero if i is less than j or zero otherwise */
unsigned int lt(unsigned int i, unsigned int j)
{
    if (i == j){
        return 0;
    }



    int x = i ^j;
    //XOR will check the different bits
    x = x | (x >> 1);
    x = x | (x >> 2);
    x = x | (x >> 4);
    x = x | (x >> 8);
    x = x | (x >> 16);
    x = sub(x, (x>>1));
//    x = x - (x >> 1);
    //this will shift all the bits until we get the first bit
    //so we can check if the bits are zero or not, if zero then it's true else false
    //this will also check j with x
    return !((j & x) ^ x);


//    int x = i;
//    int y = j;
//    int count = j;
//    if ((i == j)){
//        return 0;
//    }
//
//    if ((i != 0)||(j != 0)){
//        while (count != 0){
//            //i and j will race each other will to be zero first
//            x = sub(x,1);
//            y = sub(y,1);
//            //which one takes longer is the bigger value
//            //if j reaches first, then i is greater than j, return 0
//            if ((int)y == 0){
//                break;
//            }
//            count = sub(count,1);
//        }
//        return 0;
//    }


////    while ((x != 0)||(y != 0)){
////        //i and j will race each other will to be zero first
////        x = sub(x,1);
////        y = sub(y,1);
////        //which one takes longer is the bigger value
////        //if j reaches first, then i is greater than j, return 0
////        if (y == 0){
////            return 0;
////        }
////        //printf("value of y:%d", y);
////    }
//
    return 1;
}

/* returns non-zero if i is greater than j or zero otherwise */
unsigned int gt(unsigned int i, unsigned int j)
{
    if ((i == j)){
        return 0;
    }

    return lt(j,i);

}

/* returns the jth byte of i */
unsigned int getByte(unsigned int i, unsigned int j)
{
    //this will shift the i place by the byte of jth
    i>>=(sub(j,1));
    //i>>=(j-1);
    //
    return (i&0xFF);
}