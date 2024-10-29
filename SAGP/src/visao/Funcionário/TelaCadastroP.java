package visao.Funcionário;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.ProdutoControle;
import modelo.classes.Funcionario;
import modelo.enumerador.Categoria;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

public class TelaCadastroP extends JFrame {

	private JPanel painel;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQuantidade;

	public TelaCadastroP(JFrame telaA, Funcionario f) {

		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 434);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[][][][grow][][][][]", "[][][][][][][][][][][][][][]"));

		JLabel lblCadastroProduto = new JLabel("CADASTRO DE PRODUTO:");
		painel.add(lblCadastroProduto, "cell 3 2,alignx center");

		JLabel lblNome = new JLabel("Nome do Produto:");
		painel.add(lblNome, "cell 3 4");

		txtNome = new JTextField();
		painel.add(txtNome, "cell 3 5 2 1,growx");
		txtNome.setColumns(10);

		RoundButton btLimpa1 = new RoundButton("Limpar");
		btLimpa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
			}
		});
		btLimpa1.setForeground(new Color(245, 245, 245));
		btLimpa1.setBackground(new Color(224, 83, 76));
		painel.add(btLimpa1, "cell 5 5");

		JLabel lblPreco = new JLabel("Preço:");
		painel.add(lblPreco, "cell 3 6");

		txtPreco = new JTextField();
		painel.add(txtPreco, "cell 3 7 2 1,growx");
		txtPreco.setColumns(10);

		RoundButton btLimpa2 = new RoundButton("Limpar");
		btLimpa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btLimpa2.setForeground(new Color(245, 245, 245));
		btLimpa2.setBackground(new Color(224, 83, 76));
		painel.add(btLimpa2, "cell 5 7");

		JLabel lblQuantidade = new JLabel("Quantidade:");
		painel.add(lblQuantidade, "cell 3 8");

		txtQuantidade = new JTextField();
		painel.add(txtQuantidade, "cell 3 9 2 1,growx");
		txtQuantidade.setColumns(10);

		RoundButton btLimpa3 = new RoundButton("Limpar");
		btLimpa3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btLimpa3.setForeground(new Color(245, 245, 245));
		btLimpa3.setBackground(new Color(224, 83, 76));
		painel.add(btLimpa3, "cell 5 9");

		JLabel lblCategoria = new JLabel("Categoria:");
		painel.add(lblCategoria, "cell 3 10");

		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setModel(new DefaultComboBoxModel(Categoria.values()));
		painel.add(cbCategoria, "cell 3 11,growx");

		RoundButton btLimpa4 = new RoundButton("Limpar");
		btLimpa4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btLimpa4.setForeground(new Color(245, 245, 245));
		btLimpa4.setBackground(new Color(224, 83, 76));
		painel.add(btLimpa4, "cell 5 11");

		RoundButton btSalvar = new RoundButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = null;
				float preco = 0;
				int quantidade = 0;
				Categoria categoria = null;
				try {
				nome = (txtNome.getText());
				preco = (Float.parseFloat(txtPreco.getText()));
				quantidade = (Integer.parseInt(txtQuantidade.getText()));
				categoria = (Categoria) cbCategoria.getSelectedItem();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				if (txtNome.getText().isEmpty() || txtPreco.getText().isEmpty() || txtQuantidade.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Todos os campos precisam ser preenchidos");
				} else {
					try {
						cadastrarProduto(nome, preco, quantidade, categoria.toString());
						TelaGerenciamentoP telaGerenciamentoP = new TelaGerenciamentoP(telaA, f);
						dispose();
						telaGerenciamentoP.setVisible(true);
						JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Não foi possivel adicionar esse produto");

					}
				}
			}
		});
		btSalvar.setForeground(new Color(245, 245, 245));
		btSalvar.setBackground(new Color(224, 83, 76));
		painel.add(btSalvar, "cell 3 13,alignx center");

		RoundButton btCancelar = new RoundButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerenciamentoP telaE = new TelaGerenciamentoP(telaA, f);
				dispose();
				telaE.setVisible(true);
			}
		});
		btCancelar.setForeground(new Color(245, 245, 245));
		btCancelar.setBackground(new Color(0, 0, 0));
		painel.add(btCancelar, "cell 5 13");
	}

	private void cadastrarProduto(String nome, float preco, int quantidade, String categoria) throws SQLException {
		ProdutoControle pc = new ProdutoControle();
		pc.cadastrarProduto(nome, preco, quantidade, categoria);

	}

}
