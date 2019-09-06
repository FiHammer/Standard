package org.Unterricht.Uebung.SamBaelle;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Die Klasse Ball implementiert grafisch B�lle, die der Schwerkraft
 * unterworfen sind. Ein Ball kann bewegt werden. Die Bedingungen der Bewegung
 * werden dabei vom Ball selbst kontrolliert. Er f�llt abw�rts und beschleunigt
 * aufgrund der Schwerkraft. Er prallt ab, wenn er auf dem Boden auftrifft.
 * 
 * Diese Bewegung kann simuliert werden, indem wiederholt die Operation
 * "bewegen" aufgerufen wird.
 * 
 * @author Bruce Quig
 * @author Michael Kolling (mik)
 * @author David J. Barnes
 *
 * @version 2008.03.30
 */

public class Ball
{
    private static final int gravitation = 3;  // Einfluss der Gravitation
    private static final int bremsfaktor = 2;  // simuliert den Luftwiderstand

    private Ellipse2D.Double kreis;
    private Color farbe;
    private int durchmesser;
    private int xPosition;
    private int yPosition;
    private int xPosVorher;
    private int yPosVorher;
    private final int bodenhoehe;      // y-Position des Bodens
    private final int linkeSeite;
    private final int rechteSeite;
    private Canvas leinwand;
    private int yGeschwindigkeit = -21;   // anf�ngliche Abw�rtsgeschwindigkeit
    private int xGeschwindigkeit;

    // private int[][] obstacles = {{},{},{}};

    /**
     * Konstruktor f�r Exemplare von Ball
     *
     * @param xPos  die horizontale Koordinate des Balles
     * @param yPos  die vertikale Koordinate des Balles
     * @param balldurchmesser  der Durchmesser des Balles (in Bildschirmpunkten)
     * @param ballfarbe  die Farbe des Balles
     * @param bodenPosition  die y-Position des Bodens (wo der Ball aufspringt)
     * @param zeichengrund die Leinwand, auf der dieser Ball gezeichnet wird
     */
    public Ball(int xPos, int yPos, int balldurchmesser, Color ballfarbe,
                        int bodenPosition, int lSeitePosition, int rSeitePosition, Canvas zeichengrund)
    {
        xPosition = xPos;
        yPosition = yPos;
        farbe = ballfarbe;
        durchmesser = balldurchmesser;
        bodenhoehe = bodenPosition;
        linkeSeite = lSeitePosition;
        rechteSeite = rSeitePosition;
        leinwand = zeichengrund;
        xGeschwindigkeit = 20;
    }

    /**
     * Zeichne diesen Ball an der aktuellen Position auf die Leinwand.
     **/
    public void zeichnen()
    {
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle(xPosition, yPosition, durchmesser);
    }

    /**
     * L�sche diesen Ball an seiner aktuellen Position.
     **/
    public void loeschen()
    {
        leinwand.eraseCircle(xPosition, yPosition, durchmesser);
    }    

    /**
     * Bewege diesen Ball entsprechend seiner Position und 
     * Geschwindigkeit und zeichne ihn erneut.
     **/
    public void bewegen()
    {
        // An der aktuellen Position von der Leinwand entfernen.
            // loeschen();

        // alte Position speichern.
            // xPosVorher = xPosition;
            // yPosVorher = yPosition;

        // Neue Position berechnen.
        yGeschwindigkeit += gravitation;
        yPosition += yGeschwindigkeit;
        xPosition += xGeschwindigkeit;

        //Positionen überprüfen auf Obstacles.



        // Pr�fen, ob der Boden erreicht ist.
        if(yPosition >= (bodenhoehe - durchmesser) && yGeschwindigkeit > 0) {
            yPosition = (bodenhoehe - durchmesser);
            yGeschwindigkeit = -yGeschwindigkeit + bremsfaktor; 
        }
        if(xPosition >= (rechteSeite - durchmesser)) {
             //TODO
            xPosition = (rechteSeite -durchmesser);
            xGeschwindigkeit = 0 - xGeschwindigkeit;
        }
        if(xPosition <=linkeSeite) {
            //TODO
            xPosition = (linkeSeite);
            xGeschwindigkeit = 0 - xGeschwindigkeit;
        }

        // An der neuen Position erneut zeichnen.
            // zeichnen();


        // wenn die vorherige Position des Balls und die berechnete nächste Position
    }    

    /**
     * Liefere die horizontale Position dieses Balls.
     */
    public int gibXPosition()
    {
        return xPosition;
    }

    /**
     * Liefere die vertikale Position dieses Balls.
     */
    public int gibYPosition()
    {
        return yPosition;
    }
}
