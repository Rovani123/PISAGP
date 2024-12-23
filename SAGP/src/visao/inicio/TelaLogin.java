package visao.inicio;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private ImageIcon logo;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private RoundButton btEntrar;
	private RoundButton btfechar;
	private RoundButton btLimpar;
	private RoundButton btMostar;
	private JLabel lblNewLabel;

	public TelaLogin() {
		setTitle("Tela de Login");
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		logo = new ImageIcon(TelaInicial.class.getResource("/Imagem/Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1241, 912);
		
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][][grow][grow][][][grow][][][][][][][][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][][][][][][grow][grow][grow][][grow][grow][grow][grow]"));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(230, 230, 230));
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagem/LogoMediaMedia.png")));
		painel.add(lblNewLabel, "cell 4 1 2 1,alignx center,aligny center");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(230, 230, 230));
		lblLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagem/ImagemLogoGrande.png")));
		painel.add(lblLogo, "cell 6 1 2 1,alignx center");
		
		JLabel lblEntre = new JLabel("Entre com sua conta:");
		lblEntre.setFont(new Font("Arial", Font.BOLD, 30));
		painel.add(lblEntre, "cell 4 3 3 1,alignx center");
		
		JLabel lblUsuario = new JLabel("Usuário: *");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblUsuario, "cell 4 5");
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		//txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setForeground(new Color(130, 130, 130));
		txtUsuario.setText("Entre com seu usuário para logar no sistema");
		painel.add(txtUsuario, "cell 4 6 3 1,growx");
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: *");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		//lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel.add(lblSenha, "cell 4 7");

		
		btfechar = new RoundButton("Voltar");
		btfechar.setFont(new Font("Arial", Font.PLAIN, 20));
		//btfechar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btfechar.setText("Fechar");
		btfechar.setActionCommand("btVoltar");

		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		txtSenha.setHorizontalAlignment(SwingConstants.LEFT);
		txtSenha.setToolTipText("");
		painel.add(txtSenha, "cell 4 8 3 1,grow");
		btfechar.setForeground(new Color(255, 255, 255));
		btfechar.setBackground(new Color(0, 0, 0));
		painel.add(btfechar, "flowx,cell 4 9");
		
		btLimpar = new RoundButton("Limpar");
		btLimpar.setFont(new Font("Arial", Font.PLAIN, 20));
		btLimpar.setText("Limpar");
		//btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btLimpar.setActionCommand("btLimpa");
		btLimpar.setForeground(new Color(245, 245, 245));
		btLimpar.setBackground(new Color(224, 83, 76));
		painel.add(btLimpar, "cell 5 9,alignx right");
		
		btEntrar = new RoundButton("Entrar");
		btEntrar.setFont(new Font("Arial", Font.PLAIN, 20));
		//btEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btEntrar.setActionCommand("btEntrar");
		
		btEntrar.setForeground(new Color(255, 255, 255));
		btEntrar.setBackground(new Color(224, 83, 76));
		painel.add(btEntrar, "cell 6 9,alignx center");
		
		btMostar = new RoundButton("Voltar");
		btMostar.setText("Mostrar");
		btMostar.setSelectedIcon(new ImageIcon(TelaLogin.class.getResource("/Imagem/Senha.png")));
		btMostar.setForeground(Color.WHITE);
		btMostar.setFont(new Font("Arial", Font.PLAIN, 20));
		btMostar.setBackground(Color.BLACK);
		btMostar.setActionCommand("btMostar");
		painel.add(btMostar, "cell 4 10");
	}
	
	public void addLoginListener(ActionListener listener) {
		btEntrar.addActionListener(listener);
		btfechar.addActionListener(listener);
		btLimpar.addActionListener(listener);
		btMostar.addActionListener(listener);
	}
	
	public void setUsuario(String user) {
		txtUsuario.setText(user);
	}
	
	public String getUsuario() {
		return txtUsuario.getText();
	}
	
	public void setSenha(String senha) {
		txtSenha.setText(senha);
	}
	
	public String getSenha() {
		return String.valueOf(txtSenha.getPassword());
	}

	public void MostrarSenha(char c) {
		txtSenha.setEchoChar(c);
	}
	
}
