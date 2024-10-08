package visao.Funcionário;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.classes.Produto;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import modelo.enumerador.Categoria;

public class TelaCadastroP extends JFrame {

	private JPanel painelPrincipal;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQuantidade;

	
	public TelaCadastroP(JFrame telaA) {
		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 434);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(new MigLayout("", "[][][][grow][][][][]", "[][][][][][][][][][][][][][]"));
		
		JLabel lblCadastroProduto = new JLabel("CADASTRO DE PRODUTO:");
		painelPrincipal.add(lblCadastroProduto, "cell 3 2,alignx center");
		
		JLabel lblNome = new JLabel("Nome do Produto:");
		painelPrincipal.add(lblNome, "cell 3 4");
		
		txtNome = new JTextField();
		painelPrincipal.add(txtNome, "cell 3 5 2 1,growx");
		txtNome.setColumns(10);
		
		RoundButton btnNewButton = new RoundButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setBackground(new Color(224, 83, 76));
		painelPrincipal.add(btnNewButton, "cell 5 5");
		
		JLabel lblPreco = new JLabel("Preço:");
		painelPrincipal.add(lblPreco, "cell 3 6");
		
		txtPreco = new JTextField();
		painelPrincipal.add(txtPreco, "cell 3 7 2 1,growx");
		txtPreco.setColumns(10);
		
		RoundButton btnNewButton_1 = new RoundButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setForeground(new Color(245, 245, 245));
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		painelPrincipal.add(btnNewButton_1, "cell 5 7");
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		painelPrincipal.add(lblQuantidade, "cell 3 8");
		
		txtQuantidade = new JTextField();
		painelPrincipal.add(txtQuantidade, "cell 3 9 2 1,growx");
		txtQuantidade.setColumns(10);
		
		RoundButton btnNewButton_2 = new RoundButton("Limpar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setForeground(new Color(245, 245, 245));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		painelPrincipal.add(btnNewButton_2, "cell 5 9");
		
		JLabel lblCategoria = new JLabel("Categoria:");
		painelPrincipal.add(lblCategoria, "cell 3 10");
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setModel(new DefaultComboBoxModel(Categoria.values()));
		painelPrincipal.add(cbCategoria, "cell 3 11,growx");
		
		RoundButton btnNewButton_3 = new RoundButton("Limpar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_3.setForeground(new Color(245, 245, 245));
		btnNewButton_3.setBackground(new Color(224, 83, 76));
		painelPrincipal.add(btnNewButton_3, "cell 5 11");
		
		RoundButton btnNewButton_4 = new RoundButton("Salvar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto p = null;
				p.setNomeProduto(txtNome.getText());
				p.setPreco(Float.parseFloat(txtPreco.getText()));
				p.setQuantidadeEstoque(Integer.parseInt(txtQuantidade.getText()));
				p.setCategoria(String.valueOf(cbCategoria.getSelectedItem()));
				JOptionPane.showMessageDialog(null, p.getCategoria());
				cadastrarProduto();
			}
		});
		btnNewButton_4.setForeground(new Color(245, 245, 245));
		btnNewButton_4.setBackground(new Color(224, 83, 76));
		painelPrincipal.add(btnNewButton_4, "cell 3 13,alignx center");
		
		RoundButton btnNewButton_5 = new RoundButton("Cancelar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_5.setForeground(new Color(245, 245, 245));
		btnNewButton_5.setBackground(new Color(0, 0, 0));
		painelPrincipal.add(btnNewButton_5, "cell 5 13");
	}
	private void cadastrarProduto() {
		

	}

}
