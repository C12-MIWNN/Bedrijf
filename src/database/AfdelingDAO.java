package database;

import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AfdelingDAO {
    private DBaccess dBaccess;

    public AfdelingDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public void slaAfdelingOp(Afdeling afdeling) {
        String sql = "INSERT INTO Afdeling VALUES (?, ?);";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            System.out.println(preparedStatement);
            preparedStatement.setString(1, afdeling.getAfdelingsNaam());
            System.out.println(preparedStatement);
            preparedStatement.setString(2, afdeling.getAfdelingsPlaats());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.err.println("SQL foutmelding: " + sqlException.getMessage());
        }
    }

    public ArrayList<Afdeling> geefAfdelingen() {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        String sql = "SELECT afdelingsnaam, afdelingsplaats FROM Afdeling;";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String afdelingsNaam = resultSet.getString("afdelingsnaam");
                String afdelingsPlaats = resultSet.getString("afdelingsplaats");

                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }
        } catch (SQLException sqlException) {
            System.err.println("SQL foutmelding: " + sqlException.getMessage());
        }

        return afdelingen;
    }

    public ArrayList<Afdeling> geefAfdelingenMetPlaats(String plaats) {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        String sql = "SELECT afdelingsnaam, afdelingsplaats " +
                "FROM Afdeling " +
                "WHERE afdelingsplaats = ?;";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, plaats);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String afdelingsNaam = resultSet.getString("afdelingsnaam");
                String afdelingsPlaats = resultSet.getString("afdelingsplaats");

                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }
        } catch (SQLException sqlException) {
            System.err.println("SQL foutmelding: " + sqlException.getMessage());
        }

        return afdelingen;
    }
}
