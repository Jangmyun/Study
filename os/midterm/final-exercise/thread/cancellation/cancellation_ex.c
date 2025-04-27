#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <time.h>

#define THREADS 5

int exit_condition;

typedef struct {
	int x,y;
} Pair;

void* runner(void* arg){
	Pair* p = (Pair*)arg;
	char result = p->x > p->y ? '>' : p->x < p->y ? '<' : '=';

	sleep(1);
	printf("%d %c %d\n", p->x, result, p->y);
	
	return NULL;
}

int main() {
	srand(time(NULL));
	
	
	pthread_t thread[THREADS] = {0};
	int ret = 0;

	Pair *pair = malloc(sizeof(Pair)*THREADS);
	
	for(int i=0; i<THREADS; i++){
		pair[i].x = rand() % 100;
		pair[i].y = rand() % 100;

		ret = pthread_create(&thread[i], NULL, &runner, (void*)&pair[i]);
		if(ret){
			perror("pthread_create failed");
			exit(1);
		}

	}

	for(int i=0; i<THREADS; i++){
		ret = pthread_join(thread[i], NULL);
		if(ret){
			perror("pthread_join failed");
			exit(1);
		}
	}
	
	return 0;
}
