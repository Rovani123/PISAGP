package visao.Funcionário;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.TelaInicial;

public class TelaFuncionario extends JFrame {

	private JPanel Painel;
	private ImageIcon logo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario frame = new TelaFuncionario();
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
	public TelaFuncionario() {
		logo = new ImageIcon(TelaInicial.class.getResource("/Imagem/Logo.png"));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Painel = new JPanel();
		Painel.setForeground(new Color(245, 245, 245));
		Painel.setBackground(new Color(230, 230, 230));
		Painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Painel);
		Painel.setLayout(new MigLayout("", "[grow][][][][][][][][grow]", "[grow][120px][150px][grow]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(logo);
		Painel.add(lblLogo, "cell 1 1 7 1,alignx center");
		
		JButton btEstoque = new RoundButton("");
		btEstoque.setText("Estoque");
		btEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionarioEstoque telaE = new TelaFuncionarioEstoque();
				dispose();
				telaE.setVisible(true);
			}
		});
		btEstoque.setBackground(new Color(224, 83, 76));
		btEstoque.setForeground(new Color(245, 245, 245));
		Painel.add(btEstoque, "cell 2 2 3 1,growx");
		
		JButton btPromo = new RoundButton("");
		btPromo.setText("Promoções");
		btPromo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fazer tela
			}
		});
		btPromo.setForeground(new Color(245, 245, 245));
		btPromo.setBackground(new Color(224, 83, 76));
		Painel.add(btPromo, "cell 5 2,growx");
	}

}
