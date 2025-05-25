#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <sys/types.h>
#include <unistd.h>

#define BUFFER_SIZE 256
#define READ_END 0
#define WRITE_END 1

int main()
{
    int fd[2] = { 0 };
    if(pipe(fd) < 0){
        fprintf(stderr, "Failed to create a pipe in line %d\n", __LINE__);
        exit(-1);
    }

    pid_t pid = fork();
    if(pid < 0){
        fprintf(stderr, "fork() failed\n");
        exit(-1);
    }

    if(pid > 0){
        printf("[parent] Input messages. Type \"exit\" to quit.");
		close(fd[READ_END]);

        while(1){
            char input[BUFFER_SIZE] = "";

            fgets(input, BUFFER_SIZE, stdin);
            int len = strlen(input) - 1;
            input[len] = 0;

            printf("[parent] input = [%s]\n", input);
            if(strcmp(input, "exit") == 0)
                break;

            write(fd[WRITE_END], input, len+1);
        }

		close(fd[WRITE_END]);
        printf("Terminating parent...\n");
        exit(0);
    } else {
		close(fd[WRITE_END]);

        while(1){
            char message[BUFFER_SIZE] = "";
            int n = read(fd[READ_END], message, BUFFER_SIZE);
            printf("[child] n = %d\n", n);
            if(n == 0)
                break;
            printf("[child] message = [%s]\n", message);
        }

        close(fd[READ_END]);
        printf("Terminating child...\n");
        exit(0);
    }

    return 0;
}

