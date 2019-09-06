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

    public void zeichneDemo()
    {
        leinwand.setFont(new Font("helvetica", Font.BOLD, 14));
        leinwand.setForegroundColor(Color.red);

        leinwand.drawString("Wir k�nnen Text ausgeben, ...", 20, 30);
        leinwand.wait(1000);

        leinwand.setForegroundColor(Color.black);
        leinwand.drawString("...Linien zeichnen...", 60, 60);
        leinwand.wait(500);
        leinwand.setForegroundColor(Color.gray);
        leinwand.drawLine(200, 20, 300, 50);
        leinwand.wait(500);
        leinwand.setForegroundColor(Color.blue);
        leinwand.drawLine(220, 100, 370, 40);
        leinwand.wait(500);
        leinwand.setForegroundColor(Color.green);
        leinwand.drawLine(290, 10, 320, 120);
        leinwand.wait(1000);

        leinwand.setForegroundColor(Color.gray);
        leinwand.drawString("...und Figuren!", 110, 90);

        leinwand.setForegroundColor(Color.red);

        // Die Figur, die gezeichnet und bewegt werden soll.
        int xPos = 10;
        Rectangle rechteck = new Rectangle(xPos, 150, 30, 20);

        // Das Rechteck �ber den Bildschirm bewegen.
        for(int i = 0; i < 200; i ++) {
            leinwand.fill(rechteck);
            leinwand.wait(10);
            leinwand.erase(rechteck);
            xPos++;
            rechteck.setLocation(xPos, 150);
        }
        // Zum Schluss noch einmal zeichnen, damit es sichtbar bleibt.
        leinwand.fill(rechteck);
    }

    /**
     * Simuliere zwei springende B�lle.
     */
    public void springenLassen(int anzahl) {

    }
    public void springenInDerSchachtel(int anzahl) {

        int decke = 20;
        int boden = (int) leinwand.getSize().getHeight()-decke; // Position der Bodenlinie
        int lWand= 20;
        int rWand= (int) leinwand.getSize().getWidth()-lWand;
        int[] rechteEckeUnten = {(int)leinwand.getSize().getWidth(),(int) leinwand.getSize().getHeight()};
        Random rnd = new Random();

        leinwand.setVisible(true);

        // Den Boden und Wände zeichnen.
        leinwand.drawLine(lWand, boden, rWand, boden);
       // leinwand.drawLine(decke, lWand, boden, lWand);
       // leinwand.drawLine(decke, rWand, boden, rWand);
       // leinwand.drawLine(decke, lWand, decke, rWand);

        Schachtelball[] baelle = new Schachtelball[anzahl];
        for(int n=0; n<anzahl; n++) {
            baelle[n] = new Schachtelball(rnd.nextInt(500)+lWand, 50, 20,decke, boden, lWand, rWand, leinwand);
            //baelle[n].zeichnen();
        }
        int fertig =  0;
        while(fertig<=baelle.length) {
            leinwand.wait(50);

            //TODO leinwand.erase(); damit die random pixel nicht mehr da sind, oder einfach eine weiße box malen
            //leinwand.setForegroundColor(Color.black);
            //leinwand.fillRectangle(0,0, rechteEckeUnten[0],rechteEckeUnten[1]);
            /*leinwand.setForegroundColor(Color.white);
            leinwand.drawLine(lWand, boden, rWand, boden);
            leinwand.drawLine(decke, lWand, boden, lWand);
            leinwand.drawLine(decke, rWand, boden, rWand);
            leinwand.drawLine(decke, lWand, decke, rWand);
*/

            for (Schachtelball b: baelle) {
                b.loeschen();
            }

            for (Schachtelball b: baelle) {
                b.bewegen();
            }

            for (Schachtelball b: baelle) {
                b.zeichnen();
            }

            //leinwand.repaint();
        }


    }
}
