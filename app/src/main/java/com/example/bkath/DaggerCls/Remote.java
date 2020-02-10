package com.example.bkath.DaggerCls;
import android.util.Log;

import javax.inject.Inject;

public class Remote {
    private static final String TAG = "CarDagger";

    @Inject
    public Remote() {

    }

    public void setListener(Car car) {
        //Log.d(TAG, Integer.toHexString(System.identityHashCode(car)) + "");
    }

    public void setListener2(Car car) {
        //Log.d(TAG, Integer.toHexString(System.identityHashCode(car)) + "");
    }
}