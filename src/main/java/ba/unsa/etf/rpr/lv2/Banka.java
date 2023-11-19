package ba.unsa.etf.rpr.lv2;

import java.util.List;

public class Banka {
    private Long brRacuna;
    private List<Korisnik> korisnici;
    private List<Uposlenik> uposlenici;
    public Banka(){brRacuna=null;}
    public Korisnik kreirajNovogKorisnika(String i, String p){
        return new Korisnik(i,p);
    }
    public Uposlenik kreirajNovogUposlenika(String i, String p){
        return new Uposlenik(i,p);
    }
    public Racun kreirajRacunZaKorisnika(Korisnik k){
        return new Racun(brRacuna, k);
    }
}
