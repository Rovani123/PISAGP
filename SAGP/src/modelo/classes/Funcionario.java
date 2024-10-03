package modelo.classes;

public class Funcionario {
	
	private int idFuncionario;
	private String usuario;
	private String nome;
	private String senha;
	private int administrador;
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getUsuarioFuncionario() {
		return usuario;
	}
	public void setUsuarioFuncionario(String usuarioFuncionario) {
		this.usuario = usuarioFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getadministrador() {
		return administrador;
	}
	
	public void setadministrador(int administrador) {
		this.administrador = administrador;
	}
	
	
}
