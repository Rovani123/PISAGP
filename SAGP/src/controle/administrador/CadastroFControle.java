package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.classes.Funcionario;
import visao.Administrador.TelaAlteracaoF;
import visao.Administrador.TelaCadastroF;

public class CadastroFControle {
	private TelaCadastroF tcf;
	private Funcionario f;
	
	public CadastroFControle (Funcionario f) {
		this.f =f;
		tcf = new TelaCadastroF(f);
		tcf.setVisible(true);
		listeners();
	}

	private class CadastroF implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	
	private void listeners() {
		
			
	}
}