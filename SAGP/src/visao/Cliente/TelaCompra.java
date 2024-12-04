package visao.Cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import modelo.classes.Carrinho;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import java.awt.Font;
import java.awt.FontFormatException;

public class TelaCompra extends JFrame {
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCompra frame = new TelaCompra(null);//MUDARRR DEPOISSSSS
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static final long serialVersionUID = 1L;
	private JPanel panel_2;
	private JButton btPesquisar;
	private JPanel panelPesquisa;
	private JTextField txtPesquisa;
	private JScrollPane scrollPane;
	private JButton btCarrinho;
	private JButton btVoltar;
	private JButton btSalgados;
	private JButton btDoces;
	private JButton btBebidas;
	private JPanel painelProdutos;
	private JLabel lblLogo;
	private JPanel painel;

	public TelaCompra(Funcionario f) {
		
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
		setBounds(100, 100, 824, 519);
	
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new BorderLayout(0, 0));
		
		JPanel BarraLateral = new JPanel();
		BarraLateral.setBackground(new Color(167, 208, 214));
		painel.add(BarraLateral, BorderLayout.WEST);
		BarraLateral.setLayout(new MigLayout("", "[]", "[][grow 50][][][grow 50][][][][][grow 50][grow][][grow][]"));
		
		btVoltar = new RoundButton("Sair");
		btVoltar.setBackground(new Color(245, 245, 245));
		btVoltar.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/volte.png")));
		btVoltar.setActionCommand("btVoltar");
		BarraLateral.add(btVoltar, "cell 0 0");
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/Logo.png")));
		BarraLateral.add(lblLogo, "cell 0 3,alignx left,aligny center");
		
		JLabel lblIconAlterar = new JLabel("");
		lblIconAlterar.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/biscoitos.png")));
		BarraLateral.add(lblIconAlterar, "flowx,cell 0 6,alignx left,aligny center");
		
		JLabel lblIconRemover = new JLabel("");
		lblIconRemover.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/bolinho.png")));
		BarraLateral.add(lblIconRemover, "flowx,cell 0 7");
		
		JLabel lblIconAdicionar = new JLabel("");
		lblIconAdicionar.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/garrafa-de-agua.png")));
		BarraLateral.add(lblIconAdicionar, "flowx,cell 0 8");
		
		btBebidas = new RoundButton("Bebidas");
		btBebidas.setFont(new Font("Dialog", Font.PLAIN, 20));
		btBebidas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btBebidas.setText("Bebidas");
		btBebidas.setForeground(new Color(245, 245, 245));
		btBebidas.setBackground(new Color(224, 83, 76));
		btBebidas.setActionCommand("btBebidas");
		
		BarraLateral.add(btBebidas, "cell 0 8,growx,aligny center");
		
		btDoces = new RoundButton("Doce");
		btDoces.setFont(new Font("Dialog", Font.PLAIN, 20));
		btDoces.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btDoces.setText("Doces");
		btDoces.setActionCommand("btDoces");
		
		btDoces.setForeground(new Color(245, 245, 245));
		btDoces.setBackground(new Color(224, 83, 76));
		BarraLateral.add(btDoces, "cell 0 7,growx,aligny center");
		
		btSalgados = new RoundButton("Salgado");
		btSalgados.setText("Salgados");
		btSalgados.setForeground(new Color(245, 245, 245));
		btSalgados.setBackground(new Color(224, 83, 76));
		btSalgados.setFont(new Font("Dialog", Font.PLAIN, 20));
		btSalgados.setActionCommand("btSalgados");
		BarraLateral.add(btSalgados, "cell 0 6,growx,aligny center");
		
		btCarrinho = new RoundButton("Carrinho");
		btCarrinho.setForeground(new Color(0, 0, 0));
		btCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btCarrinho.setBackground(new Color(245, 245, 245));
		btCarrinho.setActionCommand("btCarrinho");
		btCarrinho.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/carrinho-de-compras.png")));
		BarraLateral.add(btCarrinho, "cell 0 10,growx,aligny center");
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 230));
		painel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panelPesquisa = new JPanel();
		panelPesquisa.setBackground(new Color(230, 230, 230));
		panel_2.add(panelPesquisa, BorderLayout.NORTH);
		panelPesquisa.setLayout(new MigLayout("", "[][][][grow][][][][][][][][][][][][][][][][][][][1px][]", "[][1px]"));
		
		txtPesquisa = new JTextField();
		txtPesquisa.setForeground(new Color(230, 230, 230));
		txtPesquisa.setText("Pesquisar");
		txtPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPesquisa.add(txtPesquisa, "flowx,cell 0 0 22 1,grow");
		txtPesquisa.setColumns(10);
		
		btPesquisar = new JButton("");
		btPesquisar.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/lupa.png")));
		panelPesquisa.add(btPesquisar, "cell 23 0");
		
		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		painelProdutos = new JPanel();
		scrollPane.setViewportView(painelProdutos);
	}
	public void  addCompraListner(ActionListener listener) {
		btSalgados.addActionListener(listener);
		btDoces.addActionListener(listener);
		btBebidas.addActionListener(listener);
		btVoltar.addActionListener(listener);
		btCarrinho.addActionListener(listener);
	}
	
	public void addPainelProdutos(PainelProduto pp, int l, int c) {
		painelProdutos.add(pp, "cell " + l + " " + c);
	}


	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
