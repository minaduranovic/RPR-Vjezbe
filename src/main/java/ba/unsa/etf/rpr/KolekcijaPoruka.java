package ba.unsa.etf.rpr;

public class KolekcijaPoruka {
    private String[] poruke;

    public KolekcijaPoruka(Object[] objekti) {
        this.poruke = new String[objekti.length];
        for (int i = 0; i < objekti.length; i++) {
            this.poruke[i] = ((Predstavljiv) objekti[i]).predstavi();
        }
    }

    // Get metoda za poruke
    public String[] getPoruke() {
        return poruke;
    }
}

