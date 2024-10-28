package visao.Funcionário;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.ProdutoControle;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.dao.ProdutoDAO;
import modelo.enumerador.Categoria;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.TelaInicial;
import visao.TelaLogin;
import visao.Administrador.TelaGerenciamentoF;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaGerenciamentoP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField txtPesquisar;
	private JTable table;
	private JMenuItem mAdm;
	private JMenuItem mFuncionario;
	private RoundButton btSalgados;
	private RoundButton btDoces;
	private RoundButton btBebidas;
	private RoundButton btOfertas;
	private int contS=0;
	private int contD=0;
	private int contB=0;

	
	public TelaGerenciamentoP(JFrame telaA,Funcionario f) {
		TelaGerenciamentoP tela= this;

		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 638);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mTelas = new JMenu("Telas");
		menuBar.add(mTelas);
		
		mAdm = new JMenuItem("Administrador ");
		mAdm.setEnabled(false);
		mAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				TelaGerenciamentoF tf = new TelaGerenciamentoF(tela,f);
				dispose();
				tf.setVisible(true);				
			}
		});
		mTelas.add(mAdm);
		
		mFuncionario = new JMenuItem("Funcionário ");
		mFuncionario.setEnabled(false);
		mTelas.add(mFuncionario);
		
		JMenu mOpcoes = new JMenu("Opções");
		menuBar.add(mOpcoes);
		
		JMenuItem mGProdutos = new JMenuItem("Produtos ");
		mGProdutos.setEnabled(false);
		mOpcoes.add(mGProdutos);
		
		JMenuItem mPromocoes = new JMenuItem("Promoções  ");
		mPromocoes.setEnabled(false);
		mPromocoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fazer telas
			}
		});
		mOpcoes.add(mPromocoes);
		
		JMenuItem mVoltar = new JMenuItem("Voltar ao início");
		mVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaI = new TelaInicial();
				dispose();
				telaI.setVisible(true);
			}
		});
		menuBar.add(mVoltar);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(
				new MigLayout("", "[grow][][][grow][][][][grow][]", "[grow][][grow][][][][][][][][][][][][][][][]"));

		JPanel barraLateral = new JPanel();
		barraLateral.setBackground(new Color(167, 208, 214));
		painel.add(barraLateral, "cell 0 0 1 18,alignx left,growy");
		barraLateral.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][][][][][][][][][]"));
		
				RoundButton btVoltar = new RoundButton("Sair");
				btVoltar.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/volte.png")));
				btVoltar.setText("");
				btVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaLogin tl = new TelaLogin(tela);
						dispose();
						tl.setVisible(true);
					}
				});
				btVoltar.setForeground(new Color(255, 255, 255));
				btVoltar.setBackground(new Color(245, 245, 245));
				barraLateral.add(btVoltar, "cell 0 0,alignx left");

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/LogoPequena.png")));
		barraLateral.add(lblLogo, "cell 0 2 2 1");

		JLabel lblCategoria = new JLabel("Categorias:");
		barraLateral.add(lblCategoria, "cell 1 4,alignx left");

		btSalgados = new RoundButton("Salgado");
		btSalgados.setText("Salgados");
		btSalgados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contS==0) {
					getProdutosFiltro(Categoria.categoriaString("salgados"));
					contS=1;
					contD=0;
					contB=0;
					btSalgados.setBackground(new Color(255, 255, 0));
					btDoces.setBackground(new Color(255, 255, 255));
					btBebidas.setBackground(new Color(255, 255, 255));
				} else {
					getProdutos();
					contS=0;
					contD=0;
					contB=0;
					btSalgados.setBackground(new Color(255, 255, 255));
					btDoces.setBackground(new Color(255, 255, 255));
					btBebidas.setBackground(new Color(255, 255, 255));
				}
			}
		});
		
		JLabel lblIconSalgados = new JLabel("");
		lblIconSalgados.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/biscoitos.png")));
		barraLateral.add(lblIconSalgados, "cell 0 5,alignx center");
		btSalgados.setBackground(new Color(255, 255, 255));
		barraLateral.add(btSalgados, "cell 1 5,growx");

		btDoces = new RoundButton("Doce");
		btDoces.setText("Doces");
		btDoces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contD==0) {
					getProdutosFiltro(Categoria.categoriaString("doces"));
					contS=0;
					contD=1;
					contB=0;
					btDoces.setBackground(new Color(255, 255, 0));
					btSalgados.setBackground(new Color(255, 255, 255));
					btBebidas.setBackground(new Color(255, 255, 255));
				} else {
					getProdutos();
					contS=0;
					contD=0;
					contB=0;
					btSalgados.setBackground(new Color(255, 255, 255));
					btDoces.setBackground(new Color(255, 255, 255));
					btBebidas.setBackground(new Color(255, 255, 255));
				}
			}
		});
		
		JLabel lblIconDoces = new JLabel("");
		lblIconDoces.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/bolinho.png")));
		barraLateral.add(lblIconDoces, "cell 0 6,alignx center");
		btDoces.setBackground(new Color(255, 255, 255));
		barraLateral.add(btDoces, "cell 1 6,growx");

		btBebidas = new RoundButton("Bebidas");
		btBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contB==0) {
					getProdutosFiltro(Categoria.categoriaString("bebidas"));
					contS=0;
					contD=0;
					contB=1;
					btDoces.setBackground(new Color(255, 255, 255));
					btSalgados.setBackground(new Color(255, 255, 255));
					btBebidas.setBackground(new Color(255, 255, 0));
				} else {
					getProdutos();
					contS=0;
					contD=0;
					contB=0;
					btSalgados.setBackground(new Color(255, 255, 255));
					btDoces.setBackground(new Color(255, 255, 255));
					btBebidas.setBackground(new Color(255, 255, 255));
				}
			}
		});
		
		JLabel lblIconBebidas = new JLabel("");
		lblIconBebidas.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/garrafa-de-agua.png")));
		barraLateral.add(lblIconBebidas, "cell 0 7,alignx center");
		btBebidas.setBackground(new Color(255, 255, 255));
		barraLateral.add(btBebidas, "cell 1 7,growx");

		btOfertas = new RoundButton("Ofertas");
		btOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//A implementar
			}
		});
		
		JLabel lblIconOfertas = new JLabel("icone");
		barraLateral.add(lblIconOfertas, "cell 0 8");
		btOfertas.setBackground(new Color(167, 208, 214));
		barraLateral.add(btOfertas, "cell 1 8,growx");

		RoundButton btCadastrar = new RoundButton("Adicionar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroP tcp = new TelaCadastroP(tela,f);
				dispose();
				tcp.setVisible(true);
			}
		});

		RoundButton btRemover = new RoundButton("Deletar");
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto p = ((ProdutosTableModel) table.getModel()).getItem(table.getSelectedRow());
				ProdutoDAO pdal = new ProdutoDAO();
				try {
					pdal.deletarProduto(p);
					JOptionPane.showMessageDialog(null, "operação realizada com sucesso");
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não é possivel remover esse produto");
				}
				getProdutos();

			}
			

		});

		RoundButton btAlterar = new RoundButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Produto p = ((ProdutosTableModel) table.getModel()).getItem(table.getSelectedRow());
					TelaAlteracaoP tap = new TelaAlteracaoP(tela, p,f);
					dispose();
					tap.setVisible(true);
				}catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Selecione um produto");
					}
				
			}
		});
		
		JLabel lblIconAlterar = new JLabel("");
		lblIconAlterar.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/troca.png")));
		barraLateral.add(lblIconAlterar, "cell 0 15,alignx center");
		btAlterar.setForeground(new Color(255, 255, 255));
		btAlterar.setBackground(new Color(0, 0, 0));
		barraLateral.add(btAlterar, "cell 1 15,alignx left");
		
		JLabel lblIconRemover = new JLabel("");
		lblIconRemover.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/lixeira.png")));
		barraLateral.add(lblIconRemover, "cell 0 16,alignx center");
		btRemover.setForeground(new Color(255, 255, 255));
		btRemover.setBackground(new Color(224, 83, 76));
		barraLateral.add(btRemover, "cell 1 16,alignx left");
		
		JLabel lblIconCadastrar = new JLabel("Adicionar");
		barraLateral.add(lblIconCadastrar, "cell 0 17");
		btCadastrar.setForeground(new Color(255, 255, 255));
		btCadastrar.setBackground(new Color(0, 0, 0));
		barraLateral.add(btCadastrar, "cell 1 17,alignx left");
		
		JLabel lblIconEstoque = new JLabel("iconeestoque");
		painel.add(lblIconEstoque, "cell 1 0");

		JLabel lblEstoque = new JLabel("Estoque");
		painel.add(lblEstoque, "cell 2 0,alignx trailing");

		txtPesquisar = new JTextField();
		painel.add(txtPesquisar, "cell 3 0 5 1,growx");
		txtPesquisar.setColumns(10);

		RoundButton btPesquisar = new RoundButton("Pesquisar");
		btPesquisar.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/lupa.png")));
		btPesquisar.setText("");
		btPesquisar.setForeground(new Color(255, 255, 255));
		btPesquisar.setBackground(new Color(245, 245, 245));
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		painel.add(btPesquisar, "cell 8 0");

		JScrollPane scrollPane = new JScrollPane();
		painel.add(scrollPane, "cell 1 2 8 16,grow");

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Coxinha de Carne", "Coxinha de Calabresa", "Coxinha de Frango", null },
						{ null, null, null, null }, },
				new String[] { "", "", "", "" }));
		scrollPane.setViewportView(table);

		getProdutos();
		menuAdm(f);
	}
	private void getProdutos() {
		ProdutoControle pc = new ProdutoControle();
		ArrayList<Produto> lista = pc.getProdutos();
	
		ProdutosTableModel model = new ProdutosTableModel (lista);
		table.setModel(model);

	}
	
	private void getProdutosFiltro(Categoria categoria) {
		ProdutoControle pc = new ProdutoControle();
		ArrayList<Produto> lista = pc.getProdutoFiltro(categoria);
	
		ProdutosTableModel model = new ProdutosTableModel (lista);
		table.setModel(model);		
	}

	private void menuAdm(Funcionario f) {
		JFrame tela = this;
		if(f.getadministrador() ==1) {
			mAdm.setEnabled(true);
		}
	}
}
