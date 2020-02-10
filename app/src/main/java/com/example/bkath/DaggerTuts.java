package com.example.bkath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.bkath.DaggerCls.Car;
import com.example.bkath.DaggerCls.CarComponent;
import com.example.bkath.DaggerCls.DaggerCarComponent;

import javax.inject.Inject;

public class DaggerTuts extends AppCompatActivity {

    @Inject
    Car car1,car2;

    private static final String TAG = "CarDagger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_tuts);

        //CarComponent component =  ;

        CarComponent component = DaggerCarComponent.create();
        component.inject(this);

        car1.drive();
        Log.d(TAG, Integer.toHexString(System.identityHashCode(car1)) + "  car1");


        car2.drive();
        Log.d(TAG, Integer.toHexString(System.identityHashCode(car2)) + "  car2");

    }
}
