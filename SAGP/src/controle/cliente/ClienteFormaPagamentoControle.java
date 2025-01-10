package controle.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.classes.Carrinho;
import modelo.classes.Funcionario;
import modelo.classes.Vendas;
import modelo.dao.CarrinhoDAO;
import modelo.enumerador.MetodoPagamento;
import visao.Cliente.PainelProduto;
import visao.Cliente.TelaClienteFormaPagamento;
import visao.TelasDeAviso.MensagemView;

public class ClienteFormaPagamentoControle {
	private TelaClienteFormaPagamento view;
	private Funcionario f;
	private Vendas v;
	private ArrayList<Carrinho> listaCarrinhos;
	private ArrayList<PainelProduto> listaPaineis;
	
	public ClienteFormaPagamentoControle(Funcionario f,ArrayList<Carrinho> listaCarrinhos, ArrayList<PainelProduto> listaPaineis) {
		this.f=f;
		this.listaCarrinhos = listaCarrinhos;
		this.listaPaineis = listaPaineis;
		view = new TelaClienteFormaPagamento();
		view.setVisible(true);
		listeners();
	}
	
	private class FormaPagamentoListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btCancelar":
				MensagemView mv =new MensagemView("Tem certeza que quer sair?");
				int conf = mv.getResposta();
				if(conf == 1) {
					view.dispose();
					new CompraControle(f);
				}
				break;
			case "btConfirmar":
				if(view.getCbMetodoPagamento().equals(MetodoPagamento.PIX.toString())) {
					view.dispose();
					new ClientePixControle(f, listaCarrinhos);
				}else {
					criarVenda();
					try {
						new CarrinhoDAO().cadastrarVenda(v,f);
						for (Carrinho c : listaCarrinhos) {
							new CarrinhoDAO().cadastrarCarrinho(c);
						}
						view.dispose();
						new CompraControle(f);
					} catch (SQLException e1) {
						e1.printStackTrace();
						new MensagemView("Compra nao efetuada, tente novamente",0);
					}
					break;
				}
			}
		}
		
	}
	
	
	private void listeners() {
		view.addFormaPagamentoListeners(new FormaPagamentoListeners());
		view.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				view.setLblTotal(String.valueOf(calcTotal()));
			}
		});
	}
	
	private float calcTotal() {
		int resultado=0;
		for (Carrinho c : listaCarrinhos) {
			resultado += c.getProduto().getPreco()*c.getQuantidade();
		}
		return resultado;
	}
	
	private void criarVenda() {
		v= new Vendas();
		v.setMetodoPagamento(view.getCbMetodoPagamento());
		v.setTotal(calcTotal());
	}
}
