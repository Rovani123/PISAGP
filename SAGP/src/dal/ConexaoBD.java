package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBD {
	public static Connection getConexaoMySQL() {
		Connection connection = null;
		String driverName = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String serverName = "localhost:3306/";
		String mydatabase = "bsagp";
		String url = "jdbc:mysql://" + serverName + mydatabase;
		String user = "root";
		String password = "aluno";

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao conectar com o banco de dados");
			e.printStackTrace();
		}
		return connection;
	}
}
