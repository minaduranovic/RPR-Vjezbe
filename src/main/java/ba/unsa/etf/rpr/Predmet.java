package ba.unsa.etf.rpr;

public class Predmet {
    private String naziv;
    private String opis;

    public Predmet(String naziv, String opis) {
        this.naziv = naziv;
        this.opis = opis;
    }

    // Get i set metode za naziv
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    // Get i set metode za opis
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
