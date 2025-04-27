#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>

#define SHM_SIZE 1024
#define SHM_KEY 0x1234

#define DEBUG

int main() {
	int shmid = shmget(SHM_KEY, SHM_SIZE, IPC_CREAT|0666);
	if(shmid == -1){
		perror("shmget failed");
		exit(1);
	}

	char* shared_mem = (char*)shmat(shmid, NULL, 0);
	if(shared_mem == (char*)-1){
		perror("shmat failed");
		exit(1);
	}

	printf("Shared memory: %s\n", shared_mem);

	shmdt(shared_mem);

	shmctl(shmid, IPC_RMID, NULL);

	return 0;
}
