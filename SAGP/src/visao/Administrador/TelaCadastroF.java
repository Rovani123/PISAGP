package visao.Administrador;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.FuncionarioControle;
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
import javax.swing.JPasswordField;

public class TelaCadastroF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField txtUsuario;
	private JTextField txtNome;
	private JPasswordField txtSenha;

	
	public TelaCadastroF(JFrame telaA,Funcionario f) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 556);
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[grow][][][grow][][grow][][][][][][][grow]", "[grow][][][grow][][][][][][][][][grow]"));
		
		ImageLabel lblLogo = new ImageLabel("");
		lblLogo.setIcon(new ImageIcon(TelaCadastroF.class.getResource("/Imagem/Logo.png")));
		painel.add(lblLogo, "cell 3 2 9 1,alignx center,growy");
		
		JLabel lblCadastre = new JLabel("Cadastre um Funcionário:");
		painel.add(lblCadastre, "cell 3 4 8 1,alignx center");
		
		JLabel lblUsuario = new JLabel("Usuário:");
		painel.add(lblUsuario, "cell 3 5,alignx left");
		
		JLabel lbla1 = new JLabel("*");
		lbla1.setForeground(new Color(255, 0, 0));
		painel.add(lbla1, "cell 4 5,alignx left");
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(128, 128, 128));
		txtUsuario.setText("Coloque o seu usuario para cadastar");
		painel.add(txtUsuario, "cell 3 6 8 1,growx");
		txtUsuario.setColumns(10);
		
		JButton btLimpa1 = new RoundButton("LIMPAR");
		btLimpa1.setBackground(new Color(224, 83, 76));
		btLimpa1.setForeground(new Color(245, 245, 245));
		btLimpa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtUsuario.setText("");
				
			}
		});
		painel.add(btLimpa1, "cell 11 6");
		
		JLabel lblNome = new JLabel("Nome:");
		painel.add(lblNome, "cell 3 7,alignx left");
		
		JLabel lbla2 = new JLabel("*");
		lbla2.setForeground(new Color(255, 0, 0));
		painel.add(lbla2, "cell 4 7,alignx left");
		
		txtNome = new JTextField();
		txtNome.setForeground(new Color(128, 128, 128));
		txtNome.setText("Entre com seu nome para cadastar");
		painel.add(txtNome, "cell 3 8 8 1,growx");
		txtNome.setColumns(10);
		
		JButton btLimpa2 = new RoundButton("New button");
		btLimpa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
			}
		});
		btLimpa2.setText("LIMPAR");
		btLimpa2.setBackground(new Color(224, 83, 76));
		btLimpa2.setForeground(new Color(245, 245, 245));
		painel.add(btLimpa2, "cell 11 8");
		
		JLabel lblSenha = new JLabel("Senha:");
		painel.add(lblSenha, "cell 3 9,alignx left");
		
		JLabel lbla3 = new JLabel("*");
		painel.add(lbla3, "cell 4 9,alignx trailing");
		
		JButton btCadastrar = new RoundButton("CADASTRAR");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtNome.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtSenha.getPassword().length ==0) {
						JOptionPane.showMessageDialog(null, "Todos os campos precisam ser preenchidos");
					}else {
						FuncionarioControle fc = new FuncionarioControle();
						fc.cadastrarFuncionario(txtNome.getText(),txtUsuario.getText(), String.valueOf(txtSenha.getPassword()));
						JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
						TelaGerenciamentoF tgf = new TelaGerenciamentoF(telaA, f);
						dispose();
						tgf.setVisible(true);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o funcionário");
				}				
			}
		});
		
		JButton btLimpa3 = new RoundButton("LIMPAR");
		btLimpa3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSenha.setText("");
			}
		});
		
		txtSenha = new JPasswordField();
		painel.add(txtSenha, "cell 3 10 8 1,growx");
		btLimpa3.setBackground(new Color(224, 83, 76));
		btLimpa3.setForeground(new Color(245, 245, 245));
		painel.add(btLimpa3, "cell 11 10");
		btCadastrar.setBackground(new Color(224, 83, 76));
		btCadastrar.setForeground(new Color(245, 245, 245));
		painel.add(btCadastrar, "cell 7 11");
		
		JButton btCancelar = new RoundButton("CANCELAR");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				TelaGerenciamentoF tgf = new TelaGerenciamentoF(telaA, f);
				dispose();
				tgf.setVisible(true);				
			}
		});
		btCancelar.setBackground(new Color(0, 0, 0));
		btCancelar.setForeground(new Color(245, 245, 245));
		painel.add(btCancelar, "cell 10 12");
		
		JButton btnNewButton_3 = new RoundButton("ENTRAR");
		btnNewButton_3.setBackground(new Color(224, 83, 76));
		btnNewButton_3.setForeground(new Color(245, 245, 245));
		painel.add(btnNewButton_3, "cell 11 12");
	}

}
