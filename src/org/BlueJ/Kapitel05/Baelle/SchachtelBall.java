package org.BlueJ.Kapitel05.Baelle;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class SchachtelBall{
    private static final int gravitation = 3;  // Einfluss der Gravitation

    private int bremsfaktor = 2;  // simuliert den Luftwiderstand
    private Ellipse2D.Double kreis;
    private Color farbe;
    private int durchmesser;
    private int xPosition;
    private int yPosition;
    private final int laengeDerBox;      // y-Position des Bodens
    private Canvas leinwand;
    private int yGeschwindigkeit = 0;
    private int xGeschwindigkeit = 2;

    public SchachtelBall(int xPos, int yPos, int balldurchmesser, Color ballfarbe,
                int laengeDerBox, Canvas zeichengrund)
    {
        xPosition = xPos;
        yPosition = yPos;
        farbe = ballfarbe;
        durchmesser = balldurchmesser;
        this.laengeDerBox = laengeDerBox;
        leinwand = zeichengrund;
    }


    public void bewegen() {
        // An der aktuellen Position von der Leinwand entfernen.
        loeschen();

        // Neue Position berechnen.
        yGeschwindigkeit += gravitation;
        yPosition += yGeschwindigkeit;
        xPosition += xGeschwindigkeit;

        // Pr�fen, ob eine Wand getroffen wurde
        if (yPosition == 0 ) {}

        int bodenhoehe = 0; // DEBUG


        if(yPosition >= (bodenhoehe - durchmesser) && yGeschwindigkeit > 0) {
            yPosition = (int)(bodenhoehe - durchmesser);
            yGeschwindigkeit = -yGeschwindigkeit + bremsfaktor;
        } else if (true) {

        }

        // An der neuen Position erneut zeichnen.
        zeichnen();

    }

    public boolean stopped() {return false;}


    public void zeichnen() {
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle(xPosition, yPosition, durchmesser);
    }
    public void loeschen() {leinwand.eraseCircle(xPosition, yPosition, durchmesser);}
}
