#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <string.h>

#define BUF_SIZE 64
#define IN 1
#define OUT 0

int count;
void decommentor(FILE *f);
void append(char* s, char c);
//ss

/*ask
djaksjdlkasjdlkasjkldjaslkd*/


int main(int argc, char argv[]){
    // FILE* f;
    // //a pointer to a file;
    // char s[BUF_SIZE];

    // // take input from keyboard
	// // scanf("%s", s);
	// // open file, f = NULL if can not open file stream
	// f  = fopen ("test.txt", "rw");

	// //check if file is open
	// if (f == NULL){
	// printf ("\n Incorrect file name \n");
	// return EXIT_FAILURE;
    //    }
    //      else

	char f[255];
	printf("Which file do you want to input: ");
    gets(f);

    FILE *inFile = fopen(f, "r");



    if (inFile == NULL)
    {
        perror("error accessing file");
        return -1;
    }

	// call function to de-comment file
	decommentor(inFile);
	// close file stream
	fclose(inFile);
	return 0;

}

void append(char* s, char c) {
        int len = strlen(s);
        s[len] = c;
        s[len+1] = '\0';
}

void decommentor(FILE *f){
    int escape;
    int in_comment;
    int in_quote;
    char quote_type;
    char current ;
    int temp;

    int opencomment;
    int closedcomment;

    char string[1000];

    int Startdecommenting;

	int line_comment;
    // current = quote_type = in_quote = in_comment = escape = 0;


    while((current = getc(f) != EOF)){
        
        if(current == '\n'){
            count++;
        }

		if (Startdecommenting = 0){		
			/* !(started decommenting) */
            //if it start decommenting it will start deleting
            //if it !startdecommenting it will check to see if there is a closing comment

            //line comment is called "//comment"
			if ((temp == '/') && (current == '/')) //checking single line comments
			{   
                //line comment checks to see 
				line_comment = 1;

				// //inc opencomment
                // opencomment++;

				//start decommenting
                Startdecommenting = 1;

				// code // /
			}else if ((temp == '/') && (current == '*'))//checks opening comments
			{
				//start decommenting
				
                Startdecommenting = 1;

				/* code */
			}else{//if we don't find opening comment or othe line comments
                

				append(string,current);
                // strcat(string, (char*)current);
				// add current to string
			}
			
		}else{



			if ((temp == '*') && (current == '/')) //checks closing comments
			{      
                //do nothing becuase
                //delete array
			
			}else if((current =='\n')&&(line_comment == 1)){
                //when we see a newline means no closing comment then
				line_comment = 0;
                
			}
            
		}
        //previous character
        temp = current;
    }
    
    FILE *new_file;
    new_file = fopen("new_file.txt","w");
    fprintf(new_file, "%s", string);
}