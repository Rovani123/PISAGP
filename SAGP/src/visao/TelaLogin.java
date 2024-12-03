package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import javax.swing.JPasswordField;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private ImageIcon logo;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private RoundButton btEntrar;
	private RoundButton btVoltar;
	private RoundButton bntLimpa;


	public TelaLogin() {
		
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
		
		TelaLogin tela= this;
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		logo = new ImageIcon(TelaInicial.class.getResource("/Imagem/Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1241, 912);
		
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][][grow][grow][][][grow][][][][][][][][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][][][][][][grow][grow][grow][][grow][grow][grow][grow]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(230, 230, 230));
		lblLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagem/ImagemLogoGrande.png")));
		painel.add(lblLogo, "cell 6 1 2 1,alignx center");
		
		JLabel lblEntre = new JLabel("ENTRE COM SUA CONTA:");
		lblEntre.setFont(font);
		lblEntre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel.add(lblEntre, "cell 6 3 2 1,alignx center");
		
		JLabel lblUsuario = new JLabel("Usuário: *");
		lblUsuario.setFont(font);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel.add(lblUsuario, "cell 4 5");
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setForeground(new Color(130, 130, 130));
		txtUsuario.setText("Entre com seu usuário para logar no sistema");
		txtUsuario.setFont(font);
		painel.add(txtUsuario, "cell 4 6 4 1,growx");
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: *");
		lblSenha.setFont(font);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel.add(lblSenha, "cell 4 7");
		
		btEntrar = new RoundButton("Entrar");
		btEntrar.setFont(font);
		btEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btEntrar.setActionCommand("btEntrar");

		
		btVoltar = new RoundButton("Voltar");
		btVoltar.setFont(font);
		btVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btVoltar.setText("Voltar");
		btVoltar.setActionCommand("btVoltar");

		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtSenha.setToolTipText("");
		painel.add(txtSenha, "cell 4 8 4 1,grow");
		btVoltar.setForeground(new Color(255, 255, 255));
		btVoltar.setBackground(new Color(0, 0, 0));
		painel.add(btVoltar, "cell 4 9");
		
		bntLimpa = new RoundButton("Limpa");
		bntLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bntLimpa.setFont(font);
		bntLimpa.setText("Limpar");
		bntLimpa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bntLimpa.setActionCommand("btLimpa");
		bntLimpa.setForeground(new Color(255, 255, 255));
		bntLimpa.setBackground(new Color(224, 83, 76));
		painel.add(bntLimpa, "cell 5 9");
		
		btEntrar.setForeground(new Color(255, 255, 255));
		btEntrar.setBackground(new Color(224, 83, 76));
		painel.add(btEntrar, "cell 6 9 2 1,alignx center");
	}
	
	public void addLoginListener(ActionListener listener) {
		btEntrar.addActionListener(listener);
		btVoltar.addActionListener(listener);
		bntLimpa.addActionListener(listener);
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
	
}
