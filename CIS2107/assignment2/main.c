#include <stdio.h>
#include <ctype.h>

#define OUT 0

int main(void) {
    //this will asking for the file
    char fileName[255];
    int c;
    int c2;
    int newLine = 0;

    int error;


    printf("Input file: ");
    gets(fileName);
    //this will asking for the file, please use absolute path

    FILE *inFile = fopen(fileName, "r");

    if (inFile == NULL) {
        perror("error accessing file");
        return -1;
    }

    //everytime I do fgetc go to the next character
    //ungetc goes back a character

    c2 = fgetc(inFile);//setting c2 as the first character to later shift as the second character
    while (c2 != EOF) {

       c = c2;//c will be first character
       c2 = fgetc(inFile);//c2 will be second character

        if (c2 == '\n') {
            //this will count the lines
            //later it will return it when an error occurs
            newLine++;

        }

        //printf("%c", c);
        if (c == '"') {
            //do nothing
            //in quote got to find closing quote
            //how do i find the closing quote???
            printf("%c", c);

            while (c2 != '"') {
                c = c2;
                c2 = fgetc(inFile); //to read forward the next character
                //this will keep search for the closing quotation
                printf("%c", c);
            }

            c = c2;
            c2 = fgetc(inFile);//to read forward the next character
        }

         if (c == '/' && c2 == '*') { //not in quotes
             //no need to c1 this time because will be checking first character
             c2 = fgetc(inFile); //to read forward the next character
             error = newLine;
             if (c2 == '\n'){
                 newLine++;
             }
                //start decommenting or print error
                while((c != '*') || (c2 != '/')){
                    c = c2;
                    c2 = fgetc(inFile);//to read forward the next character

                    if (c2 == '\n'){//keep reading line to check for error
                        newLine++;
                    }
                    if (c2 == EOF){//this will check till end of file while loop

                        printf( "\nerror on:%d \n", error);
                        return OUT;
                    }
                }
             c = fgetc(inFile);//to read forward the next character
             c2 = fgetc(inFile);//to read forward the next character

             if (c == '\n' || c2 == '\n'){
                 newLine++;
             }

             if (c != ' '){
                 //this will handle anything comments with a multi line comment on a single line to separate with a space
                 printf("%c",' ');
             }
        }

         printf("%c", c);


        //also handle string "",

        //keep track of unfinished comment line error


        /*
         *
         */

        //write and read to a new file after decomment

        //also handle that, know back track
        //*
        //*/

    }
    fclose(inFile);
}
