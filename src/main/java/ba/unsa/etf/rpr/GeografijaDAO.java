package ba.unsa.etf.rpr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
    private static GeografijaDAO instance;
    private Connection conn;
    private PreparedStatement glavniGradUpit, dajDrzavuUpit, obrisiDrzavuUpit, obrisiGradoveZaDrzavu, nadjiDrzavuUpit, dajGradoveUpit, dodajGradUpit, dodajDrzavuUpit, odrediIdUpit, odrediIdDrzave, promijeniGradUpit, dajGradUpit;
    public static GeografijaDAO getInstance(){
       if (instance==null) instance=new GeografijaDAO() ;
       return instance;
    }
    private GeografijaDAO(){
        try {
            conn= DriverManager.getConnection("jdbc:sqlite:baza.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            glavniGradUpit=conn.prepareStatement("SELECT grad.grad_id, grad.naziv, grad.broj_stanovnika, grad.drzava FROM grad, drzava WHERE grad.drzava=drzava.drzava_id and drzava.glavni_grad=?  ");
        } catch (SQLException e) {
            regenerisiBazu();
            try {
                glavniGradUpit=conn.prepareStatement("SELECT grad.grad_id, grad.naziv, grad.broj_stanovnika, grad.drzava  FROM grad, drzava WHERE grad.drzava=drzava.drzava_id and drzava.glavni_grad=?  ");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                dajDrzavuUpit=conn.prepareStatement("SELECT * FROM drzava WHERE drzava_id=?");
                dajGradUpit=conn.prepareStatement("SELECT * from grad where grad_id=?");
                obrisiGradoveZaDrzavu=conn.prepareStatement("delete from grad where drzava=?");
                obrisiDrzavuUpit= conn.prepareStatement("delete from drzava where naziv=?");
                nadjiDrzavuUpit=conn.prepareStatement("select * from drzava where naziv=?");
                dajGradoveUpit = conn.prepareStatement("SELECT * from grad order by broj_stanovnika desc");                odrediIdUpit= conn.prepareStatement("select max(id)+1 from grad");
                dodajDrzavuUpit=conn.prepareStatement(("INSERT into drzava values(?,?,?)"));
                dodajGradUpit=conn.prepareStatement("INSERT into grad values(?,?,?,?)");
                odrediIdDrzave=conn.prepareStatement("select max(grad_id)+1 from grad");
                promijeniGradUpit=conn.prepareStatement("update grad set naziv=?, broj_stanovnika=?, drzava=? where grad_id=?");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }

    }
    public static void removeInstance(){
        instance.close();
        instance=null;
    }
    public void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Grad glavniGrad(String drzava){
        try {
            glavniGradUpit.setString(1, drzava);
            ResultSet rs=glavniGradUpit.executeQuery();
            if (!rs.next()) return null;
            return dajGradizRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Grad dajGradizRS(ResultSet rs) throws SQLException {
       Grad grad= new Grad(rs.getInt(1),rs.getString(2),rs.getInt(3), null );
       grad.setDrzava(dajDrzavu(rs.getInt(4), grad));
       return grad;
    }

    private Drzava dajDrzavu(int id, Grad grad) {
        try {

            dajDrzavuUpit.setInt(1, id);
            ResultSet rs= dajDrzavuUpit.executeQuery();
            if (!rs.next()) return null;
            return dajDrzavuizRS(rs, grad);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    private Grad dajGrad(int id) {
        try {

            dajGradUpit.setInt(1, id);
            ResultSet rs= dajGradUpit.executeQuery();
            if (!rs.next()) return null;
            return dajGradizRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Drzava dajDrzavuizRS(ResultSet rs, Grad grad) throws SQLException {
       return new Drzava(rs.getInt(1),rs.getString(2), grad);
    }

    private void regenerisiBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.db.sql"));

            String sqlUpit = "";
            while (ulaz.hasNext()) {
                String line = ulaz.nextLine();
                sqlUpit += line;
                if (sqlUpit.charAt(sqlUpit.length() - 1) == ';') {
                    try {
                        Statement st = conn.createStatement();
                        st.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void obrisiDrzavu(String nazivDrzave){
        try {
            nadjiDrzavuUpit.setString(1, nazivDrzave);
            ResultSet rs=nadjiDrzavuUpit.executeQuery();
            if (!rs.next()) return;
            Drzava drzava=dajDrzavuizRS(rs,null);

            obrisiGradoveZaDrzavu.setInt(1, drzava.getId());
            obrisiGradoveZaDrzavu.executeUpdate();

            obrisiDrzavuUpit.setInt(1,drzava.getId());
            obrisiDrzavuUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Grad> gradovi() {
        ArrayList<Grad> rezultat = new ArrayList<>();
        try (ResultSet rs = dajGradoveUpit.executeQuery()) {
            while (rs.next()) {
                Grad grad = dajGradizRS(rs);
                rezultat.add(grad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }


    public void dodajGrad(Grad grad) {
        try {
            ResultSet rs = odrediIdUpit.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            dodajGradUpit.setInt(1, id);
            dodajGradUpit.setString(2, grad.getIme());
            dodajGradUpit.setInt(3, grad.getBrojStanovnika());
            dodajGradUpit.setInt(4, grad.getDrzava().getId());
            dodajGradUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dodajDrzavu(Drzava drzava) {
        try {
            ResultSet rs = odrediIdDrzave.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            dodajDrzavuUpit.setInt(1, id);
            dodajDrzavuUpit.setString(2, drzava.getNaziv());
            dodajDrzavuUpit.setInt(3, drzava.getGlavniGrad().getId());
            dodajDrzavuUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void izmijeniGrad(Grad grad){
       try {

           promijeniGradUpit.setString(1, grad.getIme());
           promijeniGradUpit.setInt(2, grad.getBrojStanovnika());
           promijeniGradUpit.setInt(3, grad.getDrzava().getId());
           promijeniGradUpit.setInt(4, grad.getId());
           promijeniGradUpit.executeUpdate();

       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   public Drzava nadjiDrzavu(String nazivDrzave){
       try {
           nadjiDrzavuUpit.setString(1, nazivDrzave);
           ResultSet rs=nadjiDrzavuUpit.executeQuery();
           if (!rs.next()) return null;
           return dajDrzavuizRS(rs, dajGrad(rs.getInt(3)));
       } catch (SQLException e) {
           e.printStackTrace();
           return null;
       }

   }

}
