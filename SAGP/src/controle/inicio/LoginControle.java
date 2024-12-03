package controle.inicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import controle.funcionario.GerenciamentoPControle;
import modelo.classes.Funcionario;
import modelo.dao.LoginDAO;
import visao.TelaLogin;
import visao.Administrador.TelaGerenciamentoF;
import visaoTelasDeAviso.MensagemView;

public class LoginControle {
	private TelaLogin tl;
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
				new MensagemView("Escolha uma das opções", 0);
				break;
			}
		}
	}
		
	private void listeners() {
		tl.addLoginListener(new LoginListner());
	}
	
	private void login() {
		if(tl.getUsuario().isEmpty() || tl.getSenha().isEmpty()) {
			new MensagemView("Todos os Campos precisam ser preenchidos",2);
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
					
				}else{
					tl.dispose();
					new GerenciamentoPControle(f);
				}
			}else {
				//Usuário ou senha inválidos
				new MensagemView("Usuário ou senha inválidos",2);
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
