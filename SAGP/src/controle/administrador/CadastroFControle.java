package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelo.classes.Funcionario;
import modelo.dao.FuncionarioDAO;
import visao.Administrador.TelaAlteracaoF;
import visao.Administrador.TelaCadastroF;

public class CadastroFControle {
	private TelaCadastroF tcf;
	private Funcionario f;
	private String nome;
	private String usuario;
	private String senha;
	
	public CadastroFControle (Funcionario f) {
		this.f =f;
		tcf = new TelaCadastroF(f);
		tcf.setVisible(true);
		listeners();
	}

	private class CadastroF implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btCadastrar":
				tcf.dispose();
				try {
					cadastrarFuncionario();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new GerenciamentoFControle(f);
				//mensagem
				break;
				
			case "btLimpar":
			     tcf.limpar();
				break;
				
				
			case "btCancelar":
				tcf.dispose();
				new GerenciamentoFControle(f);
				break;
				
			case "btEntrar":
//				 Jesus vai fazer
				break;
			}
			
		}
		
	}
	
	
	private void listeners() {
		tcf.addCadastroF(new CadastroF());
	}


	public void cadastrarFuncionario() throws SQLException {
//		nome =tcf.getNome();
//		usuario =tcf.getUsuario();
//		senha =tcf.getSenha();
		
		new FuncionarioDAO().cadastrarFuncionario(nome, usuario, senha);
		
	}
	
}