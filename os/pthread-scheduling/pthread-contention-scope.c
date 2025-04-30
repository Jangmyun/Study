#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
#include <stdlib.h>

void* runner(void* arg){
	printf("thread runner\n");
	return NULL;
}

int main() {

	pthread_t tid = 0;
	pthread_attr_t attr;
	int scope = 0;

	pthread_attr_init(&attr);

	pthread_attr_getscope(&attr, &scope);
	printf("pthread attr scope: %d\n", scope);
	
	if(scope == PTHREAD_SCOPE_PROCESS){
		printf("PTHREAD_SCOPE_PROCESS\n");
	}else if(scope == PTHREAD_SCOPE_SYSTEM) {
		printf("PTHREAD_SCOPE_SYSTEM\n");
	}

	pthread_create(&tid, &attr, runner, NULL);

	pthread_join(tid, NULL);

	return 0;
}
