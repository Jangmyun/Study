#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX_TEXT 256

int main()
{
	char *prompt = "input a text: ";
	int prompt_len = strlen(prompt);

	char text[MAX_TEXT] = "";
	printf("%s", prompt);
	fgets(text, MAX_TEXT, stdin);
	int len = strlen(text) - 1;
	text[len] = 0;

	int i=0;

	for(i=0; i<prompt_len; i++ ){
		printf(" ");
	}

	short isWord = 0;

	for(i=0; i<len; i++){
		if(isspace(text[i])){
			if(isWord){
				printf("]");
			}else {
				printf(" ");
			}
			isWord = 0;
		}else {
			if(isWord){
				printf(" ");
			}else {
				printf("[");
			}
			isWord = 1;
		}

	}

	if(isWord){
		printf("]");
	}

	putchar('\n');
	printf("Bye!\n");

	return 0;
}

