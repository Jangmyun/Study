#include <dirent.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>

#define FILEBUFFER_SIZE 512

int ls(char* path, int recur, int level);
char* generateIndentString(int level);

int main(int argc, char* argv[]) {
  if (argc == 1) {
    ls(".", 1, 0);
  } else {
    ls(argv[1], 1, 0);
  }
  return 0;
}

int ls(char* path, int recur, int level) {
  DIR* directory = NULL;
  struct dirent* entry = NULL;
  struct stat st;

  char filenameBuffer[FILEBUFFER_SIZE];  // for full path of file (ex.
                                         // './Temp1/'Temp2 )
  int currentBufferSize;

  // path validation check
  if (path == NULL) {
    directory = opendir(".");
  } else {
    directory = opendir(path);
  }

  // directory validation check
  if (directory == NULL) {
    printf("Cannot open %s.\n", path);
    return -1;
  }

  printf("cur_dir = %s\n", path);

  while ((entry = readdir(directory)) != NULL) {
    stat(entry->d_name, &st);  // entry file(or directory)'s state to var st

    // concat two string (parent_path + '/' + entry.d_name)
    currentBufferSize =
        snprintf(filenameBuffer, FILEBUFFER_SIZE, "%s/%s", path, entry->d_name);

    // check if it is recursive ls, directory, and d_name is not "." or ".."
    if (recur && S_ISDIR(st.st_mode) && strcmp(entry->d_name, ".") &&
        strcmp(entry->d_name, "..")) {
      ls(filenameBuffer, 1, level + 1);
      continue;
    }

    char* indent = generateIndentString(level);  // indent string allocation
    printf("%s%-32s %04x %05d %10ld\n", indent, entry->d_name, entry->d_type,
           st.st_uid, st.st_size);
    free(indent);  // free indentation string memory
    indent = NULL;
  }

  closedir(directory);
  return 0;
}

// generate string 4 spaces per indent
char* generateIndentString(int level) {
  char* str = (char*)malloc(level * 4);
  if (!str) return NULL;

  memset(str, ' ', level * 4);
  str[level * 4] = '\0';
  return str;
}
