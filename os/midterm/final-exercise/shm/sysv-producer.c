#include <stdio.h>
#include <sys/shm.h>
#include <sys/ipc.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>

#define SHM_SIZE 1024
#define SHM_KEY 0x1234

#define DEBUG

#ifdef DEBUG
#endif

int main() {
	int shmid = shmget(SHM_KEY, SHM_SIZE, IPC_CREAT | 0666);
	if(shmid == -1){
		perror("shmget failed");
		exit(1);
	}
#ifdef DEBUG
	printf("shmget\n");
#endif

	
	char* shared_mem = (char*)shmat(shmid, NULL, 0);
	if(shared_mem == (char*)-1){
		perror("shmat failed");
		exit(1);
	}

#ifdef DEBUG
	printf("shmat\n");
#endif

	sprintf(shared_mem, "%s", "HELLO, WORLD!");
	if(shmdt(shared_mem)==-1){
		perror("shmdt failed");
		exit(1);
	}

#ifdef DEBUG
	printf("shmdt\n");
#endif
	
	return 0;
}
