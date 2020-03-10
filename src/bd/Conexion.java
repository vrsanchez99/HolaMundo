/**
 * 
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Vic
 *
 */
public class Conexion {


	Connection conn = null;
	String url = "jdbc:mysql://localhost/def";
	String user = "root";
	String psswd = "";
	private static Conexion instance;

	
	/**
	 * Singleton for the db connection
	 * @return
	 * @throws SQLException
	 */
	public static Conexion getInstance() throws SQLException {

		if (instance == null) {

			instance = new Conexion();

		} else if (instance.conectar().isClosed()) {

			instance = new Conexion();
		}

		return instance;

	}

	public Conexion() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn.setAutoCommit(true);
		} catch (SQLException e) {

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * @return La conexión creada.
	 * @throws SQLException
	 */
	public Connection conectar() throws SQLException {
		conn = DriverManager.getConnection(url, user, psswd);
		return conn;
	}

	/**
	 * Borra la conexión creada.
	 * 
	 * @throws SQLException
	 */
	public void desconectar() throws SQLException {
		conn.close();
	}
	
	
}
