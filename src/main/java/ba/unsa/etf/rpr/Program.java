package ba.unsa.etf.rpr;

import java.util.*;

public class Program {
   public static Imenik imenik = new Imenik();
    public static Scanner scanner = new Scanner(System.in);

    private static TelefonskiBroj unesiBroj(){
        System.out.println("Uneesite tip broja(fiksni, mobilni,medjunarodni");
        String tip= scanner.nextLine();
        switch (tip){
            case "fiksni":
                System.out.println("Uneesite pozivni");
                String pozivni= scanner.nextLine();
                System.out.println("Unesite broj");
                String broj=scanner.nextLine();
                return new FiksniBroj(Grad.izPozivnog(pozivni), broj);
            case "mobilni":
                System.out.println("Uneesite mrezu: ");
                int mreza= scanner.nextInt();
                System.out.println("Unesite broj");
                String mobBroj=scanner.nextLine();
                return new MobilniBroj(mreza, mobBroj);
            case "medjunarodni":
                System.out.println("Uneesite kod drzave");
                String kod= scanner.nextLine();
                System.out.println("Unesite broj");
                String medbroj=scanner.nextLine();
                return new MedunarodniBroj(kod, medbroj);
        }
        return null;
    }
    public static void main(String[] args) {


        while (true) {
            System.out.println("Izaberite opciju:");
            System.out.println("1. Dodaj");
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
                    TelefonskiBroj br=unesiBroj();
                    imenik.dodaj(ime, br);
                    break;
                case 2:
                    System.out.print("Unesite ime za pretragu: ");
                    String imeZaPretragu = scanner.nextLine();
                    String rez=imenik.dajBroj(imeZaPretragu);
                    System.out.println(rez== null? "nema u imeniku" : rez);
                    break;
                case 3:
                    TelefonskiBroj broj=unesiBroj();
                    String imee=imenik.dajIme(broj);
                    if (imee==null) {
                        System.out.println("Ne postoji");
                    }
                    else{
                        System.out.println("Vlasnik broj" + broj.Ispisi()+ " je" + imee) ;
                    }
                    break;
                case 4:
                    System.out.print("Unesite slovo za pretragu: ");
                    char slovo = scanner.nextLine().charAt(0);
                    String odg =imenik.naSlovo(slovo);
                    System.out.println(odg);
                    break;
                case 5:
                    System.out.print("Unesite grad za pretragu (npr. SARAJEVO): ");
                    Grad grad = Grad.valueOf(scanner.nextLine());
                    break;
                case 6:
                    System.out.print("Unesite grad za pretragu (npr. SARAJEVO): ");
                    String gradd= scanner.nextLine();
                    try{
                        Grad g=Grad.valueOf(gradd);
                        Set<TelefonskiBroj> odgg=imenik.izGradaBrojevi(g);
                        for (TelefonskiBroj b: odgg){
                            System.out.println(b.Ispisi());
                        }
                    }catch (Exception e){
                        System.out.println("Pogresan grad");
                        return;
                    }
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

