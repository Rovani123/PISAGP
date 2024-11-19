package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.classes.Funcionario;
import visao.Administrador.ZTelaAdministrador;
import visao.Funcionário.ZTelaFuncionario;

public class LoginDAO extends ModeloDAO {

	public Funcionario validarLogin(String user, String senha) throws SQLException {
		Statement stml = null;
		Connection conn = getConnection();

		stml = (Statement) conn.createStatement();
		ResultSet resl = null;
		resl = stml.executeQuery("SELECT * FROM Funcionarios");
		while (resl.next()) {
			if (user.equals(resl.getString("usuarioFuncionario"))) {
				if (senha.equals(resl.getString("Senha"))) {
					Funcionario f = new Funcionario();
					f.setIdFuncionario(resl.getInt("idFuncionario"));
					f.setNome(resl.getString("nomeFuncionario"));
					f.setUsuarioFuncionario(resl.getString("usuarioFuncionario"));
					f.setSenha(resl.getString("senha"));
					f.setadministrador(resl.getInt("administrador"));
					return f;
				}
			}
		}
		resl.close();
		stml.close();
		conn.close();
		return null;

	}

	public boolean bancoOnline() throws SQLException {
		return getConnection().isValid(0);
	}
}
