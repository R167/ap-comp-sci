/********************
 * File: Test.java
 * Author: Winston Durand
 * Modified: Feb 26, 2015
 ********************/
package gitTest;

/**
 * @author wmd
 *
 */
public class Test {

    /**
     * exploring the weird bits of inheritance
     * 
     * @param args
     */
    public static void main(String[] args) {
        C c = new C(1);
        c.hello();
    }

}

abstract class A {
    public A() {
        System.out.println("a");
    }

    public A(int h) {
        System.out.println("wtf");
    }
}

abstract class B extends A {
    public B() {
        System.out.println('b');
    }

    public B(int h) {
        System.out.println("wtf");
    }
}

class C extends B {
    public C(int h) {
        this();
        System.out.println(h);
    }

    public C() {
        System.out.println('c');
    }

    public void hello() {
        System.out.println("horray");
    }
}
