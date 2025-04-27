#include <stdio.h>
#include <stdlib.h>

#include <unistd.h>
#include <wait.h>

int sum = 0;

int main(int argc, char *argv[]){
	if(argc<2 || atoi(argv[1])==0){
		printf("Usage: %s <upper>\n", argv[0]);
		exit(0);
	}

	pid_t child_pid = fork();

	if(child_pid < 0) {
		fprintf(stderr, "fork failed\n");
		exit(1);
	}else if(child_pid == 0){
		int upper = atoi(argv[1]);
		for(int i=1; i<=upper; i++){
			sum+=i;
		}
		exit(0);
	}else {
		wait(NULL);
		printf("Child Completed. sum = %d\n", sum);
		exit(0);
	}

	return 0;
}
