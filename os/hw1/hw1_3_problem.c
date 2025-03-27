/*
	
	1. Write a text line from the user.
	2. Retrieve all words from the input text.
	   (a word is a sequence of non-space characters separated by whitespace characters.)
		- Mark the start and end of each word by '[' and ']' in the next line.
		- Store all words in an array of structures 'words'.
	3. Display all words in the array 'words'.

	ex)
			input a text: Welcome to HGU!   Nice to see you!			// input text
			              [      ][ ][   ]  [   ][ ][  ][   ]			// start and end indices of each words

			words[0] = (0, 7, Welcome)
            words[1] = (8, 10, to)
            words[2] = (11, 15, HGU!)
            words[3] = (18, 22, Nice)
            words[4] = (23, 25, to)
            words[5] = (26, 29, see)
            words[6] = (30, 34, you!)


	Use the isspace() function to decide whether a character is whitespace or not.

	Compile command: gcc hw1_3.c
	
	Execution command: ./a.out

*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

#define MAX_TEXT 256
#define MAX_LEN 128
#define SIZE 512

typedef struct {
	int start, end;			// the start and end indices of the word
	char substr[MAX_LEN];	// substring (word)
} Substring;

Substring words[SIZE];	 	// array of structures to store words
int no_word = 0;			// the number of words

char *substr(int start, int end, char *str);

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
	short currCharFlag = 0;
	int i;
	for(i=0; i<len; i++){
		if(isspace(text[i])){ // when current char is whitespace
			if(currCharFlag){
				// end of word 
				words[no_word].end = i;				

				char *temp = substr(words[no_word].start,words[no_word].end-1, text);
				strcpy(words[no_word].substr, temp);
				free(temp);

				no_word++;
			}
			currCharFlag = 0;
		}else { // when curr char is in word
			if(!currCharFlag){
				// start of word 
				words[no_word].start = i;
			}
			currCharFlag = 1;
		}
	}

	if(currCharFlag) { 
		// if last char was not white space
		words[no_word].end = len;
		char *temp = substr(words[no_word].start,words[no_word].end-1, text);
		strcpy(words[no_word].substr, temp);
		free(temp);

		no_word++; 
	}

	short currCharInWord = 0;
	
	for(i=0; i<prompt_len; i++){
		printf("%c",' ');	
	}

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

	// DO NOT modify the following four lines
	putchar('\n');
	putchar('\n');
	for(i = 0; i < no_word; i++)
		printf("words[%d] = (%d, %d, %s)\n", i, words[i].start, words[i].end, words[i].substr);

	printf("Bye!\n");

	return 0;
}

char *substr(int start, int end, char *str) {
	char *newStr = (char *)malloc(sizeof(char)*(end-start+2));
	strncpy(newStr, str+start, end-start+1);
	newStr[end-start+1] = '\0'; // ensure null termination!!!
	return newStr;
}
