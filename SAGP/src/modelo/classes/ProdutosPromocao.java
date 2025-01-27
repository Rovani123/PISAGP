package modelo.classes;

import java.sql.Date;

public class ProdutosPromocao {

	private int idProdutosPromocao;
	private Produto produto;
	private Promocoes promocao;
	private float desconto;
	
	public int getIdProdutosPromocao() {
		return idProdutosPromocao;
	}
	public void setIdProdutosPromocao(int idProdutosPromocao) {
		this.idProdutosPromocao = idProdutosPromocao;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
	public Date getDataI() {
		return null;
	}
	public Date getDataT() {
		return null;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Promocoes getPromocao() {
		return promocao;
	}
	public void setPromocao(Promocoes promocao) {
		this.promocao = promocao;
	}
	
}
