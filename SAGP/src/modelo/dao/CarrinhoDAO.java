package modelo.dao;

import java.sql.SQLException;

public class CarrinhoDAO extends ModeloDAO{
	
	public void cadastrarCarrinho(int idProduto, int idVenda, int quantidade) throws SQLException {
		super.save("insert into carrinho (idProduto, idVenda,quantidade) values (?,?,?)", idProduto, idVenda, quantidade);
	}

}
