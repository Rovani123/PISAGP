package modelo.enumerador;

public enum Categoria {
	
	SALGADO("salgado"),DOCE("doce"),BEBIDAS("bebidas"),BOLO("bolo");
	
	private String nome;

	Categoria(String nome) {
		this.nome = nome;
	}

	public String toString() {
		
		return nome;
	}
	
	
	public static Categoria categoriaString(String categoria){
		if(categoria.equals("Salgado"))
		{
			return SALGADO;
		}else if(categoria.equals("doce"))
		{
			return DOCE;
		}else if(categoria.equals("bebidas")) {
			return BEBIDAS;
		} else if(categoria.equals("bolo")) {
			return BOLO;
		}else {
			return null;
		}
	}

}
