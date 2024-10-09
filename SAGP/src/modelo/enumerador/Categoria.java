package modelo.enumerador;

public enum Categoria {
	
	SALGADOS("salgados"),DOCES("doces"),BEBIDAS("bebidas"),BOLOS("bolos");
	
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
			return SALGADOS;
		}else if(categoria.equals("doces"))
		{
			return DOCES;
		}else if(categoria.equals("bebidas")) {
			return BEBIDAS;
		} else if(categoria.equals("bolos")) {
			return BOLOS;
		}else {
			System.err.println(categoria);
			return null;
		}
	}

}
