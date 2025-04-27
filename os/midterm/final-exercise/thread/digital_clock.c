#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <pthread.h>
#include <unistd.h>

#include "Console.h"

#define TRUE 1
#define FALSE 0

int cont = TRUE;

void* clockTick(void *arg){
	while(cont){
		time_t now = time(NULL);
		struct tm *t = localtime(&now);

		PrintXY(5, 3, "%02d:%02d:%02d", t->tm_hour, t->tm_min, t->tm_sec);
		MySleep(1000);
	}
	return NULL;
}

int main(){

	int screen_height = getWindowHeight()-3;

	clrscr();
	printf("Press Esc to finish.\n");

	pthread_t tid = 0;
	pthread_create(&tid, NULL, clockTick, NULL);

	while(1){
		if(getch() == 27) break;

		MySleep(10);
	};

	cont = FALSE;

	pthread_join(tid, NULL);
	gotoxy(1, screen_height);
	printf("Bye!\n");

	return 0;
}


