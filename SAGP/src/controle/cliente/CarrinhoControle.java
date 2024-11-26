package controle.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.classes.Carrinho;
import visao.Cliente.TelaClienteCarrinho;

public class CarrinhoControle {
	TelaClienteCarrinho tcc;
	public CarrinhoControle(ArrayList<Carrinho> listaCarrinhosCompra) {
		tcc = new TelaClienteCarrinho(listaCarrinhosCompra);
		tcc.setVisible(true);
		listeners();
	}
	private class CarrinhoListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	private void listeners() {
		tcc.addCarrinhoListeners(new CarrinhoListeners());
		
	}
}
