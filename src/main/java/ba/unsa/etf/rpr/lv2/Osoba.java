package ba.unsa.etf.rpr.lv2;

public class Osoba {
    private String ime;
    private String prezime;
    Osoba (){ime=null; prezime=null;}
    Osoba(String i , String p){ ime=i; prezime=p;}

    public String toString(){
        return ime + " " + prezime;
    }
}
