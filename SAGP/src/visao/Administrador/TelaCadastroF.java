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
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import java.awt.Font;

public class TelaCadastroF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField txtUsuario;
	private JTextField txtNome;
	private JPasswordField txtSenha;
	private RoundButton btCancelar;
	private RoundButton btCadastrar;
	private RoundButton btLimpar;
	
	public TelaCadastroF(Funcionario f) {
		setTitle("Tela de Cadastro de Funcionário");
		
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 556);
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[grow][][][grow][][][grow][][][][][][][grow]", "[grow][][][grow][][][][][][][][][grow]"));
		
		ImageLabel lblLogo = new ImageLabel("");
		lblLogo.setIcon(new ImageIcon(TelaCadastroF.class.getResource("/Imagem/LogoMediaMedia.png")));
		painel.add(lblLogo, "cell 3 0 10 2,alignx center,aligny top");
		
		JLabel lblCadastre = new JLabel("Cadastre um Funcionário:");
		lblCadastre.setFont(new Font("Arial", Font.BOLD, 30));
		painel.add(lblCadastre, "cell 3 2 9 1,alignx center,aligny baseline");
		
		JLabel lblUsuario = new JLabel("Usuário: *");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblUsuario, "cell 3 4,alignx left,aligny top");
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(128, 128, 128));
		txtUsuario.setText("Coloque o seu usuario para cadastar");
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(txtUsuario, "cell 3 5 10 1,growx,aligny top");
		txtUsuario.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome: *");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblNome, "cell 3 6,alignx left,aligny top");
		
		txtNome = new JTextField();
		txtNome.setForeground(new Color(128, 128, 128));
		txtNome.setText("Entre com seu nome para cadastar");
		txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(txtNome, "cell 3 7 10 1,growx,aligny top");
		txtNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: *");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblSenha, "cell 3 8,alignx left,aligny top");
		
		btLimpar = new RoundButton("LIMPAR");
		btLimpar.setText("Limpar");
		btLimpar.setActionCommand("btLimpa3");
		btLimpar.setBackground(new Color(224, 83, 76));
		btLimpar.setForeground(new Color(245, 245, 245));
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		txtSenha.setToolTipText("");
		painel.add(txtSenha, "cell 3 9 10 1,growx,aligny top");
		btCadastrar = new RoundButton("CADASTRAR");
		btCadastrar.setText("Cadastrar");
		btCadastrar.setFont(new Font("Arial", Font.PLAIN, 20));
		btCadastrar.setActionCommand("btCadastrar");
		btCadastrar.setBackground(new Color(224, 83, 76));
		btCadastrar.setForeground(new Color(245, 245, 245));
		painel.add(btCadastrar, "flowx,cell 3 12,alignx left,aligny center");
		
		btCancelar = new RoundButton("CANCELAR");
		btCancelar.setText("Cancelar");
		btCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btCancelar.setActionCommand("btCancelar");
		btCancelar.setBackground(new Color(0, 0, 0));
		btCancelar.setForeground(new Color(245, 245, 245));
		painel.add(btCancelar, "cell 12 12,alignx left,aligny center");
		
	}
	public void addCadastroF(ActionListener listener) {
		btCancelar.addActionListener(listener);
		btCadastrar.addActionListener(listener);
		btLimpar.addActionListener(listener);
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
