package com.example.bkath.DaggerCls;

import android.util.Log;

public class Wheels {
    //we don't own this class so we can't annotate it with @Inject

    private Rims rims;
    private Tires tires;

    private static final String TAG = "CarDagger";

    public Wheels(Rims rims, Tires tires) {
        Log.d(TAG, Integer.toHexString(System.identityHashCode(rims)) + "  rims");
        Log.d(TAG, Integer.toHexString(System.identityHashCode(tires)) + "  tires");

        this.rims = rims;
        this.tires = tires;
    }
}