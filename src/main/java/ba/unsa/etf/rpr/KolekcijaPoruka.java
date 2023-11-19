package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;


class KolekcijaPoruka {
    private List<String> poruke=new ArrayList<>();

    public KolekcijaPoruka(ArrayList<Predstava> objekti) {
        for (Predstava klasa : objekti) {
            poruke.add(klasa.predstavi());
        }
    }

    public List<String> getPoruke() {
        return poruke;
    }
}
