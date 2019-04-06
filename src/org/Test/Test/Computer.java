package org.Test.Test;

import org.Tratium.Work.MeShort;


public class Computer<datenArt> {
    private int ID;
    private boolean status;
    private datenArt startDaten;
    public Computer(int ID, datenArt startDaten) {
        this.ID = ID;
        this.status = false;
        this.startDaten = startDaten;
    }

    public void hochfahren() {
        this.status = true;
        System.out.println("Computer " + this.getID() + " faehrt hoch!");
        this.rechnen();
    }
    public void herunterfahren() {
        this.status = false;
        System.out.println("Computer " + this.getID() + " faehrt herunter!");
    }

    public void rechnen() {
        System.out.println("Computer " + this.getID() + " rechnet: "+ this.startDaten);
    }

    public int getID() {
        return ID;
    }
}
