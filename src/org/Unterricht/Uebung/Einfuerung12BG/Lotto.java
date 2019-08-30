package org.Unterricht.Uebung.Einfuerung12BG;

import java.util.Random;

public class Lotto {
    private int[] lottozahlen;
    private Random zufallsgenerator;

    private int maxLottozahlen;
    private int hoechsteLottozahl;
    public Lotto() {
        this.maxLottozahlen = 6;
        this.hoechsteLottozahl = 49;

        lottozahlen = new int[maxLottozahlen];
        zufallsgenerator = new Random();

        wuerfle();
    }

    public Lotto(int maxLottozahlen, int hoechsteLottozahl) {
        this.maxLottozahlen = maxLottozahlen;
        this.hoechsteLottozahl = hoechsteLottozahl;

        lottozahlen = new int[maxLottozahlen];
        zufallsgenerator = new Random();

        wuerfle();
    }

    public void wuerfle() {
        for (int index=0; index<maxLottozahlen; index++) {
            lottozahlen[index] = getLottoZahl();
        }
    }

    private int getLottoZahl() {
        int zahl = zufallsgenerator.nextInt(hoechsteLottozahl) + 1;
        while (existNum(zahl)) {
            zahl = zufallsgenerator.nextInt(hoechsteLottozahl) + 1;
        }
        return zahl;
    }

    private boolean existNum(int num) {
        boolean exist = false;
        for (int zahl: lottozahlen) {
            if (zahl == num) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    public int[] getLottozahlenArray() {
        return lottozahlen;
    }

    public String getLottozahlenString() {
        StringBuilder s = new StringBuilder();
        for (Integer zahl: lottozahlen) {
            s.append(zahl).append(" ");
        }
        return s.toString().trim();
    }
}
