package controle.inicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.TelaInicial;

public class TelaInicialControle {
	private TelaInicial ti;
	public TelaInicialControle() {
		ti = new TelaInicial();
		ti.setVisible(true);
		listeners();
	}
	private class InicialListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btCliente":
//				CompraControle cc = new CompraControle(); //A Fazer
				break;
			case "btLogin":
				ti.dispose();
				new LoginControle();
				break;
			default:
				//Mensagem de erro
				break;
			}
		}
	}
	
	private void listeners() {
		ti.addInicialListener(new InicialListner());
	}
}
