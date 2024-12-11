package modelo.dao;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import dal.ConexaoBD;
import modelo.classes.Produto;
import modelo.enumerador.Categoria;

public class ProdutoDAO extends ModeloDAO{
	
	public ArrayList<Produto> getProdutosFiltro(Categoria categoria) throws IOException {
		
		Statement stml = null;
		Connection conn = ConexaoBD.getConexaoMySQL();
		
		ArrayList<Produto> lista = new ArrayList<Produto>();
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			
			reslt = stml.executeQuery("SELECT * FROM PRODUTOS where categoria = '"+categoria.toString()+"'");
	
			while(reslt.next())
			{
				Produto p = new Produto();
					p.setIdProduto(reslt.getInt("idProduto"));
					p.setNomeProduto(reslt.getString("nomeProduto"));
					p.setPreco(reslt.getFloat("preco"));
					p.setQuantidadeEstoque(reslt.getInt("quantidadeEstoque"));
					Categoria cat = Categoria.categoriaString(reslt.getString("categoria"));
					p.setCategoria(cat);
					Blob blob = reslt.getBlob("foto");
					byte[] blobBytes = blob.getBytes(1, (int) blob.length());
					ByteArrayInputStream bais = new ByteArrayInputStream(blobBytes); 
					Image image = ImageIO.read(bais);
					p.setFoto(image);
					lista.add(p);
				
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
	
	public ArrayList<Produto> getProdutos() throws IOException {
		
		Statement stml = null;
		Connection conn = getConnection();
		
		ArrayList<Produto> lista = new ArrayList<Produto>();
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("SELECT * FROM PRODUTOS");
			
			while(reslt.next())
			{
				Produto p = new Produto();
					p.setIdProduto(reslt.getInt("idProduto"));
					p.setNomeProduto(reslt.getString("nomeProduto"));
					p.setPreco(reslt.getFloat("preco"));
					p.setQuantidadeEstoque(reslt.getInt("quantidadeEstoque"));
					Categoria cat = Categoria.categoriaString(reslt.getString("categoria"));
					p.setCategoria(cat);
					Blob blob = reslt.getBlob("foto");
					byte[] blobBytes = blob.getBytes(1, (int) blob.length());
					ByteArrayInputStream bais = new ByteArrayInputStream(blobBytes); 
					Image image = ImageIO.read(bais);
					p.setFoto(image);
					lista.add(p);
				
				
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
	
	public Produto getProdutoId(int id) {
		Statement stml = null;
		Connection conn = getConnection();
		
		
		try {
			stml = (Statement) conn.createStatement();
			ResultSet reslt = null;
			reslt = stml.executeQuery("SELECT * FROM PRODUTOS WHERE idProduto = "+String.valueOf(id));
			Produto p = new Produto();
			
			while(reslt.next())
			{
					p.setIdProduto(reslt.getInt("idProduto"));
					p.setNomeProduto(reslt.getString("nomeProduto"));
					p.setPreco(reslt.getFloat("preco"));
					p.setQuantidadeEstoque(reslt.getInt("quantidadeEstoque"));
					Categoria cat = Categoria.categoriaString(reslt.getString("categoria"));
					p.setCategoria(cat);
				
				};
			
			reslt.close();
			stml.close();
			conn.close();
			return p;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void alterarProduto(Produto p) throws SQLException {
		super.update("UPDATE produtos SET nomeProduto = ?, preco = ?, quantidadeEstoque = ?, categoria = ? WHERE idProduto = ?", p.getIdProduto(), p.getNomeProduto(),p.getPreco(),p.getQuantidadeEstoque(),p.getCategoria().toString());
	}

	public void cadastrarProduto(String nome,float preco,int quantidade,String categoria,FileInputStream foto) throws SQLException {
		super.save("insert into produtos(nomeProduto,preco,quantidadeEstoque,categoria,foto) values(?,?,?,?,?)", nome,preco,quantidade,categoria,foto);
	}
	
	public void deletarProduto(Produto p) throws SQLException{
		super.delete("DELETE FROM produtos WHERE idProduto = ?", p.getIdProduto());
	}
	
}
