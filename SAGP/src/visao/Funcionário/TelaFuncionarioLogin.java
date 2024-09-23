package visao.Funcionário;

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

public class TelaFuncionarioLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEntreComSeu;
	private JTextField txtEntreComUma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarioLogin frame = new TelaFuncionarioLogin();
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
	public TelaFuncionarioLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][grow][][]", "[][][][][][][][][][][][]"));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaFuncionarioLogin.class.getResource("/Imagem/Logo.png")));
		contentPane.add(lblNewLabel_5, "cell 4 1,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("ENTRE NA SUA CONTA:");
		contentPane.add(lblNewLabel_4, "cell 4 3,alignx center");
		
		JLabel lblNewLabel = new JLabel("Nome: *");
		contentPane.add(lblNewLabel, "cell 4 5");
		
		txtEntreComSeu = new JTextField();
		txtEntreComSeu.setForeground(new Color(130, 130, 130));
		txtEntreComSeu.setText("Entre com seu usuário para logar no sistema");
		contentPane.add(txtEntreComSeu, "cell 4 6,growx");
		txtEntreComSeu.setColumns(10);
		
		RoundButton btnNewButton = new RoundButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton, "cell 5 6");
		
		JLabel lblNewLabel_2 = new JLabel("");
		contentPane.add(lblNewLabel_2, "cell 6 6");
		
		JLabel lblNewLabel_1 = new JLabel("Senha: *");
		contentPane.add(lblNewLabel_1, "cell 4 7");
		
		txtEntreComUma = new JTextField();
		txtEntreComUma.setForeground(new Color(130, 130, 130));
		txtEntreComUma.setText("Entre com uma senha");
		contentPane.add(txtEntreComUma, "cell 4 8,growx");
		txtEntreComUma.setColumns(10);
		
		RoundButton btnNewButton_1 = new RoundButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_1, "cell 5 8");
		
		JLabel lblNewLabel_3 = new JLabel("");
		contentPane.add(lblNewLabel_3, "cell 6 8");
		
		RoundButton btnNewButton_2 = new RoundButton("Entrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_2, "cell 4 10,alignx center");
		
		RoundButton btnNewButton_3 = new RoundButton("Cancelar");
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		contentPane.add(btnNewButton_3, "cell 5 11");
	}

}
