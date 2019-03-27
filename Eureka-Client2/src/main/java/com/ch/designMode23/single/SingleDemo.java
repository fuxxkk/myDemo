package com.ch.designMode23.single;

/**
 * @创建人:LiJinMing
 * @日期:2018/4/13 下午4:21
 * @描述:单例模式
 **/
public class SingleDemo {
    private SingleDemo() {

    }

    private static SingleDemo singleDemo = new SingleDemo();

    public static SingleDemo getInstence() {
        return singleDemo;
    }
}

