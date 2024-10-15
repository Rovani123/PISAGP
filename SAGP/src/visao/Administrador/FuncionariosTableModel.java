package visao.Administrador;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.classes.Funcionario;
import modelo.classes.Produto;

public class FuncionariosTableModel extends AbstractTableModel{
	ArrayList<Funcionario> lista;
	String[] colunas = new String[] { "Nome do funcionario", "Usuário do Funcionário", "senha"};

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
	
	protected Funcionario getItem(int i) {
		return lista.get(i);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
	
		Funcionario p = lista.get(rowIndex);
		
		switch (columnIndex) {
		case 0: {
			
			return p.getNome();
		}
		case 1:
			return p.getUsuarioFuncionario();
		case 2:
			return p.getSenha();
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

}
