package org.Unterricht.Uebung.Banken;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Konto> konten;
    private int startBetrag;
    private String name;
    private String bic;


    public Bank(String name, String bic) {
        this(name, bic, 0);
    }
    public Bank(String name, String bic, int startBetrag) {
        this.name = name;
        this.bic = bic;
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

    public String toString() {
        String output = "";
        for (Konto k: konten) {
            output += "\n***********************\n";
            output += k.toString();
            // k.kontoUebersicht();
        }
        return output;
    }

    public void kontenUebersicht() {
        System.out.println(toString());
    }

    public String getName() {
        return name;
    }
    public void setName(String n) {
        name = n;
    }

    public String getBic() {
        return bic;
    }
    public void setBic(String bic) {
        this.bic = bic;
    }
}
