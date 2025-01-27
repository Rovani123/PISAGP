package controle.cliente;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import controle.inicio.TelaInicialControle;
import modelo.classes.Carrinho;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.dao.ProdutoDAO;
import modelo.enumerador.Categoria;
import visao.Cliente.PainelProduto;
import visao.Cliente.TelaCompra;
import visao.TelasDeAviso.MensagemView;
import visao.TelasDeAviso.MensagemViewSenha;

public class CompraControle {
	private TelaCompra view;
	private PainelProduto pp;
	private Funcionario f;
	private ArrayList<PainelProduto> listaPaineis= new ArrayList<PainelProduto>();
	private ArrayList<Produto> listaProdutos;
	private ArrayList<Carrinho> listaCarrinhos =new ArrayList<Carrinho>();
	private int contS = 0;
	private int contD = 0;
	private int contB = 0;
	private Color corPadrao = new Color(255, 255, 255);
	private Color corSelecionada = new Color(0, 255, 0);
	
	public CompraControle(Funcionario f) {
		this.f = f;
		try {
			listaProdutos = new ProdutoDAO().getProdutos();
		} catch (IOException e) {
			new MensagemView("Erro ao conectar com o banco de dados",0);
		}
		
		view = new TelaCompra(f);
		view.setVisible(true);
		
		construirCarrinhos();
		listeners();
			
	}
	
	public CompraControle(Funcionario f ,ArrayList<PainelProduto> listaPaineis) {
		this.f = f;
		try {
			listaProdutos = new ProdutoDAO().getProdutos();
		} catch (IOException e) {
			new MensagemView("Erro ao conectar com o banco de dados",0);   
		}
		this.listaPaineis = listaPaineis;
		view = new TelaCompra(f);
		view.setVisible(true);
		
		construirCarrinhos();
		listeners();
			
	}

	private class CompraListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btPesquisar":
				carregarProdutosPesquisa(view.getPeesquisa());
				break;
			case "btSair":
				String senha = new MensagemViewSenha().getSenha();
				if(senha.equals(f.getSenha())){
					new TelaInicialControle(f);
					view.dispose();
				}else {
					new MensagemView("senha inválida",2);
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
			addlista(pp);
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
			colocarPaineis();
		}});
	}
	
	private void carrinho() {
		view.dispose();
		new CarrinhoControle(f,listaPaineis);		
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

	private void CarregarDados() {
		for (Produto p : listaProdutos) {
			pp = new PainelProduto(p,listaCarrinhos.get(listaProdutos.indexOf(p)));
			pp.addPainelProdutoListeners(new PainelListeners(pp));
		}
	}
	
	private void colocarPaineis() {
		view.resetPainel();
		int coluna=1;
		int linha=1;
		for (PainelProduto painelProduto : listaPaineis) {
			view.addPainelProdutos(painelProduto, linha, coluna);
			if(linha%3==0) {
				coluna++;
				linha=0;
			}
			linha++;
		}
	}
	
	private void carregarProdutosFiltro(Categoria categoria) {
		view.resetPainel();
		int coluna=1;
		int linha=1;
		try {
			for (PainelProduto painelProduto : listaPaineis) {
				if(painelProduto.getProduto().getCategoria().equals(categoria)) {
					view.addPainelProdutos(painelProduto, linha, coluna);
					if(linha%3==0) {
						coluna++;
						linha=0;
					}
					linha++;
				}
			}
		}catch (Exception e) {
			new MensagemView("Erro ao carregar os produtos",0);
		}
	}
	
	private void carregarProdutosPesquisa(String pesquisa) {
		view.resetPainel();
		int coluna=1;
		int linha=1;
		try {
			for (PainelProduto painelProduto : listaPaineis) {
				if(painelProduto.getProduto().getNomeProduto().toLowerCase().contains(pesquisa.toLowerCase())) {
					view.addPainelProdutos(painelProduto, linha, coluna);
					if(linha%3==0) {
						coluna++;
						linha=0;
					}
					linha++;
				}
			}
		} catch (Exception e) {
			new MensagemView("Erro ao carregar os produtos",0);
		}
	}
	
	
	private void btSalgados() {
		if (contS == 0) {
			carregarProdutosFiltro(Categoria.categoriaString("salgados"));
			contS = 1;
			contD = 0;
			contB = 0;
			view.setBackgroundcolor("btSalgados", corSelecionada);
			view.setBackgroundcolor("btDoces", corPadrao);
			view.setBackgroundcolor("btBebidas", corPadrao);
		} else {
			colocarPaineis();
			contS = 0;
			contD = 0;
			contB = 0;
			view.setBackgroundcolor("btSalgados", corPadrao);
			view.setBackgroundcolor("btDoces", corPadrao);
			view.setBackgroundcolor("btBebidas", corPadrao);
		}
	}
	
	private void btDoces() {
		if (contD == 0) {
			carregarProdutosFiltro(Categoria.categoriaString("doces"));
			contS = 0;
			contD = 1;
			contB = 0;
			view.setBackgroundcolor("btSalgados", corPadrao);
			view.setBackgroundcolor("btDoces", corSelecionada);
			view.setBackgroundcolor("btBebidas", corPadrao);
		} else {
			colocarPaineis();
			contS = 0;
			contD = 0;
			contB = 0;
			view.setBackgroundcolor("btSalgados", corPadrao);
			view.setBackgroundcolor("btDoces", corPadrao);
			view.setBackgroundcolor("btBebidas", corPadrao);
		}
	}
	
	private void btBebidas() {
		if (contB == 0) {
			carregarProdutosFiltro(Categoria.categoriaString("bebidas"));
			contS = 0;
			contD = 0;
			contB = 1;
			view.setBackgroundcolor("btSalgados", corPadrao);
			view.setBackgroundcolor("btDoces", corPadrao);
			view.setBackgroundcolor("btBebidas", corSelecionada);
		} else {
			colocarPaineis();
			contS = 0;
			contD = 0;
			contB = 0;
			view.setBackgroundcolor("btSalgados", corPadrao);
			view.setBackgroundcolor("btDoces", corPadrao);
			view.setBackgroundcolor("btBebidas", corPadrao);
		}
	}

	public void addlista(PainelProduto pp) {
		listaPaineis.add(pp);
	}

}