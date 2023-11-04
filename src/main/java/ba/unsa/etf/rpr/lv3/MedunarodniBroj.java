package ba.unsa.etf.rpr.lv3;

import java.util.Objects;

public class MedunarodniBroj extends TelefonskiBroj {
    private String drzava;
    private String broj;

    public MedunarodniBroj(String drzava, String broj) {
        this.drzava = drzava;
        this.broj = broj;
    }

    @Override
    public String Ispisi() {
        return drzava + "/" + broj;
    }

    @Override
    public int hashCode() {
        return
                Objects.hash(drzava, broj);
    }
}

