package org.BlueJ.Kapitel05.Baelle;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.xml.stream.FactoryConfigurationError;
import java.awt.*;
//import java.awt.Canvas;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    private static Color[] avalibleColors = new Color[]{Color.black, Color.magenta};

    /**
     * Erzeuge ein Exemplar von BallDemo.
     * Es wird ein frischer Canvas erzeugt und sichtbar gemacht.
     */
    public BallDemo()
    {
        baelle = new ArrayList<>();
        schachtelBalls = new ArrayList<>();
        randi = new Random();
        leinwand = new Canvas("Ball Demo", 600, 600);
        leinwand.setVisible(true);
    }

    public void springenLassen(int ballAnzahl)
    {
        int boden = 500;   // Position der Bodenlinie

        leinwand.setVisible(true);

        // Den Boden zeichnen.
        leinwand.drawLine(50, boden, 550, boden);

        // Die B�lle erzeugen und anzeigen.
        for (int i=0; i<ballAnzahl; i++) {
            baelle.add(new Ball(randi.nextInt(0) + 250, randi.nextInt(0) + 250, randi.nextInt(0) + 20, avalibleColors[randi.nextInt(avalibleColors.length)], boden, leinwand));
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
        int durchmesser = randi.nextInt(15)+10;
        return new SchachtelBall(randi.nextInt(laengeDerBox-durchmesser)+50, randi.nextInt(laengeDerBox-durchmesser)+50,
                durchmesser, avalibleColors[randi.nextInt(avalibleColors.length)],
                laengeDerBox, leinwand, randi.nextInt(11)-10, randi.nextInt(11)-10);
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
            System.out.println("Bewegung");
            for (SchachtelBall b: schachtelBalls) {
                b.bewegen();
            }
            int gestoppteBaelle = 0;
            for (SchachtelBall b: schachtelBalls) {
                if (b.stopped()) {
                    System.out.println("losch");
                    gestoppteBaelle++;}
            }
            if (gestoppteBaelle == schachtelBalls.size()) {running=false;}
        }

    }
}
