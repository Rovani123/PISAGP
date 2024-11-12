package controle;

import java.sql.SQLException;

import modelo.classes.ProdutosPromocao;
import modelo.dao.ProdutoDAO;
import modelo.dao.PromocaoDAO;

public class PromocaoControle {
	public void cadastrarPromocao(String produtoPromocao,float desconto) throws SQLException {//LocalDate
			PromocaoDAO pdao = new PromocaoDAO();
			pdao.cadastrarPromocao(produtoPromocao, desconto);//LocalDate

	}

	public void alterarPromocao(ProdutosPromocao promo) {
		
		
	}

	

}
