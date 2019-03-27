package com.ch.designMode23.abstractFactory;

import com.ch.designMode23.abstractFactory.bean.Airplane;
import com.ch.designMode23.abstractFactory.bean.Car;
import com.ch.designMode23.abstractFactory.interfa.Flyable;
import com.ch.designMode23.abstractFactory.interfa.Runable;

public class Factory extends AbstractFactory {
    @Override
    public Flyable createFlyable() {
        return new Airplane();
    }

    @Override
    public Runable createRunable() {
        return new Car();
    }
}
