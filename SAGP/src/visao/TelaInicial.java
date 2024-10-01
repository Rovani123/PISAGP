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

public class TelaInicial extends JFrame {

	private JPanel Painel;
	private ImageIcon logo;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
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
		
		JButton btCliente = new RoundButton("");
		btCliente.setText("Entrar como cliente");
		btCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCompra telaC = new TelaCompra();
				dispose();
				telaC.setVisible(true);
			}
		});
		btCliente.setBackground(new Color(224, 83, 76));
		btCliente.setForeground(new Color(245, 245, 245));
		Painel.add(btCliente, "cell 2 2 3 1,growx");
		
		JButton btLogin = new RoundButton("");
		btLogin.setText("Entrar como funcionario");
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin TelaL = new TelaLogin();
				dispose();
				TelaL.setVisible(true);
			}
		});
		btLogin.setForeground(new Color(245, 245, 245));
		btLogin.setBackground(new Color(224, 83, 76));
		Painel.add(btLogin, "cell 5 2,growx");
	}

}
