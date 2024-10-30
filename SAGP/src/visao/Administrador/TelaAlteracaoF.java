package visao.Administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.FuncionarioControle;
import controle.ProdutoControle;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.enumerador.Categoria;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class TelaAlteracaoF extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	public TelaAlteracaoF(JFrame telaA, Funcionario f) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(
				new MigLayout("", "[grow][][grow][][][][][][][grow]", "[grow][][grow][][][][][][][][][grow]"));

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaAlteracaoF.class.getResource("/Imagem/logoGrande.png")));
		contentPane.add(lblLogo, "cell 6 1,growx,aligny center");

		JLabel lblNome = new JLabel("NOME DO FUNCIORARIO:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNome, "cell 1 3,alignx right,aligny center");

		txtNome = new JTextField();
		contentPane.add(txtNome, "cell 2 3 6 1,growx,aligny center");
		txtNome.setColumns(10);

		JButton btnNewButton = new RoundButton("LIMPAR");
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setBackground(new Color(224, 83, 76));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton, "cell 8 3");

		JLabel lblUsuario = new JLabel("USÚARIO:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblUsuario, "cell 1 5,alignx right,aligny center");

		txtUsuario = new JTextField();
		contentPane.add(txtUsuario, "cell 2 5 6 1,growx,aligny center");
		txtUsuario.setColumns(10);

		JButton btnNewButton_1 = new RoundButton("LIMPAR");
		btnNewButton_1.setForeground(new Color(245, 245, 245));
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton_1, "cell 8 5");

		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblSenha, "cell 1 7,alignx trailing,aligny center");

		txtSenha = new JPasswordField();
		contentPane.add(txtSenha, "cell 2 7 6 1,growx,aligny center");

		JButton btnNewButton_2 = new RoundButton("LIMPAR");
		btnNewButton_2.setForeground(new Color(245, 245, 245));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton_2, "cell 8 7");

		JButton btSalvar = new RoundButton("SALVAR");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNome.getText().isEmpty() || txtUsuario.getText().isEmpty()|| txtSenha.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Todos os campos precisam ser preenchidos");
				} else {
					try {
						alterarFuncionario(f, txtNome.getText(), txtUsuario.getText(), txtSenha.getText());
						TelaGerenciamentoF tgf = new TelaGerenciamentoF(telaA, f);
						dispose();
						tgf.setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showInternalMessageDialog(null, "não foi possivel alterar os dados do funcionário");
					}
				}
			}
		});
		btSalvar.setForeground(new Color(245, 245, 245));
		btSalvar.setBackground(new Color(224, 83, 76));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));

		contentPane.add(btSalvar, "cell 6 10,alignx right,aligny center");

		JButton btCancelar = new RoundButton("CANCELAR");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerenciamentoF tgf = new TelaGerenciamentoF(telaA, f);
				dispose();
				tgf.setVisible(true);
			}
		});
		btCancelar.setForeground(new Color(245, 245, 245));
		btCancelar.setBackground(new Color(0, 0, 0));
		btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btCancelar, "cell 8 10,alignx center,aligny center");

		setText(f);
	}

	public void setText(Funcionario f) {
		txtNome.setText(f.getNome());
		txtUsuario.setText(f.getUsuarioFuncionario());
		txtSenha.setText(f.getSenha());
	}

	private void alterarFuncionario(Funcionario f, String nome, String usuario, String senha) throws SQLException {
		f.setNome(nome);
		f.setUsuarioFuncionario(usuario);
		f.setSenha(senha);
		FuncionarioControle fc = new FuncionarioControle();
		fc.alterarFuncionario(f);
	}

}
