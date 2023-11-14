package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class InformacijeONastavnikuOcjena extends InformacijeONastavniku implements MozeOcijeniti {
    private List<Ocjena> ocjene;

    public InformacijeONastavnikuOcjena(String ime, String prezime, String titula) {
        super(ime, prezime, titula);
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
