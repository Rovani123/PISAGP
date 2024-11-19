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
				
				break;
			case "btLimpa":
				
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
			Funcionario f = dao.validarLogin(tl.getUsuario(), tl.getSenha());

			
			try {
				f = lc.validarLogin(usuario,senha);
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Falha ao conectar com o banco de dados");
				f = null;
			}
			if(f != null){
				if(f.getadministrador() == 1){
					TelaGerenciamentoF tgf = new TelaGerenciamentoF(tela,f);
					dispose();
					tgf.setVisible(true);
				}else{
					TelaGerenciamentoP tgp = new TelaGerenciamentoP(tela,f);
					dispose();
					tgp.setVisible(true);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
			}
		}
	}
	
	//mudar
	
	public boolean verificarBanco() throws SQLException {
		LoginDAO ldao = new LoginDAO();
		return ldao.bancoOnline();
	}
}
