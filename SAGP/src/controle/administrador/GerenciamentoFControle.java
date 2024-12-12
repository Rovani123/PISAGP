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
import visaoTelasDeAviso.MensagemView;

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
				carregarFuncionarios();
			}
		});
	}
	
	private void alterar() {
		try {
			Funcionario fselecionado =view.getItemTabela();
			new AlterarFControle(f, fselecionado);
			view.dispose();    
		} catch (Exception e) {
			new MensagemView("Selecione Um Funcionário!",2);
		}
	}

	private void remover() {
		try {
			Funcionario f =view.getItemTabela();
			if(f.getadministrador() == 1) {
				new MensagemView("Não é Possível Remover O Administrador!",2);
			}else {
				try {
					new FuncionarioDAO().deletarFuncionario(f);
					carregarFuncionarios();
					new MensagemView("Funcionário Removido Com Sucesso!",3);
				}catch (SQLException e) {
				new MensagemView("Não Foi Possível Remover O Funcionário!",0);
				}
			}
		} catch (Exception e) {
			new MensagemView("Selecione Um Funcionário!",2);
		};
		
	}
	
	private void carregarFuncionarios() {
		FuncionariosTableModel model = new FuncionariosTableModel(new FuncionarioDAO().getFuncionarios());
		view.setTabela(model);
	}
	
}
