package ba.unsa.etf.rpr.lv2;

public class New
{
    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
