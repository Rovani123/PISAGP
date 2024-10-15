package visao.Administrador;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dal.ConexaoBD;
import modelo.classes.Funcionario;
import modelo.dao.FuncionarioDAO;
import net.miginfocom.swing.MigLayout;
import visao.ImageLabel;
import visao.RoundButton;
import visao.TelaInicial;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class TelaCadastroF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroF frame = new TelaCadastroF();
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
	public TelaCadastroF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][][grow][][][][][][][grow]", "[grow][][][grow][][][][][][][][][grow]"));
		
		ImageLabel lblNewLabel = new ImageLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroF.class.getResource("/Imagem/Logo.png")));
		contentPane.add(lblNewLabel, "cell 3 2 9 1,alignx center,growy");
		
		JLabel lblNewLabel_1 = new JLabel("CRIE UMA CONTA:");
		contentPane.add(lblNewLabel_1, "cell 3 4 8 1,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("Usuário:");
		contentPane.add(lblNewLabel_2, "cell 3 5,alignx left");
		
		JLabel lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		contentPane.add(lblNewLabel_5, "cell 4 5,alignx left");
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(128, 128, 128));
		txtUsuario.setText("Coloque o seu usuario para cadastar");
		contentPane.add(txtUsuario, "cell 3 6 8 1,growx");
		txtUsuario.setColumns(10);
		
		JButton btnNewButton = new RoundButton("LIMPAR");
		btnNewButton.setBackground(new Color(224, 83, 76));
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtUsuario.setText("");
				
			}
		});
		contentPane.add(btnNewButton, "cell 11 6");
		
		JLabel lblNewLabel_4 = new JLabel("Nome:");
		contentPane.add(lblNewLabel_4, "cell 3 7,alignx left");
		
		JLabel lblNewLabel_6 = new JLabel("*");
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		contentPane.add(lblNewLabel_6, "cell 4 7,alignx left");
		
		txtNome = new JTextField();
		txtNome.setForeground(new Color(128, 128, 128));
		txtNome.setText("Entre com seu nome para cadastar");
		contentPane.add(txtNome, "cell 3 8 8 1,growx");
		txtNome.setColumns(10);
		
		JButton btnNewButton_5 = new RoundButton("New button");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
			}
		});
		btnNewButton_5.setText("LIMPAR");
		btnNewButton_5.setBackground(new Color(224, 83, 76));
		btnNewButton_5.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_5, "cell 11 8");
		
		JLabel lblNewLabel_3 = new JLabel("Senha:");
		contentPane.add(lblNewLabel_3, "cell 3 9,alignx left");
		
		JLabel lblNewLabel_7 = new JLabel("*");
		contentPane.add(lblNewLabel_7, "cell 4 9,alignx trailing");
		
		JButton btnNewButton_2 = new RoundButton("CADASTRAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				FuncionarioDAO adm = new FuncionarioDAO();
				
				try {
					adm.cadastrarFuncionario(txtNome.getText(),txtUsuario.getText(),txtSenha.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		txtSenha = new JTextField();
		txtSenha.setForeground(new Color(128, 128, 128));
		txtSenha.setText("Entre com uma senha");
		contentPane.add(txtSenha, "cell 3 10 8 1,growx");
		txtSenha.setColumns(10);
		
		JButton btnNewButton_1 = new RoundButton("LIMPAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSenha.setText("");
			}
		});
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		btnNewButton_1.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_1, "cell 11 10");
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		btnNewButton_2.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_2, "cell 7 11");
		
		JButton btnNewButton_4 = new RoundButton("CANCELAR");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				TelaInicial telaP = new TelaInicial ();
				dispose();
				telaP.setVisible(true);
				
			}
		});
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_4, "cell 10 12");
		
		JButton btnNewButton_3 = new RoundButton("ENTRAR");
		btnNewButton_3.setBackground(new Color(224, 83, 76));
		btnNewButton_3.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_3, "cell 11 12");
	}

}
