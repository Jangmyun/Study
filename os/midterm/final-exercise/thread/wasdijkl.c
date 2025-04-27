#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include "Console.h"

#define TRUE 1
#define FALSE 0

typedef struct {
	int x,y;
	char ch;
} Player;

int cont = TRUE;
Player player1, player2;

void* InputThread(void *arg);
void* DisplayThread(void *arg);

int main() {
	clrscr();
	EnableCursor(FALSE);
	int width = getWindowWidth();
	int height = getWindowHeight();

	player1.x = width/4;
	player1.y = height/2;
	player1.ch = 'O';

	player2.x = width*3/4;
	player2.y = height/2;
	player2.ch = 'X';

	pthread_t tid_input, tid_display;
	pthread_create(&tid_input, NULL, InputThread, NULL);
	pthread_create(&tid_display, NULL, DisplayThread, NULL);

	pthread_join(tid_input, NULL);
	pthread_join(tid_display, NULL);
	

	clrscr();
	EnableCursor(TRUE);
	printf("Bye!\n");
	return 0;
}

void* InputThread(void *arg){
	while(cont){
		if(kbhit()){
			int ch = getch();

			if(ch == 27){
				cont = FALSE;
				break;
			}

			switch(ch){
				case 'w': if (player1.y > 1) player1.y--; break;
				case 's': if (player1.y < getWindowHeight() - 1) player1.y++; break;
				case 'a': if (player1.x > 1) player1.x--; break;
				case 'd': if (player1.x < getWindowWidth() - 1) player1.x++; break;

				case 'i': if (player2.y > 1) player2.y--; break;
				case 'k': if (player2.y < getWindowHeight() - 1) player2.y++; break;
				case 'j': if (player2.x > 1) player2.x--; break;
				case 'l': if (player2.x < getWindowWidth() - 1) player2.x++; break;
			}
		}
		MySleep(10);
	}
	return NULL;
}

void* DisplayThread(void* arg){

	while(cont){
		clrscr();
		PrintXY(player1.x, player1.y, "%c", player1.ch);
		PrintXY(player2.x, player2.y, "%c", player2.ch);
		fflush(stdout);
		MySleep(30);
	}
	
	return NULL;
}
