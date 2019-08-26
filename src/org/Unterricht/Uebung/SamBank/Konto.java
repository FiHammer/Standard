package org.Unterricht.Uebung.SamBank;

import java.util.ArrayList;

public class Konto {
    private int kontonummer;
    private int balance;
    private String besitzer;
    private ArrayList<Bewegung> bewegungen = new ArrayList<>();
    public Konto(int Kontonummer, int Balance, String Besitzer) {
        this.kontonummer = Kontonummer;
        this.balance = Balance;
        this.besitzer = Besitzer;
    }

    public int getKontonummer() {return kontonummer;}

    public int getBallance() {return balance;}

    public String getBesitzer() {return besitzer;}

    public ArrayList<Bewegung> getBewegungen() {return bewegungen;}



    public void einzahlen(int betrag) {
        balance += betrag;
        bewegungen.add(new Bewegung("EINZAHLUNG", betrag));
    }

    public void ueberweisen(int zielkontonummer, int betrag) {
        betrag = 0-betrag;
        balance += betrag;
        bewegungen.add(new Bewegung("AUSZAHLUNG", betrag));
    }
}