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
import visao.Cliente.TelaClienteCarrinho;
import visao.Cliente.TelaClienteFormaPagamento;
import visao.Cliente.TelaClientePix;
import visao.Funcionário.TelaAlteracaoP;
import visao.Funcionário.TelaCadastroP;
import visao.Funcionário.TelaGerenciamentoP;
import visao.TelasDeAviso.MensagemViewSenha;

public class Jesusteste {
	static ArrayList<Vendas> vendas;
	public static void main(String[] args) {
		Vendas v = new Vendas();
		v.setIdVenda(3);
		try {
			ArrayList<Carrinho> c = new CarrinhoDAO().getCarrinhos(v);
			for (Carrinho carrinho : c) {
				System.out.println(carrinho.getProduto().getNomeProduto());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
