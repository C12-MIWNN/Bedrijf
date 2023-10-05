package database;

import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AfdelingDAO extends AbstractDAO {

    public AfdelingDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void slaAfdelingOp(Afdeling afdeling) {
        String sql = "INSERT INTO Afdeling VALUES (?, ?);";

        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, afdeling.getAfdelingsNaam());
            preparedStatement.setString(2, afdeling.getAfdelingsPlaats());
            executeManipulateStatement();
        } catch (SQLException sqlException) {
            System.err.println("SQL foutmelding: " + sqlException.getMessage());
        }
    }

    public ArrayList<Afdeling> geefAfdelingen() {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        String sql = "SELECT afdelingsnaam, afdelingsplaats FROM Afdeling;";

        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectStatement();

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
            setupPreparedStatement(sql);
            preparedStatement.setString(1, plaats);
            ResultSet resultSet = executeSelectStatement();

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

    public Afdeling geefAfdeling(String afdelingsNaam) {
        String sql = "SELECT afdelingsplaats FROM Afdeling WHERE afdelingsnaam = ?;";

        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, afdelingsNaam);
            ResultSet resultSet = executeSelectStatement();

            if (resultSet.first()) {
                return new Afdeling(afdelingsNaam, resultSet.getString("afdelingsplaats"));
            }
        }  catch (SQLException sqlException) {
            sqlExceptionWarning(sqlException);
        }

        return null;
    }
}
