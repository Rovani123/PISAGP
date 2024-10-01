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

public class PainelProdutoCliente extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelProdutoCliente(Produto p) {
		setBackground(new Color(230, 230, 230));
		setLayout(new MigLayout("", "[][grow][][][][][][][][][][]", "[grow][][][][][][][][][][][]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 0 10 8,grow");
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(PainelProdutoCliente.class.getResource("/Imagem/LogoPequena.png")));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Pastel de Carne");
		add(lblNewLabel, "cell 1 9 3 1,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("R$ 5,00");
		add(lblNewLabel_2, "cell 1 10,alignx center");
		
		RoundButton btnNewButton = new RoundButton("-");
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(btnNewButton, "cell 4 10");
		
		JLabel lblNewLabel_1 = new JLabel("1");
		add(lblNewLabel_1, "cell 6 10 2 1");
		
		RoundButton btnNewButton_1 = new RoundButton("+");
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(btnNewButton_1, "cell 9 10");

	}

}
