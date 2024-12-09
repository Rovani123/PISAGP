package visao.Cliente;

import javax.swing.JPanel;

import modelo.classes.Carrinho;
import modelo.classes.Produto;

import java.awt.Color;
import java.awt.Frame;

import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class PainelProduto extends JPanel {
	
	private JLabel lblQuantidade;
	private RoundButton btMenos;
	private RoundButton btMais;
	private Carrinho carrinho;
	private Produto produto;
	
	
	public PainelProduto(Produto p,Carrinho c) {
		produto=p;
		carrinho = c;
		setBackground(new Color(230, 230, 230));
		setLayout(new MigLayout("", "[][grow][][][][][][][][][][]", "[grow][][][][][][][][][][][]"));
		
		JPanel painelImagem = new JPanel();
		add(painelImagem, "cell 1 0 10 8,grow");
		painelImagem.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(p.getFoto()));
		painelImagem.add(lblImagem);
		
		JLabel lblNome = new JLabel("");
		lblNome.setText(p.getNomeProduto());
		add(lblNome, "cell 1 9 3 1,alignx center");
		
		JLabel lblPreco = new JLabel("");
		lblPreco.setText(String.valueOf(p.getPreco()));
		add(lblPreco, "cell 1 10,alignx center");
		
		btMenos = new RoundButton("-");
		btMenos.setBackground(new Color(245, 245, 245));
		btMenos.setActionCommand("btMenos");
		add(btMenos, "cell 4 10");
		
		lblQuantidade = new JLabel("0");
		add(lblQuantidade, "cell 6 10 2 1");
		
		btMais = new RoundButton("+");
		btMais.setBackground(new Color(245, 245, 245));
		btMais.setActionCommand("btMais");
		add(btMais, "cell 9 10");
		lblQuantidade.setText(String.valueOf(carrinho.getQuantidade()));
	}
	
	public void addPainelProdutoListeners(ActionListener listener) {
		btMenos.addActionListener(listener);
		btMais.addActionListener(listener);
	}
	
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public Produto getProduto() {
		return produto;
	}
	
	public void setCarrinhoQuant(int q) {
		carrinho.setQuantidade(q);
	}
	
	public void setLblQuant(String s) {
		lblQuantidade.setText(s);
	}
}
