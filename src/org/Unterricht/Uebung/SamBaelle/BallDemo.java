package org.Unterricht.Uebung.SamBaelle;
import java.awt.*;
import java.util.Random;

/**
 * Die Klasse BallDemo bietet zwei kurze Demonstrationen, wie die
 * Klasse Canvas benutzt werden kann.
 *
 * @author Michael K�lling und David J. Barnes
 * @version 2008.03.30
 */

public class BallDemo   
{
    private BetterCanvas leinwand;

    /**
     * Erzeuge ein Exemplar von BallDemo.
     * Es wird ein frischer Canvas erzeugt und sichtbar gemacht.
     */
    public BallDemo()
    {
        this("Ball Demo", 600, 500);
    }
    public BallDemo(int width, int height)
    {
        this("Ball Demo", width, height);
    }
    public BallDemo(String name, int width, int height)
    {
        leinwand = new BetterCanvas(name, width, height);
        leinwand.setVisible(true);
    }

    public void zeichneRahmen() {
        int abstand = 20;
        int width = (int) leinwand.getSize().getWidth()-(2*abstand);
        int height = (int) leinwand.getSize().getHeight()-(2*abstand);
        System.out.println("width: "+width+"; height: "+height+";");

        leinwand.draw(new Rectangle(abstand, abstand, width, height));
    }

    public void springenInDerSchachtel(int anzahl) {

        int decke = 20;
        int boden = (int) leinwand.getSize().getHeight()-decke; // Position der Bodenlinie
        int lWand= 20;
        int rWand= (int) leinwand.getSize().getWidth()-lWand;
        Random rnd = new Random();

        leinwand.setVisible(true);

        // Den Boden und Wände zeichnen.
        System.out.println(decke);
        System.out.println(rWand);
        System.out.println(lWand);
        System.out.println(boden);

        leinwand.drawLine(lWand, decke, rWand, decke);  // decke
        leinwand.drawLine(lWand, boden, rWand, boden); // boden
        leinwand.drawLine(lWand, decke, lWand, boden); // lWand
        leinwand.drawLine(rWand, decke, rWand, boden); // rWand

        Schachtelball[] baelle = new Schachtelball[anzahl];
        for(int n=0; n<anzahl; n++) {
            baelle[n] = new Schachtelball(rnd.nextInt(500)+lWand, 50, 20, decke, boden, lWand, rWand, leinwand);
        }

        while(true) {
            leinwand.wait(50);

            for (Schachtelball b: baelle) {
                b.loeschen();
            }

            for (Schachtelball b: baelle) {
                b.bewegen();
            }

            for (Schachtelball b: baelle) {
                b.zeichnen();
            }
        }


    }
}
