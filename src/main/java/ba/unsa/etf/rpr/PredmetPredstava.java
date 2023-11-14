package ba.unsa.etf.rpr;

public class PredmetPredstava implements Predstavljiv {
private Predmet predmet;

public PredmetPredstava(Predmet predmet) {
        this.predmet = predmet;
        }

@Override
public String predstavi() {
        return "Naziv predmeta: " + predmet.getNaziv() + ", Opis: " + predmet.getOpis();
        }
        }