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

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
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
		setBounds(100, 100, 423, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][grow][][][grow]", "[][][][][][][][][][][][][]"));
		
		JLabel lblUser = new JLabel("Usuário");
		contentPane.add(lblUser, "cell 4 2");
		
		txtUsuario = new JTextField();
		contentPane.add(txtUsuario, "cell 4 3,growx");
		txtUsuario.setColumns(10);
		
		JButton bntLimpa = new JButton("Limpa");
		contentPane.add(bntLimpa, "cell 5 3");
		
		JLabel lblSenha = new JLabel("Senha");
		contentPane.add(lblSenha, "cell 4 4");
		
		txtSenha = new JTextField();
		contentPane.add(txtSenha, "cell 4 5,growx");
		txtSenha.setColumns(10);
		
		JButton btnLimpa_1 = new JButton("Limpa");
		contentPane.add(btnLimpa_1, "cell 5 5");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnCancelar, "cell 4 7");
		
		JButton btEntrar = new JButton("Entrar");
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement stml = null;
				Connection conn = ConexaoBD.getConexaoMySQL();
				
				String user = txtUsuario.getText();
				String senha = txtSenha.getText();
				
				try {
					stml = (Statement) conn.createStatement();
					ResultSet resl = null;
					resl = stml.executeQuery("SELECT * FROM FUNCIONARIOS");
					while(resl.next())
					{
						if(user.equals(resl.getString("usuarioFuncionario")) && senha.equals(resl.getString("Senha")))
						{
							TelaFuncionarioEstoque janelaF = new TelaFuncionarioEstoque();
							janelaF.setVisible(true);
						} else
						{
							
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
		contentPane.add(btEntrar, "cell 5 7");
	}

}
