package ba.unsa.etf.rpr;

 public class Main {
    public static void main(String[] args) {
        PredmetOcjena programiranje = new PredmetOcjena("Programiranje", "Osnove programiranja");
        LicneInformacije student = new LicneInformacije("John", "Doe");

        Ocjena ocjenaZaPredmet = programiranje.ocijeni(9);
        ocjenaZaPredmet.setOsoba(student);

        System.out.println("Ocjene za predmet " + programiranje.getNaziv() + ": " + programiranje.getOcjene().get(0).getOcjena());

        InformacijeONastavnikuOcjena profNastavnik = new InformacijeONastavnikuOcjena("Prof", "Nastavnik", "Dr.");

        Ocjena ocjenaZaNastavnika = profNastavnik.ocijeni(8);
        ocjenaZaNastavnika.setOsoba(student);

        System.out.println("Ocjene za nastavnika " + profNastavnik.getIme() + " " + profNastavnik.getPrezime() + ": " + profNastavnik.getOcjene().get(0).getOcjena());
    }
}






