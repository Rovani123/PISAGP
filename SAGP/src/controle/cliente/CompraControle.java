package controle.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controle.inicio.TelaInicialControle;
import visao.Cliente.TelaCompra;

public class CompraControle {
	private TelaCompra tc;
	public CompraControle() {
		tc = new TelaCompra();
		tc.setVisible(true);
		listeners();
	}

	private class CompraListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btVoltar":
				tc.dispose();
				new TelaInicialControle();
				break;
			}
		}
	}
	
	private void listeners() {
		tc.addCompraListner(new CompraListeners());
	}
}
