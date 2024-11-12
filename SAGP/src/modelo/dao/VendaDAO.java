package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.classes.Produto;
import modelo.classes.Vendas;
import modelo.enumerador.Categoria;

public class VendaDAO extends ModeloDAO{
	
	public void cadastrarVenda(int idFuncionario, int idCliente, String metPagamento, float Total) throws SQLException {
		super.save("insert into vendas(idFuncionario,idCliente,metodoPagamento,mais) values(?,?,?,?", idFuncionario,idCliente,metPagamento,Total);
	}
	
	public ArrayList<Vendas> getVendas() {
		Statement stml = null;
		Connection conn = getConnection();
		
		ArrayList<Vendas> lista = new ArrayList<Vendas>();
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("SELECT * FROM Vendas");
			
			while(reslt.next())
			{
				Vendas v = new Vendas();
					// A fazer
					lista.add(v);
				
				
				}
			reslt.close();
			stml.close();
			conn.close();
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}