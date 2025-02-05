package visao.Cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import modelo.classes.Funcionario;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

public class TelaCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtPesquisa;
	private RoundButton btCarrinho;
	private RoundButton btSair;
	private RoundButton btSalgados;
	private RoundButton btDoces;
	private RoundButton btBebidas;
	private JPanel painelProdutos;
	private JPanel painel;
	private RoundButton btPesquisar;

	public TelaCompra(Funcionario f) {
		setTitle("Tela de Compra");
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 519);
		setMinimumSize(new Dimension(1920,1080));
		
		
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new BorderLayout(0, 0));
		
		JPanel BarraLateral = new JPanel();
		BarraLateral.setBackground(new Color(167, 208, 214));
		painel.add(BarraLateral, BorderLayout.WEST);
		BarraLateral.setLayout(new MigLayout("", "[]", "[][grow 50][][][grow 50][][][][][grow 50][grow][][grow][]"));
		
		btSair = new RoundButton("Sair");
		btSair.setFont(new Font("Arial", Font.PLAIN, 16));
		btSair.setBackground(new Color(245, 245, 245));
		btSair.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/volte.png")));
		btSair.setActionCommand("btSair");
		BarraLateral.add(btSair, "cell 0 0");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(167, 208, 214));
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
		btBebidas.setActionCommand("btBebidas");
		btBebidas.setFont(new Font("Arial", Font.PLAIN, 16));
		btBebidas.setText("Bebidas");
		btBebidas.setForeground(new Color(0, 0, 0));
		btBebidas.setBackground(new Color(245, 245, 245));
		BarraLateral.add(btBebidas, "cell 0 8,growx,aligny center");
		
		btDoces = new RoundButton("Doce");
		btDoces.setActionCommand("btDoces");
		btDoces.setFont(new Font("Arial", Font.PLAIN, 16));
		btDoces.setText("Doces");
		btDoces.setForeground(new Color(0, 0, 0));
		btDoces.setBackground(new Color(245, 245, 245));
		BarraLateral.add(btDoces, "cell 0 7,growx,aligny center");
		
		btSalgados = new RoundButton("Salgado");
		btSalgados.setActionCommand("btSalgados");
		btSalgados.setText("Salgados");
		btSalgados.setForeground(new Color(0, 0, 0));
		btSalgados.setBackground(new Color(245, 245, 245));
		btSalgados.setFont(new Font("Arial", Font.PLAIN, 16));
		BarraLateral.add(btSalgados, "cell 0 6,growx,aligny center");
		
		btCarrinho = new RoundButton("Carrinho");
		btCarrinho.setFont(new Font("Arial", Font.PLAIN, 16));
		btCarrinho.setActionCommand("btCarrinho");
		btCarrinho.setForeground(new Color(0, 0, 0));
		btCarrinho.setBackground(new Color(245, 245, 245));
		btCarrinho.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/carrinho-de-compras.png")));
		BarraLateral.add(btCarrinho, "cell 0 10,growx,aligny center");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 230));
		painel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPesquisa = new JPanel();
		panelPesquisa.setBackground(new Color(230, 230, 230));
		panel_2.add(panelPesquisa, BorderLayout.NORTH);
		panelPesquisa.setLayout(new MigLayout("", "[][][][grow][][][][][][][][][][][][][][][][][][][1px][]", "[][1px]"));
		
		txtPesquisa = new JTextField();
		txtPesquisa.setBackground(new Color(245, 245, 245));
		txtPesquisa.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPesquisa.setForeground(new Color(230, 230, 230));
		txtPesquisa.setText("Pesquisar");
		//txtPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPesquisa.add(txtPesquisa, "flowx,cell 0 0 22 1,grow");
		txtPesquisa.setColumns(10);
		
		btPesquisar = new RoundButton("");
		btPesquisar.setFont(new Font("Arial", Font.PLAIN, 16));
		btPesquisar.setBackground(new Color(245, 245, 245));
		btPesquisar.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/lupa.png")));
		btPesquisar.setActionCommand("btPesquisar");
		panelPesquisa.add(btPesquisar, "cell 23 0");
		
		JScrollPane painelCompra = new JScrollPane();
		panel_2.add(painelCompra, BorderLayout.CENTER);
		
		painelProdutos = new JPanel();
		painelProdutos.setBackground(new Color(230, 230, 230));
		painelCompra.setViewportView(painelProdutos);
		painelProdutos.setLayout(new MigLayout("", "[center]", "[]"));
	
	}
	public void  addCompraListner(ActionListener listener) {
		btSalgados.addActionListener(listener);
		btDoces.addActionListener(listener);
		btBebidas.addActionListener(listener);
		btSair.addActionListener(listener);
		btCarrinho.addActionListener(listener);
		btPesquisar.addActionListener(listener);
	}
	
	public void addPainelProdutos(PainelProduto pp, int l, int c) {
		painelProdutos.add(pp, "cell "+l+" "+c+" ");
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
	
	public void resetPainel() {
		painelProdutos.removeAll();
	}
	
	public void telaCheia() {
		setExtendedState(MAXIMIZED_BOTH);
	}
	
	public String getPeesquisa() {
		return txtPesquisa.getText();
	}
}