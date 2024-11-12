package modelo.classes;

import java.sql.Date;

public class ProdutosPromocao {

	private int idProdutosPromocao;
	private int idProduto;
	private int idPromocao;
	private float desconto;
	
	public int getIdProdutosPromocao() {
		return idProdutosPromocao;
	}
	public void setIdProdutosPromocao(int idProdutosPromocao) {
		this.idProdutosPromocao = idProdutosPromocao;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getIdPromocao() {
		return idPromocao;
	}
	public void setIdPromocao(int idPromocao) {
		this.idPromocao = idPromocao;
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
	
}
