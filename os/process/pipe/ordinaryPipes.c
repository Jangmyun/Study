#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>

#define BUFFER_SIZE 25
#define READ_END 0
#define WRITE_END 1

int main(void) {
  int fd[2];
  pid_t pid;
  char write_msg[BUFFER_SIZE] = "Greetings";
  char read_msg[BUFFER_SIZE];

  if (pipe(fd) == -1) {
    perror("Pipe failed");
    return 1;
  }

  pid = fork();
  if (pid < 0) {
    perror("Fork failed");
    return 1;
  }

  if (pid > 0) {
    // 부모 프로세스: 쓰기 전용
    close(fd[READ_END]);
    write(fd[WRITE_END], write_msg, strlen(write_msg) + 1);
    close(fd[WRITE_END]);
  } else {
    // 자식 프로세스: 읽기 전용
    close(fd[WRITE_END]);
    read(fd[READ_END], read_msg, BUFFER_SIZE);
    printf("Received: %s\n", read_msg);
    close(fd[READ_END]);
  }

  return 0;
}