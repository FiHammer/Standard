package org.Unterricht.Uebung.Baelle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BallDemo   
{
    private static final int laengeDerBox = 500;


    private Canvas leinwand;
    private ArrayList<SchachtelBall> schachtelBalls;
    private Random randi;
    private static Color[] avalibleColors = new Color[]{Color.black, Color.magenta};

    public BallDemo()
    {
        schachtelBalls = new ArrayList<>();
        randi = new Random();
        leinwand = new Canvas("Ball Demo", 600, 600);
        leinwand.setVisible(true);
    }

    private SchachtelBall randomSB() {
        int durchmesser = randi.nextInt(15)+10;
        return new SchachtelBall(randi.nextInt(laengeDerBox-durchmesser)+50, randi.nextInt(laengeDerBox-durchmesser)+50,
                durchmesser, avalibleColors[randi.nextInt(avalibleColors.length)],
                laengeDerBox, leinwand, randi.nextInt(11)-10, randi.nextInt(11)-10);
    }


    public void springenInDerSchachtel(int ballAnzahl) {

        leinwand.setVisible(true);

        // Den Kasten zeichnen.
        leinwand.drawLine(50, 50, laengeDerBox+50, 50); // boden
        leinwand.drawLine(50, laengeDerBox+50, laengeDerBox+50, laengeDerBox+50); // decke
        leinwand.drawLine(50, 50, 50, laengeDerBox+50); // linke Wand
        leinwand.drawLine(laengeDerBox+50, 50, laengeDerBox+50, laengeDerBox+50);


        for (int i=0; i<ballAnzahl; i++) {
            schachtelBalls.add(randomSB());
        }

        // Die B�lle springen lassen.
        while (true) {
            leinwand.wait(10);           // kurze Pause

            int gestoppteBaelle = 0;
            for (SchachtelBall b: schachtelBalls) {
                if (b.getStop()) {
                    gestoppteBaelle++;
                    continue;
                }
                if (b.stopped()) {
                    //System.out.println("A ball stopped");
                    gestoppteBaelle++;}
            }

            if (gestoppteBaelle == schachtelBalls.size()) {
                System.out.println("Main End");
                break;
            }


            // movement

            for (SchachtelBall b: schachtelBalls) {
                b.loeschen();
            }

            for (SchachtelBall b: schachtelBalls) {
                b.bewegen();
            }

            for (SchachtelBall b: schachtelBalls) {
                b.zeichnen();
            }
        }

    }
}
