package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelo.classes.Funcionario;
import modelo.dao.FuncionarioDAO;
import visao.TelaInicial;
import visao.Administrador.TelaAlteracaoF;
import visao.Administrador.TelaCadastroF;

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
				
			case "btEntrar":
				 entrar();
				break;
			}
			
		}
		
	}
	
	
	private void listeners() {
		view.addCadastroF(new CadastroF());
	}


	private void entrar() {
		nome =view.getNome();
		usuario =view.getUsuario();
		senha =view.getSenha();
		
		if(nome.isEmpty() && usuario.isEmpty() && senha.isEmpty()) {
			//mensagem
		}else {
			try {
				new FuncionarioDAO().cadastrarFuncionario(nome, usuario, senha);
				view.dispose();
				new GerenciamentoFControle(f);
				//mensagem
			} catch (SQLException e) {
				// Mensagem
			}
		}
//		Funcionario novoFuncionario = new FuncionarioDAO().get
//		new TelaInicial(novoFuncionario);
	}


	private void cadastrarFuncionario()  {
		nome =view.getNome();
		usuario =view.getUsuario();
		senha =view.getSenha();
		
		if(nome.isEmpty() && usuario.isEmpty() && senha.isEmpty()) {
			//mensagem
		}else {
			try {
				new FuncionarioDAO().cadastrarFuncionario(nome, usuario, senha);
			} catch (SQLException e) {
				// Mensagem
			}
		}
		
	}
	
}