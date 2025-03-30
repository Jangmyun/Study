#include <ctype.h>
#include <stdio.h>
#include <string.h>

#define MAX_TEXT 256
#define MAX_LEN 128
#define SIZE 512

typedef struct {
  int start, end;        // the start and end indices of the word
  char substr[MAX_LEN];  // substring (word)
} Substring;

Substring words[SIZE];  // array of structures to store words
int no_word = 0;        // the number of words

int main() {
  char *prompt = "input a text: ";
  int prompt_len = strlen(prompt);

  // read a text line
  char text[MAX_TEXT] = "";
  printf("%s", prompt);
  fgets(text, MAX_TEXT, stdin);
  int len = strlen(text) - 1;
  text[len] = 0;

  for (int i = 0; i < prompt_len; i++) printf(" ");

  int isopen = 0;

  for (int i = 0; i < len; i++) {
    if (isopen == 0 && isspace(text[i])) {
      printf(" ");
      continue;
    }
    if (isopen == 0 && !isspace(text[i])) {  // 단어 시작
      printf("[");
      isopen = 1;

      words[no_word].start = i;
      words[no_word].substr[i - words[no_word].start] =
          text[i];  // 시작 문자 집어넣기기

      continue;
    }
    if (isopen == 1 && isspace(text[i])) {  // 단어 끝
      printf("]");
      isopen = 0;

      words[no_word].end = i;
      words[no_word].substr[i - words[no_word].start] =
          '\0';  // 시작 문자 집어넣기기
      no_word++;

      continue;
    }

    if (!isspace(text[i])) {
      printf(" ");  // 단어 중간에 공백을 출력
      words[no_word].substr[i - words[no_word].start] = text[i];
      continue;
    }
  }
  printf("]");  // 마지막
  words[no_word].end = len;
  no_word++;

  // DO NOT modify the following four lines
  putchar('\n');
  putchar('\n');
  for (int i = 0; i < no_word; i++)
    printf("words[%d] = (%d, %d, %s)\n", i, words[i].start, words[i].end,
           words[i].substr);

  printf("Bye!\n");

  return 0;
}