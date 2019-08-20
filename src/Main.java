import org.Unterricht.Uebung.Banken.Bank;
import org.Unterricht.Uebung.Banken.Testklasse;


public class Main {
    public static void main(String[] args) {

        new Testklasse();

        Bank b = new Bank();
        b.neuesKonto("Hello Man");
        b.getKonto(0).kontoUebersicht();


        System.out.println("END!");
    }
}