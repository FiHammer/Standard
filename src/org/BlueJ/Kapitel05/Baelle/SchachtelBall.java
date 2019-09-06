package org.BlueJ.Kapitel05.Baelle;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class SchachtelBall {
    private static final double gravitation = 0; // 1.0;  // Einfluss der Gravitation

    private static final double reibung = -1; //0.05;
    private Ellipse2D.Double kreis;
    private Color farbe;
    private int durchmesser;
    private double xPosition;
    private double yPosition;
    private final int laengeDerBox;
    private Canvas leinwand;
    private boolean _geloescht = false;

    private boolean stop;


    private double yGeschwindigkeit = 10;
    private double xGeschwindigkeit = -10;

    public SchachtelBall(int xPos, int yPos, int balldurchmesser, Color ballfarbe,
                int laengeDerBox, Canvas zeichengrund, int xGeschwindigkeit, int yGeschwindigkeit)
    {
        xPosition = xPos;
        yPosition = yPos;
        farbe = ballfarbe;
        durchmesser = balldurchmesser;
        this.laengeDerBox = laengeDerBox;
        leinwand = zeichengrund;

        this.xGeschwindigkeit = xGeschwindigkeit;
        this.yGeschwindigkeit = yGeschwindigkeit;
        stop = false;

    }

    public void bewegen() {
        if (stop) return;
        // An der aktuellen Position von der Leinwand entfernen.
        //loeschen();

        // Neue Position berechnen.
        yGeschwindigkeit += gravitation;
        yPosition += yGeschwindigkeit;
        xPosition += xGeschwindigkeit;

        // Prfen, ob eine Wand getroffen wurde
        if (yPosition <= 50 && yGeschwindigkeit < 0) { // decke getroffe

            //yPosition = 50;
            // neue y Position:
            while (50 > yPosition || yPosition + durchmesser > 50 + laengeDerBox) {
                if (yPosition < 50) {
                    yPosition = 50 - (yPosition - 50);
                }
                if (yPosition + durchmesser > 50 + laengeDerBox) {
                    yPosition = laengeDerBox + 50 - (yPosition + durchmesser - (laengeDerBox + 50)) - durchmesser;  // 2*wall - position
                }
            }

            if (yGeschwindigkeit != 0) {
                yGeschwindigkeit = -yGeschwindigkeit - reibung;
            }

            if (xGeschwindigkeit > 0 && xGeschwindigkeit != 0) {  // richtung rechts
                xGeschwindigkeit -= reibung;
            } else if (xGeschwindigkeit < 0 && xGeschwindigkeit != 0) {  // richtung links
                xGeschwindigkeit += reibung;
            }
        } else if (yPosition + durchmesser >= 50+laengeDerBox && yGeschwindigkeit > 0) { // boden
            //yPosition = 50+laengeDerBox-durchmesser;
            while (50 > yPosition || yPosition + durchmesser > 50 + laengeDerBox) {
                if (yPosition < 50) {
                    yPosition = 50 - (yPosition - 50);
                }
                if (yPosition + durchmesser > 50 + laengeDerBox) {
                    yPosition = laengeDerBox + 50 - (yPosition + durchmesser - (laengeDerBox + 50)) - durchmesser;
                }
            }

            if (yGeschwindigkeit != 0) {
                yGeschwindigkeit = -yGeschwindigkeit + reibung;
            }

            if (xGeschwindigkeit > 0 && xGeschwindigkeit != 0) {  // richtung rechts
                xGeschwindigkeit -= reibung;
            } else if (xGeschwindigkeit < 0 && xGeschwindigkeit != 0) {  // richtung links
                xGeschwindigkeit += reibung;
            }
        }

        if (xPosition <= 50 && xGeschwindigkeit < 0) { // linke wand
            //xPosition = 50;
            while (50 > xPosition || xPosition + durchmesser > 50 + laengeDerBox) {
                if (xPosition < 50) {
                    xPosition = 50 - (xPosition - 50);
                }
                if (xPosition + durchmesser > 50 + laengeDerBox) {
                    xPosition = laengeDerBox + 50 - (xPosition + durchmesser - (laengeDerBox + 50)) - durchmesser;
                }
            }

            if (xGeschwindigkeit != 0) {
                xGeschwindigkeit = -xGeschwindigkeit - reibung;
            }

            if (yGeschwindigkeit > 0 && yGeschwindigkeit != 0) {  // richtung rechts
                yGeschwindigkeit -= reibung;
            } else if (yGeschwindigkeit < 0 && yGeschwindigkeit != 0) {  // richtung links
                yGeschwindigkeit += reibung;
            }
        } else if (xPosition + durchmesser >= 50+laengeDerBox && xGeschwindigkeit > 0) { // rechte wand
            //xPosition = 50+laengeDerBox-durchmesser;
            while (50 > xPosition || xPosition + durchmesser > 50 + laengeDerBox) {
                if (xPosition < 50) {
                    xPosition = 50 - (xPosition - 50);
                }
                if (xPosition + durchmesser > 50 + laengeDerBox) {
                    xPosition = laengeDerBox + 50 - (xPosition + durchmesser - (laengeDerBox + 50)) - durchmesser;
                }
            }

            if (xGeschwindigkeit != 0) {
                xGeschwindigkeit = -xGeschwindigkeit + reibung;
            }

            if (yGeschwindigkeit > 0 && yGeschwindigkeit != 0) {  // richtung rechts
                yGeschwindigkeit -= reibung;
            } else if (yGeschwindigkeit < 0 && yGeschwindigkeit != 0) {  // richtung links
                yGeschwindigkeit += reibung;
            }
        }

        stopped();



        // An der neuen Position erneut zeichnen.
        //zeichnen();

    }

    public boolean stopped() {
        if ((0 == Math.round(xGeschwindigkeit) && Math.round(yGeschwindigkeit) == 0) && yPosition == 50+laengeDerBox-durchmesser) {
            stop = true;
            System.out.println("STOPPPP");
        }

        return stop;
        }
    public boolean getStop() {
        return stop;
    }


    public void zeichnen() {
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle((int) xPosition, (int) yPosition, durchmesser);
    }
    public void loeschen() {
        if (stop) return;
        leinwand.eraseCircle((int) xPosition, (int) yPosition, durchmesser);
        _geloescht = true;
    }
    public boolean geloescht() {return _geloescht;}

}
