#include <stdio.h>
#include <unistd.H>
#include <string.h>
#include <sys/types.h>

#define BUFFER_SIZE 25
#define WIRTE_END 0
#define READ_END 1 

int main() {
	
	char wrtie_msg[BUFFER_SIZE] = "Greetings";
	char read_msg[BUFFER_SIZE];

	int fd[2];

	return 0;
}
