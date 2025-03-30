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

  // use hw1_2 code

  // declare variables
  int i = 0;       // for loop statement
  short prev = 0;  // save previous character is space or not. 1 for non-space,
                   // 0 for space
  short curr = 0;  // save current character case

  // use for loop to check start of word and end of word
  for (i = 0; i <= len; i++) {
    // check current character is space of not
    if (isspace(text[i]) || text[i] == '\0') {
      // curr is space
      curr = 0;
    } else {
      // curr is non-space
      curr = 1;
    }
    // change text[i] to something
    if (prev < curr) {
      words[no_word].start = i;
    } else if (prev > curr) {
      words[no_word].end = i;
      strncpy(words[no_word].substr, text + words[no_word].start,
              words[no_word].end - words[no_word].start);
      no_word++;
    }

    // save curr to prev
    prev = curr;
  }

  prev = 0;
  curr = 0;
  // use for loop to check start of word and end of word
  for (i = 0; i < len; i++) {
    // check current character is space of not
    if (isspace(text[i])) {
      // curr is space
      curr = 0;
    } else {
      // curr is non-space
      curr = 1;
    }
    // change text[i] to something
    if (prev < curr) {
      text[i] = '[';
    } else if (prev > curr) {
      text[i] = ']';
    }
    // save curr to prev
    prev = curr;
  }

  for (i = 0; i < len; i++) {
    if (!(text[i] == '[' || text[i] == ']') && !isspace(text[i])) {
      text[i] = ' ';
    }
  }

  // check text[i] for last word
  // end of text was word but, we can't put ']' because text[i] was '\0'
  // check i and i+1 are valid index and last character of text war non-space
  // character
  if ((i < MAX_TEXT) && (curr == 1)) {
    text[i] = ']';
    text[i + 1] = '\0';
  }

  // print space
  for (i = 0; i < prompt_len; i++) {
    printf(" ");
  }
  // print changed text
  printf("%s", text);

  // DO NOT modify the following four lines
  putchar('\n');
  putchar('\n');
  for (i = 0; i < no_word; i++)
    printf("words[%d] = (%d, %d, %s)\n", i, words[i].start, words[i].end,
           words[i].substr);

  printf("Bye!\n");

  return 0;
}
