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
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Vendas getVenda() {
		return venda;
	}
	public void setVenda(Vendas venda) {
		this.venda = venda;
	}
	
}
