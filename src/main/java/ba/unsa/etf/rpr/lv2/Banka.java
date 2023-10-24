package ba.unsa.etf.rpr.lv2;

import java.util.List;

public class Banka {
    private Long brRacuna;
    private List<Korisnik> korisnici;
    private List<Uposlenik> uposlenici;
    Banka(){brRacuna=null;}
    Korisnik kreirajNovogKorisnika(String i, String p){
        return new Korisnik(i,p);
    }
    Uposlenik kreirajNovogUposlenika(String i, String p){
        return new Uposlenik(i,p);
    }
    Racun kreirajRacunZaKorisnika(Korisnik k){
        return new Racun(brRacuna, k);
    }
}
