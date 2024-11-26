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
		viewP.addAlteracaoPListener(new LoginListener());
		
	}
	
	private class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if ("btLimpa1".equals(e.getActionCommand())) {
				LimparCampos();
			}
			else if ("btLimpa2".equals(e.getActionCommand())) {
				LimparCampo();
			}
			else if("btLimpa3".equals(e.getActionCommand())) {}
		}
	}

}
