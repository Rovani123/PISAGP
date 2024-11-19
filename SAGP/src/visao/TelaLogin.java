package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.LoginControle;
import controle.ProdutoControle;
import dal.ConexaoBD;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import net.miginfocom.swing.MigLayout;
import visao.Administrador.ZTelaAdministrador;
import visao.Administrador.TelaGerenciamentoF;
import visao.Funcionário.ZTelaFuncionario;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
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
		lblEntre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel.add(lblEntre, "cell 6 3 2 1,alignx center");
		
		JLabel lblUsuario = new JLabel("Usuário: *");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel.add(lblUsuario, "cell 4 5");
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setForeground(new Color(130, 130, 130));
		txtUsuario.setText("Entre com seu usuário para logar no sistema");
		painel.add(txtUsuario, "cell 4 6 4 1,growx");
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: *");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel.add(lblSenha, "cell 4 7");
		
		btEntrar = new RoundButton("Entrar");
		btEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btEntrar.setActionCommand("btEntrar");
//		btEntrar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				logar(txtUsuario.getText(),String.valueOf(txtSenha.getPassword()),tela);
//				
//			}
//		});
		
		btVoltar = new RoundButton("Voltar");
		btVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btVoltar.setText("Voltar");
		btVoltar.setActionCommand("btVoltar");
//		btVoltar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TelaInicial telaP = new TelaInicial();
//				dispose();
//				telaP.setVisible(true);
//			}
//		});
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtSenha.setToolTipText("");
		painel.add(txtSenha, "cell 4 8 4 1,grow");
		btVoltar.setForeground(new Color(255, 255, 255));
		btVoltar.setBackground(new Color(0, 0, 0));
		painel.add(btVoltar, "cell 4 9");
		
		bntLimpa = new RoundButton("Limpa");
		bntLimpa.setText("Limpar");
		bntLimpa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bntLimpa.setActionCommand("btLimpa");
//		bntLimpa.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				txtSenha.setText("");
//			}
//		});
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
	
	
	public String getUsuario() {
		return txtUsuario.getText();
	}
	public String getSenha() {
		return String.valueOf(txtSenha.getPassword());
	}
	
//	private void logar(String usuario, String senha,JFrame tela) {
//		LoginControle lc = new LoginControle();
//		
//		if(txtUsuario.getText().isEmpty() || txtSenha.getPassword().length ==0) {
//			JOptionPane.showMessageDialog(null, "Todos os campos precisam ser preenchidos");
//		}else {
//			Funcionario f;
//			try {
//				f = lc.validarLogin(usuario,senha);
//			} catch (SQLException e) {
//				e.printStackTrace();
//				JOptionPane.showMessageDialog(null, "Falha ao conectar com o banco de dados");
//				f = null;
//			}
//			if(f != null){
//				if(f.getadministrador() == 1){
//					TelaGerenciamentoF tgf = new TelaGerenciamentoF(tela,f);
//					dispose();
//					tgf.setVisible(true);
//				}else{
//					TelaGerenciamentoP tgp = new TelaGerenciamentoP(tela,f);
//					dispose();
//					tgp.setVisible(true);
//				}
//			}else {
//				JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
//			}
//		}
//	}
}
