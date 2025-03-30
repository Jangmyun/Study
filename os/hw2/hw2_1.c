#include <stdio.h>
#include <sys/types.h>
#include <dirent.h>

int ls(char *path, int recur, int level);

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
		printf("%s", entry->d_name);
	}



	
	closedir(directory);
	return 0;
}
