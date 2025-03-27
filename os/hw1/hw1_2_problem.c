/*
	
	1. Write a text line from the user.
	2. Retrieve the start and end indices of all words from the input text.
	   (a word is a sequence of non-space characters separated by whitespace characters.)
		- Mark the start and end of each word by '[' and ']' in the next line

	ex)
			input a text: Welcome to HGU!   Nice to see you!			// input text
			              [      ][ ][   ]  [   ][ ][  ][   ]			// start and end indices of each words

	Use the isspace() function to decide whether a character is whitespace or not.

	Compile command: gcc hw1_2.c
	
	Execution command: ./a.out

*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX_TEXT 256

int main()
{
	char *prompt = "input a text: ";
	int prompt_len = strlen(prompt);

	// read a text line
	char text[MAX_TEXT] = "";
	printf("%s", prompt);
	fgets(text, MAX_TEXT, stdin);
	int len = strlen(text) - 1;
	text[len] = 0;

	// TO DO: print '[' below the start of each word
	//        print ']' below the space character just after each word
	//		  store each word in the substring array
	//		  - start, end: the start and end indices of the word
	//		  - substr: the word
	
	int i;
	for(i=0; i<prompt_len; i++){
		printf("%c",' ');	
	}


	short currCharInWord = 0;

	for(i=0; i<len; i++){
		const char currChar = text[i];

		if(isspace(currChar)){
			if(currCharInWord){
				printf("%c",']');
			}else {
				printf("%c", currChar);
			}
			currCharInWord = 0;
		}else {
			if(currCharInWord){
				printf("%c", ' ');
			}else {
				printf("%c", '[');
			}
			currCharInWord = 1;
		}
	}

	if(currCharInWord){
		putchar(']');
	}

	putchar('\n');
	printf("Bye!\n");

	return 0;
}

