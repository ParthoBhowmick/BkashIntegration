package com.example.bkath;

public class demoMain {
    public static void main(String args[]) {
        DemoParent demoParent = new DemoParent();
        System.out.println(DemoParent.hello);
        demoParent.foo();
        System.out.println(DemoParent.hello);
        demoParent.foo21();
    }
}
