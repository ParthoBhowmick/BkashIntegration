package com.example.bkath;


import java.util.*;
import java.lang.*;
import java.io.*;

public class Ball {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            Scanner in = new Scanner(System.in);
            int test = in.nextInt();
            String names;
            HashMap<String, String> hello = new HashMap<>();
            ArrayList<String> allNames = new ArrayList<>();

            for (int i = 0; i < test; i++) {
                int cases = in.nextInt();
                in.nextLine();
                hello.clear();
                allNames.clear();
                for (int j = 0; j < cases; j++) {
                    names = in.nextLine();
                    if (hello.get(names.split(" ")[0]) != null) {
                        allNames.add(names);
                        allNames.set(Integer.parseInt(hello.get(names.split(" ")[0]).charAt(0) + ""), names.split(" ")[0] + " " + hello.get(names.split(" ")[0]).substring(1));
                    } else {
                        if (names.split(" ").length < 2)
                            hello.put(names.split(" ")[0], j + "");
                        else
                            hello.put(names.split(" ")[0], j + names.split(" ")[1]);
                        allNames.add(names.split(" ")[0]);
                    }
                }

                for (String name : allNames) {
                    System.out.println(name);
                }

            }


        }

        catch (Exception T) {

        }

    }
}

