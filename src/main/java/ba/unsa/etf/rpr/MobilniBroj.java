package ba.unsa.etf.rpr;

import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj {
    private final int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    @Override
    public String Ispisi() {
        return 0+  mobilnaMreza + "/" + broj;
    }

    @Override
    public int hashCode() {
       return Objects.hash(mobilnaMreza, broj);
    }
    }

