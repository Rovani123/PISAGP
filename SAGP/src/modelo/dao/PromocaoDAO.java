package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controle.PromocaoControle;
import modelo.classes.Produto;
import modelo.classes.ProdutosPromocao;
import modelo.classes.Promocoes;
import modelo.enumerador.Categoria;

public class PromocaoDAO extends ModeloDAO {
public ArrayList<Promocoes> getPromocoes() {
		
		Statement stml = null;
		Connection conn = getConnection();
		
		ArrayList<Promocoes> lista = new ArrayList<Promocoes>();
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("SELECT * FROM PROMOCOES");
			
			while(reslt.next())
			{
				Promocoes promo = new Promocoes();
				promo.setIdPromocao(reslt.getInt("idPromocao"));
				promo.setprodutoPromocao(reslt.getString("produtoPromocao"), null);
				promo.setDesconto(reslt.getFloat("desconto"));
					lista.add(promo);
				
				
				}
			reslt.close();
			stml.close();
			conn.close();
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public void cadastrarPromocao(String produtoPromocao,float desconto) throws SQLException {
		super.save("insert into promocoes(desconto,dataInicio,dataTermino) values(?,?,?)", produtoPromocao,desconto); //LocalDate
	}
	
	public void alterarPromocao(ProdutosPromocao promo, int desconto) throws SQLException {
		super.update("UPDATE produtos SET nomeProduto = ?, preco = ?, quantidadeEstoque = ?, categoria = ? WHERE idProduto = ?", promo, desconto);
	}

}
