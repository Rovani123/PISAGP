package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import visao.Administrador.TelaCadastroF;
import visao.Cliente.TelaClienteCadastro;
import visao.Cliente.TelaCompra;
import visao.Funcionário.ZTelaFuncionarioLogin;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Frame;
import java.awt.Font;

public class TelaInicial extends JFrame {

	private JPanel Painel;
	private ImageIcon logo;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicial() {
		TelaInicial tI= this;
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(new Color(230, 230, 230));
		logo = new ImageIcon(TelaInicial.class.getResource("/Imagem/Logo.png"));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1281, 567);
		Painel = new JPanel();
		Painel.setForeground(new Color(245, 245, 245));
		Painel.setBackground(new Color(167, 208, 214));
		Painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Painel);
		Painel.setLayout(new MigLayout("", "[grow][][grow][][][][][][][][][][][][][][][][][][][][][][][grow][][grow]", "[grow][120px][150px][grow]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(230, 230, 230));
		lblLogo.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagem/ImagemLogoGrande.png")));
		Painel.add(lblLogo, "cell 1 1 26 1,alignx center,aligny center");
		
		JButton btCliente = new RoundButton("");
		btCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btCliente.setText("Entrar como cliente");
		btCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCompra telaC = new TelaCompra();
				dispose();
				telaC.setVisible(true);
			}
		});
		
		JLabel lblCarrinho = new JLabel("");
		lblCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCarrinho.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagem/carrinho-de-compras.png")));
		Painel.add(lblCarrinho, "cell 3 2");
		btCliente.setBackground(new Color(224, 83, 76));
		btCliente.setForeground(new Color(245, 245, 245));
		Painel.add(btCliente, "cell 4 2 9 1,alignx left,aligny center");
		
		JButton btLogin = new RoundButton("");
		btLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btLogin.setText("Entrar como funcionario");
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin TelaL = new TelaLogin(tI);
				dispose();
				TelaL.setVisible(true);
			}
		});
		
		JLabel lblLupa = new JLabel("");
		lblLupa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLupa.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagem/lupa.png")));
		Painel.add(lblLupa, "cell 16 2");
		btLogin.setForeground(new Color(245, 245, 245));
		btLogin.setBackground(new Color(224, 83, 76));
		Painel.add(btLogin, "cell 17 2 8 1,alignx left,aligny center");
	}

}
