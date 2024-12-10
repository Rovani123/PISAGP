package visao.Administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.classes.Funcionario;
import net.miginfocom.swing.MigLayout;
import visao.ImageLabel;
import visao.RoundButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.FontFormatException;

public class TelaCadastroF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField txtUsuario;
	private JTextField txtNome;
	private JPasswordField txtSenha;
	private RoundButton btCancelar;
	private RoundButton btCadastrar;
	private RoundButton btLimpar;
	private RoundButton btEntrar;
	
	public TelaCadastroF(Funcionario f) {
		
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
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 556);
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[grow][][][grow][][][grow][][][][][][][grow]", "[grow][][][grow][][][][][][][][][grow]"));
		
		ImageLabel lblLogo = new ImageLabel("");
		lblLogo.setIcon(new ImageIcon(TelaCadastroF.class.getResource("/Imagem/ImagemLogoGrande.png")));
		painel.add(lblLogo, "cell 3 2 10 1,alignx center,growy");
		
		JLabel lblCadastre = new JLabel("Cadastre um Funcionário:");
		lblCadastre.setFont(font);
		painel.add(lblCadastre, "cell 3 4 9 1,alignx center");
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(font);
		painel.add(lblUsuario, "cell 3 5,alignx left");
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(128, 128, 128));
		txtUsuario.setText("Coloque o seu usuario para cadastar");
		txtUsuario.setFont(font);
		painel.add(txtUsuario, "cell 3 6 9 1,growx");
		txtUsuario.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(font);
		painel.add(lblNome, "cell 3 7,alignx left");
		
		txtNome = new JTextField();
		txtNome.setForeground(new Color(128, 128, 128));
		txtNome.setText("Entre com seu nome para cadastar");
		txtNome.setFont(font);
		painel.add(txtNome, "cell 3 8 9 1,growx");
		txtNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(font);
		painel.add(lblSenha, "cell 3 9,alignx left");
		
		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("");
		painel.add(txtSenha, "cell 3 10 9 1,growx");
		
		btCancelar = new RoundButton("CANCELAR");
		btCancelar.setText("Cancelar");
		btCancelar.setFont(font);
		btCancelar.setActionCommand("btCancelar");
		
		btLimpar = new RoundButton("LIMPAR");
		btLimpar.setText("Limpar");
		btLimpar.setFont(font);
		btLimpar.setActionCommand("btLimpa3");
		btLimpar.setBackground(new Color(224, 83, 76));
		btLimpar.setForeground(new Color(245, 245, 245));
		btCadastrar = new RoundButton("CADASTRAR");
		btCadastrar.setText("Cadastrar");
		btCadastrar.setFont(font);
		btCadastrar.setActionCommand("btCadastrar");
		btCadastrar.setBackground(new Color(224, 83, 76));
		btCadastrar.setForeground(new Color(245, 245, 245));
		painel.add(btCadastrar, "cell 6 11");
		btCancelar.setBackground(new Color(0, 0, 0));
		btCancelar.setForeground(new Color(245, 245, 245));
		painel.add(btCancelar, "cell 11 12");
		
		btEntrar = new RoundButton("ENTRAR");
		btEntrar.setText("Entrar");
		btEntrar.setFont(font);
		btEntrar.setActionCommand("btEntrar");
		btEntrar.setBackground(new Color(224, 83, 76));
		btEntrar.setForeground(new Color(245, 245, 245));
		painel.add(btEntrar, "cell 12 12,aligny bottom");
	}
	public void addCadastroF(ActionListener listener) {
		btCancelar.addActionListener(listener);
		btCadastrar.addActionListener(listener);
		btLimpar.addActionListener(listener);
		btEntrar.addActionListener(listener);
	}
	public void limpar() {
		txtNome.setText("");
		txtUsuario.setText("");
		txtSenha.setText("");
		
	}
	public String getNome() {
		return txtNome.getText();
	}
	public String getUsuario() {
		return txtUsuario.getText();
	}
	public String getSenha() {
		return String.valueOf(txtSenha.getPassword());
	}
}
