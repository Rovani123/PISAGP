package controle.cliente;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import controle.inicio.TelaInicialControle;
import modelo.classes.Carrinho;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.dao.ProdutoDAO;
import modelo.enumerador.Categoria;
import visao.Cliente.PainelProduto;
import visao.Cliente.TelaCompra;
import visaoTelasDeAviso.MensagemView;

public class CompraControle {
	private TelaCompra view;
	private PainelProduto pp;
	private Funcionario f;
	private ArrayList<Produto> listaProdutos;
	private ArrayList<Carrinho> listaCarrinhosRecuperado;
	private ArrayList<Carrinho> listaCarrinhos =new ArrayList<Carrinho>();
	private ArrayList<Carrinho> listaCarrinhosCompra =new ArrayList<Carrinho>();
	private int contS = 0;
	private int contD = 0;
	private int contB = 0;
	public CompraControle(Funcionario f ,ArrayList<Carrinho> listaCarrinhos) {
		this.f = f;
		listaProdutos = new ProdutoDAO().getProdutos();
		listaCarrinhosRecuperado = listaCarrinhos;
		
		view = new TelaCompra(f);
		view.setVisible(true);
		
		construirCarrinhos();
		listeners();
		recuperarEstado();
	}

	private class CompraListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btSair":
				// colocar Mensagem com um txt pra colocar senha
				String senha = "adm69"; //teste
				if(senha.equals(f.getSenha())){
					new TelaInicialControle(f);
					view.dispose();
				}else {
					//mensagem
				}
				break;
			case "btCarrinho":
				carrinho();
				break;
			case"btSalgados":
				btSalgados();
				break;
			case"btDoces":
				btDoces();
				break;
			case"btBebidas":
				btBebidas();
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
				new MensagemView("Estoque insuficiente",2);
			}
				break;
			}
		}
	}
	
	private void listeners() {
		view.addCompraListner(new CompraListeners());
		view.addWindowListener(new WindowAdapter() {
		public void windowOpened(WindowEvent e) {
			CarregarDados();
		}
		});
	}
	
	private void carrinho() {
		if (listaCarrinhosCompra.size() == 0) {
			for (Carrinho carrinho : listaCarrinhos) {
				if (carrinho.getQuantidade() > 0) {
					listaCarrinhosCompra.add(carrinho);
			}
		}
//			for(Carrinho c : listaCarrinhosCompra) {
//				System.out.println(c.getQuantidade());
//			}
			System.out.println(listaCarrinhosCompra.size());
	}
		view.dispose();
		new CarrinhoControle(f,listaCarrinhosCompra);		
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

	private void CarregarDados() {
		int coluna=1;
		int linha=1;
		for (Produto p : listaProdutos) {
			pp = new PainelProduto(p,listaCarrinhos.get(coluna));
			pp.addPainelProdutoListeners(new PainelListeners(pp));
			view.addPainelProdutos(pp, linha, coluna);
			if(linha%3==0) {
				coluna++;
				linha=0;
			}
			linha++;
		}
	}
	
	private void CarregarDadosFiltro(Categoria categoria) {
		int cont =0;
		ArrayList<Produto> listaFiltro = new ProdutoDAO().getProdutosFiltro(categoria);
		for (Produto p : listaFiltro) {
			pp = new PainelProduto(p,listaCarrinhos.get(cont));
			pp.addPainelProdutoListeners(new PainelListeners(pp));
			view.addPainelProdutos(pp, p.getIdProduto()-1, cont);
			cont++;
		}
	}
	
	private void btSalgados() {
		if (contS == 0) {
			carregarProdutosFiltro(Categoria.categoriaString("salgados"));
			contS = 1;
			contD = 0;
			contB = 0;
			view.setBackgroundcolor("btSalgados", new Color(255, 255, 0));
			view.setBackgroundcolor("btDoces", new Color(224, 83, 76));
			view.setBackgroundcolor("btBebidas", new Color(224, 83, 76));
		} else {
			carregarProdutos();
			contS = 0;
			contD = 0;
			contB = 0;
			view.setBackgroundcolor("btSalgados", new Color(224, 83, 76));
			view.setBackgroundcolor("btDoces", new Color(224, 83, 76));
			view.setBackgroundcolor("btBebidas", new Color(224, 83, 76));
		}
	}
	
	private void btDoces() {
		if (contD == 0) {
			carregarProdutosFiltro(Categoria.categoriaString("doces"));
			contS = 0;
			contD = 1;
			contB = 0;
			view.setBackgroundcolor("btSalgados", new Color(224, 83, 76));
			view.setBackgroundcolor("btDoces", new Color(255, 255, 0));
			view.setBackgroundcolor("btBebidas", new Color(224, 83, 76));
		} else {
			carregarProdutos();
			contS = 0;
			contD = 0;
			contB = 0;
			view.setBackgroundcolor("btSalgados", new Color(224, 83, 76));
			view.setBackgroundcolor("btDoces", new Color(224, 83, 76));
			view.setBackgroundcolor("btBebidas", new Color(224, 83, 76));
		}
	}
	

	private void btBebidas() {
		if (contB == 0) {
			carregarProdutosFiltro(Categoria.categoriaString("bebidas"));
			contS = 0;
			contD = 0;
			contB = 1;
			view.setBackgroundcolor("btSalgados", new Color(224, 83, 76));
			view.setBackgroundcolor("btDoces", new Color(224, 83, 76));
			view.setBackgroundcolor("btBebidas", new Color(255, 255, 0));
		} else {
			carregarProdutos();
			contS = 0;
			contD = 0;
			contB = 0;
			view.setBackgroundcolor("btSalgados", new Color(224, 83, 76));
			view.setBackgroundcolor("btDoces", new Color(224, 83, 76));
			view.setBackgroundcolor("btBebidas", new Color(224, 83, 76));
		}
	}

	private void carregarProdutos() {
		view.resetPainel();
		CarregarDados();
	}
	
	private void carregarProdutosFiltro(Categoria categoria) {
		view.resetPainel();
		CarregarDadosFiltro(categoria);
		
	}

}
