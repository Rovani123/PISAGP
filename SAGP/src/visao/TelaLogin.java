package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ConexaoBD;
import net.miginfocom.swing.MigLayout;
import visao.telasFuncionário.TelaFuncionarioEstoque;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaLogin extends JFrame {

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
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow][][][][grow][][][grow]", "[][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagem/Logo.png")));
		contentPane.add(lblNewLabel_3, "cell 5 1 2 1,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("ENTRE COM SUA CONTA:");
		contentPane.add(lblNewLabel_2, "cell 5 3 2 1,alignx center");
		
		JLabel lblNewLabel = new JLabel("Usuário: *");
		contentPane.add(lblNewLabel, "cell 4 5");
		
		txtEntreComSeu = new JTextField();
		txtEntreComSeu.setForeground(new Color(130, 130, 130));
		txtEntreComSeu.setText("Entre com seu usuário para logar no sistema");
		contentPane.add(txtEntreComSeu, "cell 4 6 4 1,growx");
		txtEntreComSeu.setColumns(10);
		
		RoundButton btnLimpa_1 = new RoundButton("Limpa");
		btnLimpa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLimpa_1.setForeground(new Color(255, 255, 255));
		btnLimpa_1.setBackground(new Color(224, 83, 76));
		contentPane.add(btnLimpa_1, "cell 9 6");
		
		JLabel lblNewLabel_1 = new JLabel("Senha: *");
		contentPane.add(lblNewLabel_1, "cell 4 7");
		
		txtEntreComUma = new JTextField();
		txtEntreComUma.setForeground(new Color(130, 130, 130));
		txtEntreComUma.setText("Entre com uma senha");
		contentPane.add(txtEntreComUma, "cell 4 8 4 1,growx");
		txtEntreComUma.setColumns(10);
		
		RoundButton bntLimpa = new RoundButton("Limpa");
		bntLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		bntLimpa.setForeground(new Color(255, 255, 255));
		bntLimpa.setBackground(new Color(224, 83, 76));
		contentPane.add(bntLimpa, "cell 9 8");
		
		RoundButton btnNewButton_1 = new RoundButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		RoundButton btnNewButton = new RoundButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton, "cell 5 10 2 1,alignx center");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		contentPane.add(btnNewButton_1, "cell 9 11");
	}

}
