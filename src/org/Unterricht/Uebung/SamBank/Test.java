package org.Unterricht.Uebung.SamBank;

import java.util.ArrayList;
import java.util.Random;
public class Test {
    // instance variables - replace the example below with your own
    String[] names = {"Debbra Caple", "Robbin Cheatam", "Kathaleen Mondragon", "Donna Chien", "Kathe Gorder", "Herman Dicicco", "Joe Eatmon", "Lashanda Riel", "Candra Burkes", "Retha Wylie", "Arnulfo Turbeville", "Jolanda Sotomayor", "Cornell Erikson", "Coy Heart", "Kimberlee Cloud", "Grover Rosato", "Marquerite Lebeau", "Brenda Eargle", "Leigha Durkee", "Lakendra Bruhn", "Lashon Gochenour", "Rubye Laviolette", "Brett Bangert", "Dewey Mccaffery", "Colleen Eyman", "Trudie Scheidegger", "Douglass Langone", "Fern Krug", "Rosalind Moy", "Marielle Morquecho", "Demetria Provencher", "Viki Basso", "Lavonda Chabot", "Tierra Griswold", "Joye Poplin", "Jordan Boateng", "Mabel Mcknight", "Lanora Ring", "Barrett Schoolcraft", "Boyce Will", "Rosina Bull", "Lisandra Kinlaw", "Candy Birdsell", "Gavin Canela", "Almeta Quesnel", "Anette Canady", "Rhiannon Barron", "Karine Lemley", "Malisa Bublitz", "Nicolasa Tillmon"};
    Random rnd = new Random();
    private Bank bank;

    public Test() {
        bank = new Bank();

        simulieren();
    }

    public void simulieren() {
        int anzahlKonten = 3;
        int kontoBewegungen = 3;
        for (int n=0; n<anzahlKonten; n++) {
            String name = names[rnd.nextInt(names.length)];
            bank.neuesLeeresKonto(n,0, name);
            for (int m=0; m<kontoBewegungen;m++) {
                erzeugeBewegung(n);
            }
        }

        showKonten();
    }


    public void showKonten() {
        ArrayList<Konto> konten = bank.getKonten();
        for (int n = 0; n < konten.size(); n++) {
            Konto kt = konten.get(n);
            System.out.println("******************************");
            System.out.println("KontoNummer: " + kt.getKontonummer());
            ArrayList<Bewegung> b = kt.getBewegungen();
            for (int m = 0; m < b.size(); m++) {
                System.out.println(b.get(m).toString());
            }
        }
    }

    public void erzeugeBewegung(int kontonummer) {
        int n = rnd.nextInt(2);
        int betrag = rnd.nextInt(1000);

        if (n == 1) {
            bank.getKonten().get(kontonummer).einzahlen(betrag);
        } else {
            bank.getKonten().get(kontonummer).ueberweisen(0, betrag);
        }

    }
}