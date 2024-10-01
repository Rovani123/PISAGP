package visao.Funcionário;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controle.FuncionarioDAO;
import modelo.classes.Produto;

import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaFuncionarioEstoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarioEstoque frame = new TelaFuncionarioEstoque();
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
	public TelaFuncionarioEstoque() {
		setBackground(new Color(230, 230, 230));
		FuncionarioDAO estoquedao = new FuncionarioDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 638);
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
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setBackground(new Color(0, 0, 0));
				panel.add(btnNewButton, "cell 0 0,alignx left");

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaFuncionarioEstoque.class.getResource("/Imagem/LogoPequena.png")));
		panel.add(lblNewLabel_1, "cell 0 2 2 1");

		JLabel lblNewLabel_2 = new JLabel("Categorias:");
		panel.add(lblNewLabel_2, "cell 1 4,alignx left");

		RoundButton btnSalgados = new RoundButton("Salgado");
		btnSalgados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {},
						new String[] { "nomeProduto", "preco", "quantidadeEstoque", "categoria" });

				ArrayList<Produto> lista = estoquedao.getProdutos("salgados");

				for (Produto p : lista) {
					tableModel.addRow(new Object[] { p.getNomeProduto(), p.getPreco(), p.getQuantidadeEstoque(),
							p.getCategoria() });
					table.setModel(tableModel);
				}				
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaFuncionarioEstoque.class.getResource("/Imagem/biscoitos.png")));
		panel.add(lblNewLabel_3, "cell 0 5,alignx center");
		btnSalgados.setBackground(new Color(255, 255, 255));
		panel.add(btnSalgados, "cell 1 5,alignx left");

		RoundButton btnDoces = new RoundButton("Doce");
		btnDoces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {},
						new String[] { "nomeProduto", "preco", "quantidadeEstoque", "categoria" });

				ArrayList<Produto> lista = estoquedao.getProdutos("doces");

				for (Produto p : lista) {
					tableModel.addRow(new Object[] { p.getNomeProduto(), p.getPreco(), p.getQuantidadeEstoque(),
							p.getCategoria() });
					table.setModel(tableModel);
				}

			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(TelaFuncionarioEstoque.class.getResource("/Imagem/bolinho.png")));
		panel.add(lblNewLabel_4, "cell 0 6,alignx center");
		btnDoces.setBackground(new Color(167, 208, 214));
		panel.add(btnDoces, "cell 1 6,alignx left");

		RoundButton btnBebidas = new RoundButton("Bebidas");
		btnBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {},
						new String[] { "nomeProduto", "preco", "quantidadeEstoque", "categoria" });

				ArrayList<Produto> lista = estoquedao.getProdutos("bebidas");

				for (Produto p : lista) {
					tableModel.addRow(new Object[] { p.getNomeProduto(), p.getPreco(), p.getQuantidadeEstoque(),
							p.getCategoria() });
					table.setModel(tableModel);
				}

			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaFuncionarioEstoque.class.getResource("/Imagem/garrafa-de-agua.png")));
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

			}
		});

		RoundButton btnNewButton_2 = new RoundButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		RoundButton btnNewButton_1 = new RoundButton("Alterar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(TelaFuncionarioEstoque.class.getResource("/Imagem/troca.png")));
		panel.add(lblNewLabel_7, "cell 0 15,alignx center");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton_1, "cell 1 15,alignx left");
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(TelaFuncionarioEstoque.class.getResource("/Imagem/lixeira.png")));
		panel.add(lblNewLabel_8, "cell 0 16,alignx center");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		panel.add(btnNewButton_2, "cell 1 16,alignx left");
		
		JLabel lblNewLabel_9 = new JLabel("Adicionar");
		panel.add(lblNewLabel_9, "cell 0 17");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton_4, "cell 1 17,alignx left");

		JLabel lblNewLabel = new JLabel("Estoque");
		contentPane.add(lblNewLabel, "cell 2 0,alignx trailing");

		textField = new JTextField();
		contentPane.add(textField, "cell 3 0 5 1,growx");
		textField.setColumns(10);

		RoundButton btnNewButton_3 = new RoundButton("Pesquisar");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 0, 0));
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

		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "nomeProduto", "preco", "quantidadeEstoque", "categoria" });

		ArrayList<Produto> lista = estoquedao.getProdutos("");

		for (Produto p : lista) {
			tableModel.addRow(
					new Object[] { p.getNomeProduto(), p.getPreco(), p.getQuantidadeEstoque(), p.getCategoria() });
			table.setModel(tableModel);
		}

	}

}
