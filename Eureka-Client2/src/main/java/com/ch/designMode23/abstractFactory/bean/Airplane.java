package com.ch.designMode23.abstractFactory.bean;

import com.ch.designMode23.abstractFactory.interfa.Flyable;

public class Airplane implements Flyable {
    @Override
    public void msg() {
        System.out.println("这是一辆飞机");
    }
}
