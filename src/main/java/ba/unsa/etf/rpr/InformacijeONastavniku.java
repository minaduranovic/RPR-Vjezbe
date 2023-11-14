package ba.unsa.etf.rpr;

public class InformacijeONastavniku extends LicneInformacije {
    private String titula;

    public InformacijeONastavniku(String ime, String prezime, String titula) {
        super(ime, prezime);
        this.titula = titula;
    }

    // Get i set metode za titulu
    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }
}
