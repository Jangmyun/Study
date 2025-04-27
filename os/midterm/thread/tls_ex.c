#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

#define THREADS 3

__thread int tls;
int global;

void* func(void *arg){

	int num = *(int *)arg;
	tls=num;
	global =num;

	printf("Thread %d: tls-%d, global-%d\n", num, tls, global);

	printf("Thread %d exited.\n", num);
	return NULL;
}

int main() {

	int ret = 0;
	pthread_t thread[THREADS] = {0};
	int param[THREADS] = {0};

	for(int num=0; num<THREADS; num++){
		param[num]= num;

		ret = pthread_create(&thread[num], NULL, &func, &param[num]);
		if(ret){
			perror("pthread_create failed");
			exit(1);
		}
	}

	for(int num=0; num<THREADS; num++){
		ret = pthread_join(thread[num], NULL);
		if(ret){
			perror("pthread_join failed");
			exit(1);
		}
	}

	printf("Main: All thread exited");
	return 0;
}
