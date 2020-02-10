package com.example.bkath;

public class Demo {
    static int hello = 10;
    public static void foo() {
        who();

    }

    public static void who() {
        System.out.println("Demo WHO");
    }
}

class B extends Demo {
    public static void test() {
        B.foo();
        Demo.foo();
        B.foo();
    }

    public static void who() {
        System.out.println("B WHO");
    }

}
class C extends B {

    public static void who() {
        System.out.println("C WHO");
        C.test();
    }

}

