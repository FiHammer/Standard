package org.Test.Test;
import org.Tratium.Work.MeShort;

import java.util.ArrayList;

class Test1 {
    private Integer myUsed;
    private Integer myID;

    Test1(int id) {
        this.myUsed = 0;
        this.myID = id;
    }

    String ret() {
        this.myUsed++;
        return "Usedme (" + this.myID + "): " + this.myUsed;
    }
}
