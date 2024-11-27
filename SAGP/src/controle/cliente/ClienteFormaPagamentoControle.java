package controle.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.classes.Carrinho;
import modelo.classes.Vendas;
import modelo.dao.CarrinhoDAO;
import visao.Cliente.TelaClienteFormaPagamento;

public class ClienteFormaPagamentoControle {
	TelaClienteFormaPagamento tcfp;
	private Vendas v;
	private ArrayList<Carrinho> listaCarrinhos;
	
	public ClienteFormaPagamentoControle(ArrayList<Carrinho> listaCarrinhos) {
		this.listaCarrinhos = listaCarrinhos;
		tcfp = new TelaClienteFormaPagamento();
		tcfp.setVisible(true);
		listeners();
	}
	
	private class FormaPagamentoListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btCancelar":
				//Confirmação
				tcfp.dispose();
				new CompraControle(null);
				break;
			case "btConfirmar":
				criarVenda();
				CarrinhoDAO dao = new CarrinhoDAO();
				try {
					dao.cadastrarVenda(v);
					for (Carrinho c : listaCarrinhos) {
						CarrinhoDAO dao2 = new CarrinhoDAO();
						dao2.cadastrarCarrinho(c);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					//não foi posivel efetuar a compra, tente novamente
				}
				break;
			}
		}
		
	}
	
	
	private void listeners() {
		tcfp.addFormaPagamentoListeners(new FormaPagamentoListeners());
		tcfp.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				tcfp.setLblTotal(String.valueOf(calcTotal()));
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
		v.setMetodoPagamento(tcfp.getCbMetodoPagamento());
		v.setTotal(calcTotal());
	}
}
