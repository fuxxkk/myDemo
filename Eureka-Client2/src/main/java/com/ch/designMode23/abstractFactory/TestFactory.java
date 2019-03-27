package com.ch.designMode23.abstractFactory;

import com.ch.designMode23.abstractFactory.interfa.Flyable;
import com.ch.designMode23.abstractFactory.interfa.Runable;

public class TestFactory {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Flyable flyable = factory.createFlyable();
        flyable.msg();
        Runable runable = factory.createRunable();
        runable.msg();
    }
}
