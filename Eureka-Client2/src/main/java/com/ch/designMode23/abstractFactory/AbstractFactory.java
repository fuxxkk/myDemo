package com.ch.designMode23.abstractFactory;

import com.ch.designMode23.abstractFactory.interfa.Flyable;
import com.ch.designMode23.abstractFactory.interfa.Runable;

public abstract class AbstractFactory {
    public abstract Flyable createFlyable();

    public abstract Runable createRunable();
}
