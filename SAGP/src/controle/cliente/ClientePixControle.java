package controle.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.classes.Carrinho;
import modelo.classes.Funcionario;
import modelo.classes.Vendas;
import modelo.dao.CarrinhoDAO;
import modelo.enumerador.MetodoPagamento;
import visao.Cliente.TelaClientePix;
import visao.TelasDeAviso.MensagemView;

public class ClientePixControle {
	private TelaClientePix view;
	private Funcionario f;
	private Vendas v;
	private ArrayList<Carrinho> listaCarrinhos;
	
	public ClientePixControle(Funcionario f,ArrayList<Carrinho> listaCarrinhos) {
		this.f=f;
		this.listaCarrinhos = listaCarrinhos;
		view = new TelaClientePix();
		view.setVisible(true);
		listeners();
	}
	
	private class FormaPagamentoListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btCancelar":
				int conf =new MensagemView("Tem certeza que quer sair?").getResposta();
				if(conf == 1) {
					view.dispose();
					new CompraControle(f);
				}
				break;
			case "btVoltar":
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
	
	
	private void listeners() {
		view.addLoginListener(new FormaPagamentoListeners());
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
		v.setMetodoPagamento(MetodoPagamento.PIX.toString());
		v.setTotal(calcTotal());
	}
}
