package visao.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.classes.Carrinho;
import modelo.classes.Funcionario;
import modelo.tableModel.ProdutosTableModel;

import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class TelaClienteCarrinhoCorreto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel painelProdutos;
	private JLabel lblTotalPagar;
	private RoundButton btSair;
	private RoundButton btSalgados;
	private RoundButton btDoces;
	private RoundButton btBebidas;
	private RoundButton btFinalizarCompra;
	
	public TelaClienteCarrinhoCorreto(Funcionario f,ArrayList<Carrinho> listaCarrinhos) {
		setTitle("Tela de Carrinho");
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 544);
		
		panel = new JPanel();
		panel.setBackground(new Color(230, 230, 230));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel barraLateral = new JPanel();
		barraLateral.setBackground(new Color(167, 208, 214));
		panel.add(barraLateral, BorderLayout.WEST);
		barraLateral.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][][][][]"));
		
	    btSair = new RoundButton("Voltar");
	    btSair.setFont(new Font("Arial", Font.PLAIN, 15));
		btSair.setBackground(new Color(245, 245, 245));
		btSair.setText("Sair");
		btSair.setActionCommand("btVoltar");

		btSair.setIcon(new ImageIcon(TelaClienteCarrinhoCorreto.class.getResource("/Imagem/volte.png")));
		barraLateral.add(btSair, "cell 0 0,alignx left,aligny top");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaClienteCarrinhoCorreto.class.getResource("/Imagem/Logo.png")));
		barraLateral.add(lblLogo, "cell 0 2,alignx center,aligny center");
		
		JLabel lblIconSalgados = new JLabel("");
		lblIconSalgados.setIcon(new ImageIcon(TelaClienteCarrinhoCorreto.class.getResource("/Imagem/biscoitos.png")));
		barraLateral.add(lblIconSalgados, "flowx,cell 0 5");
		
		btSalgados = new RoundButton("Salgados");
		btSalgados.setFont(new Font("Arial", Font.PLAIN, 15));
		btSalgados.setForeground(new Color(0, 0, 0));
		btSalgados.setBackground(new Color(245, 245, 245));
		barraLateral.add(btSalgados, "cell 0 5,growx,aligny center");
		btSalgados.setActionCommand("btSalgados");
		
		JLabel lblIconDoces = new JLabel("");
		lblIconDoces.setIcon(new ImageIcon(TelaClienteCarrinhoCorreto.class.getResource("/Imagem/bolinho.png")));
		barraLateral.add(lblIconDoces, "flowx,cell 0 6");
		
		btDoces = new RoundButton("Doces");
		btDoces.setFont(new Font("Arial", Font.PLAIN, 15));
		btDoces.setForeground(new Color(0, 0, 0));
		btDoces.setBackground(new Color(245, 245, 245));
		barraLateral.add(btDoces, "cell 0 6,growx,aligny center");
		btDoces.setActionCommand("btDoces");
		
		JLabel lblIconBebidas = new JLabel("");
		lblIconBebidas.setIcon(new ImageIcon(TelaClienteCarrinhoCorreto.class.getResource("/Imagem/garrafa-de-agua.png")));
		barraLateral.add(lblIconBebidas, "flowx,cell 0 7");
		
	    btBebidas = new RoundButton("Bebidas");
	    btBebidas.setFont(new Font("Arial", Font.PLAIN, 15));
	    btBebidas.setForeground(new Color(0, 0, 0));
		btBebidas.setBackground(new Color(245, 245, 245));
		barraLateral.add(btBebidas, "cell 0 7,growx,aligny center");
		btBebidas.setActionCommand("btBebidas");
		
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(230, 230, 230));
		panel.add(painelPrincipal, BorderLayout.CENTER);
		painelPrincipal.setLayout(new MigLayout("", "[grow]", "[][][grow][]"));
		
		JPanel panelPesquisa = new JPanel();
		panelPesquisa.setBackground(new Color(230, 230, 230));
		painelPrincipal.add(panelPesquisa, "cell 0 0,grow");
		panelPesquisa.setLayout(new MigLayout("", "[][][][grow]", "[]"));
		
		RoundButton btNO = new RoundButton("");
		btNO.setBackground(new Color(245, 245, 245));
		//btNO.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
			//}
		//});
		btNO.setIcon(new ImageIcon(TelaClienteCarrinhoCorreto.class.getResource("/Imagem/carrinho-de-compras.png")));
		panelPesquisa.add(btNO, "cell 0 0");
		
		JLabel lblCarrinho = new JLabel("Carrinho:");
		lblCarrinho.setFont(new Font("Arial", Font.PLAIN, 16));
		panelPesquisa.add(lblCarrinho, "cell 1 0");
		
		JScrollPane scrollPane = new JScrollPane();
		painelPrincipal.add(scrollPane, "cell 0 1 1 2,grow");
		
		painelProdutos = new JPanel();
		scrollPane.setViewportView(painelProdutos);
		
		JLabel lblTotal = new JLabel("Total à pagar:");
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 16));
		painelPrincipal.add(lblTotal, "flowx,cell 0 3,alignx right");
		
		lblTotalPagar = new JLabel("R$:");
		lblTotalPagar.setFont(new Font("Arial", Font.PLAIN, 15));
		painelPrincipal.add(lblTotalPagar, "cell 0 3");
		
		btFinalizarCompra = new RoundButton("Finalizar compra!");
		btFinalizarCompra.setFont(new Font("Arial", Font.PLAIN, 15));
		btFinalizarCompra.setBackground(new Color(224, 83, 76));
		btFinalizarCompra.setActionCommand("btFinalizarCompra");
		painelPrincipal.add(btFinalizarCompra, "cell 0 3,alignx right");

		
	}
	
	public void addCarrinhoListeners(ActionListener listener) {
		btSair.addActionListener(listener);
		btSalgados.addActionListener(listener);
		btDoces.addActionListener(listener);
		btBebidas.addActionListener(listener);
		btFinalizarCompra.addActionListener(listener);
	}
	
	public void addPainelProdutos(PainelProduto pp, int l, int c) {
		painelProdutos.add(pp, "cell " + l + " " + c);
	}
	
	public void setLblValorTotal(String s) {
		lblTotalPagar.setText(s);
	}
	

	public void setBackgroundcolor(String botao, Color color) {
		switch (botao) {
		case "btSalgados":
			btSalgados.setBackground(color);
			break;
		case "btDoces":
			btDoces.setBackground(color);
			break;
		case "btBebidas":
			btBebidas.setBackground(color);
			break;
		}
	}
}