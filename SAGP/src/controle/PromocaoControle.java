package controle;

import java.sql.SQLException;

import modelo.dao.ProdutoDAO;

public class PromocaoControle {
	private void cadastrarPromocao(String produtoPromocao,float desconto) throws SQLException {//LocalDate
			PromocaoDAO pdao = new PromocaoDAO();
			pdao.cadastrarProduto(produtoPromocao, desconto);//LocalDate

	}

}
