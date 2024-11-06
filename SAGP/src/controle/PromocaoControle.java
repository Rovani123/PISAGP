package controle;

import java.sql.SQLException;

import modelo.dao.ProdutoDAO;
import modelo.dao.PromocaoDAO;

public class PromocaoControle {
	private void cadastrarPromocao(String produtoPromocao,float desconto) throws SQLException {//LocalDate
			PromocaoDAO pdao = new PromocaoDAO();
			pdao.cadastrarPromocao(produtoPromocao, desconto);//LocalDate

	}

}
