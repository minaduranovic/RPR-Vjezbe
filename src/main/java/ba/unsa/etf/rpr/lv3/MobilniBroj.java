package ba.unsa.etf.rpr.lv3;

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
        return mobilnaMreza + broj.hashCode();
    }
}

