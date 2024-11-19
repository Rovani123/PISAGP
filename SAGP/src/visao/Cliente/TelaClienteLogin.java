package visao.Cliente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;

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
import java.io.File;
import java.io.IOException;
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 630, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][grow][][]", "[][][][][][][][][][][][]"));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaClienteLogin.class.getResource("/Imagem/Logo.png")));
		contentPane.add(lblNewLabel_5, "cell 4 1 2 1,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("ENTRE NA SUA CONTA:");
		contentPane.add(lblNewLabel_4, "cell 4 2 2 1,alignx center");
		
		JLabel lblNewLabel_8 = new JLabel("Não foi possivel entrar, tente novamente");
		lblNewLabel_8.setFont(font);
		lblNewLabel_8.setForeground(new Color(224, 83, 76));
		lblNewLabel_8.setEnabled(false);
		contentPane.add(lblNewLabel_8, "cell 4 3 2 1,alignx center");
		
		JLabel lblNewLabel = new JLabel("Usuário: *");
		lblNewLabel.setFont(font);
		contentPane.add(lblNewLabel, "cell 4 5");
		
		JLabel lblNewLabel_6 = new JLabel("Esse campo é obrigatório");
		lblNewLabel_6.setFont(font);
		lblNewLabel_6.setForeground(new Color(224, 83, 76));
		lblNewLabel_6.setEnabled(false);
		contentPane.add(lblNewLabel_6, "cell 5 5");
		
		JLabel lblNewLabel_2 = new JLabel("");
		contentPane.add(lblNewLabel_2, "cell 7 5");
		
		RoundButton btnNewButton_1 = new RoundButton("Limpar");
		btnNewButton_1.setFont(font);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		textField = new JTextField();
		contentPane.add(textField, "cell 4 6 2 1,growx");
		textField.setColumns(10);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_1, "cell 6 6");
		
		JLabel lblNewLabel_1 = new JLabel("Senha: *");
		lblNewLabel_1.setFont(font);
		contentPane.add(lblNewLabel_1, "cell 4 7");
		
		JLabel lblNewLabel_7 = new JLabel("Esse campo é obrigatório");
		lblNewLabel_7.setFont(font);
		lblNewLabel_7.setForeground(new Color(224, 83, 76));
		lblNewLabel_7.setEnabled(false);
		contentPane.add(lblNewLabel_7, "cell 5 7");
		
		JLabel lblNewLabel_3 = new JLabel("");
		contentPane.add(lblNewLabel_3, "cell 7 7");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 4 8 2 1,growx");
		textField_1.setColumns(10);
		
		RoundButton btnNewButton_2 = new RoundButton("Limpar");
		btnNewButton_2.setFont(font);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_2, "cell 6 8,alignx left");
		
		RoundButton btnNewButton = new RoundButton("Entrar");
		btnNewButton.setFont(font);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton, "cell 5 10,alignx center");
		
		RoundButton btnNewButton_3 = new RoundButton("Cancelar");
		btnNewButton_3.setFont(font);
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		contentPane.add(btnNewButton_3, "cell 6 11");
	}

}
