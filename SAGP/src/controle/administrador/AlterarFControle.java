package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.classes.Funcionario;
import visao.Administrador.TelaAlteracaoF;
import visao.Administrador.TelaGerenciamentoF;

public class AlterarFControle {
	private TelaAlteracaoF taf;
	private Funcionario f;
	
	public AlterarFControle (Funcionario f) {
		this.f =f;
		taf = new TelaAlteracaoF(f);
		taf.setVisible(true);
		listeners();
	}

	private class AlterarFListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	
	private void listeners() {
		
		
	}
}
