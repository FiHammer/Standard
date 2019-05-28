import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {



        HashSet<String> hs = new HashSet<>();
        hs.add("Hallo");
        hs.add("Ich");
        hs.add("Bin");
        hs.add("Toll");

        for (String s: hs)
        {
            System.out.println(s);
        }

        for (Iterator i= hs.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }

        x = 3;

        System.out.println("END!");
    }
    public static int x= 2;

}