package controle.cliente;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import modelo.classes.Carrinho;
import modelo.classes.Funcionario;
import modelo.enumerador.Categoria;
import visao.Cliente.PainelProduto;
import visao.Cliente.TelaClienteCarrinho;
import visao.TelasDeAviso.MensagemView;

public class CarrinhoControle {
	private TelaClienteCarrinho view;
	private Funcionario f;
	private ArrayList<PainelProduto> listaPaineis;
	private ArrayList<Carrinho> listaCarrinhosFinal = new ArrayList<Carrinho>();
	private int contS = 0;
	private int contD = 0;
	private int contB = 0;
	private Color corPadrao = new Color(255,255,255);
	private Color corSelecionada = new Color(238, 69, 57);
	
	public CarrinhoControle(Funcionario f,ArrayList<PainelProduto> listaPaineis) {
		this.f =f;
		this.listaPaineis = listaPaineis;
		view = new TelaClienteCarrinho(f);
		view.setVisible(true);
		listeners();
	}
	private class CarrinhoListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {  
			case "btVoltar":
				view.dispose();
				new CompraControle(f, listaPaineis);
				break;
			case "btFinalizarCompra":
				view.dispose();
				if (listaCarrinhosFinal.size() == 0) {
					for (PainelProduto painel : listaPaineis) {
						if (painel.getCarrinho().getQuantidade() > 0) {
							listaCarrinhosFinal.add(painel.getCarrinho());
						}
					}
				}
				new ClienteFormaPagamentoControle(f,listaCarrinhosFinal);
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
	
	private void listeners() {
		view.addCarrinhoListeners(new CarrinhoListeners());
		view.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				view.setLblValorTotal(String.valueOf(calcTotal()));
				view.resetPainel();
				int coluna=1;
				int linha=1;
				for (PainelProduto painelProduto : listaPaineis) {
					if(painelProduto.getCarrinho().getQuantidade() >0) {
						view.addPainelProdutos(painelProduto, linha, coluna);
						if(linha%3==0) {
							coluna++;
							linha=0;
						}
						linha++;
					}
				}
			}});
	}
	
	private float calcTotal() {
		int resultado=0;
		for (PainelProduto p : listaPaineis) {
			resultado += p.getProduto().getPreco()*p.getCarrinho().getQuantidade();
		}
		return resultado;
	}
	
	private void colocarPaineis() {
		view.resetPainel();
		int coluna=1;
		int linha=1;
		for (PainelProduto painelProduto : listaPaineis) {
			if(painelProduto.getCarrinho().getQuantidade() >0) {
				view.addPainelProdutos(painelProduto, linha, coluna);
				if(linha%3==0) {
					coluna++;
					linha=0;
				}
				linha++;
			}
		}
		view.repaint();
		view.pack();
		view.telaCheia();
	}
	
	private void carregarProdutosFiltro(Categoria categoria) {
		view.resetPainel();
		int coluna=1;
		int linha=1;
		try {
			for (PainelProduto painelProduto : listaPaineis) {
				if(painelProduto.getProduto().getCategoria().equals(categoria)) {
					if(painelProduto.getCarrinho().getQuantidade() >0) {
						view.addPainelProdutos(painelProduto, linha, coluna);
						if(linha%3==0) {
							coluna++;
							linha=0;
						}
						linha++;
					}
				}
			}
			view.repaint();
			view.pack();
			view.telaCheia();
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

}
