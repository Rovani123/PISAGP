package modelo.classes;

import java.time.LocalDate;

public class Promocoes {
	
	private int idPromocao;
	private Produto produtos;
	private float desconto;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private ProdutosPromocao produtoP;
	
	public int getIdPromocao() {
		return idPromocao;
	}
	public void setIdPromocao(int idPromocao) {
		this.idPromocao = idPromocao;
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
	public Produto getProdutos() {
		return produtos;
	}
	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}
	public ProdutosPromocao getProdutoP() {
		return produtoP;
	}
	public void setProdutoP(ProdutosPromocao produtoP) {
		this.produtoP = produtoP;
	}
	public void setProdutoP(Produto produtoPromocao) {
		this.produtos = produtoPromocao;
	}
	public void setprodutoPromocao(ProdutosPromocao produtoP) {
		this.produtoP = produtoP;
		
	}
	
	
}
