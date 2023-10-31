package ba.unsa.etf.rpr.lv3;

public enum Grad { SARAJEVO("033"), TUZLA("035"), ZENICA("032"), TRAVNIK("030"), ORAŠJE("031"), LIVNO("034"), MOSTAR("036"), BIHAĆ("037"), GORAŽDE("038"), ŠIROKIBRIJEG("039");
    private String pozivni;
    Grad(String pozivniBr) {
        pozivni=pozivniBr;
    }
    public String getPozivni(){
        return pozivni;
    }
}
