package visao.Funcionário;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class TelaAlteracaoProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQuantidade;




	public TelaAlteracaoProduto(TelaFuncionarioEstoque TelaAlterada,Produto produto) {
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
		
		RoundButton btnLimpar = new RoundButton("Limpar");
		btnLimpar.setForeground(new Color(245, 245, 245));
		btnLimpar.setBackground(new Color(224, 83, 76));
		contentPane.add(btnLimpar, "cell 5 5");
		
		JLabel lblNewLabel_1 = new JLabel("Preço:");
		contentPane.add(lblNewLabel_1, "cell 4 6");
		
		txtPreco = new JTextField();
		contentPane.add(txtPreco, "cell 4 7,growx");
		txtPreco.setColumns(10);
		
		RoundButton btnLimpar2 = new RoundButton("Limpar");
		btnLimpar2.setForeground(new Color(245, 245, 245));
		btnLimpar2.setBackground(new Color(224, 83, 76));
		contentPane.add(btnLimpar2, "cell 5 7");
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		contentPane.add(lblNewLabel_2, "cell 4 8");
		
		txtQuantidade = new JTextField();
		contentPane.add(txtQuantidade, "cell 4 9,growx");
		txtQuantidade.setColumns(10);
		
		RoundButton btnLimpar3 = new RoundButton("Limpar");
		btnLimpar3.setBackground(new Color(224, 83, 76));
		btnLimpar3.setForeground(new Color(245, 245, 245));
		contentPane.add(btnLimpar3, "cell 5 9");
		
		JLabel lblNewLabel_3 = new JLabel("Categoria:");
		contentPane.add(lblNewLabel_3, "cell 4 10");
		
		JComboBox cbCategoria = new JComboBox();
		contentPane.add(cbCategoria, "cell 4 11,growx");
		
		RoundButton btnLimpar4 = new RoundButton("Limpar");
		btnLimpar4.setBackground(new Color(224, 83, 76));
		btnLimpar4.setForeground(new Color(245, 245, 245));
		contentPane.add(btnLimpar4, "cell 5 11");
		
		RoundButton btnSalvar = new RoundButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Produto p = new Produto();
				
				p.setIdProduto(produto.getIdProduto());
				String nomeProduto = txtNome.getText();
				float preco = Float.parseFloat(txtPreco.getText());
				Integer quantidadeEstoque = Integer.parseInt(txtQuantidade.getText());
				cbCategoria.getSelectedItem();
				
				p.setNomeProduto(nomeProduto);
				p.setPreco(preco);
				p.setQuantidadeEstoque(quantidadeEstoque);
				p.setCategoria(nomeProduto);
				
				
				
				//TelaAlterada.(p);
				dispose();
			}
		});
		btnSalvar.setBackground(new Color(224, 83, 76));
		btnSalvar.setForeground(new Color(245, 245, 245));
		contentPane.add(btnSalvar, "cell 4 14,alignx center");
		
		RoundButton btnCancelar = new RoundButton("Cancelar");
		btnCancelar.setBackground(new Color(0, 0, 0));
		btnCancelar.setForeground(new Color(245, 245, 245));
		contentPane.add(btnCancelar, "cell 5 14");
	}

}
