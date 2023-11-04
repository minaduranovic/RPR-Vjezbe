package ba.unsa.etf.rpr;

public enum Grad { SARAJEVO("033"), TUZLA("035"), ZENICA("032"), TRAVNIK("030"), ORAŠJE("031"), LIVNO("034"), MOSTAR("036"), BIHAĆ("037"), GORAŽDE("038"), ŠIROKIBRIJEG("039");
    private String pozivni;
    Grad(String pozivniBr) {
        pozivni=pozivniBr;
    }
    public String getPozivni(){
        return pozivni;
    }

    public static Grad izPozivnog(String pozivni){
        for (Grad g: Grad.values()){
            if (g.getPozivni().equals(pozivni)){
                return g;
            }
        }
        return null;
    }
}
