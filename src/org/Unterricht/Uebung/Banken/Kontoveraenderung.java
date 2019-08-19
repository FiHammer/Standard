package org.Unterricht.Uebung.Banken;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Kontoveraenderung {
    private int ueberweisungsTyp;
    /*
    * 1: Einzahlung
    * 2: Auszahlung
    * 3: Überweisung
    * */

    private int startKontoNr;
    private int zielKontoNr;
    private int betrag;

    private String tag;
    private String uhrzeit;

    private Bank bank;
    private Konto startKonto;
    private Konto zielKonto;

    // eine Überweisung von einem Konto x zu einem Konto y; Typ 3
    Kontoveraenderung(int startKontoNr, int zielKontoNr, int betrag, Bank bank) {
        ueberweisungsTyp = 3;

        this.startKontoNr = startKontoNr;
        this.zielKontoNr = zielKontoNr;
        this.betrag = betrag;

        this.bank = bank;

        this.startKonto = bank.getKonto(startKontoNr);
        this.zielKonto = bank.getKonto(zielKontoNr);


        starteUeberweisung();
    }

    // eine Auszahlen von einem diesem Konte x (bspw. Bar); Typ 2                       ==> einzahlung = false
    // eine Einzahlung von einem unbekannten Konte (bspw. Bar) zu einem Konto x; Typ 1  ==> einzahlung = true
    Kontoveraenderung(int kontoNr, int betrag, Bank bank, boolean einzahlung) {
        this.startKontoNr = -1;

        if (einzahlung) {
            ueberweisungsTyp = 1;
        } else {
            ueberweisungsTyp = 2;
        }
        this.zielKontoNr = kontoNr;
        this.betrag = betrag;

        this.bank = bank;

        this.zielKonto = bank.getKonto(zielKontoNr);


        starteUeberweisung();
    }

    private void starteUeberweisung() {
        DateFormat datumsFormatTag = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat datumsFormatUhrzeit = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();

        tag = datumsFormatTag.format(date);
        uhrzeit = datumsFormatUhrzeit.format(date);

        if (ueberweisungsTyp == 3) {
            startKonto.zieheGeldAb(betrag, this);
            zielKonto.fuegeGeldHinzu(betrag, this);
        } else if (ueberweisungsTyp == 1) {
            zielKonto.fuegeGeldHinzu(betrag, this);
        } else if (ueberweisungsTyp == 2) {
            zielKonto.zieheGeldAb(betrag, this);
        }
    }

    // personalisierter Status für ein speziefisches Konto
    public String getStatus(int startKontoNr) {
        String ueberweisungsTypStr = "";
        String geldTypStr = "";
        if (ueberweisungsTyp == 1) {
            ueberweisungsTypStr = "Einzahlung";
            geldTypStr = "+";
        } else if (ueberweisungsTyp == 2) {
            ueberweisungsTypStr = "Auszahlung";
            geldTypStr = "-";
        } else if (ueberweisungsTyp == 3) {
            ueberweisungsTypStr = "Ueberweisung";
            if (startKontoNr == this.startKontoNr) {
                geldTypStr = "-";
            } else {
                geldTypStr = "+";
            }
        }

        return tag + ", " + ueberweisungsTypStr + ", " + geldTypStr + betrag + " Euro";
    }

    // algemeiner Status
    public String getStatus() {
        String ueberweisungsTypStr = "";
        String geldTypStr = "";
        if (ueberweisungsTyp == 1) {
            ueberweisungsTypStr = "Einzahlung";
            geldTypStr = "+";
        } else if (ueberweisungsTyp == 2) {
            ueberweisungsTypStr = "Auszahlung";
            geldTypStr = "-";
        } else if (ueberweisungsTyp == 3) {
            ueberweisungsTypStr = "Ueberweisung";

            return tag + ", " + ueberweisungsTypStr + ", " + betrag + " Euro zum Konto: " + zielKontoNr;
        }

        return tag + ", " + ueberweisungsTypStr + ", " + geldTypStr + betrag + " Euro";
    }

}
