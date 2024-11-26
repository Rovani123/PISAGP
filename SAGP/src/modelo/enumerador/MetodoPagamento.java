package modelo.enumerador;

public enum MetodoPagamento {
	
	DINHEIRO("Dinheiro"),DEBITO("Débito"),CREDITO("Crédito"),PIX("Pix");
	
	private String nome;
	
	MetodoPagamento(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return nome;
	}
	
	

}
