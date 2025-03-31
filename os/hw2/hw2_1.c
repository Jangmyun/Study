#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <sys/stat.h>
#include <string.h>

int ls(char *path, int recur, int level);
char* generateIndentString(int level);

int main (int argc, char *argv[]){
	if(argc == 1){
		ls(".", 1, 0);
	}else {
		ls(argv[1], 1, 0);
	}

	return 0;
}

int ls(char *path, int recur, int level){

	DIR* directory = NULL;
	struct dirent* entry = NULL;
	struct stat st;

	// path validation check
	if(path == NULL){
		directory = opendir(".");
	}else {
		directory = opendir(path);
	}

	// directory validation check
	if(directory==NULL){
		printf("Cannot open %s.\n", path);
		return -1;
	}
		
	printf("cur_dir = %s\n", path);


	while((entry = readdir(directory)) != NULL){
		stat(entry->d_name, &st);
		printf("%s\n", entry->d_name);
	}



	
	closedir(directory);
	return 0;
}

char* generateIndentString(int level){
	char* str = (char*)malloc(level*4);
	if(!str) return NULL;

	memset(str, ' ', level*4);
	str[level*4] = '\0';
	return str;
}
