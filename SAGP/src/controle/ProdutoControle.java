package controle;

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
	
	
}
