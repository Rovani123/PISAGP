package visao.Funcionário;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.classes.Produto;

public class ProdutosTableModel extends AbstractTableModel{
	
	ArrayList<Produto> lista;
	String[] colunas = new String[] { "Nome do Produto", "preco", "quantidadeEstoque", "categoria" };

	public String getColumnName(int column) {
		return colunas[column];
	}
	public ProdutosTableModel(ArrayList<Produto> lista) {
		this.lista = lista;
	}

	public int getRowCount() {
		return lista.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}
	
	public Produto getItem(int i) {
		return lista.get(i);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
	
		Produto p = lista.get(rowIndex);
		
		switch (columnIndex) {
		case 0: {
			
			return p.getNomeProduto();
		}
		case 1:
			return p.getPreco();
		case 2:
			return p.getQuantidadeEstoque();
		case 3:
			return p.getCategoria();
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

}
