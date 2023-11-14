package ba.unsa.etf.rpr;

public class InformacijeONastavnikuPredstava implements Predstavljiv {
    private InformacijeONastavniku informacije;

    public InformacijeONastavnikuPredstava(InformacijeONastavniku informacije) {
        this.informacije = informacije;
    }

    @Override
    public String predstavi() {
        return "Ime: " + informacije.getIme() + ", Prezime: " + informacije.getPrezime() +
                ", Titula: " + informacije.getTitula();
    }
}