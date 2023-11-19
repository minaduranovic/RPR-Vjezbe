package ba.unsa.etf.rpr.lv2;

public class Racun
{
    private Long brojRacuna;
    private Osoba korisnikRacuna;
    private Boolean odobrenjePrekoracenja;
    private Double stanjeRacuna;
    public Racun(Long br, Osoba o){ brojRacuna=br; korisnikRacuna=o; }
    private Boolean provjeriOdobrenjePrekoracenja( Double pr){
        return true;
    }
    public Boolean izvrsiUplatu(Double uplata){
        stanjeRacuna+=uplata;
        return true;
    }
    public Boolean izvrsiIsplatu (Double isplata){
        stanjeRacuna-=isplata;
        return true;
    }
   public void odobriPrekoracenje(Double d){
        if (d<0) odobrenjePrekoracenja=true;
    }

}
