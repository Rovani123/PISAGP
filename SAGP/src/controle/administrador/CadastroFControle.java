package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import controle.inicio.TelaInicialControle;
import modelo.classes.Funcionario;
import modelo.dao.FuncionarioDAO;
import visao.Administrador.TelaCadastroF;
import visao.TelasDeAviso.MensagemView;

public class CadastroFControle {
	private TelaCadastroF view;
	private Funcionario f;
	private String nome;
	private String usuario;
	private String senha;
	
	public CadastroFControle (Funcionario f) {
		this.f =f;
		view = new TelaCadastroF(f);
		view.setVisible(true);
		listeners();
	}

	private class CadastroF implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btCadastrar":
				cadastrarFuncionario();
				break;
			case "btLimpar":
			     view.limpar();
				break;
			case "btCancelar":
				view.dispose();
				new GerenciamentoFControle(f);
				break;
			}
		}
	}
	
	
	private void listeners() {
		view.addCadastroF(new CadastroF());
	}

	private void cadastrarFuncionario()  {
		nome =view.getNome();
		usuario =view.getUsuario();
		senha =view.getSenha();
		
		if(nome.isEmpty() || usuario.isEmpty() || senha.isEmpty()) {
			new MensagemView("Todos Os Campos Prescisam Ser Preenchidos!",2);
		}else {
			try {
				new FuncionarioDAO().cadastrarFuncionario(nome, usuario, senha);
				new GerenciamentoFControle(f);
				view.dispose();
				new MensagemView("Funcionário Cadastrado Com Sucesso!",3);
			} catch (SQLException e) {
				new MensagemView("Não Foi Possível Cadastrar O Funcionário!",0);
			}
		}
		
	}
	
}