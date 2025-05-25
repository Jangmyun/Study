#include <pthread.h>
#include <stdio.h>

// #define SYNC

pthread_mutex_t lock;
int shared_counter;

void* increase_counter(void* arg){
	for(int i=0; i< 100000; i++){
#ifdef SYNC
		pthread_mutex_lock(&lock);
#endif // SYNC
		shared_counter++;
#ifdef SYNC
		pthread_mutex_unlock(&lock);
#endif // SYNC
	}
	return NULL;
}

int main() {

	pthread_t t1, t2;
	pthread_mutex_init(&lock, NULL);

	pthread_create(&t1, NULL, increase_counter, NULL);
	pthread_create(&t2, NULL, increase_counter, NULL);
	
	pthread_join(t1, NULL);
	pthread_join(t2, NULL);

	printf("Final counter: %d\n", shared_counter);
	pthread_mutex_destroy(&lock);

	return 0;
}
