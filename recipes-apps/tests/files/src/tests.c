#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>

int main() {
	int fd = open("/dev/bmp280", O_RDONLY);
	if(fd == -1) {
		printf("Opening was not possible!\n");
		return -1;
	}

	char buf[20];

	ssize_t ret = read(fd, &buf, sizeof(buf));
    printf("res - %s", buf);
	
	printf("Opening was successfull!\n");
	close(fd);
	return 0;
}