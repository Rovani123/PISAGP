package teste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.classes.Funcionario;

import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.Funcionário.ProdutosTableModel;

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

public class TesteDaniela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTable table;
	private RoundButton btVoltar;
	private RoundButton btSalgados;
	private RoundButton btDoces;
	private RoundButton btBebidas;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteDaniela frame = new TesteDaniela(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TesteDaniela(Funcionario f) {
		
		Font font = new Font("Tahoma", Font.PLAIN, 11);;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Poppins-SemiBold.ttf"));
			
			font = font.deriveFont(Font.PLAIN, 11); // Definir o tamanho da fonte
				
		} catch (FontFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
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

		btVoltar.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/volte.png")));
		barraLateral.add(btVoltar, "cell 0 0,alignx left,aligny top");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/LogoPequena.png")));
		barraLateral.add(lblLogo, "cell 0 2,alignx center,aligny center");
		
		JLabel lblIconSalgados = new JLabel("");
		lblIconSalgados.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/biscoitos.png")));
		barraLateral.add(lblIconSalgados, "flowx,cell 0 5");
		
		btSalgados = new RoundButton("Salgados");
		btSalgados.setForeground(new Color(245, 245, 245));
		btSalgados.setFont(font);
		btSalgados.setBackground(new Color(224, 83, 76));
		barraLateral.add(btSalgados, "cell 0 5,growx,aligny center");
		btSalgados.setActionCommand("btSalgados");
		
		JLabel lblIconDoces = new JLabel("");
		lblIconDoces.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/bolinho.png")));
		barraLateral.add(lblIconDoces, "flowx,cell 0 6");
		
		btDoces = new RoundButton("Doces");
		btDoces.setForeground(new Color(245, 245, 245));
		btDoces.setFont(font);
		btDoces.setBackground(new Color(224, 83, 76));
		barraLateral.add(btDoces, "cell 0 6,growx,aligny center");
		btDoces.setActionCommand("btDoces");
		
		JLabel lblIconBebidas = new JLabel("");
		lblIconBebidas.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/garrafa-de-agua.png")));
		barraLateral.add(lblIconBebidas, "flowx,cell 0 7");
		
	    btBebidas = new RoundButton("Bebidas");
	    btBebidas.setForeground(new Color(245, 245, 245));
		btBebidas.setFont(font);
		btBebidas.setBackground(new Color(224, 83, 76));
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
		
		JLabel lblIconEstoque = new JLabel("Carrinho");
		lblIconEstoque.setFont(font);
		//lblIconEstoque.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelPesquisa.add(lblIconEstoque, "cell 0 0 3 1,alignx right,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		painelPrincipal.add(scrollPane, "cell 0 1 1 2,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Total à pagar:");
		lblNewLabel.setFont(font);
		painelPrincipal.add(lblNewLabel, "flowx,cell 0 3,alignx right");
		
		JLabel lblTotalPagar = new JLabel("New label");
		painelPrincipal.add(lblTotalPagar, "cell 0 3");
		
		JButton btnNewButton = new JButton("Finalizar compra!");
		btnNewButton.setBackground(new Color(224, 83, 76));
		btnNewButton.setFont(font);
		painelPrincipal.add(btnNewButton, "cell 0 3,alignx right");

		
	}
	
	public void addGerenciamentoPListner(ActionListener listener) {
		btSalgados.addActionListener(listener);
		btDoces.addActionListener(listener);
		btBebidas.addActionListener(listener);
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