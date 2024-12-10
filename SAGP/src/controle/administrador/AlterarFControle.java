package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import modelo.classes.Funcionario;
import modelo.dao.FuncionarioDAO;
import visao.Administrador.TelaAlteracaoF;
import visao.Administrador.TelaGerenciamentoF;

public class AlterarFControle {
	private TelaAlteracaoF view;
	private Funcionario f;
	private Funcionario fSelecionado;
	
	public AlterarFControle (Funcionario f, Funcionario fSelecionado) {
		this.fSelecionado = fSelecionado;
		this.f =f;
		view = new TelaAlteracaoF(f);
		view.setVisible(true);
		listeners();
	}

	private class AlterarFListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btLimpar":
				view.dispose();
			    view.limpa();   	
				break;
			
			case "btCancelar":
				view.dispose();
				new GerenciamentoFControle(f);
				break;
			
			case "btSalvar":
				salvar();			
			}
		}
	}
	
	
	private void listeners() {
		view.addAlteracaoF(new AlterarFListener());
		view.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				carregarDados();
			}
		});
	}


	private void salvar() {
		fSelecionado.setNome(view.getNome());
		fSelecionado.setUsuarioFuncionario(view.getUsuario());
		fSelecionado.setSenha(view.getSenha());
		
		try {
			new FuncionarioDAO().alteraFuncionario(fSelecionado);
			view.dispose();
			new GerenciamentoFControle(f);
			//mensagem
		} catch (SQLException e) {
			// mensagem
		}
	}


	private void carregarDados() {
		view.setText(fSelecionado);
	}
}
