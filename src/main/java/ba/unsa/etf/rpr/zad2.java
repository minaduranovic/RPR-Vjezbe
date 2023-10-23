package ba.unsa.etf.rpr;


import java.util.Scanner;

public class zad2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Unesite n: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            if (i % sumaCifara(i) == 0) {
                System.out.println(i);
            }
        }
    }

    public static int sumaCifara(int broj) {
        int suma = 0;
        while (broj > 0) {
            suma += broj % 10;
            broj /= 10;
        }
        return suma;
    }
}

