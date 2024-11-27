package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.classes.Carrinho;
import modelo.classes.Funcionario;
import modelo.classes.Vendas;

public class CarrinhoDAO extends ModeloDAO{
	private int idVenda;
	
	public void cadastrarVenda(Vendas v) throws SQLException {
		Funcionario f = new Funcionario();
		Statement stml = null;
		Connection conn = getConnection();
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("SELECT * FROM funcionarios where idFuncionario =3;");
			
			while(reslt.next())
			{
				f.setUsuarioFuncionario(reslt.getString("usuarioFuncionario"));
				f.setNome(reslt.getString("nomeFuncionario"));
				f.setSenha(reslt.getString("senha"));
				f.setIdFuncionario(reslt.getInt("idFuncionario"));
				f.setadministrador(reslt.getInt("administrador"));
			}
			
			reslt.close();
			stml.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.save("insert into Vendas (idFuncionario, metodoPagamento,Total) values (?,?,?)", f.getIdFuncionario(), v.getMetodoPagamento(),v.getTotal());
	}
	
	public void cadastrarCarrinho(Carrinho c) throws SQLException {
		Statement stml = null;
		Connection conn = getConnection();
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("SELECT idVenda FROM Vendas");
			
			while(reslt.next())
			{
				
				idVenda= reslt.getInt("idVenda");
			}
			
			reslt.close();
			stml.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.save("insert into carrinho (idProduto, idVenda,quantidade) values (?,?,?)", c.getProduto().getIdProduto(), idVenda, c.getQuantidade());
	}

}
