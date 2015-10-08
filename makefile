# removed the -c option because we need to link this
HelloWorld:
	gcc -shared -Wall -Werror -I/usr/local/jdk1.8.0_31/include -I/usr/local/jdk1.8.0_31/include/linux -o libHelloWorld.so -fPIC HelloWorld.c
clean:
	rm -f *.o 
