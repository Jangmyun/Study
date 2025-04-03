/*
Comments to other_member_1: 김유영
	- Line 30: isopen 변수는 0과 1로만 판단하면 되는데 int보다 short를 사용하는 것이 메모리를 적게 사용할 수 있을 것 같음.
	- Line 65: 마지막 "]"를 출력하는 부분은 만약 사용자가 입력한 문자열의 마지막이 공백이라면 버그가 발생할 수 있으므로 조건문으로 마지막까지 공백인지 아닌지를 판별해야 함.
	- Line 47: isopen ==0 보다 !isopen이 더 이해하기 쉬움. (0은 false, nonzero 값은 true)
	
Comments to other_member_2: 심영준
	- Line 37: 비슷한 로직의 for문을 하나로 줄이면 좋을 것 같음.
	- Line 32: prev변수와 curr변수 중 하나만 사용해도 순회중인 char배열의 원소가 white-space인지 판별할 수 있음.
	- Line 74: text값을 직접 수정하는 방법은 출력 연산을 줄일 수 있기는 하지만 원본 text를 보존하는 방법도 좋을 수 있음 (printf 버퍼는 개행문자나 input req 없다면 버퍼가 가득 차기 전까지 출력하지 않음)

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

	int i;

	// previous code 
	/*
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

	*/
	
	short currCharInWord= 0;

	for(i=0; i<prompt_len; i++){
		printf("%c", ' ');
	}

	for(i=0; i<len; i++){
		const char currChar = text[i];

		if(isspace(currChar)){
			// end of word
			if(currCharInWord){ // end of word
				printf("%c",']');

				words[no_word].end = i;

				char *temp = substr(words[no_word].start, words[no_word].end-1, text);
				strcpy(words[no_word].substr, temp);
				free(temp);

				no_word++;
			}else {
				printf("%c", currChar);
			}
			currCharInWord = 0;
		}else { // when current char is in word
			if(currCharInWord){
				printf("%c", ' ');
			}else { // start of word
				printf("%c", '[');

				words[no_word].start = i;
			}
			currCharInWord = 1;
		}
	}

	if(currCharInWord){
		// if last char was not white space
		putchar(']');

		words[no_word].end = len;
		char *temp = substr(words[no_word].start, words[no_word].end-1, text);
		
		strcpy(words[no_word].substr, temp);
		free(temp);
		temp = NULL;  // prevent dangling pointer issue

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

char *substr(int start, int end, char *str) {
	char *newStr = (char *)malloc(sizeof(char)*(end-start+2));

	if(newStr == NULL){
		printf("string memory allocation failed.\n");
		return newStr;
	}

	strncpy(newStr, str+start, end-start+1);
	newStr[end-start+1] = '\0'; // ensure null termination!!!
	return newStr;
}
