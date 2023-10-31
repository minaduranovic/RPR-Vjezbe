package ba.unsa.etf.rpr.lv3;

public class FiksniBroj extends TelefonskiBroj {


    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;
    }

    @Override
    public String Ispisi() {
        return grad.getPozivni() + "/" + broj;
    }
    @Override
    public int hashCode() {
        ////???????
        return 0;
    }
}
