package modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.classes.Carrinho;
import modelo.classes.Vendas;

public class CarrinhoTableModel extends AbstractTableModel{
	ArrayList<Carrinho> lista;
	String[] colunas = new String[] {"nome do Produto","quantidade"};

	public String getColumnName(int column) {
		return colunas[column];
	}
	public CarrinhoTableModel(ArrayList<Carrinho> lista) {
		this.lista = lista;
	}

	public int getRowCount() {
		return lista.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}
	
	protected Carrinho getItem(int i) {
		return lista.get(i);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
	
		Carrinho c = lista.get(rowIndex);
		
		switch (columnIndex) {
		case 0: 
			return c.getProduto().getNomeProduto();
		case 1:
			return c.getQuantidade();
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

}
