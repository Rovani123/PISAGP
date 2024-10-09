package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.LoginControle;
import dal.ConexaoBD;
import modelo.classes.Funcionario;
import net.miginfocom.swing.MigLayout;
import visao.Administrador.TelaAdministrador;
import visao.Funcionário.TelaFuncionario;
import visao.Funcionário.TelaGerenciamentoP;

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
import java.awt.Font;
import java.awt.Frame;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Painel;
	private ImageIcon logo;
	private JTextField txtUsuario;
	private JTextField txtSenha;


	public TelaLogin(JFrame telaA) {
		TelaLogin tl= this;
		setExtendedState(Frame.MAXIMIZED_BOTH);
		logo = new ImageIcon(TelaInicial.class.getResource("/Imagem/Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1241, 912);
		Painel = new JPanel();
		Painel.setBackground(new Color(230, 230, 230));
		Painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Painel);
		Painel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][][][grow][][][][][][][][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][][][][][][grow][grow][grow][][grow][grow][grow][grow]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(230, 230, 230));
		lblLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagem/ImagemLogoGrande.png")));
		Painel.add(lblLogo, "cell 5 1 2 1,alignx center");
		
		JLabel lblEntre = new JLabel("ENTRE COM SUA CONTA:");
		lblEntre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Painel.add(lblEntre, "cell 5 3 2 1,alignx center");
		
		JLabel lblUsuario = new JLabel("Usuário: *");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Painel.add(lblUsuario, "cell 4 5");
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setForeground(new Color(130, 130, 130));
		txtUsuario.setText("Entre com seu usuário para logar no sistema");
		Painel.add(txtUsuario, "cell 4 6 3 1,growx");
		txtUsuario.setColumns(10);
		
		RoundButton btnLimpa1 = new RoundButton("Limpa");
		btnLimpa1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimpa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setText("");
				
			}
		});
		btnLimpa1.setForeground(new Color(255, 255, 255));
		btnLimpa1.setBackground(new Color(224, 83, 76));
		Painel.add(btnLimpa1, "cell 7 6");
		
		JLabel lblSenha = new JLabel("Senha: *");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Painel.add(lblSenha, "cell 4 7");
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtSenha.setForeground(new Color(130, 130, 130));
		txtSenha.setText("Entre com uma senha");
		Painel.add(txtSenha, "cell 4 8 3 1,growx");
		txtSenha.setColumns(10);
		
		RoundButton btEntrar = new RoundButton("Entrar");
		btEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar(txtUsuario.getText(),txtSenha.getText());
				
			}
		});
		
		RoundButton btVoltar = new RoundButton("Voltar");
		btVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btVoltar.setText("Voltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaP = new TelaInicial();
				dispose();
				telaP.setVisible(true);
			}
		});
		
		RoundButton bntLimpa2 = new RoundButton("Limpa");
		bntLimpa2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bntLimpa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSenha.setText("");
			}
		});
		bntLimpa2.setForeground(new Color(255, 255, 255));
		bntLimpa2.setBackground(new Color(224, 83, 76));
		Painel.add(bntLimpa2, "cell 7 8");
		btVoltar.setForeground(new Color(255, 255, 255));
		btVoltar.setBackground(new Color(0, 0, 0));
		Painel.add(btVoltar, "cell 4 9");
		btEntrar.setForeground(new Color(255, 255, 255));
		btEntrar.setBackground(new Color(224, 83, 76));
		Painel.add(btEntrar, "cell 5 9 2 1,alignx center");
	}
	private void logar(String usuario, String senha) {
		LoginControle lc = new LoginControle();
		Funcionario f = lc.validarLogin(usuario,senha);
		if(f != null)
		{
			if(f.getadministrador() == 1)
			{
				TelaAdministrador tA = new TelaAdministrador();
				dispose();
				tA.setVisible(true);
			}else
			{
				TelaFuncionario tF = new TelaFuncionario();
				dispose();
				tF.setVisible(true);
			}
		}else 
		{
			JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
		}
		

	}

}
