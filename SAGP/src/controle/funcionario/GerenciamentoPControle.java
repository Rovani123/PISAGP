package controle.funcionario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.dao.ProdutoDAO;
import modelo.enumerador.Categoria;
import visao.Funcionário.ProdutosTableModel;
import visao.Funcionário.TelaGerenciamentoP;

public class GerenciamentoPControle {
	private TelaGerenciamentoP tgp;
	private Funcionario f;
	private int contS = 0;
	private int contD = 0;
	private int contB = 0;
	
	public GerenciamentoPControle(Funcionario f) {
		this.f = f;
		tgp = new TelaGerenciamentoP(f);
		tgp.setVisible(true);
		listeners();
	}
	
	private class GerenciamentoPListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "mGProdutos":
				//
				break;
			case "mPromocoes":
				mPromocoes();
				break;
			case "mAdm":
				
				break;
			case "mFuncionario":
				//
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
			case "btOfertas":
//				btOfertas();  // A fazer
				break;
			case "btAlterar":
//				btAlterar();
				break;
			case "btRemover":
				btRemover();
				break;
			case "btCadastrar":
				btCadastrar();
				break;
			case "btPesquisar":
//				btPesquisar();
				break;
			
			default:
				//Mensagem de erro
				break;
			}
		}
	}
	private void listeners() {
		tgp.addGerenciamentoPListner(new GerenciamentoPListeners());
		
		tgp.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				if(f.getadministrador() == 1) {
					tgp.setmenuAdm(true);
				}
			}
		});
	}

	// funcoes dos botoes
	private void mPromocoes() {
//		tgp.dispose();
//		new PromocoesControle();
	}

	private void mAdm() {
//		tgp.dispose();
//		new GerenciamentoFControle();
	}
	
	private void btSalgados() {
		if (contS == 0) {
			tgp.getProdutosFiltro(Categoria.categoriaString("salgados"));
			contS = 1;
			contD = 0;
			contB = 0;
			tgp.setBackgroundcolor("btSalgados", new Color(255, 255, 0));
			tgp.setBackgroundcolor("btDoces", new Color(255, 255, 255));
			tgp.setBackgroundcolor("btBebidas", new Color(255, 255, 255));
		} else {
			tgp.getProdutos();
			contS = 0;
			contD = 0;
			contB = 0;
			tgp.setBackgroundcolor("btSalgados", new Color(255, 255, 255));
			tgp.setBackgroundcolor("btDoces", new Color(255, 255, 255));
			tgp.setBackgroundcolor("btBebidas", new Color(255, 255, 255));
		}
	}
	
	private void btDoces() {
		if (contD == 0) {
			tgp.getProdutosFiltro(Categoria.categoriaString("doces"));
			contS = 0;
			contD = 1;
			contB = 0;
			tgp.setBackgroundcolor("btSalgados", new Color(255, 255, 255));
			tgp.setBackgroundcolor("btDoces", new Color(255, 255, 0));
			tgp.setBackgroundcolor("btBebidas", new Color(255, 255, 255));
		} else {
			tgp.getProdutos();
			contS = 0;
			contD = 0;
			contB = 0;
			tgp.setBackgroundcolor("btSalgados", new Color(255, 255, 255));
			tgp.setBackgroundcolor("btDoces", new Color(255, 255, 255));
			tgp.setBackgroundcolor("btBebidas", new Color(255, 255, 255));
		}
	}
	
	private void btBebidas() {
		if (contB == 0) {
			tgp.getProdutosFiltro(Categoria.categoriaString("bebidas"));
			contS = 0;
			contD = 0;
			contB = 1;
			tgp.setBackgroundcolor("btSalgados", new Color(255, 255, 255));
			tgp.setBackgroundcolor("btDoces", new Color(255, 255, 255));
			tgp.setBackgroundcolor("btBebidas", new Color(255, 255, 0));
		} else {
			tgp.getProdutos();
			contS = 0;
			contD = 0;
			contB = 0;
			tgp.setBackgroundcolor("btSalgados", new Color(255, 255, 255));
			tgp.setBackgroundcolor("btDoces", new Color(255, 255, 255));
			tgp.setBackgroundcolor("btBebidas", new Color(255, 255, 255));
		}
	}

	private void  btRemover() {
		try {
			Produto p = tgp.getItemTabela();
			ProdutoDAO dao = new ProdutoDAO();
			try {
				dao.deletarProduto(p);
				// operação realizada com sucesso
			} catch (SQLException e1) {
				e1.printStackTrace();
				//Não é possivel remover esse produto
			}
			if (contS == 1) {
				tgp.getProdutosFiltro(Categoria.categoriaString("salgados"));
			} else if (contD == 1) {
				tgp.getProdutosFiltro(Categoria.categoriaString("doces"));
			} else if (contD == 1) {
				tgp.getProdutosFiltro(Categoria.categoriaString("bebidas"));
			} else {
				tgp.getProdutos();
			}
		} catch (Exception e2) {
			//Selecione um produto
		}
		
	}
       	
	private void btCadastrar() {
		tgp.dispose();
		new CadastroPControle(f);
	}
}
