package visao.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	private JTable table;
	private RoundButton btVoltar;
	private RoundButton btSalgados;
	private RoundButton btDoces;
	private RoundButton btBebidas;
	private RoundButton btFinalizarCompra;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteCarrinhoCorreto frame = new TelaClienteCarrinhoCorreto(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaClienteCarrinhoCorreto(Funcionario f) {
		
		Font font = new Font("Tahoma", Font.PLAIN, 11);;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Poppins-SemiBold.ttf"));
			
			font = font.deriveFont(Font.PLAIN, 11); // Definir o tamanho da fonte
				
		} catch (FontFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 544);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel barraLateral = new JPanel();
		barraLateral.setBackground(new Color(167, 208, 214));
		panel.add(barraLateral, BorderLayout.WEST);
		barraLateral.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][][][][]"));
		
	    btVoltar = new RoundButton("Voltar");
	    btVoltar.setFont(font);
		btVoltar.setBackground(new Color(245, 245, 245));
		btVoltar.setText("Sair");
		btVoltar.setActionCommand("btVoltar");

		btVoltar.setIcon(new ImageIcon(TelaClienteCarrinhoCorreto.class.getResource("/Imagem/volte.png")));
		barraLateral.add(btVoltar, "cell 0 0,alignx left,aligny top");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaClienteCarrinhoCorreto.class.getResource("/Imagem/LogoPequena.png")));
		barraLateral.add(lblLogo, "cell 0 2,alignx center,aligny center");
		
		JLabel lblIconSalgados = new JLabel("");
		lblIconSalgados.setIcon(new ImageIcon(TelaClienteCarrinhoCorreto.class.getResource("/Imagem/biscoitos.png")));
		barraLateral.add(lblIconSalgados, "flowx,cell 0 5");
		
		btSalgados = new RoundButton("Salgados");
		btSalgados.setForeground(new Color(0, 0, 0));
		btSalgados.setFont(font);
		btSalgados.setBackground(new Color(245, 245, 245));
		barraLateral.add(btSalgados, "cell 0 5,growx,aligny center");
		btSalgados.setActionCommand("btSalgados");
		
		JLabel lblIconDoces = new JLabel("");
		lblIconDoces.setIcon(new ImageIcon(TelaClienteCarrinhoCorreto.class.getResource("/Imagem/bolinho.png")));
		barraLateral.add(lblIconDoces, "flowx,cell 0 6");
		
		btDoces = new RoundButton("Doces");
		btDoces.setForeground(new Color(0, 0, 0));
		btDoces.setFont(font);
		btDoces.setBackground(new Color(245, 245, 245));
		barraLateral.add(btDoces, "cell 0 6,growx,aligny center");
		btDoces.setActionCommand("btDoces");
		
		JLabel lblIconBebidas = new JLabel("");
		lblIconBebidas.setIcon(new ImageIcon(TelaClienteCarrinhoCorreto.class.getResource("/Imagem/garrafa-de-agua.png")));
		barraLateral.add(lblIconBebidas, "flowx,cell 0 7");
		
	    btBebidas = new RoundButton("Bebidas");
	    btBebidas.setForeground(new Color(0, 0, 0));
		btBebidas.setFont(font);
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
		panelPesquisa.add(lblCarrinho, "cell 1 0");
		
		JScrollPane scrollPane = new JScrollPane();
		painelPrincipal.add(scrollPane, "cell 0 1 1 2,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblTotal = new JLabel("Total à pagar:");
		lblTotal.setFont(font);
		painelPrincipal.add(lblTotal, "flowx,cell 0 3,alignx right");
		
		JLabel lblTotalPagar = new JLabel("New label");
		painelPrincipal.add(lblTotalPagar, "cell 0 3");
		
		RoundButton btFinalizarCompra = new RoundButton("Finalizar compra!");
		btFinalizarCompra.setBackground(new Color(224, 83, 76));
		btFinalizarCompra.setFont(font);
		btFinalizarCompra.setActionCommand("btFinalizarCompra");
		painelPrincipal.add(btFinalizarCompra, "cell 0 3,alignx right");

		
	}
	
	public void addGerenciamentoPListner(ActionListener listener) {
		btSalgados.addActionListener(listener);
		btDoces.addActionListener(listener);
		btBebidas.addActionListener(listener);
		btFinalizarCompra.addActionListener(listener);
		btVoltar.addActionListener(listener);
	}
	
	public void setTabela(ProdutosTableModel tm) {
		table.setModel(tm);
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