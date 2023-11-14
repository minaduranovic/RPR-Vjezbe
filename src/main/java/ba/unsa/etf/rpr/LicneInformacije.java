package ba.unsa.etf.rpr;

public class LicneInformacije {
    private String ime;
    private String prezime;

    public LicneInformacije(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    // Get i set metode za ime
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    // Get i set metode za prezime
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}