package modelo.tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelo.classes.Funcionario;

public class FuncionariosTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	ArrayList<Funcionario> lista;
	String[] colunas = new String[] {"Usuário do Funcionário","Nome do funcionario", };

	public String getColumnName(int column) {
		return colunas[column];
	}
	public FuncionariosTableModel(ArrayList<Funcionario> lista) {
		this.lista = lista;
	}

	public int getRowCount() {
		return lista.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}
	
	public Funcionario getItem(int i) {
		return lista.get(i);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
	
		Funcionario p = lista.get(rowIndex);
		
		switch (columnIndex) {
		case 0: {
			return p.getUsuarioFuncionario();
		}
		case 1:
			return p.getNome();
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

}
