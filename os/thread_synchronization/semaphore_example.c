#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>

// #define SYNC

sem_t sem;
int shared_counter = 0;

void* increase_counter(void* arg){
	for(int i=0; i< 100000; i++){
#ifdef SYNC
		sem_wait(&sem);
#endif
		shared_counter++;
#ifdef SYNC
		sem_post(&sem);
#endif
	}
	return NULL;
}

int main() {

	pthread_t t1,t2;
	sem_init(&sem, 0, 1);

	pthread_create(&t1, NULL, increase_counter, NULL);
	pthread_create(&t2, NULL, increase_counter, NULL);

	pthread_join(t1, NULL);
	pthread_join(t2, NULL);

	printf("Final counter: %d\n", shared_counter);
	sem_destroy(&sem);
	
	return 0;
}
