package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import dal.ConexaoBD;
import modelo.classes.Funcionario;

public class AdmDAO {

	public void CadastrarFuncionario(String nome,String usuario, String senha) {
		// TODO Auto-generated method stub

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
			
			System.out.println(preparedStatement);
			
			int row = preparedStatement.executeUpdate();
			
			System.out.println(row); 
			
			preparedStatement.close();
			//resl.close();
			//stml.close();
			conn.close();
			
			JOptionPane.showMessageDialog(null,"Deu Certo");
		} catch (SQLException e1) {
			e1.printStackTrace();
			
			
		}
		
	}
	
}
