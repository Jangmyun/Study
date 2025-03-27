#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
int main(){
	pid_t child_id = fork();
	printf("child_id = %d\n", child_id);

	if(child_id!=0){
		wait(NULL);
		printf("parent code executed.\n");
	}else {
		printf("child code executed.\n");
	}

	printf("Hello world!\n");

	return 0;
}
