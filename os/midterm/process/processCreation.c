#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
	fork();

	printf("hello hello\n");

	return 0;
}
