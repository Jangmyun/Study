#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>

#define BUFFER_SIZE 25
#define READ_END 0
#define WRITE_END 1

int main() {
	
	char write_msg[BUFFER_SIZE] = "Greetings";
	char read_msg[BUFFER_SIZE];

	int fd[2] = {0};
	pid_t pid = 0;

	if(pipe(fd) == -1){
		fprintf(stderr, "PIPE FAILED.\n");
		return 1;
	}

	pid = fork();
	
	if(pid<0){
		fprintf(stderr, "FORK FAILED\n");
		return 1;
	}

	if(pid > 0){  // parent
		close(fd[READ_END]);
		
		write(fd[WRITE_END], write_msg, strlen(write_msg)+1);

		close(fd[WRITE_END]);
	}
	else {		// child
		close(fd[WRITE_END]);

		read(fd[READ_END], read_msg, BUFFER_SIZE);
		printf("Read: %s\n", read_msg);

		close(fd[READ_END]);
	}
	return 0;
}
