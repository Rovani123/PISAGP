package modelo.classes;

public class Vendas {

	private int idVenda;
	private Cliente cliente;
	private Funcionario funcionario;
	private String metodoPagamento;
	
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public String getMetodoPagamento() {
		return metodoPagamento;
	}
	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	
	
}
