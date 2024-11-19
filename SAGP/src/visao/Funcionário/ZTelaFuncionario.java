package visao.Funcionário;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.TelaInicial;

public class ZTelaFuncionario extends JFrame {

	private JPanel Painel;
	private ImageIcon logo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZTelaFuncionario frame = new ZTelaFuncionario();
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
	public ZTelaFuncionario() {
		
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
		btEstoque.setFont(font);
		btEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				TelaGerenciamentoP telaE = new TelaGerenciamentoP();
//				dispose();
//				telaE.setVisible(true);
			}
		});
		btEstoque.setBackground(new Color(224, 83, 76));
		btEstoque.setForeground(new Color(245, 245, 245));
		Painel.add(btEstoque, "cell 2 2 3 1,growx");
		
		JButton btPromo = new RoundButton("");
		btPromo.setText("Promoções");
		btPromo.setFont(font);
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
