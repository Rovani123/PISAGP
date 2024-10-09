package modelo.enumerador;

public enum Categoria {
	
	SALGADO("salgados"),DOCE("doces"),BEBIDAS("bebidas"),BOLO("bolos");
	
	private String nome;

	Categoria(String nome) {
		this.nome = nome;
	}

	public String toString() {
		
		return nome;
	}
	
	
	public static Categoria categoriaString(String categoria){
		if(categoria.equals("salgados"))
		{
			return SALGADO;
		}else if(categoria.equals("doces"))
		{
			return DOCE;
		}else if(categoria.equals("bebidas")) {
			return BEBIDAS;
		} else if(categoria.equals("bolos")) {
			return BOLO;
		}else {
			System.err.println(categoria);
			return null;
		}
	}

}
