package com.example.bkath.DaggerCls;

import android.util.Log;

import javax.inject.Inject;

public class Car {

    private static final String TAG = "CarDagger";

    private Engine engine;
    private Wheels wheels;

    @Inject
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    public void drive() {
        Log.d(TAG, "driving...");
    }

    @Inject
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }

    @Inject
    public void enableRemote2(Remote remote) {
        remote.setListener2(this);
    }

}
