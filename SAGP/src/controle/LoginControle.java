package controle;

import java.sql.SQLException;

import modelo.classes.Funcionario;
import modelo.dao.LoginDAO;
import visao.TelaLogin;

public class LoginControle {
	public Funcionario logar(String user, String senha) {
		LoginDAO ldao = new LoginDAO();
		return ldao.validarLogin(user, senha);
	}
	
	public boolean verificarBanco() throws SQLException {
		LoginDAO ldao = new LoginDAO();
		return ldao.bancoOnline();
	}
}
