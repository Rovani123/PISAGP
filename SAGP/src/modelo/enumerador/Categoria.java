package modelo.enumerador;

public enum Categoria {
	
	SALGADO("Salgado"),DOCE("Doce"),BEBIDAS("Bebidas"),BOLO("Bolo");
	
	private String nome;

	Categoria(String nome) {
		this.nome = nome;
	}

	public String toString() {
		
		return nome;
	}

}
