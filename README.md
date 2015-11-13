# java-jni (Linux only)

Prerequisites are JDK and Git.

To run this sample: 
1. change directories (cd) to a development directory
2. issue "git clone https://github.com/dkelosky/java-jni.git
3. issue "cd java-jni" to change to the java-jni directory
4. issue "javac HelloWorld.java" to compile the Java source


5*. issue "javah -jni HelloWorld" to generate a HelloWorld.h C header file
6*. create the HelloWorld.c source including <jni.h> and "HelloWorld.h" C header files in addition to required C runtime library headers.
7.** edit make file so that the include paths contain the location of the generated HelloWorld.h C header file, your_JDK_install_path/include, and your_JDK_install_path/include/linux (see "makefile" below for more notes)
8. issue "make" to generate the libHelloWorld.so (so = Shared Object and is like a Windows DLL)
9. set the LD_LIBRARY_PATH variable to the libHelloWorld.so directory and export 
  (e.g. "LD_LIBRARY_PATH=./" to set to the current directory and then "export LD_LIBRARY_PATH"

* these steps are optional since the HelloWorld.h and HelloWorld.c source are contained in this sample.
**
