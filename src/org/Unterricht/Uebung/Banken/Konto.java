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

    public void kontoUebersicht() {
        System.out.println("Konto-Nr.: \t\t\t" + kontonummer);
        System.out.println("Kontoinhaber: \t\t" + besitzer);
        System.out.println("Kontostand: \t\t" + geldbetrag + " Euro");

        System.out.print("Kontobewegungen:\t");
        if (kontoveraenderungen.size() > 0) {
            for (int index = 0; index < kontoveraenderungen.size(); index++) {
                if (index == kontoveraenderungen.size() - 1) { // keine neue line an der letzten Bewegung
                    System.out.println(kontoveraenderungen.get(index).getStatus(kontonummer));
                } else {
                    System.out.print(kontoveraenderungen.get(index).getStatus(kontonummer) + "\n\t\t\t\t\t");
                }
            }
        } else {
            System.out.println("Keine");
        }
    }

}
