package modelo;

import java.time.LocalDate;

public class Promocoes {
	
	private int idPromocao;
	private int idProduto;
	private float desconto;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	
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
	
	
}
