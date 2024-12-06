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
	private JButton btSelecionarImagem;

	public TelaCadastroP(Funcionario f) {

		Font font = new Font("Tahoma", Font.PLAIN, 11);
		;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Poppins-SemiBold.ttf"));

			font = font.deriveFont(Font.PLAIN, 11); // Definir o tamanho da fonte

		} catch (FontFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 434);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[][][][grow][][][][]", "[][][][][][][][][][][][][][][]"));

		JLabel lblCadastroProduto = new JLabel("CADASTRO DE PRODUTO:");
		lblCadastroProduto.setFont(font);
		painel.add(lblCadastroProduto, "cell 3 2,alignx center");

		JLabel lblNome = new JLabel("Nome do Produto:");
		lblNome.setFont(font);
		painel.add(lblNome, "cell 2 4");

		txtNome = new JTextField();
		painel.add(txtNome, "cell 2 5 4 1,growx");
		txtNome.setColumns(10);

		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(font);
		painel.add(lblPreco, "cell 2 6");

		txtPreco = new JTextField();
		painel.add(txtPreco, "cell 2 7 4 1,growx");
		txtPreco.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(font);
		painel.add(lblQuantidade, "cell 2 8");

		txtQuantidade = new JTextField();
		painel.add(txtQuantidade, "cell 2 9 4 1,growx");
		txtQuantidade.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(font);
		painel.add(lblCategoria, "cell 2 10");

		cbCategoria = new JComboBox();
		cbCategoria.setModel(new DefaultComboBoxModel(Categoria.values()));
		painel.add(cbCategoria, "cell 2 11 4 1,growx");

		btSalvar = new RoundButton("Salvar");
		btSalvar.setFont(font);
		btSalvar.setActionCommand("btSalvar");
		btSelecionarImagem = new JButton("Selecionar Imagem");
		btSelecionarImagem.setFont(font);
		btSelecionarImagem.setActionCommand("btFile");
		painel.add(btSelecionarImagem, "cell 3 12,alignx center,aligny center");
		btLimpar = new RoundButton("Limpar");
		btLimpar.setFont(font);
		btLimpar.setForeground(new Color(245, 245, 245));
		btLimpar.setBackground(new Color(224, 83, 76));
		btLimpar.setActionCommand("btLimpa");
		painel.add(btLimpar, "cell 5 12");
		btSalvar.setForeground(new Color(245, 245, 245));
		btSalvar.setBackground(new Color(224, 83, 76));
		painel.add(btSalvar, "cell 3 14,alignx center");
		btCancelar = new RoundButton("Cancelar");
		btCancelar.setFont(font);
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
