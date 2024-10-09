package modelo.dao;

import java.sql.SQLException;

public class FuncionarioDAO extends ModeloDAO{

	public void CadastrarFuncionario(String nome,String usuario, String senha) throws SQLException {

		super.save("insert into Funcionarios (nomeFuncionario,usuarioFuncionario,senha,administrador) VALUES (?,?,?,?)",nome,usuario,senha,0);
		
	}
	private void AlterarFuncionarios(Funcionario f) {
		super.update("UPDATE funcionarios SET nomeFuncionario = ?, usuarioFuncionario = ?, senha = ?, administrador = ? WHERE idFuncionario = ?",
				p.getidFuncionario(), p.getnomeFuncionario(),p.getusuarioFuncionario(),p.getsenha(),p.getadministrador().toString());
	}
	
	private void DeletarFuncionario() {
		

	}

}

