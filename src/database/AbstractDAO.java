package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Centraliseert gedeelde database bewerkingen
 * @author Remi De Boer, Gerke de Boer, Michael Oosterhout
 */
public abstract class AbstractDAO {

	protected DBaccess dBaccess;
	protected PreparedStatement preparedStatement;

	public AbstractDAO(DBaccess dBaccess) {
		this.dBaccess = dBaccess;
	}
	
	/**
	 * Maakt een preparedStatement voor de sql string. Een DAO gebruikt dit om de parameters te vullen.
	 *
	 * @param sql,
	 *            de SQl query
	 */
	protected void setupPreparedStatement(String sql) throws SQLException {
		preparedStatement = dBaccess.getConnection().prepareStatement(sql);
	}

	/**
	 * Voert de preparedStatement uit zonder een ResultSet. Wordt gebruikt voor insert, update en
	 * delete statements.
	 *
	 */
	protected void executeManipulateStatement() throws SQLException {
		preparedStatement.executeUpdate();
	}

	/**
	 * Voert de preparedStatement uit met een ResultSet. Wordt gebruikt voor select statements.
	 *
	 */
	protected ResultSet executeSelectStatement() throws SQLException {
		return preparedStatement.executeQuery();
	}

	/**
	 * Maakt een preparedStatement voor de sql string, die een gegenereerde sleutel terug moet geven.
	 * @param sql,
	 *            de SQL query
	 */
	protected void setupPreparedStatementWithKey(String sql) throws SQLException {
		preparedStatement = dBaccess.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	}

	/**
	 * Voert de prepared statement uit en geeft de gegenereerde sleutel terug.
	 * Wordt gebruikt voor een insert in een AutoIncrement tabel
	 */
	protected int executeInsertStatementWithKey() throws SQLException {
		preparedStatement.executeUpdate();
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		int gegenereerdeSleutel = 0;
		while (resultSet.next()) {
			gegenereerdeSleutel = resultSet.getInt(1);
		}
		return gegenereerdeSleutel;
	}

	public void sqlExceptionWarning(SQLException sqlException) {
		System.err.println("SQL fout: " + sqlException.getMessage());
	}
}
