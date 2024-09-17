package visao.telasCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaClienteLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteLogin frame = new TelaClienteLogin();
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
	public TelaClienteLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][grow][][]", "[][][][][][][][][][][][]"));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaClienteLogin.class.getResource("/Imagem/Logo.png")));
		contentPane.add(lblNewLabel_5, "cell 5 1,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("ENTRE NA SUA CONTA:");
		contentPane.add(lblNewLabel_4, "cell 5 3,alignx center");
		
		JLabel lblNewLabel = new JLabel("Usuário: *");
		contentPane.add(lblNewLabel, "cell 5 4");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 5 5,growx");
		textField.setColumns(10);
		
		RoundButton btnNewButton_1 = new RoundButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_1, "cell 6 5");
		
		JLabel lblNewLabel_2 = new JLabel("");
		contentPane.add(lblNewLabel_2, "cell 7 5");
		
		JLabel lblNewLabel_1 = new JLabel("Senha: *");
		contentPane.add(lblNewLabel_1, "cell 5 6");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 5 7,growx");
		textField_1.setColumns(10);
		
		RoundButton btnNewButton_2 = new RoundButton("Limpar");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_2, "cell 6 7,alignx left");
		
		JLabel lblNewLabel_3 = new JLabel("");
		contentPane.add(lblNewLabel_3, "cell 7 7");
		
		RoundButton btnNewButton = new RoundButton("Entrar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton, "cell 5 9,alignx center");
		
		RoundButton btnNewButton_3 = new RoundButton("Cancelar");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		contentPane.add(btnNewButton_3, "cell 6 11");
	}

}
