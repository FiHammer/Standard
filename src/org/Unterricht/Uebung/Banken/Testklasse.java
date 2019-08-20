package org.Unterricht.Uebung.Banken;

import java.util.Random;

public class Testklasse {
    public Testklasse() {
        simulieren();
    }

    public void simulieren() {
        Bank b = new Bank(100);
        Random r = new Random();

        b.neuesKonto("Hummer Olaf");
        b.neuesKonto("Kammbert Guenter");
        b.neuesKonto("Plant Unger");

        for (Konto k: b.getKonten()) {
            for (int i=0; i<2; i++) {
                switch (r.nextInt(3)) {
                    case 0: {
                        k.einzahlen(r.nextInt(50));
                    }
                    case 1: {
                        k.auszahlen(r.nextInt(50));
                    }
                    case 2: {
                        k.ueberweisen(r.nextInt(b.getKonten().size()), r.nextInt(50));
                    }
                }
            }
        }

        b.kontenUebersicht();
    }
}
