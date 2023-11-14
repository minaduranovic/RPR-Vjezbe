package ba.unsa.etf.rpr;

public class InformacijeOStudentuPredstava implements Predstavljiv {
    private InformacijeOStudentu informacije;

    public InformacijeOStudentuPredstava(InformacijeOStudentu informacije) {
        this.informacije = informacije;
    }

    @Override
    public String predstavi() {
        return "Ime: " + informacije.getIme() + ", Prezime: " + informacije.getPrezime() +
                ", Godina studija: " + informacije.getGodinaStudija() + ", Broj indexa: " + informacije.getBrojIndexa();
    }
}
