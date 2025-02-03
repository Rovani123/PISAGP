package visao.Funcionário;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
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
import javax.swing.ImageIcon;

public class TelaCadastroP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	private RoundButton btLimpar;
	private RoundButton btSalvar;
	private RoundButton btCancelar;
	private JComboBox cbCategoria;
	private RoundButton btSelecionarImagem;
	private JLabel lblNewLabel;

	public TelaCadastroP(Funcionario f) {
		setTitle("Tela de Cadastro de Produto");

		setBackground(new Color(230, 230, 230));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 434);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ScrollPane scroll = new ScrollPane();
		scroll.add(painel);
		
		setContentPane(scroll);
		painel.setLayout(new MigLayout("", "[][][][grow][][][][]", "[][][][][][][][][][][][][][][][]"));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(230, 230, 230));
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroP.class.getResource("/Imagem/LogoMediaMedia.png")));
		painel.add(lblNewLabel, "cell 2 1 4 1,alignx center,aligny center");

		JLabel lblCadastroProduto = new JLabel("Cadastro de Produto:");
		lblCadastroProduto.setFont(new Font("Arial", Font.BOLD, 30));
		painel.add(lblCadastroProduto, "cell 3 3,alignx center");

		JLabel lblNome = new JLabel("Nome do Produto:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblNome, "cell 2 5");

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(txtNome, "cell 2 6 4 1,growx");
		txtNome.setColumns(10);

		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblPreco, "cell 2 7");

		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(txtPreco, "cell 2 8 4 1,growx");
		txtPreco.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblQuantidade, "cell 2 9");

		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(txtQuantidade, "cell 2 10 4 1,growx");
		txtQuantidade.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Arial", Font.PLAIN, 20));
		painel.add(lblCategoria, "cell 2 11");

		cbCategoria = new JComboBox();
		cbCategoria.setFont(new Font("Arial", Font.PLAIN, 20));
		cbCategoria.setModel(new DefaultComboBoxModel(Categoria.values()));
		painel.add(cbCategoria, "cell 2 12 4 1,growx");

		btSalvar = new RoundButton("Salvar");
		btSalvar.setFont(new Font("Arial", Font.PLAIN, 20));
		btSalvar.setActionCommand("btSalvar");
		
		btSelecionarImagem = new RoundButton("Selecionar Imagem");
		btSelecionarImagem.setBackground(new Color(245, 245, 245));
		btSelecionarImagem.setFont(new Font("Arial", Font.PLAIN, 20));
		btSelecionarImagem.setActionCommand("btFile");
		painel.add(btSelecionarImagem, "cell 3 13,alignx center,aligny center");
		
		btLimpar = new RoundButton("Limpar");
		btLimpar.setFont(new Font("Arial", Font.PLAIN, 20));
		btLimpar.setForeground(new Color(245, 245, 245));
		btLimpar.setBackground(new Color(224, 83, 76));
		btLimpar.setActionCommand("btLimpar");
		painel.add(btLimpar, "cell 2 15,alignx left");
		btSalvar.setForeground(new Color(245, 245, 245));
		btSalvar.setBackground(new Color(224, 83, 76));
		painel.add(btSalvar, "cell 3 15,alignx center");
		
		btCancelar = new RoundButton("Cancelar");
		btCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btCancelar.setActionCommand("btCancelar");
		btCancelar.setForeground(new Color(245, 245, 245));
		btCancelar.setBackground(new Color(0, 0, 0));
		painel.add(btCancelar, "cell 5 15");
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
