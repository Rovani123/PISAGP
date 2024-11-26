package controle.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.Funcionário.TelaAlteracaoP;

public class AlteracaoPControle {
	private TelaAlteracaoP viewP;
	
	public AlteracaoPControle(){
		
		
		configurarListeners();
	}

	private void configurarListeners() {
		viewP.addAlteracaoPListener(new  AlterarPListener());
	}
	
	private class AlterarPListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if ("btLimpa1".equals(e.getActionCommand())) {
				limparCampos();
			}
			else if ("btLimpa2".equals(e.getActionCommand())) {
				limparCampos();
			}
			else if("btLimpa3".equals(e.getActionCommand())) {
				limparCampos();
			}
			else if ("btSalvar".equals(e.getActionCommand())) {
				salvarP;
			}
			else if ("btCancelar".equals(e.getActionCommand())) {
				cancelarP;
			}
		}

	}

}
