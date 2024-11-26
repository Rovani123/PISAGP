package controle.funcionario;

import java.sql.SQLException;
import java.time.LocalDate;

import modelo.classes.Produto;
import modelo.classes.ProdutosPromocao;
import modelo.classes.Promocoes;
import modelo.dao.ProdutoDAO;
import modelo.dao.PromocaoDAO;

public class PromocaoControle {
	public void cadastrarPromocao(Produto produtoPromocao,float desconto,LocalDate dataInicio, LocalDate dataTermino) throws SQLException {//LocalDate
		Promocoes p = new Promocoes();
		p.setDataInicio(dataInicio);
		p.setDataTermino(dataTermino);
		p.setDesconto(desconto);
		p.setProdutoP(produtoPromocao);
		
		
			PromocaoDAO pdao = new PromocaoDAO();
			pdao.cadastrarPromocao(produtoPromocao, desconto, dataInicio , dataTermino);//LocalDate

	}

	public void alterarPromocao(ProdutosPromocao promo) throws SQLException {
		PromocaoDAO pdal = new PromocaoDAO();
		pdal.alterarPromocao(promo, 0);
	}

	public void cadastrarPromocao(String produtoPromocao, float desconto, LocalDate dataInicio, LocalDate dataTermino) {
		PromocaoControle promo = new PromocaoControle();
		promo.cadastrarPromocao(produtoPromocao, desconto, dataInicio , dataTermino);
	}

	}


