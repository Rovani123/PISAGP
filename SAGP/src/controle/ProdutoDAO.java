package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dal.ConexaoBD;
import modelo.classes.Produto;

public class ProdutoDAO {

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
		Connection conn = ConexaoBD.getConexaoMySQL();
		
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
}
