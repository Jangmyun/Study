#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/ipc.h>
#include <sys/stat.h>

int main() {
	// size of shared memory (bytes)
	const int SIZE = 4096;

	const char *message0 = "Hello";
	const char *message1 = "World";

	int shmid = shmget(IPC_PRIVATE, SIZE, IPC_CREAT | 0666);
	if(shmid == -1){
		perror("shmget");
		exit(1);
	}
	printf("SHMID: %d\n", shmid);

	char* shared_mem = (char*)shmat(shmid, NULL, 0);
	if(shared_mem == (char *)-1){
		perror("shmat");
		exit(1);
	}

	sprintf(shared_mem, "%s", message0);

	printf("Producer: shared memory written.\n");

	shmdt(shared_mem);

	return 0;
}
