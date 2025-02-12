package controle.funcionario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import controle.administrador.GerenciamentoFControle;
import controle.cliente.CompraControle;
import controle.inicio.TelaInicialControle;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.dao.ProdutoDAO;
import modelo.enumerador.Categoria;
import modelo.tableModel.ProdutosTableModel;
import visao.Funcionário.TelaGerenciamentoP;
import visao.TelasDeAviso.MensagemView;

public class GerenciamentoPControle {
	private TelaGerenciamentoP view;
	private Funcionario f;
	private int contS = 0;
	private int contD = 0;
	private int contB = 0;
	private Color corSelecionada = new Color(238, 69, 57);
	private Color corPadrao = new Color(255, 245, 245);
	
	public GerenciamentoPControle(Funcionario f) {
		this.f = f;
		view = new TelaGerenciamentoP(f);
		view.setVisible(true);
		listeners();
	}
	
	private class GerenciamentoPListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "mAdm":
				mAdm();
				break;
			case "btSalgados":
				btSalgados();
				break;
			case "btDoces":
				btDoces();
				break;
			case "btBebidas":
				btBebidas();
				break;
			case "btAlterar":
				btAlterar();
				break;
			case "btRemover":
				btRemover();
				break;
			case "btCadastrar":
				btCadastrar();
				break;
			case "btPesquisar":
				String nome = view.getPesquisa();
				ProdutosTableModel model;
				try {
					model = new ProdutosTableModel(new ProdutoDAO().getProdutosNome(nome));
					view.setTabela(model);
				} catch (IOException e1) {
					new MensagemView("Erro ao conectar com o banco de dados",0);
				}
				break;
			case "mVoltar":
				view.dispose();
				new TelaInicialControle(f);
				break;
			case "mCliente":
				view.dispose();
				new CompraControle(f);
				break;
			}
		}
	}
	
private void listeners() {
		view.addGerenciamentoPListner(new GerenciamentoPListeners());
		
		view.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				carregarProdutos();
				if(f.getadministrador() == 1) {
					view.setmenuAdm(true);
				}
			}});
	}

	private void mAdm() {
		view.dispose();
		new GerenciamentoFControle(f);
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
			carregarProdutos();
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
			carregarProdutos();
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
			carregarProdutos();
			contS = 0;
			contD = 0;     
			contB = 0;
			view.setBackgroundcolor("btSalgados", corPadrao);
			view.setBackgroundcolor("btDoces", corPadrao);
			view.setBackgroundcolor("btBebidas", corPadrao);
		}
	}

	private void  btRemover() {
		try {
			Produto p = view.getItemTabela();
			try {
				new ProdutoDAO().deletarProduto(p);
				new MensagemView("Produto Removido",3);
			} catch (SQLException e1) {
				new MensagemView("Não Foi Possível Remover O Produto",0);
			}
			if (contS == 1) {
				carregarProdutosFiltro(Categoria.categoriaString("salgados"));
			} else if (contD == 1) {
				carregarProdutosFiltro(Categoria.categoriaString("doces"));
			} else if (contD == 1) {
				carregarProdutosFiltro(Categoria.categoriaString("bebidas"));
			} else {
				carregarProdutos();
			}
		} catch (Exception e2) {
			new MensagemView("Selecione Um Produto!",2);
		}
		
	}
       	
	private void btCadastrar() {
		view.dispose();
		new CadastroPControle(f);
	}
	
	private void btAlterar() {
		Produto p;
		try {
			p = view.getItemTabela();
			view.dispose();
			new AlterarPControle(f,p);
		} catch (Exception e) {
			new MensagemView("Selecione Um Produto!",2);
		}
	}

	private void carregarProdutos() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutosTableModel model;
		try {
			model = new ProdutosTableModel(dao.getProdutos());
			view.setTabela(model);
		} catch (IOException e) {
			new MensagemView("Erro ao conectar com o banco de dados",0);
		}
	}
	
	private void carregarProdutosFiltro(Categoria filtro) {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutosTableModel model;
		try {
			model = new ProdutosTableModel(dao.getProdutosFiltro(filtro));
			view.setTabela(model);
		} catch (IOException e) {
			new MensagemView("Erro ao conectar com o banco de dados",0);
		}
	}
	
}
