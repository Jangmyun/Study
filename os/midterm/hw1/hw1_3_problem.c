#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX_TEXT 256
#define MAX_LEN 128
#define SIZE 512

typedef struct {
	int start, end;			// the start and end indices of the word
	char substr[MAX_LEN];	// substring (word)
} Substring;

Substring words[SIZE];	 	// array of structures to store words
int no_word = 0;			// the number of words

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

	int i=0;
	short isWord=0;

	for(i=0; i<prompt_len; i++){
		putchar(' ');
	}

	for(i=0; i<len; i++){
		if(isspace(text[i])){
			if(isWord){
				putchar(']');
				words[no_word].end = i;

				strncpy(words[no_word].substr, text+words[no_word].start, words[no_word].end-words[no_word].start);	
				words[no_word].substr[words[no_word].end-words[no_word].start] = '\0';
				no_word++;
			}else {
				putchar(' ');
			}
			isWord=0;
		}else {
			if(isWord){
				putchar(' ');
			}else {
				putchar('[');
				words[no_word].start = i;				
			}
			isWord = 1;
		}
	}

	if(isWord){
		putchar(']');
		words[no_word].end = i;
		strncpy(words[no_word].substr, text+words[no_word].start, words[no_word].end-words[no_word].start);	
		words[no_word].substr[words[no_word].end-words[no_word].start] = '\0';
		no_word++;	
	}



	// DO NOT modify the following four lines
	putchar('\n');
	putchar('\n');
	for(i = 0; i < no_word; i++)
		printf("words[%d] = (%d, %d, %s)\n", i, words[i].start, words[i].end, words[i].substr);

	printf("Bye!\n");

	return 0;
}

