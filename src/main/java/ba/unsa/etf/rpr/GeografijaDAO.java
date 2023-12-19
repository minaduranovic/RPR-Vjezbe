package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeografijaDAO {

    private static GeografijaDAO instance;
    private Connection connection;

    private GeografijaDAO() {
        try {
             connection = DriverManager.getConnection("jdbc:sqlite:gradovi.db");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static GeografijaDAO getInstance() {
        if (instance == null) {
            instance = new GeografijaDAO();
        }
        return instance;
    }

    public List<Grad> gradovi() {
        List<Grad> gradovi = new ArrayList<>();

        try {
            String query = "SELECT ime, broj_stanovnika FROM gradovi ORDER BY broj_stanovnika DESC";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    String ime = resultSet.getString("ime");
                    int brojStanovnika = resultSet.getInt("broj_stanovnika");
                    Grad grad = new Grad(ime, brojStanovnika);
                    gradovi.add(grad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gradovi;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
