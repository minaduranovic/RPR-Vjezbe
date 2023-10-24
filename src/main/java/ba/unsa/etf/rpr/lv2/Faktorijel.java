package ba.unsa.etf.rpr.lv2;

public class Faktorijel {
    static public int fakt(int n){
        if (n==1) return n;
        else return n*fakt(n-1);
    }
}
