/**
 * http://www.java-tips.org/other-api-tips/jni/simple-example-of-using-the-java-native-interface.html
 */

class HelloWorld {
  static {
    System.loadLibrary("HelloWorld");
  }

  private native void print();

  //application main entry point
  public static void main(String[] args) {

    //invoke non-static print method
    new HelloWorld().print();
  }
}
