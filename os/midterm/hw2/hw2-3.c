#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <string.h>
#include <sys/stat.h>
#include <ctype.h>
#include <unistd.h>
#include <errno.h>

#define BUFFER_SIZE 512

void shell_loop();
int runCommand(char* argv[]);
void printHello() { printf("hello shell\n");}
char* generateIndent(int level);
int ls(char* path, int recur, int level);
char** tokenizeLine(char *input);

int main() {
	printHello();
	
	shell_loop();

	return 0;
}

int runCommand(char* argv[]){
	int dir_status = 0;

	if(argv == NULL || !argv[0]){
		fprintf(stderr, "command not entered.\n");
		return 0;
	}else if(!strcmp(argv[0], "exit")) return 1;
	else if(!strcmp(argv[0], "cd")){
		if(argv[1] == NULL){
			fprintf(stderr, "Destination directory not defined.\n");
			return 1;
		}

		dir_status = chdir(argv[1]);

		if(!dir_status){
			fprintf(stderr, "Directory not changed.\n");
			return 1;
		}
	}
	else if(!strcmp(argv[0], "ls")){
		ls(argv[1]? argv[1]: ".", 0, 0);
		return 1;
	}
	
	else if(!strcmp(argv[0], "recur_ls")){
		ls(argv[1]? argv[1]: ".", 1, 0);
	}

	else if(!strcmp(argv[0], "md")){
		if(argv[1] == NULL){
			fprintf(stderr, "Directory name is not defined.\n");
			return 1;
		}

		dir_status = mkdir(argv[1], 0755);

		if(dir_status){
			fprintf(stderr, "mkdir failed\n");
			return 1;
		}
	}

	else if(!strcmp(argv[0], "rd")){
		if(argv[1] == NULL){
			fprintf(stderr, "Directory name is not defined.\n");
			return 1;
		}
		
		dir_status = rmdir(argv[1]);

		if(dir_status){
			fprintf(stderr, "Directory is not deleted.\n");
			return 1;
		}
	}

	else fprintf(stderr, "Command not found\n");
	return 1;
}

void shell_loop(){
	char* shellIndicator = "my_shell0 $ ";	
	char inputBuffer[BUFFER_SIZE] = "";
	char** tokenizedInput = NULL;
	short status;
	int input_len;

	do {
		printf("%s", shellIndicator);
		fgets(inputBuffer, BUFFER_SIZE, stdin);
		input_len = strlen(inputBuffer) - 1;

		tokenizedInput = tokenizeLine(inputBuffer);
		
		printf("input command = \"%s\"\n", inputBuffer);

		printf("cmd =([%s]", tokenizedInput[0]);
		for(int i=1; tokenizedInput[i] != NULL; i++) {
			printf(", [%s]", tokenizedInput[i]);
		}
		printf(")\n");	

		status = runCommand(tokenizedInput);
		free(tokenizedInput);
		
	}while(status);

	printf("Bye!\n");
}

char** tokenizeLine(char *input){
	const char* token_delimiter = " \t\r\n\a";
	int token_no = 0;

	char** tokens = (char **)malloc(sizeof(char*)*BUFFER_SIZE);
	char* token = NULL;

	if(!tokens){
		fprintf(stderr, "input token allocation err");
		exit(1);
	}

	token = strtok(input, token_delimiter);

	while(token != NULL){
		tokens[token_no] = token;
		token_no++;

		token = strtok(NULL, token_delimiter);
	}

	tokens[token_no] = NULL;
	return tokens;
}

int ls(char* path, int recur, int level){
	DIR* dir=NULL;
	struct dirent* entry= NULL;
	struct stat st;

	char fileBuffer[BUFFER_SIZE];
	int currBufferSize=0;

	if(path==NULL) dir = opendir(".");
	else dir = opendir(path);

	if(dir == NULL){
		printf("Cannot open %s\n", path);
		return -1;
	}

	printf("curr_dir = %s\n", path);
	
	while((entry = readdir(dir))!= NULL){
		stat(entry->d_name, &st);
		
		currBufferSize = snprintf(fileBuffer, BUFFER_SIZE, "%s/%s", path, entry->d_name);

		if(recur && S_ISDIR(st.st_mode) &&
			strcmp(entry->d_name, ".") &&
			strcmp(entry->d_name, "..")
		){
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

char *generateIndent(int level){
	char *indent = (char*)malloc(level*4+1);
	if (strlen(indent)==1) return NULL;

	memset(indent,' ', level*4);
	indent[level*4] = '\0';

	return indent;
}
