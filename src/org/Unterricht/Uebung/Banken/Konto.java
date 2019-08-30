package org.Unterricht.Uebung.Banken;

import java.util.ArrayList;

public class Konto {
    private int kontonummer;
    private String besitzer;
    private int geldbetrag;

    private Bank bank;

    private ArrayList<Kontoveraenderung> kontoveraenderungen;

    Konto(int kontonr, String besitzer, Bank bank, int startBetrag) {
        this.bank = bank;
        kontonummer = kontonr;
        this.besitzer = besitzer;
        geldbetrag = startBetrag;
        kontoveraenderungen = new ArrayList<>();
    }

    Konto(int kontonr, String besitzer, Bank bank){
        this(kontonr, besitzer, bank, 0);
    }

    public void einzahlen(int betrag) {
        if (betrag < 0) return;
        new Kontoveraenderung(kontonummer, betrag, bank, true);
    }
    public void auszahlen(int betrag) {
        if (betrag < 0) return;
        new Kontoveraenderung(kontonummer, betrag, bank, false);
    }
    public void ueberweisen(int zielkontoNr, int betrag) {
        if (zielkontoNr == kontonummer || betrag < 0) return;
        new Kontoveraenderung(kontonummer, zielkontoNr, betrag, bank);
    }

    void fuegeGeldHinzu(int geld, Kontoveraenderung kontoveraenderung) {
        kontoveraenderungen.add(kontoveraenderung);
        geldbetrag += geld;
    }

    void zieheGeldAb(int geld, Kontoveraenderung kontoveraenderung) {
        kontoveraenderungen.add(kontoveraenderung);
        geldbetrag -= geld;
    }

    public String toString() {
        String output = "";

        output += "Konto-Nr.: \t\t\t" + kontonummer + "\n";
        output += "Kontoinhaber: \t\t" + besitzer + "\n";
        output += "Kontostand: \t\t" + geldbetrag + " Euro" + "\n";
        output += "Kontobewegungen:\t";
        //output += ;

        if (kontoveraenderungen.size() > 0) {
            for (int index = 0; index < kontoveraenderungen.size(); index++) {
                if (index == kontoveraenderungen.size() - 1) { // keine neue line an der letzten Bewegung
                    output += kontoveraenderungen.get(index).getStatus(kontonummer) + "\n";
                } else {
                    output += kontoveraenderungen.get(index).getStatus(kontonummer) + "\n\t\t\t\t\t";
                }
            }
        } else {
            output += "Keine" + "\n";
        }

        return output;
    }

    public void kontoUebersicht() {
        System.out.println(toString());
    }

}
