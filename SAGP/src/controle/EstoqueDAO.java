package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import dal.ConexaoBD;

public class EstoqueDAO {

	public DefaultTableModel visualizarTabela(String categoria) {
		
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"nomeProduto","preco","quantidadeEstoque","categoria"
				}
			);
		
		Statement stml = null;
		Connection conn = ConexaoBD.getConexaoMySQL();
		
		try {
			stml = (Statement) conn.createStatement();
			ResultSet resl = null;
			resl = stml.executeQuery("SELECT * FROM PRODUTOS");
			while(resl.next())
			{
				
				if (resl.getString("categoria").equals(categoria)) {
					
				
				tableModel.addRow(new Object[] {resl.getString("nomeProduto"),resl.getFloat("preco"),resl.getInt("quantidadeEstoque"),resl.getString("categoria")});
				
				}
			}
			resl.close();
			stml.close();
			conn.close();
			return tableModel;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
