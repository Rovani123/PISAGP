package controle;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.classes.Produto;
import modelo.dao.ProdutoDAO;

public class ProdutoControle {
	
	public ArrayList<Produto> getProdutos() {
		ProdutoDAO pdal = new ProdutoDAO();
		return pdal.getProdutos();		
	
	}
	public ArrayList<Produto> getProdutoFiltro(String categoria) {
		ProdutoDAO pdal = new ProdutoDAO();
		return pdal.getProdutosFiltro(categoria);
		
	}
	
	public void alterarProduto(Produto p) {
		ProdutoDAO pdal = new ProdutoDAO();
		try {
			pdal.AlteraProduto(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
