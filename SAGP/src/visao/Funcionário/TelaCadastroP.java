package visao.Funcionário;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import modelo.classes.Funcionario;
import modelo.enumerador.Categoria;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import javax.swing.JButton;

public class TelaCadastroP extends JFrame {

	private JPanel painel;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	private JLabel lblFoto;
	private Image imagemProduto;
	private RoundButton btLimpar;
	private RoundButton btSalvar;
	private RoundButton btCancelar;
	private JComboBox cbCategoria;
	private RoundButton btSelecionarImagem;

	public TelaCadastroP(Funcionario f) {

		setBackground(new Color(230, 230, 230));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 434);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[][][][grow][][][][]", "[][][][][][][][][][][][][][][]"));

		JLabel lblCadastroProduto = new JLabel("CADASTRO DE PRODUTO:");
		lblCadastroProduto.setFont(new Font("Arial", Font.PLAIN, 30));
		painel.add(lblCadastroProduto, "cell 3 2,alignx center");

		JLabel lblNome = new JLabel("Nome do Produto:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblNome, "cell 2 4");

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(txtNome, "cell 2 5 4 1,growx");
		txtNome.setColumns(10);

		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblPreco, "cell 2 6");

		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(txtPreco, "cell 2 7 4 1,growx");
		txtPreco.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblQuantidade, "cell 2 8");

		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(txtQuantidade, "cell 2 9 4 1,growx");
		txtQuantidade.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblCategoria, "cell 2 10");

		cbCategoria = new JComboBox();
		cbCategoria.setFont(new Font("Arial", Font.PLAIN, 20));
		cbCategoria.setModel(new DefaultComboBoxModel(Categoria.values()));
		painel.add(cbCategoria, "cell 2 11 4 1,growx");

		btSalvar = new RoundButton("Salvar");
		btSalvar.setFont(new Font("Arial", Font.PLAIN, 20));
		btSalvar.setActionCommand("btSalvar");
		
		btLimpar = new RoundButton("Limpar");
		btLimpar.setFont(new Font("Arial", Font.PLAIN, 20));
		btLimpar.setForeground(new Color(245, 245, 245));
		btLimpar.setBackground(new Color(224, 83, 76));
		btLimpar.setActionCommand("btLimpar");
		painel.add(btLimpar, "cell 2 12,alignx center");
		
		btSelecionarImagem = new RoundButton("Selecionar Imagem");
		btSelecionarImagem.setBackground(new Color(245, 245, 245));
		btSelecionarImagem.setFont(new Font("Arial", Font.PLAIN, 20));
		btSelecionarImagem.setActionCommand("btFile");
		painel.add(btSelecionarImagem, "cell 3 12,alignx center,aligny center");
		btSalvar.setForeground(new Color(245, 245, 245));
		btSalvar.setBackground(new Color(224, 83, 76));
		painel.add(btSalvar, "cell 3 14,alignx center");
		
		btCancelar = new RoundButton("Cancelar");
		btCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btCancelar.setActionCommand("btCancelar");
		btCancelar.setForeground(new Color(245, 245, 245));
		btCancelar.setBackground(new Color(0, 0, 0));
		painel.add(btCancelar, "cell 5 14");
	}

	public void addCadastroP(ActionListener listener) {
		btLimpar.addActionListener(listener);
		btSalvar.addActionListener(listener);
		btCancelar.addActionListener(listener);
		btSelecionarImagem.addActionListener(listener);
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

	public void limpar() {
		txtNome.setText("");
		txtPreco.setText("");
		txtQuantidade.setText("");
		cbCategoria.setSelectedIndex(0);
	}
}
