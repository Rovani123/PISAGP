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
	
	public void alterarProduto(Produto p) {
		ProdutoDAO pdal = new ProdutoDAO();
		try {
			pdal.alteraProduto(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletarProduto(Produto deletarProduto) {
		ProdutoDAO pdal = new ProdutoDAO();
		try {
			pdal.DeletarProduto(deletarProduto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarProduto(String nome,float preco,int quantidade,String categoria) {
		ProdutoDAO pdao = new ProdutoDAO();
		try {
			pdao.cadastrarProduto(nome, preco, quantidade, categoria);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
