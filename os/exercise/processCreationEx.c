#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>

int main() {
  pid_t child_pid = fork();
  int stat;

  if (child_pid < 0) {
    fprintf(stderr, "fork failed.\n");
    exit(1);
  } else if (child_pid == 0) {
    execlp("/bin/ls", "ls", NULL);
    exit(1);
  } else {
    wait(&stat);
    printf("child_state = %d\n", stat);
  }

  return 0;
}