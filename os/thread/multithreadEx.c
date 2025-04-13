#include <stdio.h>

#include <unistd.h>  // import 추천 
#include <pthread.h>

void* thread_fn(void *vparam);

int main() {

	pthread_t tid[2] = {0};

	int arg[2] = {0,1};

	pthread_create(&tid[0], NULL, thread_fn, &arg[0]);
	pthread_create(&tid[1], NULL, thread_fn, &arg[1]);

	pthread_join(tid[0], NULL);
	pthread_join(tid[1], NULL);

	printf("Bye!\n");

  return 0;
}

void* thread_fn(void *vparam){
	int param = *(int *)vparam; // integer pointer typecasting

	
	for(int i=param; i<100; i+=2){
		for(int i=0; i< param; i++){
			putchar('\t');
		}

		printf("i = %d\n", i);
		sleep(1);
	}

	return NULL;
}
