package visao.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ProdutoControle;
import modelo.classes.Carrinho;
import modelo.classes.Produto;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaClienteCarrinho extends JFrame {
	private JPanel painelProdutos;
	private ArrayList<Carrinho> listaCarrinhosCompra;

	public TelaClienteCarrinho() {
		setBackground(new Color(230, 230, 230));
		getContentPane().setLayout(new MigLayout("", "[grow][][][][][][][grow][][][][][][][][][][][][][][][][][][]", "[grow][grow][][][][][][][][][][][][][][][][][][]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(167, 208, 214));
		getContentPane().add(panel_1, "cell 0 0 7 20,grow");
		panel_1.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/carrinho-de-compras.png")));
		getContentPane().add(btnNewButton, "cell 7 0");
		
		JLabel lblNewLabel = new JLabel("Carrinho:");
		getContentPane().add(lblNewLabel, "cell 8 0");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 7 1 19 17,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Total a pagar: ");
		getContentPane().add(lblNewLabel_1, "cell 20 18");
		
		JButton btnNewButton_1 = new JButton("Finalizar compra");
		getContentPane().add(btnNewButton_1, "cell 25 18");
		
	}

	
}
