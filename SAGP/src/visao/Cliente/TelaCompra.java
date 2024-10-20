package visao.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.classes.Produto;
import modelo.classes.Vendas;
import modelo.dao.ProdutoDAO;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelPrincipal;
	private JTextField txtPesquisa;
	private JScrollPane scrollPane;
	private JPanel painelMenu;
	private JButton btnNewButton_1;
	private JButton btVoltar;
	private JButton btSalgados;
	private JLabel lblCategorias;
	private JButton btDoces;
	private JButton btBebidas;
	private JButton btOfertas;
	private JPanel painelProdutos;
	private JLabel lblLogo;
	private ArrayList<Produto> listaProdutos;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCompra frame = new TelaCompra();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCompra() {
		ProdutoDAO pdao = new ProdutoDAO();
		listaProdutos = pdao.getProdutos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 625);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(new MigLayout("", "[][grow][][][grow][][][][][][][][grow][]", "[grow][][grow][][][][][][][][][][][][][][][]"));
		
		txtPesquisa = new JTextField();
		txtPesquisa.setForeground(new Color(230, 230, 230));
		txtPesquisa.setText("Pesquisar");
		painelPrincipal.add(txtPesquisa, "cell 1 0 12 1,growx");
		txtPesquisa.setColumns(10);
		
		RoundButton btPesquisar = new RoundButton("Pesquisar");
		btPesquisar.setForeground(new Color(245, 245, 245));
		btPesquisar.setBackground(new Color(0, 0, 0));
		btPesquisar.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/lupa.png")));
		btPesquisar.setText("");
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		painelPrincipal.add(btPesquisar, "cell 13 0");
		
		painelMenu = new JPanel();
		painelMenu.setBackground(new Color(167, 208, 214));
		painelPrincipal.add(painelMenu, "cell 0 0 1 18,alignx left,growy");
		painelMenu.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][][][][][][][][]"));
		
		btVoltar = new RoundButton("Sair");
		btVoltar.setBackground(new Color(0, 0, 0));
		btVoltar.setForeground(new Color(245, 245, 245));
		btVoltar.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/volte.png")));
		btVoltar.setText("");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		painelMenu.add(btVoltar, "cell 1 0");
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/LogoPequena.png")));
		painelMenu.add(lblLogo, "cell 0 2 2 1");
		
		lblCategorias = new JLabel("Categorias:");
		painelMenu.add(lblCategorias, "cell 0 5 2 1,alignx left");
		
		btSalgados = new RoundButton("Salgado");
		btSalgados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/biscoitos.png")));
		painelMenu.add(lblNewLabel, "cell 0 6,alignx center");
		painelMenu.add(btSalgados, "cell 1 6,alignx left");
		
		btDoces = new RoundButton("Doce");
		btDoces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/bolinho.png")));
		painelMenu.add(lblNewLabel_1, "cell 0 7,alignx center");
		painelMenu.add(btDoces, "cell 1 7,alignx left");
		
		btBebidas = new RoundButton("Bebidas");
		btBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/garrafa-de-agua.png")));
		painelMenu.add(lblNewLabel_2, "cell 0 8,alignx center");
		painelMenu.add(btBebidas, "cell 1 8,alignx left");
		
		btOfertas = new RoundButton("Ofertas");
		btOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		lblNewLabel_3 = new JLabel("Icone");
		painelMenu.add(lblNewLabel_3, "cell 0 9");
		painelMenu.add(btOfertas, "cell 1 9,alignx left");
		
		btnNewButton_1 = new RoundButton("Carrinho");
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		btnNewButton_1.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/carrinho-de-compras.png")));
		btnNewButton_1.setText("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		painelMenu.add(btnNewButton_1, "cell 1 15,alignx center");
		
		scrollPane = new JScrollPane();
		painelPrincipal.add(scrollPane, "cell 1 1 13 17,grow");
		
		painelProdutos = new JPanel();
		scrollPane.setViewportView(painelProdutos);
		painelProdutos.setLayout(new MigLayout("", "[]", "[]"));
		int c =0;
		int l=0;
		for (Produto produto : listaProdutos) {
			PainelProduto pp = new PainelProduto(produto);
			painelProdutos.add(pp,"cell "+l+" "+c);
			l++;
			if(l%3==0)
			{
				c++;
				l=0;
			}
								
		}
		criarVendas();
	}
	private void criarVendas() {
		Vendas venda = new Vendas();
		

	}
}
