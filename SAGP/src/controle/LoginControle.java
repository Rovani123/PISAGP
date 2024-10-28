package controle;

import java.sql.SQLException;

import modelo.classes.Funcionario;
import modelo.dao.LoginDAO;
import visao.TelaLogin;
import visao.Administrador.ZTelaAdministrador;
import visao.Funcionário.ZTelaFuncionario;

public class LoginControle {
	public Funcionario validarLogin(String user, String senha) throws SQLException {
		LoginDAO ldao = new LoginDAO();
		return ldao.validarLogin(user, senha);
	}
	
	public boolean verificarBanco() throws SQLException {
		LoginDAO ldao = new LoginDAO();
		return ldao.bancoOnline();
	}
}
