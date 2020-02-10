package com.example.bkath;

public class Laptop {
    String memory = "1GB";
}

class Workshop {

    //Laptop life2 = new Laptop();
    public static void main(String args[]) {
        Laptop life = new Laptop();
        repair(life);
        // can't access life2 in repair method.
        System.out.println(life.memory);
    }
    public static void repair(Laptop laptop) {
        laptop.memory = "2GB";
    }
}
