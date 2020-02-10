package com.example.bkath.DaggerCls;

import com.example.bkath.DaggerTuts;
import com.example.bkath.MainActivity;

import dagger.Component;

@Component(modules = WheelsModule.class)
public interface CarComponent {
    Car getCar();
    void inject(DaggerTuts dagtuts);
}