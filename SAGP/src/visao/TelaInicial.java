package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.classes.Funcionario;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel painel;
	private ImageIcon logo;
	private RoundButton btCliente;
	private RoundButton btLogin;
	private RoundButton btSair;

	public TelaInicial(Funcionario f) {
		
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
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(new Color(230, 230, 230));
		logo = new ImageIcon(TelaInicial.class.getResource("/Imagem/Logo.png"));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1281, 567);
		painel = new JPanel();
		painel.setForeground(new Color(245, 245, 245));
		painel.setBackground(new Color(167, 208, 214));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[grow][][grow][][][][][][][][][][][][][][][][][][][][][][][grow][][grow]", "[grow][120px][150px][grow]"));
		
		btSair = new RoundButton("Sair");
		btSair.setFont(font);
		btSair.setActionCommand("btSair");
		
		btSair.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagem/volte.png")));
		painel.add(btSair, "cell 0 0");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(230, 230, 230));
		lblLogo.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagem/ImagemLogoGrande.png")));
		painel.add(lblLogo, "cell 1 1 26 1,alignx center,aligny center");
		
		btCliente = new RoundButton("");
		btCliente.setFont(font);
		//btCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btCliente.setText("Entrar como cliente");
		btCliente.setActionCommand("btCliente");
		
		JLabel lblCarrinho = new JLabel("");
		lblCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCarrinho.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagem/carrinho-de-compras.png")));
		painel.add(lblCarrinho, "cell 3 2");
		btCliente.setBackground(new Color(245, 245, 245));
		btCliente.setForeground(new Color(0, 0, 0));
		painel.add(btCliente, "cell 4 2 9 1,alignx left,aligny center");
		
		btLogin = new RoundButton("");
		//btLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btLogin.setText("Entrar como funcionario");
		btLogin.setFont(font);
		btLogin.setActionCommand("btLogin");
		
		JLabel lblLupa = new JLabel("");
		lblLupa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLupa.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagem/lupa.png")));
		painel.add(lblLupa, "cell 16 2");
		btLogin.setForeground(new Color(0, 0, 0));
		btLogin.setBackground(new Color(245, 245, 245));
		painel.add(btLogin, "cell 17 2 8 1,alignx left,aligny center");
	}
	public void addInicialListener(ActionListener listener) {		
		btCliente.addActionListener(listener);
		btLogin.addActionListener(listener);
		btSair.addActionListener(listener);
	}

}
