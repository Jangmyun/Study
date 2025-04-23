#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/mman.h>

int main(){
	const int SIZE=4096;
	const char* name = "OS";
	const char* message0 = "HELLO";
	const char* message1 = "WORLD";

	int shm_fd = 0;
	void *ptr = NULL;

	shm_fd = shm_open(name, O_CREAT|O_RDWR, 0666);
	if(shm_fd == -1){
		perror("shm_open falied");
		exit(1);
	}
	
	if(ftruncate(shm_fd, SIZE)== -1){
		perror("ftruncate failed");
		exit(1);
	}

	ptr = mmap(0, SIZE, PROT_WRITE, MAP_SHARED, shm_fd, 0);
	if(ptr == (void*)-1){
		perror("mmap failed");
		exit(1);
	}

	sprintf(ptr, "%s", message0);
	ptr += strlen(message0);
	sprintf(ptr, "%s", message1);
	ptr += strlen(message1);
	*(char*)ptr = '\0';
	
	return 0;
}
