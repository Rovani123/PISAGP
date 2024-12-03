package teste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.FuncionarioControle;
import modelo.classes.Carrinho;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.TelaInicial;
import visao.Administrador.FuncionariosTableModel;
import visao.Administrador.TelaAlteracaoF;
import visao.Administrador.TelaAnáliseVendas;
import visao.Administrador.TelaCadastroF;
import visao.Administrador.TelaGerenciamentoF;
import visao.Cliente.PainelProduto;
import visao.Funcionário.TelaGerenciamentoP;
import java.awt.Font;
import java.awt.FontFormatException;

public class TelaDeTes2 extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeTes2 frame = new TelaDeTes2(null,null);//MUDARRR DEPOISSSSS
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
	private ArrayList<Produto> listaProdutos;
	private ArrayList<Carrinho> listaCarrinhos = new ArrayList<Carrinho>();
	private ArrayList<Carrinho> listaCarrinhosCompra = new ArrayList<Carrinho>();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel painel;
	private JTable table;
	private JMenuItem mVoltar;
	

	public TelaDeTes2(JFrame telaA,Funcionario f) {
		
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
		
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 519);
<<<<<<< Updated upstream
		
		// inico menu
		menuBar = new JMenuBar();
		menuBar.setFont(font);
		setJMenuBar(menuBar);
		
		mTelas = new JMenu("Telas");
		mTelas.setFont(font);
		menuBar.add(mTelas);
		
		mAdm = new JMenuItem("Administrador");
		mAdm.setFont(font);
		mAdm.setEnabled(false);
		mTelas.add(mAdm);
		
		mFuncionario = new JMenuItem("Funcionário");
		mFuncionario.setFont(font);
		mFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerenciamentoP telaG = new TelaGerenciamentoP(null,f);
				dispose();
				telaG.setVisible(true);
			}
		});
		mTelas.add(mFuncionario);
		
		mOpcoes = new JMenu("Opções");
		mOpcoes.setFont(font);
		menuBar.add(mOpcoes);
		
		mAnaliseVendas = new JMenuItem("Análise de vendas");
		mAnaliseVendas.setFont(font);
		mAnaliseVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAnáliseVendas telaAV = new TelaAnáliseVendas(null,f);
				dispose();
				telaAV.setVisible(true);
			}
		});
		mOpcoes.add(mAnaliseVendas);
		
		mGFuncionarios = new JMenuItem(" Funcionarios");
		mGFuncionarios.setFont(font);
		mGFuncionarios.setEnabled(false);
		mOpcoes.add(mGFuncionarios);
		
		mVoltar = new JMenuItem("Voltar ao inicio");
		mVoltar.setFont(font);
		mVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaI = new TelaInicial();
				dispose();
				telaI.setVisible(true);
			}
		});
		menuBar.add(mVoltar);
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		//Fim do menu
=======
>>>>>>> Stashed changes
	
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new BorderLayout(0, 0));
		
		JPanel BarraLateral = new JPanel();
		BarraLateral.setBackground(new Color(167, 208, 214));
		painel.add(BarraLateral, BorderLayout.WEST);
		BarraLateral.setLayout(new MigLayout("", "[]", "[][grow 50][][][grow 50][][][][][grow 50][grow][][grow][]"));
		
		JButton btVoltar = new RoundButton("Sair");
		btVoltar.setBackground(new Color(245, 245, 245));
		btVoltar.setIcon(new ImageIcon(TelaDeTes2.class.getResource("/Imagem/volte.png")));
		btVoltar.setText("");
		btVoltar.setActionCommand("btVoltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				btVoltar.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					TelaInicial telaI = new TelaInicial();
//					dispose();
//					telaI.setVisible(true);
//				}
//			}); 
			}
		});
		BarraLateral.add(btVoltar, "cell 0 0");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaDeTes2.class.getResource("/Imagem/Logo.png")));
		BarraLateral.add(lblLogo, "cell 0 3,alignx left,aligny center");
		
		JLabel lblIconAlterar = new JLabel("");
		lblIconAlterar.setIcon(new ImageIcon(TelaDeTes2.class.getResource("/Imagem/biscoitos.png")));
		BarraLateral.add(lblIconAlterar, "flowx,cell 0 6,alignx left,aligny center");
		
		JLabel lblIconRemover = new JLabel("");
		lblIconRemover.setIcon(new ImageIcon(TelaDeTes2.class.getResource("/Imagem/bolinho.png")));
		BarraLateral.add(lblIconRemover, "flowx,cell 0 7");
		
		JLabel lblIconAdicionar = new JLabel("");
		lblIconAdicionar.setIcon(new ImageIcon(TelaDeTes2.class.getResource("/Imagem/garrafa-de-agua.png")));
		BarraLateral.add(lblIconAdicionar, "flowx,cell 0 8");
		
		btBebidas = new RoundButton("Bebidas");
		btBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btBebidas.setFont(new Font("Dialog", Font.PLAIN, 20));
		btBebidas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btBebidas.setText("Bebidas");
		btBebidas.setForeground(new Color(245, 245, 245));
		btBebidas.setBackground(new Color(224, 83, 76));
		btBebidas.setActionCommand("btBebidas");
//		btBebidas.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			getProdutosFiltro(Categoria.categoriaString("bebidas"));
//		}
//	});
		
		BarraLateral.add(btBebidas, "cell 0 8,growx,aligny center");
		
		btDoces = new RoundButton("Doce");
		btDoces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btDoces.setFont(new Font("Dialog", Font.PLAIN, 20));
		btDoces.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btDoces.setText("Doces");
		btDoces.setActionCommand("btDoces");
//		btDoces.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			getProdutosFiltro(Categoria.categoriaString("doces"));
//		}
//	});
		
		btDoces.setForeground(new Color(245, 245, 245));
		btDoces.setBackground(new Color(224, 83, 76));
		BarraLateral.add(btDoces, "cell 0 7,growx,aligny center");
		
		btSalgados = new RoundButton("Salgado");
		btSalgados.setText("Salgados");
		btSalgados.setForeground(new Color(245, 245, 245));
		btSalgados.setBackground(new Color(224, 83, 76));
		btSalgados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btSalgados.setFont(new Font("Dialog", Font.PLAIN, 20));
		btSalgados.setActionCommand("btSalgados");
//        btSalgados.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				getProdutosFiltro(Categoria.categoriaString("salgados"));
//
//			}
//		});
		BarraLateral.add(btSalgados, "cell 0 6,growx,aligny center");
		
		JButton btCarrinho = new RoundButton("Carrinho");
		btCarrinho.setForeground(new Color(0, 0, 0));
		btCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btCarrinho.setBackground(new Color(245, 245, 245));
		btCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btCarrinho.setIcon(new ImageIcon(TelaDeTes2.class.getResource("/Imagem/carrinho-de-compras.png")));
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
		txtPesquisa.setForeground(new Color(230, 230, 230));
		txtPesquisa.setText("Pesquisar");
		txtPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPesquisa.add(txtPesquisa, "flowx,cell 0 0 22 1,grow");
		txtPesquisa.setColumns(10);
		
		JButton btPesquisar = new RoundButton("");
		btPesquisar.setBackground(new Color(230, 230, 230));
		btPesquisar.setText("");
		btPesquisar.setActionCommand("btPesquisar");
		painelPrincipal.add(btPesquisar, "cell 13 0");
		btPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btPesquisar.setIcon(new ImageIcon(TelaDeTes2.class.getResource("/Imagem/lupa.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
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



	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
