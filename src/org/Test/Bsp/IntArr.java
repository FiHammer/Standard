package org.Test.Bsp;

public class IntArr {
    private Integer[] intArr;
    private Compiler[] compi;
    public IntArr() {
        this.intArr = new Integer[100];
    }

    public void testMeth() {
        for (int aOb: intArr) {
            System.out.println(aOb);
        }

    }
    public void testMethWrite() {
        for (int x=0;x<this.intArr.length; x++) {
            this.intArr[x] = x;
        }

    }
}