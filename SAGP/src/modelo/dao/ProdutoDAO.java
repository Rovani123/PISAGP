package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dal.ConexaoBD;
import modelo.classes.Produto;
import modelo.enumerador.Categoria;

public class ProdutoDAO extends ModeloDAO{
	
	public ArrayList<Produto> getProdutosFiltro(String categoria) {
		
		Statement stml = null;
		Connection conn = ConexaoBD.getConexaoMySQL();
		
		ArrayList<Produto> lista = new ArrayList<Produto>();
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("SELECT * FROM PRODUTOS");
			
			if(categoria.equals("salgados"))
			{
				reslt = stml.executeQuery("SELECT * FROM PRODUTOS where categoria = 'salgados'");
				
			}
			if(categoria.equals("doces"))
			{
				reslt = stml.executeQuery("SELECT * FROM PRODUTOS where categoria = 'doces'");
				
			}
			if(categoria.equals("bebidas"))
			{
				reslt = stml.executeQuery("SELECT * FROM PRODUTOS where categoria = 'bebidas'");
				
			}
			
			while(reslt.next())
			{
				Produto p = new Produto();
					p.setIdProduto(reslt.getInt("idProduto"));
					p.setNomeProduto(reslt.getString("nomeProduto"));
					p.setPreco(reslt.getFloat("preco"));
					p.setQuantidadeEstoque(reslt.getInt("quantidadeEstoque"));
					p.setCategoria(reslt.getString("categoria"));
					lista.add(p);
				
				
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
	
	public ArrayList<Produto> getProdutos() {
		
		Statement stml = null;
		Connection conn = getConnection();
		
		ArrayList<Produto> lista = new ArrayList<Produto>();
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("SELECT * FROM PRODUTOS");
			
			while(reslt.next())
			{
				Produto p = new Produto();
					p.setIdProduto(reslt.getInt("idProduto"));
					p.setNomeProduto(reslt.getString("nomeProduto"));
					p.setPreco(reslt.getFloat("preco"));
					p.setQuantidadeEstoque(reslt.getInt("quantidadeEstoque"));
					p.setCategoria(reslt.getString("categoria"));
					lista.add(p);
				
				
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
	
	public void alteraProduto(Produto p) throws SQLException {
		
		super.update("UPDATE produtos SET nomeProduto = ?, preco = ?, quantidadeEstoque = ?, categoria = ? WHERE idProduto = ?", p.getIdProduto(), p.getNomeProduto(),p.getPreco(),p.getQuantidadeEstoque(),p.getCategoria());
		
		/*
		Statement stml = null;
		Connection conn = getConnection();
		
		try {
			stml = (Statement) conn.createStatement();
			int reslt;
			reslt = stml.executeUpdate("UPDATE produtos SET nomeProduto = ?,"
					+ " preco = ?, quantidadeEstoque = ?, categoria = ? WHERE idProduto = ?");
			
			 stml.setString(1, produto.getNome());
		     stml.setDouble(2, produto.getPreco());
		     stml.setInt(3, produto.getQuantidadeEstoque());
		     stml.setString(4, produto.getCategoria());
		     stml.setInt(5, produto.getId());
			
			
			//			while(reslt.next()){}
			
			
			reslt.close();
			stml.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
*/

	}

	public void cadastrarProduto(String nome,float preco,int quantidade,String categoria) throws SQLException {
		super.save("insert into produtos(nomeProduto,preco,quantidadeEstoque,categoria) values(?,?,?,?)", nome,preco,quantidade,categoria);
	}
	
}
