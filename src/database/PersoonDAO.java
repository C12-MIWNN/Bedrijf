package database;

import model.Persoon;

import java.sql.SQLException;

/**
 * @author Vincent Velthuizen
 *
 * Regelt het in de DB zetten en uit de DB halen van werknemers als hulpmiddel voor de DAOs van de subklassen
 */
public class PersoonDAO extends AbstractDAO {
    public PersoonDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public int slaPersoonOp(Persoon persoon) {
        String sql = "INSERT INTO Persoon (naam, woonplaats, afdeling) VALUES (?, ?, ?);";
        int personeelsnummer = -1;

        try {
            setupPreparedStatementWithKey(sql);

            preparedStatement.setString(1, persoon.getNaam());
            preparedStatement.setString(2, persoon.getWoonplaats());
            preparedStatement.setString(3, persoon.getAfdeling().getAfdelingsNaam());

            personeelsnummer = executeInsertStatementWithKey();
        } catch (SQLException sqlException) {
            sqlExceptionWarning(sqlException);
        }

        return personeelsnummer;
    }
}
