package ba.unsa.etf.rpr.lv2;

public class Main
{
   public static void main(String[] args){
       for (int i=0; i<args.length; i++){
           int a=Integer.parseInt(args[i]);
           System.out.println(Faktorijel.fakt(a));
           System.out.println(Sinus.sin(a));
       }
   }
}
