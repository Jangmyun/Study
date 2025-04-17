#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
	pid_t child_pid=fork();

	if(child_pid == 0){
		return 0;
	}
	

	printf("hello hello\n");

	return 0;
}
