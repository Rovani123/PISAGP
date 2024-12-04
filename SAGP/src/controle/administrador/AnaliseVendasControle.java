package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.classes.Funcionario;
import visao.Administrador.TelaAnáliseVendas;
import visao.Administrador.TelaCadastroF;

public class AnaliseVendasControle {
	private TelaAnáliseVendas tav;
	private Funcionario f;
	
	public AnaliseVendasControle (Funcionario f) {
		this.f =f;
		tav = new TelaAnáliseVendas(f);
		tav.setVisible(true);
		listeners();	
	}

	private class AnaliseVendas implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	
	private void listeners() {
		
		
	}
}