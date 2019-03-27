package com.ch.designMode23.abstractFactory.bean;


import com.ch.designMode23.abstractFactory.interfa.Runable;

public class Car implements Runable {

    @Override
    public void msg() {
        System.out.println("这是一辆车");

    }
}
