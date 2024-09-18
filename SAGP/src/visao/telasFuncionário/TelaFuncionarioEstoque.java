package visao.telasFuncionário;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.EstoqueDAO;

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
		EstoqueDAO estoquedao = new EstoqueDAO ();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][grow][][][][grow][]", "[grow][][grow][][][][][][][][][][][][][][][]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(167, 208, 214));
		contentPane.add(panel, "cell 0 0 2 18,grow");
		panel.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][][][][][][][][][]"));
		
		RoundButton btnNewButton = new RoundButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton, "cell 1 0,alignx left");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaFuncionarioEstoque.class.getResource("/Imagem/Logo.png")));
		panel.add(lblNewLabel_1, "cell 1 2");
		
		JLabel lblNewLabel_2 = new JLabel("Categorias:");
		panel.add(lblNewLabel_2, "cell 1 4,alignx center");
		
		RoundButton btnSalgados = new RoundButton("Salgado");
		btnSalgados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(estoquedao.visualizarTabela("salgados"));
			}
		});
		btnSalgados.setBackground(new Color(255, 255, 255));
		panel.add(btnSalgados, "cell 1 5,alignx center");
		
		RoundButton btnDoces = new RoundButton("Doce");
		btnDoces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(estoquedao.visualizarTabela("doces"));
			
			}
		});
		btnDoces.setBackground(new Color(167, 208, 214));
		panel.add(btnDoces, "cell 1 6,alignx center");
		
		RoundButton btnBebidas = new RoundButton("Bebidas");
		btnBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(estoquedao.visualizarTabela("bebidas"));
			}
		});
		btnBebidas.setBackground(new Color(167, 208, 214));
		panel.add(btnBebidas, "cell 1 7,alignx center");
		
		RoundButton btnOfertas = new RoundButton("Ofertas");
		btnOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnOfertas.setBackground(new Color(167, 208, 214));
		panel.add(btnOfertas, "cell 1 8,alignx center");
		
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
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton_1, "cell 1 15,alignx center");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		panel.add(btnNewButton_2, "cell 1 16,alignx center");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton_4, "cell 1 17,alignx center");
		
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
		contentPane.add(scrollPane, "cell 2 2 7 16,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Coxinha de Carne", "Coxinha de Calabresa", "Coxinha de Frango", null},
				{null, null, null, null},
			},
			new String[] {
				"Pastel de Calabresa", "Pastel de Pizza", "Pastel de Frango", "Pastel de Carne"
			}
		));
		scrollPane.setViewportView(table);
	
		
	
		//criar if 
		//selecionar as categorias
	
	}

}
