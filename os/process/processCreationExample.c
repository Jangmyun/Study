#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main() {
	pid_t child_pid = fork();

	if(child_pid < 0){
		fprintf(stderr, "fork failed.\n");
		exit(-1);
	}
	else if (child_pid == 0) {
		execlp("/bin/ls", "ls", NULL);
	}
	else {
		wait(NULL);
		printf("child completed.\n");
		exit(0);
	}

	return 0;
}
