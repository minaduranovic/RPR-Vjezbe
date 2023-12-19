package ba.unsa.etf.rpr;

public class Grad {
    private String ime;
    private int brojStanovnika;

    public Grad(String ime, int brojStanovnika) {
        this.ime = ime;
        this.brojStanovnika = brojStanovnika;
    }

    public String getIme() {
        return ime;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }
}

