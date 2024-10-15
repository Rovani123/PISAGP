package controle;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.classes.Produto;
import modelo.dao.ProdutoDAO;
import modelo.enumerador.Categoria;

public class ProdutoControle {
	
	public ArrayList<Produto> getProdutos() {
		ProdutoDAO pdal = new ProdutoDAO();
		return pdal.getProdutos();		
	
	}
	
	public ArrayList<Produto> getProdutoFiltro(Categoria categoria) {
		ProdutoDAO pdal = new ProdutoDAO();
		return pdal.getProdutosFiltro(categoria);
		
	}
	
	public void alterarProduto(Produto p) throws SQLException {
		ProdutoDAO pdal = new ProdutoDAO();
		pdal.alterarProduto(p);
	}
	
	public void deletarProduto(Produto deletarProduto) {
		ProdutoDAO pdal = new ProdutoDAO();
		try {
			pdal.deletarProduto(deletarProduto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarProduto(String nome,float preco,int quantidade,String categoria) throws SQLException {
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.cadastrarProduto(nome, preco, quantidade, categoria);
		
	}
	
	
}
