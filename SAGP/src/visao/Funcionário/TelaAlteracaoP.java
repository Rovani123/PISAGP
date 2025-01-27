package visao.Funcionário;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.enumerador.Categoria;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaAlteracaoP extends JFrame {

	private JPanel painel;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	private JComboBox cbCategoria;
	private RoundButton btSalvar;
	private RoundButton btCancelar;
	private RoundButton btLimpar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel;
	private RoundButton btSelecionarFoto;
	
	public TelaAlteracaoP(Produto p, Funcionario f) {
		setTitle("Tela de Alteração de Produto");

		setBackground(new Color(230, 230, 230));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 460);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[][][][][grow][][][][]", "[][][][][][][][][][][][][][][][]"));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(230, 230, 230));
		lblNewLabel.setIcon(new ImageIcon(TelaAlteracaoP.class.getResource("/Imagem/LogoMediaMedia.png")));
		painel.add(lblNewLabel, "cell 3 1 3 1");

		JLabel lblAlteracao = new JLabel("Alteração do Produto:");
		lblAlteracao.setFont(new Font("Arial", Font.BOLD, 30));
		painel.add(lblAlteracao, "cell 4 3,alignx center");

		JLabel lblNome = new JLabel("Nome do Produto:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblNome, "cell 3 5");

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(txtNome, "cell 3 6 3 1,growx");
		txtNome.setColumns(10);

		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblPreco, "cell 3 7");

		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(txtPreco, "cell 3 8 3 1,growx");
		txtPreco.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblQuantidade, "cell 3 9");

		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(txtQuantidade, "cell 3 10 3 1,growx");
		txtQuantidade.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblCategoria, "cell 3 11");

		cbCategoria = new JComboBox();
		cbCategoria.setFont(new Font("Arial", Font.PLAIN, 20));
		cbCategoria.setModel(new DefaultComboBoxModel(Categoria.values()));
		cbCategoria.setBackground(new Color(245, 245, 245));
		painel.add(cbCategoria, "cell 3 12 3 1,growx");
		
		btSelecionarFoto = new RoundButton("Selecionar Foto");
		btSelecionarFoto.setForeground(new Color(245, 245, 245));
		btSelecionarFoto.setBackground(new Color(224, 83, 76));
		btSelecionarFoto.setFont(new Font("Arial", Font.PLAIN, 20));
		btSelecionarFoto.setActionCommand("btSelecionarFoto");
		painel.add(btSelecionarFoto, "cell 3 13");

		btLimpar = new RoundButton("Limpar");
		btLimpar.setFont(new Font("Arial", Font.PLAIN, 20));
		buttonGroup.add(btLimpar);
		btLimpar.setBackground(new Color(224, 83, 76));
		btLimpar.setForeground(new Color(245, 245, 245));
		btLimpar.setActionCommand("btLimpa");
		painel.add(btLimpar, "cell 3 15");

		btSalvar = new RoundButton("Salvar");
		btSalvar.setFont(new Font("Arial", Font.PLAIN, 20));
		btSalvar.setActionCommand("btSalvar");
		btSalvar.setBackground(new Color(224, 83, 76));
		btSalvar.setForeground(new Color(245, 245, 245));
		painel.add(btSalvar, "cell 4 15,alignx center");

		btCancelar = new RoundButton("Cancelar");
		btCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btCancelar.setActionCommand("btCancelar");
		btCancelar.setBackground(new Color(0, 0, 0));
		btCancelar.setForeground(new Color(245, 245, 245));
		painel.add(btCancelar, "cell 5 15");
		setText(p);
	}

	public void limpa() {
		txtNome.setText("");
		txtQuantidade.setText("");
		txtPreco.setText("");
		cbCategoria.setSelectedIndex(0);
	}

	public void setText(Produto p) {

		txtNome.setText(p.getNomeProduto());
		txtPreco.setText(String.valueOf(p.getPreco()));
		txtQuantidade.setText(String.valueOf(p.getQuantidadeEstoque()));
		cbCategoria.setSelectedItem(p.getCategoria());
	}

	public void setCampos(Produto p) {
		txtNome.setText(p.getNomeProduto());
		txtPreco.setText(String.valueOf(p.getPreco()));
		txtQuantidade.setText(String.valueOf(p.getQuantidadeEstoque()));
		cbCategoria.setSelectedItem(p);
	}

	public void addAlteracaoPListener(ActionListener listener) {
		btLimpar.addActionListener(listener);
		btSalvar.addActionListener(listener);
		btCancelar.addActionListener(listener);
		btSelecionarFoto.addActionListener(listener);
	}

	public String getNome() {
		return txtNome.getText();
	}

	public String getPreco() {
		return txtPreco.getText();
	}

	public String getQuantidade() {
		return txtQuantidade.getText();
	}

	public Categoria getCategoria() {
		return (Categoria) cbCategoria.getSelectedItem();
	}
}
