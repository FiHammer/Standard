import org.Bsp.Set_List_Map.MapBsp;
import org.Test.Test.Person;
import org.Test.Test.Raum;
import org.Unterricht.Uebung.Einfuerung12BG.Lotto;

import java.util.Random;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Lotto l = new Lotto();

        System.out.println(l.getLottozahlenString());
        l.wuerfle();
        System.out.println(l.getLottozahlenString());
        l.wuerfle();
        System.out.println(l.getLottozahlenString());
        l.wuerfle();
        System.out.println(l.getLottozahlenString());
        l.wuerfle();
        System.out.println(l.getLottozahlenString());
        l.wuerfle();
        System.out.println(l.getLottozahlenString());
        l.wuerfle();

        System.out.println("END!");
    }
}