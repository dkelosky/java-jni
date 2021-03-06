# java-jni

### Overview 
This is a very simple "Hello World" example of how to use Java Native Interface (JNI) to call a C function from Java.

### Prerequisites 
* JDK 
* Git

### To compile and run this sample in linux

1. change directories (cd) to a development directory

2. issue "git clone https://github.com/dkelosky/java-jni.git"

3. issue "cd java-jni" to change to the java-jni directory

4. issue "javac HelloWorld.java" to compile the Java source

5. issue "javah -jni HelloWorld" to generate a HelloWorld.h C header file (see [**Note1**](#misc-notes) )

6. create the HelloWorld.c source including the jni.h and HelloWorld.h C header files in addition to required C runtime library headers (see [**Note1**](#misc-notes) )

7. edit the make file so that the include paths contain the location of the generated HelloWorld.h C header file, your_JDK_install_path/include, and your_JDK_install_path/include/linux (see [**Note2**](#misc-notes) and [**Makefile**](#misc-notes))

8. issue "make" to generate the libHelloWorld.so (so = Shared Object which is like a Windows DLL)

9. set the LD_LIBRARY_PATH variable to the libHelloWorld.so directory and export so that the JVM can locate the shared object
  * (e.g. "LD_LIBRARY_PATH=./" to set to the current directory and then "export LD_LIBRARY_PATH"

10. issue "java HelloWorld" to see the "Hello world" text which is written by a C shared object called from Java

---

### To compile and run this sample in mac osx

- git clone https://github.com/dkelosky/java-jni.git
- cd java-jni
- javac HelloWorld.java
- javah -jni HelloWorld
- create jni dynamic library for mac osx
- g++ "-I/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers" -x c -c HelloWorld.c
- g++ -dynamiclib -o libHelloWorld.jnilib HelloWorld.o
- you will see a libHelloWorld.jnilib in current dir
- excute HelloWolrd.class and get C print result `Hello world!` 
- java HelloWorld

#### Misc Notes

* **Note0**
  * be sure to consitently use the same version of Java for all steps (i.e. same release number and only 31 OR 64-bit) .
* **Note1** 
  * these steps are optional since the HelloWorld.h and HelloWorld.c source are contained in this sample.
* **Note2** 
  * you could alternatively use the C_INCLUDE_PATH variable to specifiy JDK or other C include headers instead of using the "gcc -I" include options
* **Makefile** 
  * the makefile uses -Wall to turn on most warnings and -Werror to make warnings errors (and fail the compilation)
