package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import controle.funcionario.GerenciamentoPControle;
import controle.inicio.TelaInicialControle;
import modelo.classes.Funcionario;
import modelo.dao.FuncionarioDAO;
import visao.Administrador.FuncionariosTableModel;
import visao.Administrador.TelaGerenciamentoF;

public class GerenciamentoFControle {
	private TelaGerenciamentoF tgf;
	private Funcionario f;
	
	public GerenciamentoFControle(Funcionario f) {
		this.f =f;
		tgf = new TelaGerenciamentoF(f);
		tgf.setVisible(true);
		listeners();
		
	}
	
	private class GerenciamentoFListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "mVoltar":
				tgf.dispose();
				new TelaInicialControle(f);
				break;
			case "btRemover":
				remover();
				break;
			case "mFuncionario":
				tgf.dispose();
				new GerenciamentoPControle(f);
				break;
			case "btAdicionar":
				tgf.dispose();
				System.out.println("btAdicionar");
				break;
			case "btAlterar":
				tgf.dispose();
				System.out.println("btAlterar");
				break;
			case "mAnaliseVendas":
				tgf.dispose();
				System.out.println("mAnaliseVendas");
				break;
			case "btPesquisar":
				System.out.println("btPesquisar");
				break;
			}
		}
	}
	private void listeners() {
		tgf.addGerenciamentoFListener(new GerenciamentoFListeners());
		tgf.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				carregarProdutos();
			}
		});
	}
	
	private void remover() {
		Funcionario f =tgf.getItemTabela();
		try {
			new FuncionarioDAO().deletarFuncionario(f);
			carregarProdutos();
		} catch (SQLException e) {
			e.printStackTrace();
			// não foi possivel remover
		};
		
	}
	
	private void carregarProdutos() {
		FuncionariosTableModel model = new FuncionariosTableModel(new FuncionarioDAO().getFuncionarios());
		tgf.setTabela(model);
	}
}
