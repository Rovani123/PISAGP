package visao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	public static Connection getConexaoMySQL() {
		Connection connection = null;
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("N foi");
		}
		
		String serverName = "localhost:3306/";
		String mydatabase = "teste";
		String url = "jdbc:mysql://" + serverName + mydatabase;
		String user = "root";
		String password = "aluno";
		
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("N foi");
		}
		
		return connection;
	}
}
