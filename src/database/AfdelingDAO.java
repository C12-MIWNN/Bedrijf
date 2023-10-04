package database;

import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
