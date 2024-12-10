package visao.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaClientePix extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private RoundButton btVoltar;
	private RoundButton btCancelar;

	public TelaClientePix() {
		
		Font font = new Font("Tahoma", Font.PLAIN, 30);;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Poppins-SemiBold.ttf"));
			
			font = font.deriveFont(Font.PLAIN, 30); // Definir o tamanho da fonte
	
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setVisible(false);
		setBounds(100, 100, 701, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(167, 208, 214));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][grow]", "[][][][][][][][][]"));
		
		RoundButton btVoltar = new RoundButton("Voltar");
		btVoltar.setFont(font);
		btVoltar.setActionCommand("btVoltar");
		btVoltar.setForeground(new Color(245, 245, 245));
		//btVoltar.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
		//	}
		//});
		btVoltar.setBackground(new Color(224, 83, 76));
		btVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btVoltar, "cell 0 0,alignx left,aligny top");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaClientePix.class.getResource("/Imagem/ImagemLogoGrande.png")));
		contentPane.add(lblNewLabel, "cell 6 1,alignx center,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("PAGAMENTO COM O PIX");
		lblNewLabel_1.setFont(font);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel_1, "cell 6 3,alignx center,aligny center");
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaClientePix.class.getResource("/Imagem/pixPagamento.jpg")));
		contentPane.add(lblNewLabel_2, "cell 6 5,alignx center,aligny center");
		
		RoundButton btCancelar = new RoundButton("Cancelar");
		btCancelar.setFont(font);
		btCancelar.setActionCommand("btCancelar");
		btCancelar.setBackground(new Color(224, 83, 76));
		btCancelar.setForeground(new Color(230, 230, 230));
		//btCancelar.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
				
		//	}
		//});
		btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(btCancelar, "flowx,cell 14 8");
	}
	
	public void addLoginListener(ActionListener listener) {
		btCancelar.addActionListener(listener);
		btVoltar.addActionListener(listener);
	}

}
