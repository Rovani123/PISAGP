package visao.Funcionário;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ProdutoControle;
import modelo.classes.Produto;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import modelo.enumerador.Categoria;

public class TelaAlteracaoP extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	private JComboBox cbCategoria;


	public TelaAlteracaoP(JFrame telaA,Produto p) {
		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][grow][][][][]", "[][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel_4 = new JLabel("ALTERAÇÃO DO PRODUTO:");
		contentPane.add(lblNewLabel_4, "cell 4 2,alignx center");
		
		JLabel lblNewLabel = new JLabel("Nome do Produto:");
		contentPane.add(lblNewLabel, "cell 4 4");
		
		txtNome = new JTextField();
		contentPane.add(txtNome, "cell 4 5,growx");
		txtNome.setColumns(10);
		
		RoundButton btnNewButton = new RoundButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
			}
		});
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton, "cell 5 5");
		
		JLabel lblNewLabel_1 = new JLabel("Preço:");
		contentPane.add(lblNewLabel_1, "cell 4 6");
		
		txtPreco = new JTextField();
		contentPane.add(txtPreco, "cell 4 7,growx");
		txtPreco.setColumns(10);
		
		RoundButton btnNewButton_1 = new RoundButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPreco.setText("");
			}
		});
		btnNewButton_1.setForeground(new Color(245, 245, 245));
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_1, "cell 5 7");
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		contentPane.add(lblNewLabel_2, "cell 4 8");
		
		txtQuantidade = new JTextField();
		contentPane.add(txtQuantidade, "cell 4 9,growx");
		txtQuantidade.setColumns(10);
		
		RoundButton btnNewButton_2 = new RoundButton("Limpar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtQuantidade.setText("");
			}
		});
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		btnNewButton_2.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_2, "cell 5 9");
		
		JLabel lblNewLabel_3 = new JLabel("Categoria:");
		contentPane.add(lblNewLabel_3, "cell 4 10");
		
		cbCategoria = new JComboBox();
		cbCategoria.setModel(new DefaultComboBoxModel(Categoria.values()));
		cbCategoria.setBackground(new Color(245, 245, 245));
		contentPane.add(cbCategoria, "cell 4 11,growx");
		
		RoundButton btnNewButton_3 = new RoundButton("Limpar");
		btnNewButton_3.setBackground(new Color(224, 83, 76));
		btnNewButton_3.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_3, "cell 5 11");
		
		RoundButton btnNewButton_4 = new RoundButton("Salvar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				float preco = Float.parseFloat(txtPreco.getText());
				int quantidade = Integer.parseInt(txtQuantidade.getText());
				Categoria categoria = (Categoria) cbCategoria.getSelectedItem();
				
				alterarProduto(p, nome, preco, quantidade, categoria);
				
				
			}
		});
		btnNewButton_4.setBackground(new Color(224, 83, 76));
		btnNewButton_4.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_4, "cell 4 14,alignx center");
		
		RoundButton btnNewButton_5 = new RoundButton("Cancelar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerenciamentoP telaE = new TelaGerenciamentoP();
				dispose();
				telaE.setVisible(true);
			}
		});
		btnNewButton_5.setBackground(new Color(0, 0, 0));
		btnNewButton_5.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_5, "cell 5 14");
		setText(p);
	}

	public void setText(Produto p) {
		
		txtNome.setText(p.getNomeProduto());
		txtPreco.setText(String.valueOf(p.getPreco()));
		txtQuantidade.setText(String.valueOf(p.getQuantidadeEstoque()));
		cbCategoria.setSelectedItem(p.getCategoria());
	}
	private void alterarProduto(Produto p,String nome,float preco,int quantidade,Categoria categoria ) {
		
		p.setNomeProduto(nome);
		p.setPreco(preco);
		p.setQuantidadeEstoque(quantidade);
		p.setCategoria(categoria);
		ProdutoControle pc = new ProdutoControle();
		pc.alterarProduto(p);
		
	}
	
	
}
