package controle;

import java.sql.SQLException;

import modelo.classes.Funcionario;
import modelo.dao.LoginDAO;
import visao.TelaLogin;
import visao.Administrador.TelaAdministrador;
import visao.Funcionário.TelaFuncionario;

public class LoginControle {
	public boolean validarLogin(String user, String senha) {
		LoginDAO ldao = new LoginDAO();
		Funcionario f;
		f = ldao.validarLogin(user, senha);
		if(f != null)
		{
			if(f.getadministrador() == 1)
			{
				TelaAdministrador tA = new TelaAdministrador();
				tA.setVisible(true);
			}else
			{
				TelaFuncionario tF = new TelaFuncionario();
				tF.setVisible(true);
			}
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean verificarBanco() throws SQLException {
		LoginDAO ldao = new LoginDAO();
		return ldao.bancoOnline();
	}
}
