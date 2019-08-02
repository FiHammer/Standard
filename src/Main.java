import org.Bsp.Set_List_Map.MapBsp;
import org.Test.Test.Person;
import org.Test.Test.Raum;
import java.util.Random;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MapBsp mp = new MapBsp();
        mp.doWork();

        /*

            1   - 10
            min - max

            1. zwischen min & max => 2-9
            int inclMin = 0;
            r.nextInt(max-min+inclMin)+min+1-inclMin;

            2. von min (incl) & max
            r.nextInt(max-min)+min


         */

        /*

        Random rand = new Random();

        int inclMin = 0;
        int inclMax = 1;
        int max = 5;
        int min = 2;
        if (inclMax == 0) {
            max -= 1;
        }
        if (inclMin == 0) {
            min += 1;
        }

        for (int x=0; x<10; x++) {
            System.out.println(rand.nextInt(max-min+1)+min);
        }
        */
        System.out.println("END!");
    }
}