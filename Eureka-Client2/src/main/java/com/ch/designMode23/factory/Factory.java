package com.ch.designMode23.factory;

public class Factory {
    public static BMW create(Integer num) {
        switch (num) {
            case 320:
                return new BMW320();
            case 520:
                return new BMW520();
            default:
                break;

        }
        System.out.println("没有该款汽车");
        return null;
    }
}
