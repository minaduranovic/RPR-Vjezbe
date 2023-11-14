package ba.unsa.etf.rpr;

public class InformacijeOStudentu extends LicneInformacije {
    private String godinaStudija;
    private String brojIndexa;

    public InformacijeOStudentu(String ime, String prezime, String godinaStudija, String brojIndexa) {
        super(ime, prezime);
        this.godinaStudija = godinaStudija;
        this.brojIndexa = brojIndexa;
    }

    // Get i set metode za godinaStudija
    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    // Get i set metode za brojIndexa
    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }
}