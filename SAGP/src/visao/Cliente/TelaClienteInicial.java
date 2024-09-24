package visao.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaClienteInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JPanel panel_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteInicial frame = new TelaClienteInicial();
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
	public TelaClienteInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][][grow][][][][][][][][grow][]", "[grow][][grow][][][][][][][][][][][][][][][]"));
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 0 12 1,growx");
		textField.setColumns(10);
		
		RoundButton btnNewButton = new RoundButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnNewButton, "cell 13 0");
		
		panel = new JPanel();
		contentPane.add(panel, "cell 0 0 1 18,alignx left,growy");
		panel.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][][][][][][][][]"));
		
		btnNewButton_2 = new RoundButton("Sair");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton_2, "cell 0 0");
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaClienteInicial.class.getResource("/Imagem/LogoPequena.png")));
		panel.add(lblNewLabel, "cell 0 2");
		
		lblNewLabel_1 = new JLabel("Categorias:");
		panel.add(lblNewLabel_1, "cell 0 5,alignx center");
		
		btnNewButton_3 = new RoundButton("Salgado");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton_3, "cell 0 6,alignx center");
		
		btnNewButton_4 = new RoundButton("Doce");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton_4, "cell 0 7,alignx center");
		
		btnNewButton_5 = new RoundButton("Bebidas");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton_5, "cell 0 8,alignx center");
		
		btnNewButton_6 = new RoundButton("Ofertas");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton_6, "cell 0 9,alignx center");
		
		btnNewButton_1 = new RoundButton("Carrinho");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton_1, "cell 0 15,alignx center");
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 1 13 17,grow");
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[]", "[]"));
	}

}
