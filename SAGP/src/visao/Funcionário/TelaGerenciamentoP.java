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
import modelo.classes.Produto;
import modelo.dao.ProdutoDAO;
import modelo.enumerador.Categoria;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.TelaInicial;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaGerenciamentoP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenciamentoP frame = new TelaGerenciamentoP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaGerenciamentoP() {
		TelaGerenciamentoP tgp= this;

		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 638);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Telas");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Administrador ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Funcionário ");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Opções");
		mnNewMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Produtos ");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Promoções  ");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Tela Inicial");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaI = new TelaInicial();
				dispose();
				telaI.setVisible(true);
			}
		});
		menuBar.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(
				new MigLayout("", "[grow][][][grow][][][][grow][]", "[grow][][grow][][][][][][][][][][][][][][][]"));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(167, 208, 214));
		contentPane.add(panel, "cell 0 0 1 18,alignx left,growy");
		panel.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][][][][][][][][][]"));
		
				RoundButton btnNewButton = new RoundButton("Sair");
				btnNewButton.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/volte.png")));
				btnNewButton.setText("");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaFuncionario tf = new TelaFuncionario();
						dispose();
						tf.setVisible(true);
					}
				});
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setBackground(new Color(245, 245, 245));
				panel.add(btnNewButton, "cell 0 0,alignx left");

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/LogoPequena.png")));
		panel.add(lblNewLabel_1, "cell 0 2 2 1");

		JLabel lblNewLabel_2 = new JLabel("Categorias:");
		panel.add(lblNewLabel_2, "cell 1 4,alignx left");

		RoundButton btnSalgados = new RoundButton("Salgado");
		btnSalgados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getProdutosFiltro(Categoria.categoriaString("salgados"));
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/biscoitos.png")));
		panel.add(lblNewLabel_3, "cell 0 5,alignx center");
		btnSalgados.setBackground(new Color(255, 255, 255));
		panel.add(btnSalgados, "cell 1 5,alignx left");

		RoundButton btnDoces = new RoundButton("Doce");
		btnDoces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getProdutosFiltro(Categoria.categoriaString("doces"));

			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/bolinho.png")));
		panel.add(lblNewLabel_4, "cell 0 6,alignx center");
		btnDoces.setBackground(new Color(167, 208, 214));
		panel.add(btnDoces, "cell 1 6,alignx left");

		RoundButton btnBebidas = new RoundButton("Bebidas");
		btnBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				getProdutosFiltro(Categoria.categoriaString("bebidas"));
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/garrafa-de-agua.png")));
		panel.add(lblNewLabel_5, "cell 0 7,alignx center");
		btnBebidas.setBackground(new Color(167, 208, 214));
		panel.add(btnBebidas, "cell 1 7,alignx left");

		RoundButton btnOfertas = new RoundButton("Ofertas");
		btnOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("icone");
		panel.add(lblNewLabel_6, "cell 0 8");
		btnOfertas.setBackground(new Color(167, 208, 214));
		panel.add(btnOfertas, "cell 1 8,alignx left");

		RoundButton btnNewButton_4 = new RoundButton("Adicionar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroP tcp = new TelaCadastroP(tgp);
				dispose();
				tcp.setVisible(true);
			}
		});

		RoundButton btnNewButton_2 = new RoundButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
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

		RoundButton btnNewButton_1 = new RoundButton("Alterar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Produto p = ((ProdutosTableModel) table.getModel()).getItem(table.getSelectedRow());
					TelaAlteracaoP tap = new TelaAlteracaoP(tgp, p);
					dispose();
					tap.setVisible(true);
				}catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Selecione um produto");
					}
				
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/troca.png")));
		panel.add(lblNewLabel_7, "cell 0 15,alignx center");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton_1, "cell 1 15,alignx left");
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/lixeira.png")));
		panel.add(lblNewLabel_8, "cell 0 16,alignx center");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		panel.add(btnNewButton_2, "cell 1 16,alignx left");
		
		JLabel lblNewLabel_9 = new JLabel("Adicionar");
		panel.add(lblNewLabel_9, "cell 0 17");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton_4, "cell 1 17,alignx left");
		
		JLabel lblNewLabel_10 = new JLabel("iconeestoque");
		contentPane.add(lblNewLabel_10, "cell 1 0");

		JLabel lblNewLabel = new JLabel("Estoque");
		contentPane.add(lblNewLabel, "cell 2 0,alignx trailing");

		textField = new JTextField();
		contentPane.add(textField, "cell 3 0 5 1,growx");
		textField.setColumns(10);

		RoundButton btnNewButton_3 = new RoundButton("Pesquisar");
		btnNewButton_3.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/lupa.png")));
		btnNewButton_3.setText("");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(245, 245, 245));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		contentPane.add(btnNewButton_3, "cell 8 0");

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 2 8 16,grow");

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Coxinha de Carne", "Coxinha de Calabresa", "Coxinha de Frango", null },
						{ null, null, null, null }, },
				new String[] { "", "", "", "" }));
		scrollPane.setViewportView(table);

		getProdutos();
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
}
