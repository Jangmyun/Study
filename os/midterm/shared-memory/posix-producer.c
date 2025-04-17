#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/mman.h>

int main() {

	const int SIZE = 4096;
	const char* name = "OS";
	const char* msg0 = "Hello";
	const char* msg1 = "World";

	int shm_fd = -1;
	void* ptr;

	shm_fd = shm_open(name, O_CREAT | O_RDWR, 0666);
	if(shm_fd == -1) exit(1);

	if(ftruncate(shm_fd, SIZE) == -1) exit(1);

	ptr = mmap(0, SIZE, PROT_WRITE, MAP_SHARED, shm_fd, 0);

	sprintf(ptr, "%s", msg0);
	ptr += strlen(msg0);
	sprintf(ptr, "%s", msg1);
	ptr += strlen(msg1);

	return 0;
}


