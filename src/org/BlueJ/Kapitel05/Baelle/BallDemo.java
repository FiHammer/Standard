package org.BlueJ.Kapitel05.Baelle;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.xml.stream.FactoryConfigurationError;
import java.awt.*;
//import java.awt.Canvas;
import java.awt.geom.*;
import java.util.ArrayList;
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
    private static final int laengeDerBox = 500;


    private Canvas leinwand;
    private ArrayList<Ball> baelle;
    private ArrayList<SchachtelBall> schachtelBalls;
    private Random randi;
    private static Color[] avalibleColors = new Color[]{Color.RED, Color.blue, Color.yellow, Color.pink};

    /**
     * Erzeuge ein Exemplar von BallDemo.
     * Es wird ein frischer Canvas erzeugt und sichtbar gemacht.
     */
    public BallDemo()
    {
        baelle = new ArrayList<>();
        schachtelBalls = new ArrayList<>();
        randi = new Random();
        leinwand = new Canvas("Ball Demo", 600, 500);
        leinwand.setVisible(true);
    }

    /**
     * Demonstriere einige der Zeichenoperationen,
     * die von der Klasse Canvas angeboten werden.
     */
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
    public void springenLassen(int ballAnzahl)
    {
        int boden = 400;   // Position der Bodenlinie

        leinwand.setVisible(true);

        // Den Boden zeichnen.
        leinwand.drawLine(50, boden, 550, boden);

        // Die B�lle erzeugen und anzeigen.
        for (int i=0; i<ballAnzahl; i++) {
            baelle.add(new Ball(randi.nextInt(100), randi.nextInt(100), randi.nextInt(15) + 5, avalibleColors[randi.nextInt(avalibleColors.length)], boden, leinwand));
        }

        boolean running = true;
        // Die B�lle springen lassen.
        while (running) {
            leinwand.wait(50);           // kurze Pause
            for (Ball b: baelle) {
                b.bewegen();
            }
            // Stoppen, wenn die B�lle weit genug gesprungen sind.
            for (Ball b: baelle) {
                if (b.gibXPosition() >= 550) {
                    running = false;
                    break;
                }
            }
        }

        for (Ball b: baelle) {
            b.loeschen();
        }
    }

    private SchachtelBall randomSB() {
        return new SchachtelBall(randi.nextInt(50)+50, randi.nextInt(50)+50,
                randi.nextInt(15)+5, avalibleColors[randi.nextInt(avalibleColors.length)],
                laengeDerBox, leinwand);
    }


    public void springenInDerSchachtel(int ballAnzahl) {

        leinwand.setVisible(true);

        // Den Boden zeichnen.
        leinwand.drawLine(50, 50, laengeDerBox+50, 50); // boden
        leinwand.drawLine(50, laengeDerBox+50, laengeDerBox+50, laengeDerBox+50); // decke
        leinwand.drawLine(50, 50, 50, laengeDerBox+50); // linke Wand
        leinwand.drawLine(laengeDerBox+50, 50, laengeDerBox+50, laengeDerBox+50);


        for (int i=0; i<ballAnzahl; i++) {
            schachtelBalls.add(randomSB());
        }

        boolean running = true;
        // Die B�lle springen lassen.
        while (running) {
            leinwand.wait(50);           // kurze Pause
            for (SchachtelBall b: schachtelBalls) {
                b.bewegen();
            }
            // Stoppen, wenn die B�lle weit genug gesprungen sind.
            for (SchachtelBall b: schachtelBalls) {
                if (b.stopped()) {
                    running = false;
                    break;
                }
            }
        }

        for (SchachtelBall b: schachtelBalls) {
            b.loeschen();
        }
    }
}
