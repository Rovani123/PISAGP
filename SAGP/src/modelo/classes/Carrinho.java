package modelo.classes;

public class Carrinho {

	private int idCarrinho;
	private Produto produto;
	private Vendas venda;
	private int quantidade;
	
	public int getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(int idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
