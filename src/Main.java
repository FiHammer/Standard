import org.Test.Test.Person;
import org.Test.Test.Raum;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Raum<Person> raum;
        raum = new Raum<>();
        raum.add(new Person());
        raum.add(new Person());

        raum.timeIsGone();

        System.out.println("END!");
    }
}