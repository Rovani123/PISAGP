package visao.Funcionário;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.classes.Funcionario;
import modelo.classes.Produto;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

public class TelaGerenciamentoP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField txtPesquisar;
	private JTable table;
	private JMenuItem mGProdutos;
	private JMenuItem mPromocoes;
	private JMenuItem mAdm;
    private JMenuItem mVoltar;
	private JMenuItem mFuncionario;
	private RoundButton btSalgados;
	private RoundButton btDoces;
	private RoundButton btBebidas;
	private RoundButton btOfertas;
	private RoundButton btAlterar;
	private RoundButton btRemover;
	private RoundButton btCadastrar;
	private RoundButton btPesquisar;

	
	public TelaGerenciamentoP(Funcionario f) {
		
		Font font = new Font("Tahoma", Font.PLAIN, 11);;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Poppins-SemiBold.ttf"));
			
			font = font.deriveFont(Font.PLAIN, 11); // Definir o tamanho da fonte
				
		} catch (FontFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 638);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mTelas = new JMenu("Telas");
		mTelas.setFont(font);
		menuBar.add(mTelas);

		mAdm = new JMenuItem("Administrador ");
		mAdm.setFont(font);
		mAdm.setEnabled(false);
		mAdm.setActionCommand("mAdm");
//		mAdm.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TelaGerenciamentoF tf = new TelaGerenciamentoF(tela, f);
//				dispose();
//				tf.setVisible(true);
//			}
//		});
		mTelas.add(mAdm);

		mFuncionario = new JMenuItem("Funcionário ");
		mFuncionario.setFont(font);
		mFuncionario.setEnabled(false);
		mFuncionario.setActionCommand("mFuncionario");
		mTelas.add(mFuncionario);

		JMenu mOpcoes = new JMenu("Opções");
		mOpcoes.setFont(font);
		menuBar.add(mOpcoes);

		mGProdutos = new JMenuItem("Produtos ");
		mGProdutos.setFont(font);
		mGProdutos.setEnabled(false);
		mGProdutos.setActionCommand("mGProdutos");
		mOpcoes.add(mGProdutos);

		mPromocoes = new JMenuItem("Promoções  ");
		mPromocoes.setFont(font);
		mPromocoes.setActionCommand("mPromocoes");
//		mPromocoes.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TelaPromocoes tp = new TelaPromocoes(telaA, tela, f);
//				tp.setVisible(true);
//				dispose();
//			}
//		});
		mOpcoes.add(mPromocoes);

		mVoltar = new JMenuItem("Voltar ao início");
		mVoltar.setFont(font);
		mVoltar.setActionCommand("mVoltar");
//		mVoltar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TelaInicial telaI = new TelaInicial();
//				dispose();
//				telaI.setVisible(true);
//			}
//		});
		menuBar.add(mVoltar);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[grow][][][grow][][][][grow][]", "[grow][][grow][][][][][][][][][][][][][][][]"));

		JPanel barraLateral = new JPanel();
		barraLateral.setBackground(new Color(167, 208, 214));
		painel.add(barraLateral, "cell 0 0 1 18,alignx left,growy");
		barraLateral.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][][][][][][][][][]"));

		RoundButton btVoltar = new RoundButton("Sair");
		btVoltar.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/volte.png")));
		btVoltar.setText("");
		
		btVoltar.setForeground(new Color(255, 255, 255));
		btVoltar.setBackground(new Color(245, 245, 245));
		barraLateral.add(btVoltar, "cell 0 0,alignx left");

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/LogoPequena.png")));
		barraLateral.add(lblLogo, "cell 0 2 2 1");

		JLabel lblCategoria = new JLabel("Categorias:");
		lblCategoria.setFont(font);
		barraLateral.add(lblCategoria, "cell 1 4,alignx left");

		btSalgados = new RoundButton("Salgado");
		btSalgados.setFont(font);
		btSalgados.setText("Salgados");
		btSalgados.setActionCommand("btSalgados");

		JLabel lblIconSalgados = new JLabel("");
		lblIconSalgados.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/biscoitos.png")));
		barraLateral.add(lblIconSalgados, "cell 0 5,alignx center");
		btSalgados.setBackground(new Color(255, 255, 255));
		barraLateral.add(btSalgados, "cell 1 5,growx");

		btDoces = new RoundButton("Doce");
		btDoces.setFont(font);
		btDoces.setText("Doces");
		btDoces.setActionCommand("btDoces");

		JLabel lblIconDoces = new JLabel("");
		lblIconDoces.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/bolinho.png")));
		barraLateral.add(lblIconDoces, "cell 0 6,alignx center");
		btDoces.setBackground(new Color(255, 255, 255));
		barraLateral.add(btDoces, "cell 1 6,growx");

		btBebidas = new RoundButton("Bebidas");
		btBebidas.setFont(font);
		btBebidas.setActionCommand("btBebidas");

		JLabel lblIconBebidas = new JLabel("");
		lblIconBebidas.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/garrafa-de-agua.png")));
		barraLateral.add(lblIconBebidas, "cell 0 7,alignx center");
		btBebidas.setBackground(new Color(255, 255, 255));
		barraLateral.add(btBebidas, "cell 1 7,growx");

		btOfertas = new RoundButton("Ofertas");
		btOfertas.setFont(font);
		btOfertas.setActionCommand("btOfertas");

		JLabel lblIconOfertas = new JLabel("icone");
		lblIconOfertas.setFont(font);
		barraLateral.add(lblIconOfertas, "cell 0 8");
		btOfertas.setBackground(new Color(167, 208, 214));
		barraLateral.add(btOfertas, "cell 1 8,growx");

		btCadastrar = new RoundButton("Adicionar");
		btCadastrar.setFont(font);
		btCadastrar.setActionCommand("btCadastrar");
//		btCadastrar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				TelaCadastroP tcp = new TelaCadastroP(tela, f);
//				dispose();
//				tcp.setVisible(true);
//			}
//		});

		btRemover = new RoundButton("Deletar");
		btRemover.setFont(font);
		btRemover.setActionCommand("btRemover");
//		btRemover.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					Produto p = ((ProdutosTableModel) table.getModel()).getItem(table.getSelectedRow());
//					ProdutoDAO pdal = new ProdutoDAO();
//					try {
//						pdal.deletarProduto(p);
//						JOptionPane.showMessageDialog(null, "operação realizada com sucesso");
//					} catch (SQLException e1) {
//						e1.printStackTrace();
//						JOptionPane.showMessageDialog(null, "Não é possivel remover esse produto");
//					}
//					if (contS == 1) {
//						getProdutosFiltro(Categoria.categoriaString("salgados"));
//					} else if (contD == 1) {
//						getProdutosFiltro(Categoria.categoriaString("doces"));
//					} else if (contD == 1) {
//						getProdutosFiltro(Categoria.categoriaString("bebidas"));
//					} else {
//						getProdutos();
//					}
//				} catch (Exception e2) {
//					JOptionPane.showMessageDialog(null, "Selecione um produto");
//				}
//			}
//		});

		btAlterar = new RoundButton("Alterar");
		btAlterar.setFont(font);
		btAlterar.setActionCommand("btAlterar");
//		btAlterar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					Produto p = ((ProdutosTableModel) table.getModel()).getItem(table.getSelectedRow());
//
//					TelaAlteracaoP tap = new TelaAlteracaoP(tela, p, f);
//					dispose();
//					tap.setVisible(true);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//					JOptionPane.showMessageDialog(null, "Selecione um produto");
//				}
//			}
//		});

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
		lblIconCadastrar.setFont(font);
		barraLateral.add(lblIconCadastrar, "cell 0 17");
		btCadastrar.setForeground(new Color(255, 255, 255));
		btCadastrar.setBackground(new Color(0, 0, 0));
		barraLateral.add(btCadastrar, "cell 1 17,alignx left");

		JLabel lblIconEstoque = new JLabel("iconeestoque");
		painel.add(lblIconEstoque, "cell 1 0");

		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setFont(font);
		painel.add(lblEstoque, "cell 2 0,alignx trailing");

		txtPesquisar = new JTextField();
		painel.add(txtPesquisar, "cell 3 0 5 1,growx");
		txtPesquisar.setColumns(10);

		btPesquisar = new RoundButton("Pesquisar");
		btPesquisar.setFont(font);
		btPesquisar.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/lupa.png")));
		btPesquisar.setText("");
		btPesquisar.setForeground(new Color(255, 255, 255));
		btPesquisar.setBackground(new Color(245, 245, 245));
		btPesquisar.setActionCommand("btPesquisar");
		painel.add(btPesquisar, "cell 8 0");

		JScrollPane scrollPane = new JScrollPane();
		painel.add(scrollPane, "cell 1 2 8 16,grow");

		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	public void addGerenciamentoPListner(ActionListener listener) {
		mGProdutos.addActionListener(listener);
		mPromocoes.addActionListener(listener);
		mAdm.addActionListener(listener);
		mFuncionario.addActionListener(listener);
		btSalgados.addActionListener(listener);
		btDoces.addActionListener(listener);
		btBebidas.addActionListener(listener);
		btOfertas.addActionListener(listener);
		btAlterar.addActionListener(listener);
		btRemover.addActionListener(listener);
		btCadastrar.addActionListener(listener);
		btPesquisar.addActionListener(listener);
	}

	public void setTabela(ProdutosTableModel tm) {
		table.setModel(tm);
	}


	public void setmenuAdm(boolean b) {
		mAdm.setEnabled(b);		
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

	public Produto getItemTabela() {
		return ((ProdutosTableModel) table.getModel()).getItem(table.getSelectedRow());
	}
	
}
