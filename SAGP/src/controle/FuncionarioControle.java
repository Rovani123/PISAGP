package controle;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.classes.Funcionario;
import modelo.dao.FuncionarioDAO;

public class FuncionarioControle {
	
	public ArrayList<Funcionario> getFuncionarios() {
		FuncionarioDAO fdal = new FuncionarioDAO();
		return fdal.getFuncionarios();		
	
	}
	
	public void alterarFuncionario(Funcionario f) throws SQLException {
		FuncionarioDAO fdal = new FuncionarioDAO();
		fdal.alteraFuncionario(f);
	}
	
	public void deletarFuncionario(Funcionario f) throws SQLException {
		FuncionarioDAO fdal = new FuncionarioDAO();
		fdal.deletarFuncionario(f);
		
	}
	
	public void cadastrarFuncionario(String nome,String usuario,String senha) throws SQLException {
		FuncionarioDAO fdao = new FuncionarioDAO();
		fdao.cadastrarFuncionario(nome, usuario, senha);
		
	}
	
	
}
