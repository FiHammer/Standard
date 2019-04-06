package org.BlueJ.Kap3.Uebung.U27;

public class Quadrat {
    private double x;
    private double y;

    public Quadrat(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getAcreage() {
        return x*y;
    }
    public double getExtent() {
        return 2*x+2*y;
    }

}
