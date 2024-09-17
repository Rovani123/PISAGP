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
	private JTextField txtUser;
	private JTextField txtSenha;

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
		
		txtUser = new JTextField();
		txtUser.setForeground(new Color(130, 130, 130));
		txtUser.setText("Entre com seu usuário para logar no sistema");
		contentPane.add(txtUser, "cell 4 6 4 1,growx");
		txtUser.setColumns(10);
		
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
		
		txtSenha = new JTextField();
		txtSenha.setForeground(new Color(130, 130, 130));
		txtSenha.setText("Entre com uma senha");
		contentPane.add(txtSenha, "cell 4 8 4 1,growx");
		txtSenha.setColumns(10);
		
		RoundButton bntLimpa = new RoundButton("Limpa");
		bntLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		bntLimpa.setForeground(new Color(255, 255, 255));
		bntLimpa.setBackground(new Color(224, 83, 76));
		contentPane.add(bntLimpa, "cell 9 8");
		
		RoundButton btEntrar = new RoundButton("Entrar");
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement stml = null;
				Connection conn = ConexaoBD.getConexaoMySQL();
				
				try {
					stml = (Statement) conn.createStatement();
					ResultSet resl = null;
					resl = stml.executeQuery("SELECT * FROM Funcionarios");
					while(resl.next())
					{
						if(txtUser.getText().equals(resl.getString("usuarioFuncionario")))
						{
							if(txtSenha.getText().equals(resl.getString("Senha")))
							{
								if(resl.getInt("administrador") == 1)
								{
									JOptionPane.showMessageDialog(null, "ADM");
								}
								else
								{
									JOptionPane.showMessageDialog(null, "FUNC");
								}
							}
						}
					}
					resl.close();
					stml.close();
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("N foi");
				}
			}
		});
		
		RoundButton btVoltar = new RoundButton("Voltar");
		btVoltar.setText("Voltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaP = new TelaPrincipal();
				dispose();
				telaP.setVisible(true);
			}
		});
		btVoltar.setForeground(new Color(255, 255, 255));
		btVoltar.setBackground(new Color(0, 0, 0));
		contentPane.add(btVoltar, "cell 4 10");
		btEntrar.setForeground(new Color(255, 255, 255));
		btEntrar.setBackground(new Color(224, 83, 76));
		contentPane.add(btEntrar, "cell 5 10 2 1,alignx center");
	}

}
