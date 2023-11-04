package ba.unsa.etf.rpr;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Imenik imenik = new Imenik();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Izaberite opciju:");
            System.out.println("1. Dodaj osobu i broj");
            System.out.println("2. Pronađi broj po imenu");
            System.out.println("3. Pronađi ime po broju");
            System.out.println("4. Osobe na slovo");
            System.out.println("5. Osobe iz grada");
            System.out.println("6. Brojevi osoba iz grada");
            System.out.println("0. Izlaz");

            int opcija = scanner.nextInt();
            scanner.nextLine();

            switch (opcija) {
                case 1:
                    System.out.print("Unesite ime: ");
                    String ime = scanner.nextLine();
                    System.out.print("Unesite broj (npr. 061/987-654): ");
                    String broj = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Unesite ime za pretragu: ");
                    String imeZaPretragu = scanner.nextLine();

                    break;
                case 3:
                    System.out.print("Unesite broj za pretragu (npr. 061/987-654): ");
                    String brojZaPretragu = scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Unesite slovo za pretragu: ");
                    char slovo = scanner.nextLine().charAt(0);
                    break;
                case 5:
                    System.out.print("Unesite grad za pretragu (npr. SARAJEVO): ");
                    Grad grad = Grad.valueOf(scanner.nextLine());
                    break;
                case 6:
                    System.out.print("Unesite grad za pretragu (npr. SARAJEVO): ");
                    Grad gradBrojevi = Grad.valueOf(scanner.nextLine());
                    break;
                case 0:
                    System.out.println("Hvala što ste koristili ETF Telefonski imenik.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Nepostojeća opcija. Molimo izaberite ponovo.");
            }
        }
    }
}

