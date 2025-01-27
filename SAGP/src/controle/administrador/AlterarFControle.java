package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import modelo.classes.Funcionario;
import modelo.dao.FuncionarioDAO;
import visao.Administrador.TelaAlteracaoF;
import visao.TelasDeAviso.MensagemView;

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
		if(fSelecionado.getNome().isEmpty() || fSelecionado.getUsuarioFuncionario().isEmpty() || fSelecionado.getSenha().isEmpty()) {
			new MensagemView("Todos Os Campos Precisam Ser Preenchidos",0);
		}else {
			try {
				new FuncionarioDAO().alteraFuncionario(fSelecionado);
				view.dispose();
				new GerenciamentoFControle(f);
				new MensagemView("Funcionário Alterado Com Sucesso",3);
			} catch (SQLException e) {
				new MensagemView("Não Foi Possível Alterar O Funcionário",0);
			}
		}
	}


	private void carregarDados() {
		view.setText(fSelecionado);
	}
}
