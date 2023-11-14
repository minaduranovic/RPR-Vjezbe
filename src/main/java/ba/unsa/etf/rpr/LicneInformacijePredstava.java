package ba.unsa.etf.rpr;

public class LicneInformacijePredstava implements Predstavljiv {
    private LicneInformacije informacije;

    public LicneInformacijePredstava(LicneInformacije informacije) {
        this.informacije = informacije;
    }

    @Override
    public String predstavi() {
        return "Ime: " + informacije.getIme() + ", Prezime: " + informacije.getPrezime();
    }
}

