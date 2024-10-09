package controle;

import java.sql.SQLException;

import modelo.classes.Funcionario;
import modelo.dao.LoginDAO;
import visao.TelaLogin;
import visao.Administrador.TelaAdministrador;
import visao.Funcionário.TelaFuncionario;

public class LoginControle {
	public Funcionario validarLogin(String user, String senha) {
		LoginDAO ldao = new LoginDAO();
		return ldao.validarLogin(user, senha);
	}
	
	public boolean verificarBanco() throws SQLException {
		LoginDAO ldao = new LoginDAO();
		return ldao.bancoOnline();
	}
}
