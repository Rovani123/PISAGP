package visao.Cliente;

import javax.swing.JPanel;

import modelo.classes.Produto;

import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class PainelProduto extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelProduto(Produto p) {
		setBackground(new Color(230, 230, 230));
		setLayout(new MigLayout("", "[][grow][][][][][][][][][][]", "[grow][][][][][][][][][][][]"));
		
		JPanel painelImagem = new JPanel();
		add(painelImagem, "cell 1 0 10 8,grow");
		painelImagem.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImagem = new JLabel("");
		painelImagem.add(lblImagem);
		
		JLabel lblNome = new JLabel("");
		lblNome.setText(p.getNomeProduto());
		add(lblNome, "cell 1 9 3 1,alignx center");
		
		JLabel lblPreco = new JLabel("");
		lblPreco.setText(String.valueOf(p.getPreco()));
		add(lblPreco, "cell 1 10,alignx center");
		
		RoundButton btMenos = new RoundButton("-");
		btMenos.setBackground(new Color(245, 245, 245));
		btMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(btMenos, "cell 4 10");
		
		JLabel lblQuantidade = new JLabel("1");
		add(lblQuantidade, "cell 6 10 2 1");
		
		RoundButton btMais = new RoundButton("+");
		btMais.setBackground(new Color(245, 245, 245));
		btMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(btMais, "cell 9 10");

	}

}
