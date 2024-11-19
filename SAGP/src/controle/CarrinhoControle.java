package controle;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.classes.Carrinho;
import modelo.dao.CarrinhoDAO;

public class CarrinhoControle {
	
	public void cadastrarCarrinho(ArrayList<Carrinho> listaCarrinhos) throws SQLException {
		for(int i=0;i<listaCarrinhos.size();i++) {
			if(listaCarrinhos.get(i).getQuantidade() != 0) {
				CarrinhoDAO dao = new CarrinhoDAO();
				dao.cadastrarCarrinho(listaCarrinhos.get(i).getIdProduto(), listaCarrinhos.get(i).getIdVenda(), listaCarrinhos.get(i).getQuantidade());
			}
		}
	}
	
}
