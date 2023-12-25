package ba.unsa.etf.rpr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
    private static GeografijaDAO instance;
    private Connection conn;
    private PreparedStatement glavniGradUpit, dajDrzavuUpit, obrisiDrzavuUpit, obrisiGradoveZaDrzavu, nadjiDrzavuUpit;
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
            glavniGradUpit=conn.prepareStatement("SELECT grad.grad_id, grad.naziv, grad.broj_stanovnika, grad.drzava FROM grad, drzava WHERE grad.drzava=drzava.id and drzava.glavni_grad=?  ");
        } catch (SQLException e) {
            regenerisiBazu();
            try {
                glavniGradUpit=conn.prepareStatement("SELECT grad.grad_id, grad.naziv, grad.broj_stanovnika, grad.drzava  FROM grad, drzava WHERE grad.drzava=drzava.id and drzava.glavni_grad=?  ");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                dajDrzavuUpit=conn.prepareStatement("SELECT * FROM drzava WHERE id=?");
                obrisiGradoveZaDrzavu=conn.prepareStatement("delete from grad where drzava=?");
                obrisiDrzavuUpit= conn.prepareStatement("delete from drzava where naziv=?");
                nadjiDrzavuUpit=conn.prepareStatement("select * from drzava where naziv=?");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }


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
}
