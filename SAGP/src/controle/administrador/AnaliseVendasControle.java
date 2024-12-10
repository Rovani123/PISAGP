package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import modelo.classes.Funcionario;
import modelo.dao.VendaDAO;
import visao.Administrador.TelaAnáliseVendas;
import visao.Administrador.TelaCadastroF;
import visao.Administrador.VendasTableModel;

public class AnaliseVendasControle {
	private TelaAnáliseVendas view;
	private Funcionario f;
	
	public AnaliseVendasControle (Funcionario f) {
		this.f =f;
		view = new TelaAnáliseVendas(f);
		view.setVisible(true);
		listeners();
		teste();
	}

	private void teste() {
		System.out.println(new VendaDAO().getVendas());
	}

	private class AnaliseVendas implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	
	private void listeners() {
		view.addAnaliseVendas(new AnaliseVendas());
		view.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				carregarDados();
			}
		});		
	}
	
	private void carregarDados() {
		VendasTableModel model = new VendasTableModel(new VendaDAO().getVendas());
//		view.setTabela(model);
	}
}