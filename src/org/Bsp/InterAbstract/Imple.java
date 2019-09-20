package org.Bsp.InterAbstract;

public class Imple implements Test {

    public Imple() {
        sayHello();
    }

    @Override
    public void sayHello() {
        System.out.println("Hi");
    }

    @Override
    public void testMe() {

    }
}
