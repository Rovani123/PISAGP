package visao.Administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.classes.Funcionario;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPasswordField;

public class TelaAlteracaoF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private RoundButton btSalvar;
	private RoundButton btCancelar;
	private RoundButton btLimpar;
	private JLabel lblNewLabel;
	
	public TelaAlteracaoF(Funcionario f) {
		setTitle("Tela de Alteração do Funcionário");

		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow 50][][grow 50][][][][][][][grow 50]", "[grow][][][][grow][][][][][][][][][grow]"));
		
				JLabel lblLogo = new JLabel("");
				lblLogo.setIcon(new ImageIcon(TelaAlteracaoF.class.getResource("/Imagem/LogoMediaMedia.png")));
				contentPane.add(lblLogo, "cell 2 1 7 1,alignx center,aligny center");
		
		lblNewLabel = new JLabel("Alteração de funcionário");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblNewLabel, "cell 2 2 7 1,alignx center,aligny center");

		JLabel lblNome = new JLabel("Nome do Funcionário: *");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNome, "cell 2 4,alignx left,aligny bottom");

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(txtNome, "cell 2 5 7 1,growx,aligny top");
		txtNome.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuário: *");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 25));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblUsuario, "cell 2 6,alignx left,aligny bottom");

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(txtUsuario, "cell 2 7 7 1,growx,aligny top");
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha: *");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 25));
		contentPane.add(lblSenha, "cell 2 8,alignx left,aligny bottom");

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(txtSenha, "cell 2 9 7 1,growx,aligny top");

		btSalvar = new RoundButton("SALVAR");
		btSalvar.setFont(new Font("Arial", Font.PLAIN, 20));
		btSalvar.setText("Salvar");
		btSalvar.setActionCommand("btSalvar");
//		btSalvar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (txtNome.getText().isEmpty() || txtUsuario.getText().isEmpty()|| txtSenha.getPassword().length == 0) {
//					JOptionPane.showMessageDialog(null, "Todos os campos precisam ser preenchidos");
//				} else {
//					try {
//						alterarFuncionario(f, txtNome.getText(), txtUsuario.getText(), txtSenha.getText());
//						TelaGerenciamentoF tgf = new TelaGerenciamentoF(telaA, f);
//						dispose();
//						tgf.setVisible(true);
//					} catch (SQLException e1) {
//						e1.printStackTrace();
//						JOptionPane.showInternalMessageDialog(null, "não foi possivel alterar os dados do funcionário");
//					}
//				}
//			}
//		});

		btLimpar = new RoundButton("LIMPAR");
		btLimpar.setFont(new Font("Arial", Font.PLAIN, 20));
		btLimpar.setText("Limpar");
		btLimpar.setActionCommand("btLimpar");
		btLimpar.setForeground(new Color(245, 245, 245));
		btLimpar.setBackground(new Color(224, 83, 76));
		// btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btLimpar, "cell 2 12");
		btSalvar.setForeground(new Color(245, 245, 245));
		btSalvar.setBackground(new Color(224, 83, 76));
		// btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));

		contentPane.add(btSalvar, "cell 6 12,alignx right,aligny center");

		btCancelar = new RoundButton("CANCELAR");
		btCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btCancelar.setText("Cancelar");
		btCancelar.setActionCommand("btCancelar");
//		btCancelar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TelaGerenciamentoF tgf = new TelaGerenciamentoF(telaA, f);
//				dispose();
//				tgf.setVisible(true);
//			}
//		});
		btCancelar.setForeground(new Color(245, 245, 245));
		btCancelar.setBackground(new Color(0, 0, 0));
		contentPane.add(btCancelar, "cell 8 12,alignx center,aligny center");

	}

	public void setText(Funcionario f) {
		txtNome.setText(f.getNome());
		txtUsuario.setText(f.getUsuarioFuncionario());
		txtSenha.setText(f.getSenha());
	}

	public void addAlteracaoF(ActionListener listener) {
		btSalvar.addActionListener(listener);
		btCancelar.addActionListener(listener);
		btLimpar.addActionListener(listener);
	}

	public void limpa() {
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
