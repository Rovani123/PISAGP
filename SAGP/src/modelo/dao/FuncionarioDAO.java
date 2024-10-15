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

	public void CadastrarFuncionario(String nome,String usuario, String senha) {

		Funcionario novoFuncionario = new Funcionario();
		
		novoFuncionario.setUsuarioFuncionario(usuario);
		novoFuncionario.setNome(nome);
		novoFuncionario.setSenha(senha);
		
		String insert = "insert into Funcionarios (nomeFuncionario,usuarioFuncionario,senha,administrador) VALUES (?,?,?,?)";
		
		Statement stml = null;
		Connection conn = ConexaoBD.getConexaoMySQL();
		
		try {
			//stml = (Statement) conn.prepareStatement(insert);
			PreparedStatement preparedStatement = conn.prepareStatement(insert);
			//ResultSet resl = null;
			
			preparedStatement.setString(1, usuario);
			preparedStatement.setString(2, nome);
			preparedStatement.setString(3, senha);
			preparedStatement.setInt(4,0);
			
			
			int row = preparedStatement.executeUpdate();
			
			
			preparedStatement.close();
			//resl.close();
			//stml.close();
			conn.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
			
		}
		
	}
	
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
					
					f.setUsuarioFuncionario("usuarioFuncionario");
					f.setNome("nomeFuncionario");
					f.setSenha("senha");
						
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
		super.save("insert into funcionarios(nomeFuncionario,usuarioFuncionario,senha) values(?,?,?)", nome,usuario,senha);
	}
	
	public void DeletarFuncionario(Funcionario f) throws SQLException{
		super.delete("DELETE FROM funcionarios WHERE idFuncionario = ?", f.getIdFuncionario());
	}


}
