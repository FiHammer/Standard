package org.Unterricht.Uebung.SamBank;

import java.util.ArrayList;
public class Bank {
    private ArrayList<Konto> konten = new ArrayList<Konto>();

    public Bank() {
        
    }
    public void neuesLeeresKonto(int Kontonummer, int Balance, String Besitzer) {
        konten.add(new Konto(Kontonummer, Balance, Besitzer));
    }

    public ArrayList<Konto> getKonten() {
        return konten;
    }
    
    public void kontenUebersicht() {
        for(Konto k : konten) {
            System.out.println(k);
        }
    }

    /*
    public void zeigeBewegungen() {
        for(Konto k : konten) {
            System.out.println(k.Bewegungen);
        }
    }
    */
}
