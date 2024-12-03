package controle.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import modelo.classes.Carrinho;
import visao.Cliente.PainelProduto;
import visao.Cliente.TelaClienteCarrinho;
import visaoTelasDeAviso.MensagemView;

public class CarrinhoControle {
	TelaClienteCarrinho tcc;
	private PainelProduto pp;
	private ArrayList<Carrinho> listaCarrinhos;
	private ArrayList<Carrinho> listaCarrinhosFinal = new ArrayList<Carrinho>();
	
	public CarrinhoControle(ArrayList<Carrinho> listaCarrinhosCompra) {
		this.listaCarrinhos = listaCarrinhosCompra;
		tcc = new TelaClienteCarrinho(listaCarrinhosCompra);
		tcc.setVisible(true);
		listeners();
	}
	private class CarrinhoListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btVoltar":
				tcc.dispose();
				new CompraControle(listaCarrinhos);
				break;
			case "btFinalizarCompra":
				tcc.dispose();
				if (listaCarrinhosFinal.size() == 0) {
					for (Carrinho carrinho : listaCarrinhos) {
						if (carrinho.getQuantidade() > 0) {
							listaCarrinhosFinal.add(carrinho);
					}
				}
				}
				new ClienteFormaPagamentoControle(listaCarrinhosFinal);
				break;
			
			}
		}
		
	}
	
	private class PainelListeners implements ActionListener{
		private PainelProduto pp;
		public PainelListeners(PainelProduto pp) {
			this.pp = pp;
		}
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btMenos":
				if(pp.getCarrinho().getQuantidade()>0) {
					pp.setCarrinhoQuant(pp.getCarrinho().getQuantidade()-1);
					pp.setLblQuant(String.valueOf(pp.getCarrinho().getQuantidade()));
				}
				break;
			case "btMais":
				if(pp.getCarrinho().getQuantidade() < pp.getProduto().getQuantidadeEstoque()) {
					pp.setCarrinhoQuant(pp.getCarrinho().getQuantidade()+1);
					pp.setLblQuant(String.valueOf(pp.getCarrinho().getQuantidade()));
			}else {
				//mensagem
				new MensagemView("Estoque insuficiente",2);
			}
				break;
			}
		}
	}
	
	private void listeners() {
		tcc.addCarrinhoListeners(new CarrinhoListeners());
		tcc.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				tcc.setLblValorTotal(String.valueOf(calcTotal()));
				int cont =0;
				for (Carrinho c : listaCarrinhos) {
					pp = new PainelProduto(c.getProduto(),c);
					pp.addPainelProdutoListeners(new PainelListeners(pp));
					tcc.addPainelProdutos(pp, c.getProduto().getIdProduto()-1, 0);
					cont++;
				}
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
}
