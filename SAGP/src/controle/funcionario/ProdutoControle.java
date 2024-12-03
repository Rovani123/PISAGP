package controle.funcionario;

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
	public Produto getProdutoId(int id) {
		ProdutoDAO pdao = new ProdutoDAO();
		return pdao.getProdutoId(id);
		}

}
