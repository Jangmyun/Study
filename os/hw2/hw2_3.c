#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <sys/stat.h>
#include <string.h>

#define FILEBUFFER_SIZE 512

int ls(char *path, int recur, int level);
char* generateIndentString(int level);
void printWelcomeString();

int main() {
	return 0;
}

int ls(char *path, int recur, int level){
	
	DIR* directory = NULL;
	struct dirent* entry = NULL;
	struct stat st;

	char filenameBuffer[FILEBUFFER_SIZE];

	int currentBufferSize;

	// path validation check
	if(path == NULL){
		directory = opendir(".");
	}else {
		directory = opendir(path);
	}

	// directory validation check
	if(directory == NULL){
		printf("Cannot open %s.\n", path);
		return -1;
	}

	printf("curr_dir = %s\n", path);

	while((entry = readdir(directory)) != NULL){
		stat(entry->d_name, &st); // entry file(or directory)'s state to variable st

		currentBufferSize = snprintf(filenameBuffer, FILEBUFFER_SIZE, "%s/%s", path, entry->d_name);

		if(recur && S_ISDIR(st.st_mode) && strcmp(entry->d_name, ".") && strcmp(entry->d_name, ".")){
			ls(filenameBuffer, 1, level+1);
			continue;
		}

		char* indent = generateIndentString(level);
		printf("%s%-32s %04x %05d %10ld\n", indent, entry->d_name, entry->d_type, st.st_uid, st.st_size);
		free(indent);
		indent = NULL;
	}

	closedir(directory);
	return 0;
}

// generate string 4 spaces per indent
char* generateIndentString(int level){
	char* str = (char*)malloc(level*4);
	if(!str) return NULL;

	memset(str, ' ', level*4);
	str[level*4] = '\0';
	return str;
}


