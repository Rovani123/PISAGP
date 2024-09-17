package visao.telasCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class TelaClienteInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JPanel panel_1;

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
		
		JButton btnNewButton = new JButton("Pesquisar");
		contentPane.add(btnNewButton, "cell 13 0");
		
		panel = new JPanel();
		contentPane.add(panel, "cell 0 0 1 18,alignx left,growy");
		panel.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][][][][][][][][]"));
		
		btnNewButton_2 = new JButton("Sair");
		panel.add(btnNewButton_2, "cell 0 0");
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaClienteInicial.class.getResource("/Imagem/Logo.png")));
		panel.add(lblNewLabel, "cell 0 2");
		
		lblNewLabel_1 = new JLabel("Categorias:");
		panel.add(lblNewLabel_1, "cell 0 5,alignx center");
		
		btnNewButton_3 = new JButton("Salgado");
		panel.add(btnNewButton_3, "cell 0 6,alignx center");
		
		btnNewButton_4 = new JButton("Doce");
		panel.add(btnNewButton_4, "cell 0 7,alignx center");
		
		btnNewButton_5 = new JButton("Bebidas");
		panel.add(btnNewButton_5, "cell 0 8,alignx center");
		
		btnNewButton_6 = new JButton("Ofertas");
		panel.add(btnNewButton_6, "cell 0 9,alignx center");
		
		btnNewButton_1 = new JButton("Carrinho");
		panel.add(btnNewButton_1, "cell 0 15,alignx center");
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 1 13 17,grow");
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[]", "[]"));
	}

}
