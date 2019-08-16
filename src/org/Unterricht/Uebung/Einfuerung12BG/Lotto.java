package org.Unterricht.Uebung.Einfuerung12BG;

import java.util.Random;
import java.util.ArrayList;

public class Lotto {
    private ArrayList<Integer> lottozahlen;
    private Random zufallsgenerator;

    private int maxLottozahlen;
    private int hoechsteLottozahl;
    public Lotto() {
        lottozahlen = new ArrayList<>();
        zufallsgenerator = new Random();

        this.maxLottozahlen = 6;
        this.hoechsteLottozahl = 49;

        wuerfle();
    }

    public Lotto(int maxLottozahlen, int hoechsteLottozahl) {
        lottozahlen = new ArrayList<>();
        zufallsgenerator = new Random();

        this.maxLottozahlen = maxLottozahlen;
        this.hoechsteLottozahl = hoechsteLottozahl;

        wuerfle();
    }

    public void wuerfle() {
        lottozahlen.clear();
        for (int index=0; index<maxLottozahlen; index++) {
            lottozahlen.add(getLottoZahl());
        }
    }

    private int getLottoZahl() {

        int zahl = zufallsgenerator.nextInt(hoechsteLottozahl) + 1;
        while (lottozahlen.contains(zahl)) {
            zahl = zufallsgenerator.nextInt(hoechsteLottozahl) + 1;
        }

        return zahl;
    }

    public Object[] getLottozahlenArray() {
        return lottozahlen.toArray();
    }

    public String getLottozahlenString() {
        StringBuilder s = new StringBuilder();
        for (Integer zahl: lottozahlen) {
            s.append(zahl).append(" ");
        }
        return s.toString();
    }
}
