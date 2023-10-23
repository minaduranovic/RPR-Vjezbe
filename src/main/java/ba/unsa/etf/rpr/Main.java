package ba.unsa.etf.rpr;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {

        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite prvi broj");
        int a, b;
        a = ulaz.nextInt();
        System.out.println("Unesite drugi broj");
        b = ulaz.nextInt();
        System.out.println("Uneseni su brojevi: " + a + " i " + b);
    }


}