package teste;

import java.util.ArrayList;

import controle.administrador.AnaliseVendasControle;
import modelo.classes.Vendas;
import modelo.dao.VendaDAO;
import visao.Administrador.TelaCadastroF;
import visao.Administrador.TelaGerenciamentoF;
import visao.Cliente.TelaClienteCarrinho;
import visao.Cliente.TelaClienteFormaPagamento;
import visao.Cliente.TelaClientePix;
import visao.Funcionário.TelaAlteracaoP;
import visao.Funcionário.TelaCadastroP;
import visao.Funcionário.TelaGerenciamentoP;
import visaoTelasDeAviso.MensagemViewSenha;

public class Jesusteste {
	static ArrayList<Vendas> vendas;
	public static void main(String[] args) {

		new MensagemViewSenha(null);
	}
}
