package visao.Cliente;

import javax.swing.JPanel;

import modelo.classes.Carrinho;
import modelo.classes.Produto;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Font;

public class PainelProduto extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblQuantidade;
	private RoundButton btMenos;
	private RoundButton btMais;
	private Carrinho carrinho;
	private Produto produto;
	
	
	public PainelProduto(Produto p,Carrinho c) {
		produto=p;
		carrinho = c;
		setBackground(new Color(230, 230, 230));
		setLayout(new MigLayout("", "[][grow][][][][][][][][][][][]", "[grow][][][][][][][][][][][]"));
		
		JPanel painelImagem = new JPanel();
		add(painelImagem, "cell 1 0 11 8,grow");
		painelImagem.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(p.getFoto()));
		painelImagem.add(lblImagem);
		
		JLabel lblNome = new JLabel("");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setText(p.getNomeProduto());
		add(lblNome, "cell 1 9 4 1,alignx center");
		
		JLabel lblNewLabel = new JLabel("R$:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(lblNewLabel, "cell 1 10,alignx right");
		
		JLabel lblPreco = new JLabel("");
		lblPreco.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPreco.setText(String.valueOf(p.getPreco()));
		add(lblPreco, "cell 2 10,alignx center");
		
		btMenos = new RoundButton("-");
		btMenos.setFont(new Font("Arial", Font.PLAIN, 16));
		btMenos.setBackground(new Color(245, 245, 245));
		btMenos.setActionCommand("btMenos");
		add(btMenos, "cell 5 10");
		
		lblQuantidade = new JLabel("0");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 16));
		add(lblQuantidade, "cell 7 10 2 1");
		
		btMais = new RoundButton("+");
		btMais.setFont(new Font("Arial", Font.PLAIN, 16));
		btMais.setBackground(new Color(245, 245, 245));
		btMais.setActionCommand("btMais");
		add(btMais, "cell 10 10");
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
