package org.Unterricht.Uebung.SamBaelle;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

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

public class Schachtelball
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
    private final int deckenhoehe;
    private final int bodenhoehe;      // y-Position des Bodens
    private final int linkeSeite;
    private final int rechteSeite;
    private BetterCanvas leinwand;
    private int yGeschwindigkeit;   // anf�ngliche Abw�rtsgeschwindigkeit
    private int xGeschwindigkeit;


    public Schachtelball(int xPos, int yPos, int balldurchmesser,int deckenPosition,
                int bodenPosition, int lSeitePosition, int rSeitePosition, BetterCanvas zeichengrund)
    {
        xPosition = xPos;
        yPosition = yPos;
        Random rnd = new Random();
        farbe = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255), 255);
        //farbe = new Color(0, 0, 0, 255);
        durchmesser = balldurchmesser;
        deckenhoehe = deckenPosition;
        bodenhoehe = bodenPosition;
        linkeSeite = lSeitePosition;
        rechteSeite = rSeitePosition;
        leinwand = zeichengrund;
        xGeschwindigkeit = 5 - rnd.nextInt(11);
        yGeschwindigkeit = 5 - rnd.nextInt(11);
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
        if(yPosition <= deckenhoehe) {
            yPosition = deckenhoehe;
            yGeschwindigkeit = -yGeschwindigkeit;
        }
        if(xPosition >= (rechteSeite - durchmesser)) {
            //TODO
            xPosition = (rechteSeite -durchmesser);
            xGeschwindigkeit = 0 - xGeschwindigkeit;
        }
        if(xPosition <= linkeSeite) {
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
