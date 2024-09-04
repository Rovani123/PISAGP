package visao.telasCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaClienteCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
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
					TelaClienteCadastro frame = new TelaClienteCadastro();
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
	public TelaClienteCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][grow][][][]", "[][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("CRIE UMA CONTA:");
		contentPane.add(lblNewLabel_3, "cell 4 2");
		
		JLabel lblNewLabel_4 = new JLabel("");
		contentPane.add(lblNewLabel_4, "cell 6 2");
		
		JLabel lblNewLabel_5 = new JLabel("");
		contentPane.add(lblNewLabel_5, "cell 7 2");
		
		JLabel lblNewLabel = new JLabel("Nome: *");
		contentPane.add(lblNewLabel, "cell 4 4");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 4 5,growx");
		textField.setColumns(10);
		
		JButton btnNewButton = new RoundButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBackground(new Color(224, 83, 76));
		btnNewButton.setForeground(new Color(255, 255, 255));
		contentPane.add(btnNewButton, "cell 5 5");
		
		JLabel lblNewLabel_1 = new JLabel("Usuário: *");
		contentPane.add(lblNewLabel_1, "cell 4 6");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 4 7,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new RoundButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_1, "cell 5 7");
		
		JLabel lblNewLabel_2 = new JLabel("Senha: *");
		contentPane.add(lblNewLabel_2, "cell 4 8");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 4 9,growx");
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new RoundButton("Limpar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_2, "cell 5 9");
		
		JButton btnNewButton_3 = new RoundButton("Cadastrar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(224, 83, 76));
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(btnNewButton_3, "cell 4 11");
		
		JButton btnNewButton_4 = new RoundButton("Cancelar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		contentPane.add(btnNewButton_4, "cell 5 13");
		
		JButton btnNewButton_5 = new RoundButton("Entrar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				///
				
				//hjhuj
				
			}
		});
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(Color.DARK_GRAY);
		contentPane.add(btnNewButton_5, "cell 6 13");
	}

}
