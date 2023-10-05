package database;

import model.Werknemer;

import java.sql.SQLException;

/**
 * @author Vincent Velthuizen
 *
 * Regelt het in de DB zetten en uit de DB halen van werknemers (met behulp van de PersoonDAO)
 */
public class WerknemerDAO extends AbstractDAO {
    public WerknemerDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void slaWerknemerOp(Werknemer werknemer) {
        PersoonDAO persoonDAO = new PersoonDAO(dBaccess);
        int personeelsnummer = persoonDAO.slaPersoonOp(werknemer);

        String sql = "INSERT INTO Werknemer (personeelsnummer, maandsalaris) VALUES (?, ?);";

        try {
            setupPreparedStatement(sql);

            preparedStatement.setInt(1, personeelsnummer);
            preparedStatement.setDouble(2, werknemer.getMaandSalaris());

            executeManipulateStatement();
        } catch (SQLException sqlException) {
            sqlExceptionWarning(sqlException);
        }
    }
}
