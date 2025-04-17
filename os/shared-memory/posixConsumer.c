#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <unistd.h>

int main() {
  const int SIZE = 4096;
  const char *name = "OS";

  int shm_fd;
  void *ptr;

  // 공유 메모리 객체 열기 (읽기 전용)
  shm_fd = shm_open(name, O_RDONLY, 0666);
  if (shm_fd == -1) {
    perror("shm_open 실패");
    exit(1);
  }

  // 공유 메모리 매핑 (읽기 전용)
  ptr = mmap(0, SIZE, PROT_READ, MAP_SHARED, shm_fd, 0);
  if (ptr == MAP_FAILED) {
    perror("mmap 실패");
    exit(1);
  }

  // 공유 메모리에서 데이터 읽기
  printf("%s\n", (char *)ptr);

  // 공유 메모리 객체 제거 (이 프로세스만 unlink함)
  shm_unlink(name);

  return 0;
}
