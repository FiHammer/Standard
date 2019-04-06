package org.BlueJ.Kap3.Uebung.U27;

import org.Tratium.Work.MeShort;

public class Main {
    public static void main(String[] args) {
        MeShort W = new MeShort();

        Quadrat Fenster = new Quadrat(3,4);
        double f = Fenster.getAcreage();
        W.p(f);
    }
}

