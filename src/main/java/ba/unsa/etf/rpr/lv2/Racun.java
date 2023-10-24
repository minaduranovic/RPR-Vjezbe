package ba.unsa.etf.rpr.lv2;

public class Racun
{
    private Long brojRacuna;
    private Osoba korisnikRacuna;
    private Boolean odobrenjePrekoracenja;
    private Double stanjeRacuna;
    Racun(Long br, Osoba o){ brojRacuna=br; korisnikRacuna=o; }
    private Boolean provjeriOdobrenjePrekoracenja( Double pr){
        return true;
    }
    Boolean izvrsiUplatu(Double uplata){
        stanjeRacuna+=uplata;
        return true;
    }
    Boolean izvrsiIsplatu (Double isplata){
        stanjeRacuna-=isplata;
        return true;
    }
    void odobriPrekoracenje(Double d){
        if (d<0) odobrenjePrekoracenja=true;
    }

}
