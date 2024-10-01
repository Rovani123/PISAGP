package teste;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.sun.tools.javac.Main;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.TelaLogin;
import visao.TelaInicial;
import visao.Administrador.TelaCadastroF;
import visao.Cliente.TelaClienteCadastro;
import visao.Funcionário.ZTelaFuncionarioLogin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.Point;

public class TelaCheia extends JFrame {

	private JPanel contentPane;
	private JLabel lbllogo;
	private BufferedImage bimagem;
	private ImageIcon imageI;
	private Image imagem;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCheia frame = new TelaCheia();
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
	public TelaCheia() {
		imageI = new ImageIcon(TelaLogin.class.getResource("/Imagem/Logo.png"));
		imagem = imageI.getImage();
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		//setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(245, 245, 245));
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow][grow][grow][grow]"));
		
		JButton btnNewButton_1 = new RoundButton("SOU FUNCIONARIO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin TelaL = new TelaLogin();
				dispose();
				TelaL.setVisible(true);
			}
		});
		
		JButton btnNewButton = new RoundButton("Ola");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClienteCadastro telaC = new TelaClienteCadastro();
				dispose();
				telaC.setVisible(true);
			}
		});
		
		lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(TelaCheia.class.getResource("/Imagem/Logo.png")));
		contentPane.add(lbllogo, "cell 1 1 2 1,alignx center,aligny center");
		
		btnNewButton.setBackground(new Color(224, 83, 76));
		btnNewButton.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton, "cell 1 2,alignx center,aligny center");
		btnNewButton_1.setForeground(new Color(245, 245, 245));
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_1, "cell 2 2,alignx center,aligny center");
		
		 addComponentListener(new ComponentAdapter() {
	            public void componentResized(ComponentEvent e) {
	            	updateImage();
	            }
	        });
	}
	   private void updateImage() {
		   Image n =imagem.getScaledInstance(getWidth()/3, getHeight()/3, Image.SCALE_SMOOTH);
		   //Image n =imagem.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
		   lbllogo.setIcon(new ImageIcon(n));
	        
	    }
}
