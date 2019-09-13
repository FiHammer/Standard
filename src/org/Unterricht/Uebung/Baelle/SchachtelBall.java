package org.Unterricht.Uebung.Baelle;

import java.awt.*;

public class SchachtelBall {
    private static final double gravitation = 1.0;  // Einfluss der Gravitation

    private static final double reibung = 10.05;
    private static final double frictionFactor = 0.05;
    private Color farbe;
    private int diameter;
    private double xPosition;
    private double yPosition;
    private final int lengthOfBox;
    private Canvas leinwand;
    private boolean _geloescht = false;

    private boolean stop;


    private double ySpeed;
    private double xSpeed;

    // use for realistic y/x-movement
    private double startXSpeed=0;
    private double startYSpeed=0;
    private int timeSpend=0;

    public SchachtelBall(int xPos, int yPos, int balldurchmesser, Color ballfarbe,
                         int lengthOfBox, Canvas zeichengrund, int xSpeed, int ySpeed)
    {
        xPosition = xPos;
        yPosition = yPos;
        farbe = ballfarbe;
        diameter = balldurchmesser;
        this.lengthOfBox = lengthOfBox;
        leinwand = zeichengrund;

        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        stop = false;

        System.out.println("Generated a ball with \n" +
                "\t\txSpeed: " + xSpeed + "\n" +
                "\t\tySpeed: " + ySpeed);

    }

    public void bewegen() {
        if (stop) return;
        /*// Neue Position berechnen.
        if (Math.abs(ySpeed) > gravitation/100) { // gravity will only be apllied, if the the speed is under the gravityFac to prevent making the ball faster
            ySpeed += gravitation; // really bad operation to use gravity
        }
        yPosition += ySpeed;
        xPosition += xSpeed;*/

        timeSpend++;

        yPosition = -0.5*gravitation*Math.pow(timeSpend, 2) + startYSpeed*timeSpend;
        xPosition = startXSpeed*timeSpend;





        // Prfen, ob eine Wand getroffen wurde
        if (yPosition <= 50 && ySpeed < 0) { // decke getroffe
            // neue y Position:
            while (50 > yPosition || yPosition + diameter > 50 + lengthOfBox) {
                if (yPosition < 50) {
                    yPosition = 50 - (yPosition - 50);
                }
                if (yPosition + diameter > 50 + lengthOfBox) {
                    yPosition = lengthOfBox + 50 - (yPosition + diameter - (lengthOfBox + 50)) - diameter; // 2*wall - position
                }
            }

            if (ySpeed < 0) { // speed must be negative
                // bounce of wall
                // frictionYSpeed is now negative

                double frictionYSpeed = ySpeed * frictionFactor;
                //       make speed positive  adds (negtive) fricSpeed
                System.out.println("Invert ySpeed (bounce ceiling): \n\t\t\tFriction: " + frictionYSpeed + "\n\t\t\tOld Speed: " + ySpeed
                                    + "\n\t\t\tNew Speed: " + (-ySpeed + frictionYSpeed) );
                ySpeed = -ySpeed + frictionYSpeed;

            } else {throw new UnknownError();} // WTF could this be?


            // friction for the x Speed
            if (xSpeed < 0) {  // negativ xSpeed => left movement
                double frictionXSpeed = -xSpeed * frictionFactor;
                System.out.println("\tFriction for xSpeed (left): \n\t\t\tFriction: " + frictionXSpeed +
                                    "\n\t\t\tOld Speed: " + xSpeed +
                                    "\n\t\t\tNew Speed: " + (xSpeed + frictionXSpeed) );

                xSpeed += frictionXSpeed;
            } else if (0 < xSpeed) {  // positive xSpeed => right movement
                double frictionXSpeed = -xSpeed * frictionFactor;

                System.out.println("\tFriction for xSpeed (right): \n\t\t\tFriction: " + frictionXSpeed +
                        "\n\t\t\tOld Speed: " + xSpeed +
                        "\n\t\t\tNew Speed: " + (xSpeed + frictionXSpeed) );

                xSpeed += frictionXSpeed;
            } else {System.out.println("\tNo Friction for xSpeed");}


            /*
            if (ySpeed != 0) {
                ySpeed = -ySpeed - reibung;
            }

            if (xSpeed > 0 && xSpeed != 0) {  // richtung rechts
                xSpeed -= reibung;
            } else if (xSpeed < 0 && xSpeed != 0) {  // richtung links
                xSpeed += reibung;
            }*/

        } else if (yPosition + diameter >= 50+ lengthOfBox && ySpeed > 0) { // boden
            //yPosition = 50+lengthOfBox-diameter;
            while (50 > yPosition || yPosition + diameter > 50 + lengthOfBox) {
                if (yPosition < 50) {
                    yPosition = 50 - (yPosition - 50);
                }
                if (yPosition + diameter > 50 + lengthOfBox) {
                    yPosition = lengthOfBox + 50 - (yPosition + diameter - (lengthOfBox + 50)) - diameter;
                }
            }


            if (0 < ySpeed) { // positive ySpeed (falling) => going up/inverting
                double frictionYSpeed = ySpeed * frictionFactor;
                //       make speed negativ  adds (postivie) fricSpeed
                System.out.println("Invert ySpeed (bounce ground): \n\t\t\tFriction: " + frictionYSpeed + "\n\t\t\tOld Speed: " + ySpeed
                        + "\n\t\t\tNew Speed: " + (-ySpeed + frictionYSpeed) );
                ySpeed = -ySpeed + frictionYSpeed;

            } else {throw new UnknownError();}


            // friction for the x Speed
            if (xSpeed < 0) {  // negativ xSpeed => left movement
                double frictionXSpeed = -xSpeed * frictionFactor;
                System.out.println("\tFriction for xSpeed (left): \n\t\t\tFriction: " + frictionXSpeed +
                        "\n\t\t\tOld Speed: " + xSpeed +
                        "\n\t\t\tNew Speed: " + (xSpeed + frictionXSpeed) );

                xSpeed += frictionXSpeed;
            } else if (0 < xSpeed) {  // positive xSpeed => right movement
                double frictionXSpeed = -xSpeed * frictionFactor;

                System.out.println("\tFriction for xSpeed (right): \n\t\t\tFriction: " + frictionXSpeed +
                        "\n\t\t\tOld Speed: " + xSpeed +
                        "\n\t\t\tNew Speed: " + (xSpeed + frictionXSpeed) );

                xSpeed += frictionXSpeed;
            } else {System.out.println("\tNo Friction for xSpeed");}


            /*if (ySpeed != 0) {
                ySpeed = -ySpeed + reibung;
            }

            if (xSpeed > 0 && xSpeed != 0) {  // richtung rechts
                xSpeed -= reibung;
            } else if (xSpeed < 0 && xSpeed != 0) {  // richtung links
                xSpeed += reibung;
            }*/
        }

        if (xPosition <= 50 && xSpeed < 0) { // linke wand
            //xPosition = 50;
            while (50 > xPosition || xPosition + diameter > 50 + lengthOfBox) {
                if (xPosition < 50) {
                    xPosition = 50 - (xPosition - 50);
                }
                if (xPosition + diameter > 50 + lengthOfBox) {
                    xPosition = lengthOfBox + 50 - (xPosition + diameter - (lengthOfBox + 50)) - diameter;
                }
            }

            if (xSpeed < 0) { // xspeed is negative (movement to left)
                double frictionXSpeed = xSpeed * frictionFactor;
                System.out.println("Invert xSpeed (bounce left wall): \n\t\t\tFriction: " + frictionXSpeed + "\n\t\t\tOld Speed: " + xSpeed
                        + "\n\t\t\tNew Speed: " + (-xSpeed + frictionXSpeed) );
                //      positive speed + negative friction
                xSpeed = -xSpeed + frictionXSpeed;

            } else {throw new UnknownError();}

            if (ySpeed < 0) {  // negativ ySpeed => up movement
                double frictionYSpeed = -ySpeed * frictionFactor; // positive friction
                System.out.println("\tFriction for ySpeed (up): \n\t\t\tFriction: " + frictionYSpeed +
                        "\n\t\t\tOld Speed: " + ySpeed +
                        "\n\t\t\tNew Speed: " + (ySpeed + frictionYSpeed) );

                ySpeed += frictionYSpeed;
            } else if (0 < ySpeed) {  // positive ySpeed => down movement
                double frictionYSpeed = -ySpeed * frictionFactor;

                System.out.println("\tFriction for ySpeed (down): \n\t\t\tFriction: " + frictionYSpeed +
                        "\n\t\t\tOld Speed: " + ySpeed +
                        "\n\t\t\tNew Speed: " + (ySpeed + frictionYSpeed) );

                ySpeed += frictionYSpeed;
            } else {System.out.println("\tNo Friction for ySpeed");}

            /*if (xSpeed != 0) {
                xSpeed = -xSpeed - reibung;
            }

            if (ySpeed > 0 && ySpeed != 0) {  // richtung rechts
                ySpeed -= reibung;
            } else if (ySpeed < 0 && ySpeed != 0) {  // richtung links
                ySpeed += reibung;
            }*/
        } else if (xPosition + diameter >= 50+ lengthOfBox && xSpeed > 0) { // rechte wand
            //xPosition = 50+lengthOfBox-diameter;
            while (50 > xPosition || xPosition + diameter > 50 + lengthOfBox) {
                if (xPosition < 50) {
                    xPosition = 50 - (xPosition - 50);
                }
                if (xPosition + diameter > 50 + lengthOfBox) {
                    xPosition = lengthOfBox + 50 - (xPosition + diameter - (lengthOfBox + 50)) - diameter;
                }
            }

            if (0 < xSpeed) { // xspeed is positive (movement to right)
                double frictionXSpeed = xSpeed * frictionFactor;
                System.out.println("Invert xSpeed (bounce right wall): \n\t\t\tFriction: " + frictionXSpeed + "\n\t\t\tOld Speed: " + xSpeed
                        + "\n\t\t\tNew Speed: " + (-xSpeed + frictionXSpeed) );
                //      negative speed + positive friction
                xSpeed = -xSpeed + frictionXSpeed;

            } else {throw new UnknownError();}

            if (ySpeed < 0) {  // negativ ySpeed => up movement
                double frictionYSpeed = -ySpeed * frictionFactor; // positive friction
                System.out.println("\tFriction for ySpeed (up): \n\t\t\tFriction: " + frictionYSpeed +
                        "\n\t\t\tOld Speed: " + ySpeed +
                        "\n\t\t\tNew Speed: " + (ySpeed + frictionYSpeed) );

                ySpeed += frictionYSpeed;
            } else if (0 < ySpeed) {  // positive ySpeed => down movement
                double frictionYSpeed = -ySpeed * frictionFactor;

                System.out.println("\tFriction for ySpeed (down): \n\t\t\tFriction: " + frictionYSpeed +
                        "\n\t\t\tOld Speed: " + ySpeed +
                        "\n\t\t\tNew Speed: " + (ySpeed + frictionYSpeed) );

                ySpeed += frictionYSpeed;
            } else {System.out.println("\tNo Friction for ySpeed");}

            /*if (xSpeed != 0) {
                xSpeed = -xSpeed + reibung;
            }

            if (ySpeed > 0 && ySpeed != 0) {  // richtung rechts
                ySpeed -= reibung;
            } else if (ySpeed < 0 && ySpeed != 0) {  // richtung links
                ySpeed += reibung;
            }*/
        }


        stopped(); // checked if stopped

    }

    public boolean stopped() {
        if ((0 == Math.round(xSpeed) && Math.round(ySpeed) == 0) && yPosition == 50+ lengthOfBox - diameter) {
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
        leinwand.fillCircle((int) xPosition, (int) yPosition, diameter);
    }
    public void loeschen() {
        if (stop) return;
        leinwand.eraseCircle((int) xPosition, (int) yPosition, diameter);
        _geloescht = true;
    }
    public boolean geloescht() {return _geloescht;}

}
