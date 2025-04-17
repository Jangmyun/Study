#include <stdio.h>
#include <string.h>
#include <dirent.h>
#include <stdlib.h>
#include <sys/stat.h>

#define BUFFER_SIZE 512

int ls(char *path, int recur, int level);
char* generateIndent(int level);

int main(int argc, char *argv[]){
	
	if(argc == 1) ls(".", 1, 0);
	else ls(argv[1], 1, 0);

	return 0;
}

int ls(char *path, int recur, int level){
	DIR *dir = NULL; // directory pointer
	struct dirent* entry = NULL; // directory's entry pointer
	struct stat st; // for getting entry's state

	char fileBuffer[BUFFER_SIZE];
	int currBufferSize = 0; // snprint return input length and should be saved it's value

	// open directory
	if(path==NULL) dir = opendir(".");
	else dir = opendir(path);

	// if openddir failed 
	if(dir == NULL){
		printf("Cannot open %s\n", path);
		return -1;
	}

	printf("cur_dir = %s\n", path);

	while((entry = readdir(dir))!=NULL){
		stat(entry->d_name, &st);

		currBufferSize = snprintf(fileBuffer, BUFFER_SIZE, "%s/%s", path, entry->d_name);

		if(recur && S_ISDIR(st.st_mode) && 
			strcmp(entry->d_name, ".") && 
			strcmp(entry->d_name, "..")){
			
			ls(fileBuffer, 1, level+1);
			continue;
		}
		
		char* indent = generateIndent(level);
		printf("%s%-32s %04x %05d %10ld\n", indent, entry->d_name, entry->d_type, st.st_uid, st.st_size);
		free(indent);
		indent = NULL;
	}

	closedir(dir);
	return 0;
}

char* generateIndent(int level){
	char* indent = (char*)malloc(level*4 + 1);
	if(!indent) return NULL;

	memset(indent, ' ', level*4);
	indent[level*4] = '\0';
	return indent;
}
