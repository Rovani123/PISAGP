package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dal.ConexaoBD;
import net.miginfocom.swing.MigLayout;
import visao.Administrador.TelaAdministrador;
import visao.Funcionário.TelaFuncionario;
import visao.Funcionário.TelaFuncionarioEstoque;

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
	private JPanel Painel;
	private ImageIcon logo;
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
		logo = new ImageIcon(TelaInicial.class.getResource("/Imagem/Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 450);
		Painel = new JPanel();
		Painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Painel);
		Painel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(logo);
		Painel.add(lblLogo, "cell 5 1 2 1,alignx center");
		
		JLabel lblEntre = new JLabel("ENTRE COM SUA CONTA:");
		Painel.add(lblEntre, "cell 5 3 2 1,alignx center");
		
		JLabel lblUsuario = new JLabel("Usuário: *");
		Painel.add(lblUsuario, "cell 4 5");
		
		txtUser = new JTextField();
		txtUser.setHorizontalAlignment(SwingConstants.LEFT);
		txtUser.setForeground(new Color(130, 130, 130));
		txtUser.setText("Entre com seu usuário para logar no sistema");
		Painel.add(txtUser, "cell 4 6 4 1,growx");
		txtUser.setColumns(10);
		
		RoundButton btnLimpa1 = new RoundButton("Limpa");
		btnLimpa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUser.setText("");
				
			}
		});
		btnLimpa1.setForeground(new Color(255, 255, 255));
		btnLimpa1.setBackground(new Color(224, 83, 76));
		Painel.add(btnLimpa1, "cell 9 6");
		
		JLabel lblSenha = new JLabel("Senha: *");
		Painel.add(lblSenha, "cell 4 7");
		
		txtSenha = new JTextField();
		txtSenha.setForeground(new Color(130, 130, 130));
		txtSenha.setText("Entre com uma senha");
		Painel.add(txtSenha, "cell 4 8 4 1,growx");
		txtSenha.setColumns(10);
		
		RoundButton bntLimpa2 = new RoundButton("Limpa");
		bntLimpa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSenha.setText("");
			}
		});
		bntLimpa2.setForeground(new Color(255, 255, 255));
		bntLimpa2.setBackground(new Color(224, 83, 76));
		Painel.add(bntLimpa2, "cell 9 8");
		
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
									TelaAdministrador telaAdm = new TelaAdministrador();
									dispose();
									telaAdm.setVisible(true);
								}
								else
								{
									TelaFuncionario telaF = new TelaFuncionario();
									dispose();
									telaF.setVisible(true);
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
				TelaInicial telaP = new TelaInicial();
				dispose();
				telaP.setVisible(true);
			}
		});
		btVoltar.setForeground(new Color(255, 255, 255));
		btVoltar.setBackground(new Color(0, 0, 0));
		Painel.add(btVoltar, "cell 4 10");
		btEntrar.setForeground(new Color(255, 255, 255));
		btEntrar.setBackground(new Color(224, 83, 76));
		Painel.add(btEntrar, "cell 5 10 2 1,alignx center");
	}

}
