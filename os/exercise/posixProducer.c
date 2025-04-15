#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <unistd.h>

int main() {
  const int SIZE = 4096;
  const char *name = "OS";
  const char *message_0 = "hello";
  const char *message_1 = "world";

  int shm_fd = 0;
  void *ptr = NULL;

  shm_fd = shm_open(name, O_CREAT | O_RDWR, 0666);
  if (shm_fd == -1) {
    perror("shm_open failed.");
    exit(1);
  }

  if (ftruncate(shm_fd, SIZE) == -1) {
    perror("ftruncate 실패");
    exit(1);
  }

  ptr = mmap(0, SIZE, PROT_WRITE, MAP_SHARED, shm_fd, 0);
  if (ptr == MAP_FAILED) {
    perror("mmap 실패");
    exit(1);
  }

  return 0;
}