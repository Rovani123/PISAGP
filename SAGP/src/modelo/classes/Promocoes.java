package modelo.classes;

import java.time.LocalDate;

public class Promocoes {
	
	private int idPromocao;
	private int idProduto;
	private float desconto;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private String produtoPromocao;
	
	public int getIdPromocao() {
		return idPromocao;
	}
	public void setIdPromocao(int idPromocao) {
		this.idPromocao = idPromocao;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public void setprodutoPromocao(String string, String produtoPromocao) {
		this.setProdutoPromocao(produtoPromocao);
		
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getProdutoPromocao() {
		return produtoPromocao;
	}
	public void setProdutoPromocao(String produtoPromocao) {
		this.produtoPromocao = produtoPromocao;
	}
	public void setprodutoPromocao(String string, Object produtoPromocao2) {
		// TODO Auto-generated method stub
		
	}
	
}
