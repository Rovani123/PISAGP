package modelo.dao;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import modelo.classes.Carrinho;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.classes.Vendas;
import modelo.enumerador.Categoria;

public class CarrinhoDAO extends ModeloDAO{
	private int idVenda;
	
	public void cadastrarVenda(Vendas v, Funcionario f) throws SQLException {
		super.save("insert into Vendas (idFuncionario, metodoPagamento,Total) values (?,?,?)", f.getIdFuncionario(), v.getMetodoPagamento(),v.getTotal());
	}
	
	public void cadastrarCarrinho(Carrinho c) throws SQLException {
		Statement stml = null;
		Connection conn = getConnection();
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("SELECT idVenda FROM Vendas");
			
			while(reslt.next())
			{
				
				idVenda= reslt.getInt("idVenda");
			}
			
			reslt.close();
			stml.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.save("insert into carrinho (idProduto, idVenda,quantidade) values (?,?,?)", c.getProduto().getIdProduto(), idVenda, c.getQuantidade());
	}

	public ArrayList<Carrinho> getCarrinhos(Vendas v) throws IOException{
		Statement stml = null;
		Statement stml2 = null;
		Connection conn = getConnection();
		
		ArrayList<Carrinho> lista = new ArrayList<Carrinho>();
		try {
			stml = (Statement) conn.createStatement();
			stml2 = (Statement) conn.createStatement();
			ResultSet reslt = null;
			ResultSet reslt2 = null;
			reslt = stml.executeQuery("select * from Vendas v right join Carrinho c on v.idVenda = c.idVenda where v.idVenda = "+v.getIdVenda()+";");
			reslt2 = stml2.executeQuery("select * from produtos p left join carrinho c on p.idProduto = c.idProduto;");
			
			while(reslt2.next())
			{
				Produto p = new Produto();
				p.setIdProduto(reslt2.getInt("idProduto"));
				p.setNomeProduto(reslt2.getString("nomeProduto"));
				p.setPreco(reslt2.getFloat("preco"));
				p.setQuantidadeEstoque(reslt2.getInt("quantidadeEstoque"));
				p.setCategoria(Categoria.categoriaString(reslt2.getString("categoria")));
				Blob blob = reslt2.getBlob("foto");
				byte[] blobBytes = blob.getBytes(1, (int) blob.length());
				ByteArrayInputStream bais = new ByteArrayInputStream(blobBytes); 
				Image image = ImageIO.read(bais);
				p.setFoto(image);
				while(reslt.next())
				{
					Carrinho c = new Carrinho();
					c.setIdCarrinho(reslt.getInt("idCarrinho"));
					c.setProduto(p);
					c.setQuantidade(reslt.getInt("quantidade"));
					lista.add(c);
				}
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
}
