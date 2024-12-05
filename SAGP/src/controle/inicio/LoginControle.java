package controle.inicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import controle.administrador.GerenciamentoFControle;
import controle.funcionario.GerenciamentoPControle;
import modelo.classes.Funcionario;
import modelo.dao.LoginDAO;
import visao.TelaLogin;
import visaoTelasDeAviso.MensagemView;

public class LoginControle {
	private TelaLogin view;
	private boolean oculto =true;
	public LoginControle() {
		view = new TelaLogin();
		view.setVisible(true);
		listeners();
	}
	
	private class LoginListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btEntrar":
				login();
				break;
			case "btVoltar":
				fechar();
				break;
			case "btLimpa":
				limpar();
				break;
			case "btMostar":
				mostrarSenha();
				break;
			default:
				new MensagemView("Escolha uma das opções", 0);
				break;
			}
		}
	}
		
	private void listeners() {
		view.addLoginListener(new LoginListner());
	}
	
	private void login() {
		if(view.getUsuario().isEmpty() || view.getSenha().isEmpty()) {
			new MensagemView("Todos os Campos precisam ser preenchidos",2);
		}else {
			
			LoginDAO dao = new LoginDAO();
			Funcionario f;
			
			try {
				f = dao.validarLogin(view.getUsuario(), view.getSenha());
				if(f != null){
					view.dispose();
					new TelaInicialControle(f);
				}else {
					new MensagemView("Usuário ou senha inválidos",2);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				f=null;
			}
		}
	}
	
	private void fechar() {
		view.dispose();
	}
	
	private void limpar() {
		view.setUsuario(null);
		view.setSenha(null);
	}
	
	private void mostrarSenha() {
		if(oculto) {
			view.MostrarSenha((char) 0);
			oculto =false;
		}else {
			view.MostrarSenha('•');
			oculto=true;
		}
	}
	
	//não utilizado
	public boolean verificarBanco() throws SQLException {
		LoginDAO ldao = new LoginDAO();
		return ldao.bancoOnline();
	}
}
