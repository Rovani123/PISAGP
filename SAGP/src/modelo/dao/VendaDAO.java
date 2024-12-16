package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.classes.Funcionario;
import modelo.classes.Vendas;

public class VendaDAO extends ModeloDAO{
	
	public void cadastrarVenda(int idFuncionario, int idCliente, String metPagamento, float Total) throws SQLException {
		super.save("insert into vendas(idFuncionario,idCliente,metodoPagamento,total) values(?,?,?,?)", idFuncionario,idCliente,metPagamento,Total);
	}
	
	public ArrayList<Vendas> getVendas() {
		Statement stml = null;
		Connection conn = getConnection();
		
		ArrayList<Vendas> lista = new ArrayList<Vendas>();
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("select * from Vendas v Inner join Funcionarios f on v.idFuncionario = f.idFuncionario;");
			
			while(reslt.next())
			{
				Vendas v = new Vendas();
				v.setIdVenda(reslt.getInt("idVenda"));
				Funcionario f = new Funcionario();
				f.setIdFuncionario(reslt.getInt("idFuncionario"));
				f.setNome(reslt.getString("nomeFuncionario"));
				f.setUsuarioFuncionario(reslt.getString("usuarioFuncionario"));
				f.setSenha(reslt.getString("senha"));
				f.setadministrador(reslt.getInt("administrador"));
				v.setFuncionario(f);
				
				v.setMetodoPagamento(reslt.getString("metodoPagamento"));
				v.setTotal(reslt.getFloat("Total"));
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

	public int getIdVenda() {
		Statement stml = null;
		Connection conn = getConnection();
		
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("SELECT * FROM Vendas");
			
			int id=-1;
			
			while(reslt.next())
			{
				id=reslt.getInt("idVenda");								
			}
			reslt.close();
			stml.close();
			conn.close();
			return id;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
 
}