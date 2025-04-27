#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>
#include <string.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <sys/wait.h>

int main(){
	const int SIZE = 4096;
	const char* name = "OS";
	const char* message0 = "HELLO";
	const char* message1 = "WORLD";

	int shm_fd = shm_open(name, O_CREAT | O_RDWR, 0666);
	if(shm_fd == -1){
		perror("shm_open failed");
		exit(1);
	}

	if(ftruncate(shm_fd, SIZE)==-1){
		perror("ftruncate failed");
		exit(1);
	}

	void* ptr = mmap(0, SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, shm_fd, 0);
	if(ptr == (void*)-1){
		perror("mmap failed");
		exit(1);
	}

	pid_t child_pid = fork();
	if(child_pid < 0){
		perror("fork fail");
		exit(1);
	}

	if(child_pid == 0){
		sleep(1);
		printf("%s %ld\n", (char*)ptr, strlen((char*)ptr));
		munmap(ptr, SIZE);
		shm_unlink(name);
	}else {
		sprintf((char*)ptr, "%s", message0);
		ptr += strlen(message0);
		sprintf((char*)ptr, "%s", message1);
		ptr += strlen(message1);
		*(char*)ptr = '\0';
		wait(NULL);
		munmap(ptr, SIZE);
	}

	return 0;
}
