package controle.inicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controle.administrador.GerenciamentoFControle;
import controle.cliente.CompraControle;
import controle.funcionario.GerenciamentoPControle;
import modelo.classes.Funcionario;
import visao.TelaInicial;
import visaoTelasDeAviso.MensagemView;

public class TelaInicialControle {
	private TelaInicial view;
	private Funcionario f;
	public TelaInicialControle(Funcionario f) {
		this.f = f;
		view = new TelaInicial(f);
		view.setVisible(true);
		listeners();
	}
	private class InicialListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btCliente":
				view.dispose();
				new CompraControle(null); 
				break;
			case "btLogin":
				view.dispose();
					if(f.getadministrador() == 1){
						view.dispose();
						new GerenciamentoFControle(f);
					}else{
						view.dispose();
						new GerenciamentoPControle(f);
					}

				break;
			default:
				//Mensagem de erro
				break;
			}
		}
	}
	
	private void listeners() {
		view.addInicialListener(new InicialListner());
	}
}
