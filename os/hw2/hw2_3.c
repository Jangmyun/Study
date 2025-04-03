#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <sys/stat.h>
#include <string.h>
#include <ctype.h>
#include <unistd.h>
#include <errno.h>

#define FILEBUFFER_SIZE 512
#define INPUTBUFFER_SIZE 1024
#define TOKEN_DELIMITER " \t\r\n\a"

int ls(char *path, int recur, int level);
char* generateIndentString(int level);
void printWelcomeString();
void sh_loop();
char** tokenizeLine(char *line);
int runCommand(char **argv);

int main(int argc, char **argv) {

	printWelcomeString();
	
	// command loop
	sh_loop();		

	return 0;
}

void sh_loop(){

	char *shellIndicator = "my_shell0 $ ";
	char inputBuffer[INPUTBUFFER_SIZE] = "";
	char **tokenizedInput;
	int status;

	do {
		printf("%s", shellIndicator);
		fgets(inputBuffer, INPUTBUFFER_SIZE, stdin);
		int inputLen = strlen(inputBuffer) - 1;
		inputBuffer[inputLen] = 0;
		
		tokenizedInput = tokenizeLine(inputBuffer);

		printf("input command = \"%s\"\n", inputBuffer); // print full command string

		// print tokenized command and args
		printf("cmd =([%s]", tokenizedInput[0]);
		for(int i=1; tokenizedInput[i] != NULL; i++) {
			printf(", [%s]", tokenizedInput[i]);
		}
		printf(")\n");
		
		status = runCommand(tokenizedInput);

		free(tokenizedInput);

	} while (status);

	printf("Bye!\n");
}

char** tokenizeLine(char *line){
	int bufferSize = INPUTBUFFER_SIZE;
	int i=0;
	char **tokens = (char **)malloc(sizeof(char *) * bufferSize);
	char *token;

	if(!tokens){
		printf("input token allocation error\n");
		exit(EXIT_FAILURE);
	}

	token = strtok(line, TOKEN_DELIMITER);

	while(token != NULL){
		tokens[i] = token;
		i++;
		
		token = strtok(NULL, TOKEN_DELIMITER);
	}

	tokens[i] = NULL;
	return tokens;
}

int runCommand(char **argv){

	int dir_status;

	// cmd validation check
	if (!argv[0]){
		printf("command not entered.\n");
		return 1;
	}	

	if(!strcmp(argv[0], "exit")) return 0;

	if(!strcmp(argv[0], "cd")){
		// cd cmd argument validation check
		if (argv[1] == NULL) {
			printf("destination directory is not specified.\n");
			return 1;
		}
		
		dir_status = chdir(argv[1]);
		if(dir_status == -1){
			perror("Directory Not Changed");
			return 1;
		}

		return 1;
	}

	if(!strcmp(argv[0], "ls")) {
		return ls(argv[1]? argv[1]: ".", 0, 0);
	}

	if(!strcmp(argv[0], "recur_ls")) {
		return ls(argv[1]? argv[1]: ".", 1, 0);
	}

	if(!strcmp(argv[0], "md")){
		if(argv[1] == NULL){
			printf("directory name is not defined.\n");
			return 1;
		}
		
		dir_status = mkdir(argv[1], 0755);
		if(dir_status != 0){
			perror("Directory Not Made");
			return 1;
		}

		return 1;
	}

	if(!strcmp(argv[0], "rd")){
		if(argv[1] == NULL){
			printf("destination directory is not specified.\n");
			return 1;
		}
		
		dir_status = rmdir(argv[1]);
		if(dir_status != 0){
			perror("Directory Not Removed");
			return 1;
		}
		
		return 1;
	}

	return 1;
}

int ls(char *path, int recur, int level){

	DIR* directory = NULL;
	struct dirent* entry = NULL;
	struct stat st;

	char filenameBuffer[FILEBUFFER_SIZE]; // for full path of file (ex. './Temp1/'Temp2 )
	int currentBufferSize;

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
		stat(entry->d_name, &st); // entry file(or directory)'s state to var st
		
		// concat two string (parent_path + '/' + entry.d_name)
		currentBufferSize = snprintf(filenameBuffer, FILEBUFFER_SIZE, "%s/%s", path, entry->d_name);

		// check if it is recursive ls, directory, and d_name is not "." or ".."
		if(recur && S_ISDIR(st.st_mode)  && strcmp(entry->d_name, ".") && strcmp(entry->d_name, "..")){
			ls(filenameBuffer, 1, level+1);
			continue;
		}

		char* indent = generateIndentString(level); // indent string allocation
		printf("%s%-32s %04x %05d %10ld\n", indent, entry->d_name, entry->d_type, st.st_uid, st.st_size);
		free(indent); // free indentation string memory
		indent=NULL;
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

void printWelcomeString(){
	printf("Welcome to my_shell0. This shell supports cd, ls, recur_ls, md, rd, exit commands.\n- cd <dir>: change directory\n- ls [<dir>]: list the files and subdirectories of the specified directory\n\tif <dir> is omitted, list the current directoy\n- recur_ls [<dir>]: list the files and subdirectories of the specified directory in a recursive way\n\tif <dir> is omitted, list the current directory\n- md <dir>: make a new directory\n- rd <dir>: make a new directory\n- exit: printf \"Bye!\" and terminate\n");
}

