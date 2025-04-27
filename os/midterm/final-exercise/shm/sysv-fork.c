#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>

#define SHM_SIZE 1024
#define SHM_KEY 0x1234

int main() {
	int shmid = shmget(SHM_KEY, SHM_SIZE, IPC_CREAT|0666);
	if(shmid == -1){
		perror("shmget failed");
		exit(1);
	}

	pid_t child_pid = fork();
	if(child_pid<0){
		perror("fork failed");
		exit(1);
	}

	if(child_pid==0){ // child
		char* shared_mem = (char*)shmat(shmid, NULL, 0);
		if(shared_mem == (char*)-1){
			perror("shmat failed");
			exit(1);
		}

		sprintf(shared_mem, "HELLO, WORLD!");
		shmdt(shared_mem);
		exit(0);

	}else { // parent
		wait(NULL);

		char* shared_mem = (char*)shmat(shmid, NULL, 0);
		if(shared_mem == (char*)-1){
			perror("shmat failed");
			exit(1);
		}

		printf("Shared memory: %s\n", shared_mem);

		shmdt(shared_mem);
		shmctl(shmid, IPC_RMID, NULL);
	}

	return 0;
}
