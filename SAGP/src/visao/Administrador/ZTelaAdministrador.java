package visao.Administrador;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.TelaInicial;
import visao.TelaLogin;
import visao.Cliente.TelaCompra;
import visao.Funcionário.ZTelaFuncionario;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ZTelaAdministrador extends JFrame {

	private JPanel Painel;
	private ImageIcon logo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZTelaAdministrador frame = new ZTelaAdministrador();
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
	public ZTelaAdministrador() {
		
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
		
		setTitle("Tela Administrador");
		setBackground(new Color(230, 230, 230));
		logo = new ImageIcon(TelaInicial.class.getResource("/Imagem/Logo.png"));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 300);
		Painel = new JPanel();
		Painel.setForeground(new Color(245, 245, 245));
		Painel.setBackground(new Color(230, 230, 230));
		Painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(Painel);
		Painel.setLayout(new MigLayout("", "[grow][][][][][][][][][][grow]", "[grow][120px][150px][grow]"));
		
		JLabel lblNewLabel = new JLabel("");
		Painel.add(lblNewLabel, "cell 0 0 1 3,grow");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(logo);
		Painel.add(lblLogo, "cell 1 1 9 1,alignx center");
		
		JButton btVendas = new RoundButton("");
		btVendas.setText("Histórico de vendas");
		btVendas.setFont(font);
		btVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fazer tela
			}
		});
		btVendas.setBackground(new Color(224, 83, 76));
		btVendas.setForeground(new Color(245, 245, 245));
		Painel.add(btVendas, "cell 2 2 3 1,growx");
		
		JButton btFuncionarios = new RoundButton("");
		btFuncionarios.setText("Funcionários");
		btFuncionarios.setFont(font);
		btFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fazer tela
			}
		});
		btFuncionarios.setForeground(new Color(245, 245, 245));
		btFuncionarios.setBackground(new Color(224, 83, 76));
		Painel.add(btFuncionarios, "cell 5 2,growx");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ZTelaAdministrador.class.getResource("/Imagem/volte.png")));
		Painel.add(lblNewLabel_1, "cell 7 2,alignx right");
		
		JButton btFuncionario = new RoundButton("TELA FUNCIONARIO");
		btFuncionario.setFont(font);
		btFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ZTelaFuncionario tf = new ZTelaFuncionario();
//				dispose();
//				tf.setVisible(true);
			}
		});
		btFuncionario.setText("Tela de funcionarios");
		btFuncionario.setFont(font);
		btFuncionario.setForeground(new Color(245, 245, 245));
		btFuncionario.setBackground(new Color(0, 0, 0));
		Painel.add(btFuncionario, "cell 8 2,growx");
	}

}
