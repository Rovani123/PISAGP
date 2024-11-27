package modelo.classes;

public class Vendas {

	private int idVenda;
	private Funcionario funcionario;
	private String metodoPagamento;
	private float total;
	
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
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
}
