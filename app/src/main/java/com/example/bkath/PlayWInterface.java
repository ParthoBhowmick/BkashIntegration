package com.example.bkath;

public class PlayWInterface {
    public static void main(String args[]) {

        demo obj = new demo();
//        foo1 foo_obj = new foo1();
//        obj.demoFunc(foo_obj);

        foo2 demo = new foo2();
        obj.demoFunc2(demo);

    }
}

class demo {
    public void demoFunc(dummy1 demo) {
        demo.prinln();
    }
    public void demoFunc2(dummy1 dummy1) {

    }
}

class foo1 implements dummy {

    @Override
    public void prinln() {
        System.out.println("foo1");
    }
}

class foo2 implements dummy,dummy1 {

    @Override
    public void prinln() {
        System.out.println("foo2");
    }
}

class foo3 implements  dummy,dummy1 {

    @Override
    public void prinln() {
        System.out.println("foo3");
    }
}


interface dummy {
    void prinln();
}

interface dummy1 {
    void prinln();
}