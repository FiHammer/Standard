package org.Unterricht.Uebung.Math;

import org.Tratium.Work.MeShort;

public class Main {

    public static void main(String[] args) {
        MeShort W = new MeShort();
        Calc c = new Calc();

        W.p("Ergebnis eins: " + c.calc1());
        W.p("Ergebnis zwei: " + c.calc2());
        W.p("Ergebnis drei: " + c.calc3());
        W.p("Ergebnis vier: " + c.calc4());

    }
}
