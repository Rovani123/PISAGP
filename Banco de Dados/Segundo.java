package visao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Segundo {
	public static void main(String[] args) {
		Statement stml = null;
		Connection conn = ConexaoDB.getConexaoMySQL();
		
		try {
			stml = (Statement) conn.createStatement();
			ResultSet resl = null;
			resl = stml.executeQuery("SELECT * FROM CLIENTES");
			while(resl.next())
			{
				//System.out.println("ID  NOME  EMAIL");
				System.out.println(resl.getInt("idclientes")+"  "+resl.getString("nome")+"  "+resl.getString("email"));
			}
			resl.close();
			stml.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("N foi");
		}
	}
}
