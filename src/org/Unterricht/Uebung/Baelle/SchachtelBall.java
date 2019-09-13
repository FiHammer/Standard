package org.Unterricht.Uebung.Baelle;

import java.awt.*;

public class SchachtelBall {
    private static final double gravitation = 1.0;  // Einfluss der Gravitation

    private static final double reibung = 0.05;
    private static final double reibungInPercent = 5;
    private static final double reibFak = 0.05;
    private Color farbe;
    private int durchmesser;
    private double xPosition;
    private double yPosition;
    private final int laengeDerBox;
    private Canvas leinwand;
    private boolean _geloescht = false;

    private boolean stop;


    private double yGeschwindigkeit;
    private double xGeschwindigkeit;

    private double highestXS;
    private double highestYS;

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
        if (stop) return; // ende, wenn der ball gestopped ist

        // Neue Position berechnen.
        yGeschwindigkeit += gravitation;
        yPosition += yGeschwindigkeit;
        xPosition += xGeschwindigkeit;


        double oldYP = yPosition;
        double oldXP = xPosition;
        double oldYS = yGeschwindigkeit;
        double oldXS = xGeschwindigkeit;
        System.out.println("Anfang: " + yGeschwindigkeit);


        // Prfen, ob eine Wand getroffen wurde, sollte ersetzt werden durch eine schleife
        if (yPosition <= 50 && yGeschwindigkeit < 0) { // decke getroffe
            // neue y Position:
            while (50 > yPosition || yPosition + durchmesser > 50 + laengeDerBox) {
                if (yPosition < 50) {
                    yPosition = 50 - (yPosition - 50);
                }
                if (yPosition + durchmesser > 50 + laengeDerBox) {
                    yPosition = laengeDerBox + 50 - (yPosition + durchmesser - (laengeDerBox + 50)) - durchmesser; // 2*wall - position
                }
            }

            if (yGeschwindigkeit != 0) {
                // vorher muss die geschwindigkeit negativ sein
                //                 positive yGesch (teste abs)- Reibung (yGesch * reibFaktor)
                yGeschwindigkeit = Math.abs(yGeschwindigkeit) - (Math.abs(yGeschwindigkeit) * reibFak);
            }


            System.out.println("Decke getroffen:\txGesch: " + (oldXS - xGeschwindigkeit) + "\n\t\t\t\t\t" +
                                                " yGesch: " + (oldYS - yGeschwindigkeit) + "\n\t\t\t\t\t" +
                                                " xPos: " + (oldXP - xPosition) + "\n\t\t\t\t\t" +
                                                " yPos: " + (oldYP - yPosition));
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
                // vorher muss die geschwindigkeit postiv sein
                //                neg( positive yGesch (teste abs)  - Reibung (yGesch * reibFaktor)
                System.out.println("Reibung " + yGeschwindigkeit + " " + Math.abs(yGeschwindigkeit)*reibFak);
                yGeschwindigkeit = -(Math.abs(yGeschwindigkeit) - (Math.abs(yGeschwindigkeit) * reibFak));
            }

            System.out.println("Boden getroffen:\t xGesch: " + (oldXS - xGeschwindigkeit) + "\n\t\t\t\t\t" +
                    " yGesch: " + (oldYS - yGeschwindigkeit) + "\n\t\t\t\t\t" +
                    " xPos: " + (oldXP - xPosition) + "\n\t\t\t\t\t" +
                    " yPos: " + (oldYP - yPosition));
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
                // vorher muss die geschwindigkeit neg sein
                //                pos( positive yGesch (teste abs)  - Reibung (yGesch * reibFaktor)
                xGeschwindigkeit = (Math.abs(xGeschwindigkeit) - (Math.abs(xGeschwindigkeit) * reibFak));
            }


            System.out.println("Linke Wand getroffen:\txGesch: " + (oldXS - xGeschwindigkeit) + "\n\t\t\t\t\t" +
                    " yGesch: " + (oldYS - yGeschwindigkeit) + "\n\t\t\t\t\t" +
                    " xPos: " + (oldXP - xPosition) + "\n\t\t\t\t\t" +
                    " yPos: " + (oldYP - yPosition));
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
                // vorher muss die geschwindigkeit pos sein
                //                neg( positive yGesch (teste abs)  - Reibung (yGesch * reibFaktor)
                xGeschwindigkeit = -(Math.abs(xGeschwindigkeit) - (Math.abs(xGeschwindigkeit) * reibFak));
            }

            System.out.println("Rechte Wand getroffen:\txGesch: " + (oldXS - xGeschwindigkeit) + "\n\t\t\t\t\t" +
                    " yGesch: " + (oldYS - yGeschwindigkeit) + "\n\t\t\t\t\t" +
                    " xPos: " + (oldXP - xPosition) + "\n\t\t\t\t\t" +
                    " yPos: " + (oldYP - yPosition));
        }

        if (yGeschwindigkeit > highestYS) {
            highestYS = yGeschwindigkeit;
            //System.out.println("Neue höhste Y-Gesch: " + highestYS);
        }


        if (xGeschwindigkeit > highestXS) {
            highestXS = xGeschwindigkeit;
            //System.out.println("Neue höhste X-Gesch: " + highestXS);
        }
        //System.out.println(xGeschwindigkeit + " " + yGeschwindigkeit);

        System.out.println("Ende: " + yGeschwindigkeit);
        stopped();
    }

    public boolean stopped() {
        if ((0 == Math.round(xGeschwindigkeit) && Math.round(yGeschwindigkeit) == 0) && Math.round(yPosition) == 50+laengeDerBox-durchmesser) {
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
