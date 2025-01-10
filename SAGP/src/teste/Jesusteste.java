package teste;

import java.io.IOException;
import java.util.ArrayList;
import controle.administrador.AnaliseVendasControle;
import modelo.classes.Carrinho;
import modelo.classes.Vendas;
import modelo.dao.CarrinhoDAO;
import modelo.dao.VendaDAO;
import visao.Administrador.TelaCadastroF;
import visao.Administrador.TelaGerenciamentoF;
import visao.Cliente.TelaClienteFormaPagamento;
import visao.Cliente.TelaClientePix;
import visao.Funcionário.TelaAlteracaoP;
import visao.Funcionário.TelaCadastroP;
import visao.Funcionário.TelaGerenciamentoP;
import visao.TelasDeAviso.MensagemViewSenha;

public class Jesusteste {
	static ArrayList<Vendas> vendas;
	public static void main(String[] args) {
		String nome="lucas";
		if(nome.contains("ca")) {
			System.out.println("A");
		}else {
			System.out.println("B");
		}
	}
}
