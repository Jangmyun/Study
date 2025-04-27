#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

#define READ_END 0
#define WRITE_END 1
#define BUF_SIZE 256

int main() {

	int fd[2];
	pid_t pid;
	char message[] = "HELLO_WORLD";
	char buf[BUF_SIZE];

	if(pipe(fd)==-1){
		perror("pipe failed");
		exit(1);
	}

	pid = fork();
	if(pid < 0){
		perror("fork failed");
		exit(1);
	}

	if(pid == 0){
		close(fd[WRITE_END]);
		
		read(fd[READ_END], buf, BUF_SIZE);

		printf("READ: %s\n", buf);

		close(fd[READ_END]);
	} else {
		close(fd[READ_END]);

		write(fd[WRITE_END], message, strlen(message)+1);

		printf("WRITE: %s\n", message);
		
		close(fd[WRITE_END]);
	}

	return 0;

}


