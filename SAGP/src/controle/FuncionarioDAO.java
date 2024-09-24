package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dal.ConexaoBD;
import modelo.classes.Produto;

public class FuncionarioDAO {

	public ArrayList<Produto> getProdutos(String categoria) {
		
		Statement stml = null;
		Connection conn = ConexaoBD.getConexaoMySQL();
		
		ArrayList<Produto> lista = new ArrayList<Produto>();
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("SELECT * FROM PRODUTOS");
			
			if(categoria.equals("salgados"))
			{
				reslt = stml.executeQuery("SELECT * FROM PRODUTOS where categoria = salgados");
				
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
}
