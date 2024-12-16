package modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import modelo.classes.Vendas;

public class VendasTableModel extends AbstractTableModel{
	ArrayList<Vendas> lista;
	String[] colunas = new String[] {"idVenda","Funcionario", "metodoPagamento", "Total"};

	public String getColumnName(int column) {
		return colunas[column];
	}
	public VendasTableModel(ArrayList<Vendas> lista) {
		this.lista = lista;
	}

	public int getRowCount() {
		return lista.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}
	
	public Vendas getItem(int i) {
		return lista.get(i);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
	
		Vendas v = lista.get(rowIndex);
		
		switch (columnIndex) {
		case 0: 
			return v.getIdVenda();
		case 1:
			return v.getFuncionario().getNome();
		case 2:
			return v.getMetodoPagamento();
		case 3:
			return v.getTotal();
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

}
