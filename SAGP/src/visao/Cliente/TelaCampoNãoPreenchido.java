package visao.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TelaCampoNãoPreenchido extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCampoNãoPreenchido frame = new TelaCampoNãoPreenchido();
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
	public TelaCampoNãoPreenchido() {
		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][grow][][]", "[][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(TelaCampoNãoPreenchido.class.getResource("/Imagem/Logo.png")));
		contentPane.add(lblNewLabel_10, "cell 5 2,alignx center");
		
		JLabel lblNewLabel_9 = new JLabel("CRIE UMA CONTA:");
		contentPane.add(lblNewLabel_9, "cell 5 5,alignx center");
		
		JLabel lblNewLabel = new JLabel("Nome: *");
		contentPane.add(lblNewLabel, "cell 4 7");
		
		JLabel lblNewLabel_6 = new JLabel("Esse campo é obrigatório");
		contentPane.add(lblNewLabel_6, "cell 5 7");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 4 8 2 1,growx");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Limpar");
		contentPane.add(btnNewButton, "cell 6 8");
		
		JLabel lblNewLabel_3 = new JLabel("");
		contentPane.add(lblNewLabel_3, "cell 7 8");
		
		JLabel lblNewLabel_1 = new JLabel("Usuário: *");
		contentPane.add(lblNewLabel_1, "cell 4 9");
		
		JLabel lblNewLabel_7 = new JLabel("Esse campo é obrigatório");
		contentPane.add(lblNewLabel_7, "cell 5 9");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 4 10 2 1,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		contentPane.add(btnNewButton_1, "cell 6 10");
		
		JLabel lblNewLabel_4 = new JLabel("");
		contentPane.add(lblNewLabel_4, "cell 7 10");
		
		JLabel lblNewLabel_2 = new JLabel("Senha: *");
		contentPane.add(lblNewLabel_2, "cell 4 11");
		
		JLabel lblNewLabel_8 = new JLabel("Esse campo é obrigatório");
		contentPane.add(lblNewLabel_8, "cell 5 11");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 4 12 2 1,growx");
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Limpar");
		contentPane.add(btnNewButton_2, "cell 6 12");
		
		JLabel lblNewLabel_5 = new JLabel("");
		contentPane.add(lblNewLabel_5, "cell 7 12");
		
		JButton btnNewButton_3 = new JButton("Cadastrar");
		contentPane.add(btnNewButton_3, "cell 5 14,alignx center");
		
		JButton btnNewButton_4 = new JButton("Cancelar");
		contentPane.add(btnNewButton_4, "cell 6 16");
		
		JButton btnNewButton_5 = new JButton("Entrar");
		contentPane.add(btnNewButton_5, "cell 7 16");
	}

}
