package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class PredmetOcjena extends Predmet implements MozeOcijeniti {
    private List<Ocjena> ocjene;

    public PredmetOcjena(String naziv, String opis) {
        super(naziv, opis);
        this.ocjene = new ArrayList<>();
    }

    @Override
    public Ocjena ocijeni(int ocjena) {
        Ocjena novaOcjena = new Ocjena(null, ocjena);
        ocjene.add(novaOcjena);
        return novaOcjena;
    }

    // Get metoda za ocjene
    public List<Ocjena> getOcjene() {
        return ocjene;
    }
}
