package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dal.ConexaoBD;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.enumerador.Categoria;

public class FuncionarioDAO extends ModeloDAO {

	public ArrayList<Funcionario> getFuncionarios() {
		
		Statement stml = null;
		Connection conn = getConnection();
		
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("SELECT * FROM Funcionarios");
			
			while(reslt.next())
			{
				Funcionario f = new Funcionario();
					
					f.setUsuarioFuncionario(reslt.getString("usuarioFuncionario"));
					f.setNome(reslt.getString("nomeFuncionario"));
					f.setSenha(reslt.getString("senha"));
						
					lista.add(f);
				
				
				}
			reslt.close();
			stml.close();
			conn.close();
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void alteraFuncionario(Funcionario f) throws SQLException {
		super.update("UPDATE funcionarios SET nomeFuncionario = ?, usuarioFuncionario = ?, senha = ? WHERE idFuncionario = ?", f.getIdFuncionario(), f.getNome(), f.getUsuarioFuncionario(), f.getSenha());
	}

	public void cadastrarFuncionario(String nome,String usuario,String senha) throws SQLException {
		super.save("insert into funcionarios(nomeFuncionario,usuarioFuncionario,senha,administrador) values(?,?,?,?)", nome,usuario,senha,0);
	}
	
	public void deletarFuncionario(Funcionario f) throws SQLException{
		super.delete("DELETE FROM funcionarios WHERE idFuncionario = ?", f.getIdFuncionario());
	}


}
