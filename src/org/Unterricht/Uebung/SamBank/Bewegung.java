package org.Unterricht.Uebung.SamBank;

import java.util.Calendar;
public class Bewegung
{
    private String datum;
    private String text;
    private int betrag;
    Calendar myCal1 = Calendar.getInstance();


    public Bewegung(String text, int betrag) {
        this.datum = myCal1.getTime().toString();
        this.text = text;
        this.betrag = betrag;
    }

    public String getDatum() {return datum;}

    public String getText() {return text;}

    public int getBetrag() {return betrag;}
}
