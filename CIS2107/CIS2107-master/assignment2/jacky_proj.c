#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <string.h>

#define BUF_SIZE 64
#define IN 1
#define OUT 0

int count;
int decommentor(FILE f);


//ss

/*ask
djaksjdlkasjdlkasjkldjaslkd*/


int main(int argc, char argv[]){
    FILE f;
    //a pointer to a file;
    char s[BUF_SIZE];
	
	char[] string;


}

int decommentor(FILE f){
    int escape;
    int in_comment;
    int in_quote;
    char quote_type;
    char current;
    char temp;

    int opencomment;
    int closedcomment;

	int line_comment;
    current = quote_type = in_quote = in_comment = escape = 0;



    while((current = getc(f) != EOF)){

        if(current == '\n'){
            count++;
        }
			
				//asdasfsaf
				/*
				
				/*
				
				*/
				*/
				*/
				


		if (/* !(started decommenting) */){		
			
			if ((temp = "/") && (current = "/")) //checking single line comments
			{
				//line_comment = 1;
				//inc opencomment
				//start decommenting
				
				
				if (current == '\n')
				{
					// code /
				}

				// code // /
			}else if ((temp = "/") && (current = "*"))//checks opening comments
			{
				//start decommenting
				
				/* code */
			}else{
			
				// add comment to string
			}
			
		}else{
			if ((temp = "*") && (current = "/")) //checks closing comments
			{
				//inc closedcomment
			}else if('\n'){
				line_comment = 0;
				//inc closedcomment
			}else if(){
				//delete char
			}
		}
        //previous character
        temp = current;

    }
}