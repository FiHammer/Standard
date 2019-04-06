package org.Tratium.Work;


public class MeThreading extends Thread {
    private MeShort W = new MeShort();
    public MeThreading() {

    }

    public void run() {
        work();
    }
    private void work() {
        W.p("Hi");
    }
}
