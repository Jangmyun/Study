#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/shm.h>
#include <sys/mman.h>

int main() {

	const int SIZE = 4096;
	const char* name = "OS";

	int shm_fd = -1;
	void* ptr = NULL;

	shm_fd = shm_open(name, O_RDONLY, 0666);

	ptr = mmap(0, SIZE, PROT_READ, MAP_SHARED, shm_fd, 0);

	printf("%s", (char*)ptr);

	shm_unlink(name);

	return 0;
}
