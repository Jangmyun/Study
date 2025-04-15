#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

int main() {
  pid_t childPID = fork();

  if (childPID != 0) {  // parent
    wait(NULL);
    printf("waited parent\n");
  } else {  // child
    printf("child\n");
  }

  printf("helloworld\n");

  return 0;
}