#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
#include <stdlib.h>

#define NUM_THREADS 3

void* runner(void* arg){
	printf("thread\n");
	return NULL;
}

int main() {
	int i=0, policy =0;
	pthread_t tid[NUM_THREADS]= {0};
	pthread_attr_t attr;

	pthread_attr_init(&attr);

	if(pthread_attr_getschedpolicy(&attr, &policy) != 0){
		fprintf(stderr, "Unable to get policy\n");
	} else {
		if(policy == SCHED_OTHER){
			printf("SCHED OTHER\n");
		}else if(policy == SCHED_RR){
			printf("SCHED_RR\n");
		}else if(policy == SCHED_FIFO){
			printf("SCHED_FIFO\n");
		}
	}

	if(pthread_attr_setschedpolicy(&attr, SCHED_FIFO)!=0){
		fprintf(stderr, "Unable to set policy\n");
	}

	for(i=0; i<NUM_THREADS; i++){
		pthread_create(&tid[i], &attr, runner, NULL);
	}

	for(i=0; i<NUM_THREADS; i++){
		pthread_join(tid[i], NULL);
	}

	return 0;
}
