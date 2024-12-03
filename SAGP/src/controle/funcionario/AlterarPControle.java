package controle.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.w3c.dom.Text;

import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.dao.ProdutoDAO;
import modelo.enumerador.Categoria;
import visao.RoundButton;
import visao.Funcionário.TelaAlteracaoP;
import visao.Funcionário.TelaGerenciamentoP;

public class AlterarPControle {
	private TelaAlteracaoP tap;
	private Funcionario f;
	private Produto p;
	
	public AlterarPControle(Funcionario f, Produto p){
		this.f = f;
		this.p =p;
		tap = new TelaAlteracaoP(p,f);
		tap.setVisible(true);
		listerners();
		
	}

	private void listerners() {
		tap.addAlteracaoPListener(new  AlterarPListener());
		tap.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				tap.setCampos(p);
			}
		});
	}
	
	public class AlterarPListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "btLimpa":
				tap.limpa();
				break;
			case "btSalvar":
				salvar();
				break;
			case "btCancelar":
				cancelar();

			default:
				break;
				
			}
			}
		}
	private void salvar() {
		p.setNomeProduto(tap.getNome());
		p.setPreco(Float.parseFloat(tap.getPreco()));
		p.setQuantidadeEstoque(Integer.parseInt(tap.getQuantidade()));
		p.setCategoria(tap.getCategoria());
		ProdutoDAO dao = new ProdutoDAO();
		try {
			dao.alterarProduto(p);
			tap.dispose();
			new GerenciamentoPControle(f);
			//Produto Alterado com sucesso
		} catch (SQLException e) {
			e.printStackTrace();
			//não foi possível alterar o produto
		}
	}
	private void cancelar() {
		tap.dispose();
		new GerenciamentoPControle(f);
	}

	}


