package org.Unterricht.Uebung.Banken;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Konto> konten;
    private int startBetrag;

    public Bank() {
        this(0);
    }
    public Bank(int startBetrag) {
        this.startBetrag = startBetrag;
        konten = new ArrayList<>();
    }

    public int neuesKonto(String besitzer) {
        int id = konten.size();
        konten.add(new Konto(id, besitzer, this, startBetrag));
        return id;
    }

    public Konto getKonto(int kontoNr) {
        return konten.get(kontoNr);
    }
    public ArrayList<Konto> getKonten() {
        return konten;
    }


    public void kontenUebersicht() {
        for (Konto k: konten) {
            System.out.println("\n***********************");
            k.kontoUebersicht();
        }
    }
}
