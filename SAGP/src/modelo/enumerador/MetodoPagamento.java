package modelo.enumerador;

public enum MetodoPagamento {
	
	DINHEIRO("dinheiro"),DEBITO("débito"),CREDITO("crédito"),PIX("pix");
	
	private String nome;
	
	MetodoPagamento(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return nome;
	}
	
	

}
