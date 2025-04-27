#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <stdio.h>

int main() {
	const int SIZE=4096;
	const char* name = "OS";

	int shm_fd = 0;
	void* ptr = NULL;

	shm_fd = shm_open(name, O_RDONLY, 0666);
	if(shm_fd == -1){
		perror("shm_open falied");
		exit(1);
	}

	ptr = mmap(0, SIZE, PROT_READ, MAP_SHARED, shm_fd, 0);
	if(ptr == (void*)-1){
		perror("mmap failed");
		exit(1);
	}

	printf("%s %ld\n", (char*)ptr, strlen((char*)ptr));

	shm_unlink(name);

	return 0;
}
