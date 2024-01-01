package ba.unsa.etf.rpr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static  String ispisiGradove(){
        GeografijaDAO dao= GeografijaDAO.getInstance();
        String rez="";
        for (Grad grad: dao.gradovi()){
            rez+= grad.getIme()+ " ("+ grad.getDrzava().getNaziv()+ ") - " + grad.getBrojStanovnika()+ "\n";

        }

        return rez;
    }

    public static void glavniGrad(){
        GeografijaDAO dao=GeografijaDAO.getInstance();
        Scanner sc= new Scanner(System.in);
        System.out.println("Unesite naziv drzave: ");
        String naziv= sc.nextLine();
        Grad grad=dao.glavniGrad(naziv);
        if (grad==null )System.out.println("Nepostojeca drzava");
        else  System.out.println("Glavni grad drzave " + naziv+ " je " +grad.getIme());



     }
    public static void main(String[] args) {
        System.out.println(ispisiGradove());
        glavniGrad();
}
}
