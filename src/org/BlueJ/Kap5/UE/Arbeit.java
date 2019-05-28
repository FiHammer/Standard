package org.BlueJ.Kap5.UE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Arbeit {
    // 5.10
    // Ergebnistyp: boolean
    public boolean ue510(String s1, String s2) {
        return s1.equals(s2);
    }

    // 5.11
    public boolean ue511vor(String s1, String s2) {
        return s1.startsWith(s2);
    }
    public boolean ue511nach(String s1, String s2) {
        return s1.equals(s2);
    }

    // 5.15
    private Random randi = new Random();
    public int ue515() {
        return randi.nextInt(100);
    }
    // 0-99 also 100 Zahlen!

    // 5.16
    // würfle
    public int wuerfeln() {
        return randi.nextInt(5) + 1;
    }

    // 5.17
    public String gibAntwort0() {
        int num = randi.nextInt(3);
        if (num == 0) {
            return "ja";
        } else if (num == 1) {
            return "nein";
        } else {
            return "vielleicht";
        }
    }

    // 5.18
    private ArrayList<String> arrL = new ArrayList<>();
    public String gibAntwort() {
        return arrL.get(randi.nextInt(arrL.size()));
    }

    // 5.19
    public int ue519(int max) {
        return randi.nextInt(max) + 1;
    }

    // 5.20
    public int ue520(int min, int max) {
        return randi.nextInt(max-min) + min;
    }

    // 5.23
    /*
     * HashSet hat immer KEY und VALUE
     * die Datentypen müssen als Parameter (in den <> Klammern) angegeben werden => alle Datentypen werden akzeptiert
     * der KEY muss einzigartig sein (siehe Mathe: jedem x(KEY) darf nur ein y/f(x)-Wert (VALUE) zugeordnet sein)
     *
     * Wichtige Methoden: put, get (vll. noch: contains(Key/Value), remove)
     *
     * Wofür benutzen:
     * um irgendwelche Daten iregendwelchen Daten zuzuorden
     * Bsp.:
     * Mathe - eine Wertetabelle
     * Geräte - Computer zu einer Seriennummer
     * Telefonbuch - Name zur Telefonnummer
     *
     */
    private HashMap<String, String> hm;
    public void ue523() {
        // hinzufügen
        hm.put("aKEY", "aVALUE");
        // abfragen nach Value, bekommt hier "aVALUE" zurück
        hm.get("aKEY");
        // abfragen ob der Key existiert, bekommt wahr/falsch zurück (hier: true)
        hm.containsKey("aKey");
        // löschen
        hm.remove("aKey");
    }

    // 5.24
    /*
     * der selbe Typ kann natürlich funktionieren (siehe oben (ue523))
     *
     * Methoden: (fast) alle
     * wichtige: put, get, remove, contains(Key/Value) usw.
     *
     *
     */

    // 5.25
    /*
     * Gemeinsamkeiten und Unterschiede: (allgemein)
     * ArrayList:           HashSet:
     * sortiert             unsortier
     * mit Index aufrufbar  nur durch foreach oder Iterator aufrufbar(/Inhalt einsehbar)
     * doppelte Werte       jeder Wert nur einmal
     *
     * Methoden:
     * hinzufügen: .add     .add
     * löschen: .remove     .remove
     * beinhaltet: .contains.contains
     * werte abrufen: .get  mit Iterator/foreach-Schleife
     *
     *
     *
     * Wieso HashSet spezieller als Set und ArrayList spezieller als List ist: k.A.
     *
     */
    private HashSet<String> hs = new HashSet<>();
    public void ue532() {
        // fügt sachen hinzu
        hs.add("Hallo");
        hs.add("Ich");
        hs.add("Bin");
        hs.add("Toll");


        // gibt sie aus (unsortiert)
        for (String s : hs) { // foreach schleife = geht durch jedes Objekt durch und gibt es aus
            System.out.println(s);
        }
    }

    // 5.35
    /*
     *
     * auf jeden Fall können dann eingabe-Wörter doppelt vorkommen,
     * aber ändern sollte sich glaub ich direkt nichts, außer ich hab den Sourcecode von Kapitel 5 falsch im Kopf
     * (da es durch HashSet.contains(x) kein unterschied mit ArrayList.contains(x) machen sollte)
     *
     */

    // zugriffsmodifikatoren

    public String s1 = "Hallo Leser"; // public, jede Klasse kann auf diese Variable daraufzugreifen (lesen+schreiben)
    private String s2 = "Hallo Leser (nochmal)"; // private, nur die EIGENE Klasse kann auf diese Variable daraufzugreifen (lesen+schreiben)

    /*
     * "Geheimnisprinzip"
     *
     * warum für manche Sachen private und get/set-Methoden genutzt werden sollte:
     * um Schutzmaßnahmen einzubauen: Tier kann nicht weniger als 0 Beine haben
     *
     * Bsp.: ein Tier bzw. Hund
     *
     */

    private int beine;
    public int getBeine() { // get-Methode
        return beine;
    }
    public void setBeine(int beineX) { // set-Methode, ich hab es mal beineX genannt, um zwichen beine (alt=beine) und beine (neu=beineX) zu unterscheiden
        if (beineX < 0) {
            return; // bricht ab weil ein Tier kann nicht weniger als 0 Beine haben
        } else {
            beine = beineX; // überschreibt die Beine
        }

    }

    // final

    public final String s3 = "Ich bin schreibgeschützt"; // final, macht die Variable schreibgeschütz also nur noch lesbar, kann mit den Zugriffsmodifikatoren public und private verwendet werden

    // static
    /*
     * static-Variablen bzw. Methoden
     * sind vars oder meth, die auch ohne Instanzierung aufgerufen werden kann
     * auf die Math/ Mathe Klasse kann man auch so daraufzugreifen (siehe Unten)
     *
     */
    public void matheTest() {
        System.out.println(Math.PI + " * Daumen");
        System.out.println("2 ^ 4 = " + Math.pow(2, 4)); // Methodenaufruf ohne Instanzierung (potenzen)

        // normalerweise wie in random
        Random rander = new Random(); // Instanzierung
        rander.nextInt(); // Methodenaufruf

    }
}
