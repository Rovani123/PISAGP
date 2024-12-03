package controle.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import controle.funcionario.ProdutoControle;
import controle.inicio.TelaInicialControle;
import modelo.classes.Carrinho;
import modelo.classes.Produto;
import modelo.classes.Vendas;
import visao.Cliente.PainelProduto;
import visao.Cliente.TelaCompra;
import visaoTelasDeAviso.MensagemView;

public class CompraControle {
	private TelaCompra tc;
	private PainelProduto pp;
	private ArrayList<Produto> listaProdutos;
	private ArrayList<Carrinho> listaCarrinhosRecuperado;
	private ArrayList<Carrinho> listaCarrinhos =new ArrayList<Carrinho>();
	private ArrayList<Carrinho> listaCarrinhosCompra =new ArrayList<Carrinho>();
	public CompraControle(ArrayList<Carrinho> listaCarrinhos) {
		ProdutoControle pc = new ProdutoControle();
		listaProdutos = pc.getProdutos();
		
		listaCarrinhosRecuperado = listaCarrinhos;
		
		tc = new TelaCompra();
		tc.setVisible(true);
		
		construirCarrinhos();
		listeners();
		recuperarEstado();
	}

	private class CompraListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btVoltar":
				tc.dispose();
				new TelaInicialControle();
				break;
			case "btCarrinho":
				if (listaCarrinhosCompra.size() == 0) {
					for (Carrinho carrinho : listaCarrinhos) {
						if (carrinho.getQuantidade() > 0) {
							listaCarrinhosCompra.add(carrinho);
					}
				}
			}
				tc.dispose();
				new CarrinhoControle(listaCarrinhosCompra);
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
				new MensagemView("Estoque insuficiente",2);
			}
				break;
			}
		}
	}
	
	private void listeners() {
		tc.addCompraListner(new CompraListeners());
		tc.addWindowListener(new WindowAdapter() {
		public void windowOpened(WindowEvent e) {
			int cont =0;
			for (Produto p : listaProdutos) {
				pp = new PainelProduto(p,listaCarrinhos.get(cont));
				pp.addPainelProdutoListeners(new PainelListeners(pp));
				tc.addPainelProdutos(pp, p.getIdProduto()-1, 0);
				cont++;
			}
		}
		});
	}
	
	private void construirCarrinhos() {
		for (Produto p : listaProdutos) {
			Carrinho c = new Carrinho();
			c.setIdCarrinho(0);
			c.setQuantidade(0);
			c.setProduto(p);
			c.setVenda(null);
			listaCarrinhos.add(c);
		}
	}
	
	private void recuperarEstado() {
		if(listaCarrinhosRecuperado != null){
			for(Carrinho c :listaCarrinhosRecuperado) {
				listaCarrinhos.get(c.getProduto().getIdProduto()-1) .setQuantidade(c.getQuantidade());
			}
		}
	}
}
