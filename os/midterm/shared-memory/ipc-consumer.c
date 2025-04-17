#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>

#define SHM_ID 8

int main() {
	// int shmid = shmget(SHM_KEY, SIZE, IPC_CREAT | 0666);

	char *shared_mem = (char*)shmat(SHM_ID, NULL, 0);
	if(shared_mem == (char*)-1){
		perror("shmat");
		exit(1);
	}

	printf("Consumer: %s\n", shared_mem);

	shmdt(shared_mem);

	return 0;
}
