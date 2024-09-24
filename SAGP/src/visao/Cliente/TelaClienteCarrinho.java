package visao.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaClienteCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteCarrinho frame = new TelaClienteCarrinho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaClienteCarrinho() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][][][][grow]", "[][][][][grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(167, 208, 214));
		contentPane.add(panel, "cell 0 0 1 5,alignx left,growy");
		panel.setLayout(new MigLayout("", "[][][][][]", "[][][][][][][][][][][][][][][]"));
		
		JButton btnNewButton = new RoundButton("");
		btnNewButton.setBackground(new Color(224, 83, 76));
		btnNewButton.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/volte.png")));
		panel.add(btnNewButton, "cell 1 0 2 1,alignx left,aligny center");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/LogoPequena.png")));
		panel.add(lblNewLabel, "cell 1 2 2 1,alignx center,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("CATEGORIAS:");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		panel.add(lblNewLabel_1, "cell 1 4 2 1,alignx left,aligny center");
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/biscoitos.png")));
		panel.add(lblNewLabel_6, "cell 1 6");
		
		JButton btnNewButton_1 = new RoundButton("Salgados");
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_1, "cell 2 6,alignx left,aligny center");
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/bolinho.png")));
		panel.add(lblNewLabel_7, "cell 1 8");
		
		JButton btnNewButton_2 = new RoundButton("Doces");
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		panel.add(btnNewButton_2, "cell 2 8,alignx left,aligny center");
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/garrafa-de-agua.png")));
		panel.add(lblNewLabel_8, "cell 1 10");
		
		JButton btnNewButton_3 = new RoundButton("Bebidas");
		btnNewButton_3.setBackground(new Color(245, 245, 245));
		panel.add(btnNewButton_3, "cell 2 10,alignx left,aligny center");
		
		JLabel lblNewLabel_9 = new JLabel("");
		panel.add(lblNewLabel_9, "flowx,cell 1 11");
		
		JButton btnNewButton_4 = new RoundButton("Ofertas");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBackground(new Color(245, 245, 245));
		panel.add(btnNewButton_4, "cell 2 12,alignx left,aligny center");
		
		JButton btnNewButton_5 = new RoundButton("");
		btnNewButton_5.setBackground(new Color(224, 83, 76));
		btnNewButton_5.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/carrinho-de-compras.png")));
		contentPane.add(btnNewButton_5, "cell 1 1");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 2 6 2,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_6 = new RoundButton("FINALIZAR COMPRA");
		btnNewButton_6.setBackground(new Color(224, 83, 76));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL A PAGAR:");
		contentPane.add(lblNewLabel_2, "cell 4 4");
		contentPane.add(btnNewButton_6, "cell 6 4,growx,aligny center");
	}

}
