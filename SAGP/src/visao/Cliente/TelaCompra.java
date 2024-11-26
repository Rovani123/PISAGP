package visao.Cliente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.funcionario.ProdutoControle;
import modelo.classes.Carrinho;
import modelo.classes.Produto;
import modelo.classes.Vendas;
import modelo.enumerador.Categoria;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.TelaInicial;
import java.awt.Font;
import java.awt.FontFormatException;
import javax.swing.ScrollPaneConstants;
import java.awt.ComponentOrientation;

public class TelaCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelPrincipal;
	private JTextField txtPesquisa;
	private JScrollPane scrollPane;
	private JPanel painelMenu;
	private JButton btCarrinho;
	private JButton btVoltar;
	private JButton btSalgados;
	private JLabel lblCategorias;
	private JButton btDoces;
	private JButton btBebidas;
	private JButton btOfertas;
	private JPanel painelProdutos;
	private JLabel lblLogo;
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	private ArrayList<Carrinho> listaCarrinhos = new ArrayList<Carrinho>();
	private ArrayList<Carrinho> listaCarrinhosCompra = new ArrayList<Carrinho>();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	

	public TelaCompra() {
		TelaCompra tela = this;
		
		  Font font = new Font("Tahoma", Font.PLAIN, 11);;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Poppins-SemiBold.ttf"));
			
			font = font.deriveFont(Font.PLAIN, 11); // Definir o tamanho da fonte
			

			
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 625);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(new MigLayout("", "[][grow][][][grow][][][][][][][][grow][]",
				"[grow][][grow][][][][][][][][][][][][][][][]"));

		txtPesquisa = new JTextField();
		txtPesquisa.setFont(font);
		txtPesquisa.setForeground(new Color(230, 230, 230));
		txtPesquisa.setText("Pesquisar");
		painelPrincipal.add(txtPesquisa, "cell 1 0 12 1,growx");
		txtPesquisa.setColumns(10);

		RoundButton btPesquisar = new RoundButton("Pesquisar");
		btPesquisar.setForeground(new Color(245, 245, 245));
		btPesquisar.setBackground(new Color(0, 0, 0));
		btPesquisar.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/lupa.png")));
		btPesquisar.setText("");
		btPesquisar.setActionCommand("btPesquisar");
		painelPrincipal.add(btPesquisar, "cell 13 0");

		painelMenu = new JPanel();
		painelMenu.setBackground(new Color(167, 208, 214));
		painelPrincipal.add(painelMenu, "cell 0 0 1 18,alignx left,growy");
		painelMenu.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][][][][][][][][][]"));

		btVoltar = new RoundButton("Sair");
		btVoltar.setBackground(new Color(0, 0, 0));
		btVoltar.setForeground(new Color(245, 245, 245));
		btVoltar.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/volte.png")));
		btVoltar.setText("");
		btVoltar.setActionCommand("btVoltar");
//		btVoltar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TelaInicial telaI = new TelaInicial();
//				dispose();
//				telaI.setVisible(true);
//			}
//		});
		painelMenu.add(btVoltar, "cell 1 0");

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/LogoPequena.png")));
		painelMenu.add(lblLogo, "cell 0 2 2 1");

		lblCategorias = new JLabel("Categorias:");
		lblCategorias.setFont(font);
		painelMenu.add(lblCategorias, "cell 0 5 2 1,alignx left");

		btSalgados = new RoundButton("Salgado");
		btSalgados.setFont(font);
		btSalgados.setActionCommand("btSalgados");
//        btSalgados.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				getProdutosFiltro(Categoria.categoriaString("salgados"));
//
//			}
//		});

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/biscoitos.png")));
		painelMenu.add(lblNewLabel, "cell 0 6,alignx center");
		painelMenu.add(btSalgados, "cell 1 6,alignx left");

		btDoces = new RoundButton("Doce");
		btDoces.setFont(font);
		btDoces.setActionCommand("btDoces");
//		btDoces.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				getProdutosFiltro(Categoria.categoriaString("doces"));
//			}
//		});

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/bolinho.png")));
		painelMenu.add(lblNewLabel_1, "cell 0 7,alignx center");
		painelMenu.add(btDoces, "cell 1 7,alignx left");

		btBebidas = new RoundButton("Bebidas");
		btBebidas.setFont(font);
		btBebidas.setActionCommand("btBebidas");
//		btBebidas.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				getProdutosFiltro(Categoria.categoriaString("bebidas"));
//			}
//		});

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/garrafa-de-agua.png")));
		painelMenu.add(lblNewLabel_2, "cell 0 8,alignx center");
		painelMenu.add(btBebidas, "cell 1 8,alignx left");

		btOfertas = new RoundButton("Ofertas");
		btOfertas.setFont(font);
		btOfertas.setActionCommand("btOfertas");
//		btOfertas.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/etiqueta-de-desconto.png")));
		painelMenu.add(lblNewLabel_3, "cell 0 9");
		painelMenu.add(btOfertas, "cell 1 9,alignx left");

		btCarrinho = new RoundButton("Carrinho");
		btCarrinho.setFont(font);
		btCarrinho.setBackground(new Color(224, 83, 76));
		btCarrinho.setIcon(new ImageIcon(TelaCompra.class.getResource("/Imagem/carrinho-de-compras.png")));
		btCarrinho.setText("");
		btCarrinho.setActionCommand("btCarrinho");
//		btCarrinho.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (listaCarrinhosCompra.size() == 0) {
//					for (Carrinho carrinho : listaCarrinhos) {
//						if (carrinho.getQuantidade() > 0) {
//							listaCarrinhosCompra.add(carrinho);
//
//						}
//					}
//				}
//				TelaClienteCarrinho tcc = new TelaClienteCarrinho(tela,listaCarrinhosCompra);
//				dispose();		
//				tcc.setVisible(true);
//			}
//		});
		painelMenu.add(btCarrinho, "cell 1 15,alignx center");

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		painelPrincipal.add(scrollPane, "cell 1 1 13 17,grow");

		painelProdutos = new JPanel();
		scrollPane.setRowHeaderView(painelProdutos);
		painelProdutos.setLayout(new MigLayout("", "[grow,center]", "[grow,center]"));

//		getProdutos();
	}

	public void  addCompraListner(ActionListener listener) {
		btSalgados.addActionListener(listener);
		btDoces.addActionListener(listener);
		btBebidas.addActionListener(listener);
		btOfertas.addActionListener(listener);
		btVoltar.addActionListener(listener);
		btVoltar.addActionListener(listener);
		btCarrinho.addActionListener(listener);
	}
	
	public void addPainelProdutos(PainelProduto pp, int l, int c) {
		painelProdutos.add(pp, "cell " + l + " " + c);
	}
	
//	private void getProdutos() {
//
//		painelProdutos.removeAll();
//		ProdutoControle pc = new ProdutoControle();
//		listaProdutos = pc.getProdutos();
//
//		int c = 0;
//		int l = 0;
//
//		for (Produto produto : listaProdutos) {
//
//			Carrinho carrinho = new Carrinho();
//			carrinho.setIdCarrinho(listaProdutos.indexOf(produto));
//			carrinho.setIdProduto(produto.getIdProduto());
//			carrinho.setIdVenda(-1);
//			carrinho.setQuantidade(0);
//			listaCarrinhos.add(carrinho);
//
//			PainelProduto pp = new PainelProduto(produto, carrinho);
//			painelProdutos.add(pp, "cell " + l + " " + c);
//
//			l++;
//			if (l % 3 == 0) {
//				c++;
//				l = 0;
//			}
//		}
//	}
//
//	private void getProdutosFiltro(Categoria categoria) {
//		painelProdutos.removeAll();
//		ProdutoControle pc = new ProdutoControle();
//		listaProdutos = pc.getProdutoFiltro(categoria);
//		int c = 0;
//		int l = 0;
//		for (Produto produto : listaProdutos) {
//			Carrinho ca = new Carrinho();
//			ca.setIdCarrinho(listaProdutos.indexOf(produto));
//			ca.setIdProduto(produto.getIdProduto());
//			ca.setIdVenda(-1);
//			ca.setQuantidade(0);
//			PainelProduto pp = new PainelProduto(produto, ca);
//			painelProdutos.add(pp, "cell " + l + " " + c);
//			l++;
//			if (l % 3 == 0) {
//				c++;
//				l = 0;
//			}
//		}
//	}

}
