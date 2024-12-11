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
	private TelaGerenciamentoF view;
	private Funcionario f;
	
	public GerenciamentoFControle(Funcionario f) {
		this.f =f;
		view = new TelaGerenciamentoF(f);
		view.setVisible(true);
		listeners();
		
	}
	
	private class GerenciamentoFListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "mVoltar":
				view.dispose();
				new TelaInicialControle(f);
				break;
			case "btRemover":
				remover();
				break;
			case "mFuncionario":
				view.dispose();
				new GerenciamentoPControle(f);
				break;
			case "btAdicionar":
				view.dispose();
				new CadastroFControle(f);
				break;
			case "btAlterar":
				view.dispose();
				alterar();
				break;
			case "mAnaliseVendas":
				view.dispose();
				new AnaliseVendasControle(f);
				break;
			case "btPesquisar":
				System.out.println("btPesquisar");
				break;
			}
		}
	}
	
	private void listeners() {
		view.addGerenciamentoFListener(new GerenciamentoFListeners());
		view.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				carregarProdutos();
			}
		});
	}
	
	private void alterar() {
		Funcionario fselecionado =view.getItemTabela();
		new AlterarFControle(f, fselecionado);
	}

	private void remover() {
		Funcionario f =view.getItemTabela();
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
		view.setTabela(model);
	}
	
//	criar metodo para pegar os get da view TelaGerenciamentoF
}
