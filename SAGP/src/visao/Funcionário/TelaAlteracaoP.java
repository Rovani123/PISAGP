package visao.Funcionário;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.funcionario.AlteracaoPControle.AlterarPListener;
import controle.funcionario.ProdutoControle;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import modelo.enumerador.Categoria;
import javax.swing.ButtonGroup;

public class TelaAlteracaoP extends JFrame {

	private JPanel painel;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	private JComboBox cbCategoria;
	private RoundButton btSalvar;
	private RoundButton btCancelar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public TelaAlteracaoP(Produto p, Funcionario f) {
		
		Font font = new Font("Tahoma", Font.PLAIN, 11);;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Poppins-SemiBold.ttf"));
			
			font = font.deriveFont(Font.PLAIN, 11); // Definir o tamanho da fonte
				
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 460);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[][][][][grow][][][][]", "[][][][][][][][][][][][][][][]"));

		JLabel lblAlteracao = new JLabel("ALTERAÇÃO DO PRODUTO:");
		lblAlteracao.setFont(font);
		painel.add(lblAlteracao, "cell 4 2,alignx center");
		
				JLabel lblNome = new JLabel("Nome do Produto:");
				lblNome.setFont(font);
				painel.add(lblNome, "cell 3 4");

		txtNome = new JTextField();
		painel.add(txtNome, "cell 3 5 3 1,growx");
		txtNome.setColumns(10);
		
				JLabel lblPreco = new JLabel("Preço:");
				lblPreco.setFont(font);
				painel.add(lblPreco, "cell 3 6");

		txtPreco = new JTextField();
		painel.add(txtPreco, "cell 3 7 3 1,growx");
		txtPreco.setColumns(10);
		
				JLabel lblQuantidade = new JLabel("Quantidade:");
				lblQuantidade.setFont(font);
				painel.add(lblQuantidade, "cell 3 8");

		txtQuantidade = new JTextField();
		painel.add(txtQuantidade, "cell 3 9 3 1,growx");
		txtQuantidade.setColumns(10);
		
				JLabel lblCategoria = new JLabel("Categoria:");
				lblCategoria.setFont(font);
				painel.add(lblCategoria, "cell 3 10");

		cbCategoria = new JComboBox();
		cbCategoria.setModel(new DefaultComboBoxModel(Categoria.values()));
		cbCategoria.setBackground(new Color(245, 245, 245));
		painel.add(cbCategoria, "cell 3 11 3 1,growx");
		
				RoundButton btLimpa4 = new RoundButton("Limpar");
				buttonGroup.add(btLimpa4);
				btLimpa4.setFont(font);
				btLimpa4.setBackground(new Color(224, 83, 76));
				btLimpa4.setForeground(new Color(245, 245, 245));
				painel.add(btLimpa4, "cell 3 14");

		btSalvar = new RoundButton("Salvar");
		btSalvar.setFont(font);
		btSalvar.setActionCommand("btSalvar");
		btSalvar.setBackground(new Color(224, 83, 76));
		btSalvar.setForeground(new Color(245, 245, 245));
		painel.add(btSalvar, "cell 4 14,alignx center");

		btCancelar = new RoundButton("Cancelar");
		btCancelar.setFont(font);
		btCancelar.setActionCommand("btCancelar");
//		btCancelar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TelaGerenciamentoP telaE = new TelaGerenciamentoP(telaA, f);
//				dispose();
//				telaE.setVisible(true);
//			}
//		});
		btCancelar.setBackground(new Color(0, 0, 0));
		btCancelar.setForeground(new Color(245, 245, 245));
		painel.add(btCancelar, "cell 5 14");
		setText(p);
	}
	
	public void limpa () {
		txtNome.setText("");
		txtQuantidade.setText("");
		txtPreco.setText("");
	}

	public void setText(Produto p) {

		txtNome.setText(p.getNomeProduto());
		txtPreco.setText(String.valueOf(p.getPreco()));
		txtQuantidade.setText(String.valueOf(p.getQuantidadeEstoque()));
		cbCategoria.setSelectedItem(p.getCategoria());
	}

	private void alterarProduto(Produto p, String nome, float preco, int quantidade, Categoria categoria)
			throws SQLException {

		p.setNomeProduto(nome);
		p.setPreco(preco);
		p.setQuantidadeEstoque(quantidade);
		p.setCategoria(categoria);
		ProdutoControle pc = new ProdutoControle();
		pc.alterarProduto(p);

	}
	public void addAlteracaoPListener(ActionListener listener) {
		btLimpa1.addActionListener(listener);
		btLimpa2.addActionListener(listener);
		btLimpa3.addActionListener(listener);
		btSalvar.addActionListener(listener);
		btCancelar.addActionListener(listener);
	}
	
	public String getNome() {
		return txtNome.getText();
	}
	
	public void salvar () {
		
		txtNome.getText();
		Float.parseFloat(txtPreco.getText());
		Integer.parseInt(txtQuantidade.getText());
		(Categoria) cbCategoria.getSelectedItem();
		
		
	}

	
}
