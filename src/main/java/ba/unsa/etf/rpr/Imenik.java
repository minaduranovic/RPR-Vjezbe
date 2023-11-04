package ba.unsa.etf.rpr;

import java.util.*;

public class Imenik {
    private Map<String, TelefonskiBroj> imenik ;

    public Imenik(){
        this.imenik= new HashMap<String, TelefonskiBroj>();
    }

    public Map<String, TelefonskiBroj> getImenik() {
        return imenik;
    }

    public void setImenik(Map<String, TelefonskiBroj> imenik) {
        this.imenik = imenik;
    }

    public void dodaj(String ime, TelefonskiBroj broj) {
        imenik.put(ime, broj);
    }

    public String dajBroj(String ime) {
        TelefonskiBroj broj = imenik.get(ime);
        if (broj != null) {
            return broj.Ispisi();
        } else {
            return "Nema te osobe u imeniku";
        }
    }

    public String dajIme(TelefonskiBroj broj) {
        for (String ime : imenik.keySet()) {
            if (imenik.get(ime).equals(broj)) {
                return ime;
            }
        }
        return "nema broja";
    }

    public String naSlovo(char s) {
        StringBuilder rez = new StringBuilder();
        for (String ime : imenik.keySet()) {
            if (ime.charAt(0) == s) {
                rez.append(ime).append(" - ").append(imenik.get(ime).Ispisi()).append("\n");
            }
        }
        return rez.toString();
    }

    public Set<String> izGrada(Grad g) {
        Set<String> novi=new TreeSet<>();

        for (Map.Entry<String, TelefonskiBroj> entry: this.imenik.entrySet()){
            if (uGradu(entry.getValue(), g)){
                novi.add(entry.getKey());
            }
        }

        return novi;
    }
    private boolean uGradu(TelefonskiBroj br, Grad g){
        if (br instanceof FiksniBroj ) {
            return g.equals(((FiksniBroj) br).getGrad());
        }
        else return false;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        Set<TelefonskiBroj> novi = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.Ispisi().compareTo(o2.Ispisi());
            }
        });
        for (Map.Entry<String, TelefonskiBroj> entry : this.imenik.entrySet()) {
            if (uGradu(entry.getValue(), g)) {
                novi.add(entry.getValue());
            }
        }
        return novi;
    }

    @Override
    public String toString() {
        StringBuilder rez = new StringBuilder();
        int count=1;

        for (Map.Entry<String, TelefonskiBroj> entry: this.imenik.entrySet()) {
            rez.append(count).append(". ").append(entry.getKey()).append(" - ").append(entry.getValue().Ispisi()).append(System.lineSeparator());
    count++;
        }
        return rez.toString();
    }
}

