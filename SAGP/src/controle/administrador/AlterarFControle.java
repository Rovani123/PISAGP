package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.classes.Funcionario;
import visao.Administrador.TelaAlteracaoF;
import visao.Administrador.TelaGerenciamentoF;

public class AlterarFControle {
	private TelaAlteracaoF taf;
	private Funcionario f;
	private Funcionario fSelecionado;
	
	public AlterarFControle (Funcionario f, Funcionario fSelecionado) {
		this.fSelecionado = fSelecionado;
		this.f =f;
		taf = new TelaAlteracaoF(f);
		taf.setVisible(true);
		listeners();
	}

	private class AlterarFListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btLimpar":
				taf.dispose();
			    taf.limpa();   	
				break;
			
			case "btCancelar":
				taf.dispose();
				new GerenciamentoFControle(f);
				break;
			
			case "btSalvar":
//				A Fazer
			
			
			}
			
		}
		
	}
	
	
	private void listeners() {
		
		
	}
}
