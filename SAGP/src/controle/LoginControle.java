package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import modelo.classes.Funcionario;
import modelo.dao.LoginDAO;
import visao.TelaLogin;

public class LoginControle {
	TelaLogin tl;
	public LoginControle() {
		tl = new TelaLogin();
		tl.setVisible(true);
		listeners();
	}
	
	private class LoginListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btEntrar":
				login();
				break;
			case "btVoltar":
				voltar();
				break;
			case "btLimpa":
				limpar();
				break;
			default:
				//Mensagem de erro
				break;
			}
		}
	}
	
	
	private void listeners() {
		tl.addLoginListener(new LoginListner());
	}
	
	private void login() {
		if(tl.getUsuario().isEmpty() || tl.getSenha().isEmpty()) {
			//Todos os Campos precisam ser preenchidos
		}else {
			
			LoginDAO dao = new LoginDAO();
			Funcionario f;
			
			try {
				f = dao.validarLogin(tl.getUsuario(), tl.getSenha());
			} catch (SQLException e) {
				e.printStackTrace();
				f=null;
			}

			
			
			if(f != null){
				if(f.getadministrador() == 1){
					//admControle
					System.out.println("ADM");
				}else{
					System.out.println("F");
					//funcionarioControle
				}
			}else {
				//Usuário ou senha inválidos
			}
		}
	}
	
	private void voltar() {
		new TelaInicialControle();
	}
	
	private void limpar() {
		tl.setUsuario(null);
		tl.setSenha(null);
	}
	
	
	//não utilizado
	public boolean verificarBanco() throws SQLException {
		LoginDAO ldao = new LoginDAO();
		return ldao.bancoOnline();
	}
}
