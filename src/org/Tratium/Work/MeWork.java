package org.Tratium.Work;

public class MeWork {
    private org.Tratium.Work.MeShort pr;
    public MeWork() {
        org.Tratium.Work.MeShort pr = new org.Tratium.Work.MeShort();
    }
    public void Do() {
        for (int x = 0; x < 10; x++) {
            pr.p("Hi: " + x);
        }
    }
}
