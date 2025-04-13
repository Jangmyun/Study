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
  const char *message0 = "Hello";
  const char *message1 = "World!";

  int shm_fd;
  void *ptr;

  // 공유 메모리 객체 생성
  shm_fd = shm_open(name, O_CREAT | O_RDWR, 0666);
  if (shm_fd == -1) {
    perror("shm_open 실패");
    exit(1);
  }

  // 공유 메모리 크기 설정
  if (ftruncate(shm_fd, SIZE) == -1) {
    perror("ftruncate 실패");
    exit(1);
  }

  // 공유 메모리 매핑
  ptr = mmap(0, SIZE, PROT_WRITE, MAP_SHARED, shm_fd, 0);
  if (ptr == MAP_FAILED) {
    perror("mmap 실패");
    exit(1);
  }

  // 데이터 쓰기
  sprintf(ptr, "%s", message0);
  ptr += strlen(message0);
  sprintf(ptr, "%s", message1);

  return 0;
}
