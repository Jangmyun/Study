#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <dirent.h>
#include <unistd.h>
#include <errno.h>
#include <ctype.h>

#define BUFFER_SIZE 512
#define TRUE 1
#define FALSE 0

#define DEBUG

void shell_loop();
int runCommand(char* argv[]);
void printHello() { printf("Hello Shell!\n");}
char* generateIndent(int level);
int ls(char* path, int recur, int level);
int splitArgs(char *input, char *args[], int max_arg);

int main() {
	
	printHello();
	shell_loop();

	return 0;	
}

void shell_loop(){
	char* shellIndicator = "my_shell $ ";
	char input[BUFFER_SIZE] = "";
	char *args[BUFFER_SIZE]  = {NULL};

	while(1){
		printf("%s", shellIndicator);
		fgets(input, BUFFER_SIZE, stdin);
		int len = strlen(input) -1;
		input[len] = 0;

#ifdef DEBUG
		printf("input command = %s (len = %d)\n", input, len);
#endif

		int no_arg = splitArgs(input, args, BUFFER_SIZE);
		
#ifdef DEBUG
		printf("no_arg = %d\n", no_arg);
		for(int i=0; i<no_arg; i++)
			printf("args[%d] = %s\n", i, args[i]);
		printf("args[%d] = %p\n", no_arg, args[no_arg]);
#endif
		
		if(no_arg == 0) continue;

		int wait_for_child = TRUE;
		
		if(!strcmp(args[no_arg-1], "&")) {
			wait_for_child = FALSE;
			args[no_arg-1] = NULL;
			no_arg--;
		}
	}
}

int splitArgs(char* input, char* args[], int max_arg){
	int len = strlen(input);
	
	int no_arg = 0;

	for(int i=0; i<len; i++){
		while(isspace(input[i])) i++;
		
		if(input[i] == 0) break;

		args[no_arg++] = &input[i];

		for(; i<len && !isspace(input[i]); i++);

		input[i] = 0;

		if(no_arg >= max_arg - 1) break;
	}

	args[no_arg] = NULL;

	return no_arg;
}

int ls(char* path, int recur, int level){
	DIR* dir = NULL;
	struct dirent* entry = NULL;
	struct stat st;

	char filename[BUFFER_SIZE] = "";
	int filename_len = 0;

	if(path == NULL) dir = opendir(".");
	else dir = opendir(path);
	
	if(dir == NULL) return -1;

	while((entry = readdir(dir))!= NULL){
		stat(entry->d_name, &st);
		snprintf(filename, BUFFER_SIZE, "%s/%s", path, entry->d_name);

		if(recur && S_ISDIR(st.st_mode)&&
			strcmp(entry->d_name, ".")&& strcmp(entry->d_name, "..")){
			
			ls(filename, 1, level+1);
			continue;
		}

		char* indent = generateIndent(level);
		printf("%s %-32s %04x %05d %10ld\n", indent, entry->d_name, entry->d_type, st.st_uid, st.st_size);

		free(indent);
		indent = NULL;
	}
	closedir(dir);
	
	return 0;
}

char* generateIndent(int level){
	char* indent = (char*)malloc(level*4+1);
	if(!indent) return NULL;
	memset(indent, ' ', level*4);
	indent[level*4] = 0;
	return indent;
}
