package ba.unsa.etf.rpr.lv3;

import java.util.HashMap;

public class Imenik {
    private HashMap<String, TelefonskiBroj> imenik = new HashMap<String, TelefonskiBroj>();

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

//    public Set<String> izGrada(Grad g) {
//
//    }
//
//    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
//
//    }
}

