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
import visaoTelasDeAviso.MensagemView;

public class AlterarPControle {
	private TelaAlteracaoP view;
	private Funcionario f;
	private Produto p;
	
	public AlterarPControle(Funcionario f, Produto p){
		this.f = f;
		this.p =p;
		view = new TelaAlteracaoP(p,f);
		view.setVisible(true);
		listerners();
		
	}

	private void listerners() {
		view.addAlteracaoPListener(new  AlterarPListener());
		view.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				view.setCampos(p);
			}
		});
	}
	
	private class AlterarPListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "btLimpa":
				view.limpa();
				break;
			case "btSalvar":
				salvar();
				break;
			case "btCancelar":
				cancelar();
			}
		}
	}
	
	private void salvar() {
		p.setNomeProduto(view.getNome());
		p.setPreco(Float.parseFloat(view.getPreco()));
		p.setQuantidadeEstoque(Integer.parseInt(view.getQuantidade()));
		p.setCategoria(view.getCategoria());
		try {
			new ProdutoDAO().alterarProduto(p);;
			view.dispose();
			new GerenciamentoPControle(f);
			new MensagemView("Produto alterado com sucesso!",0);
		} catch (SQLException e) {
			e.printStackTrace();
			new MensagemView("não foi possível alterar esse produto!",0);
		}
	}
	
	private void cancelar() {
		view.dispose();
		new GerenciamentoPControle(f);
	}

}


