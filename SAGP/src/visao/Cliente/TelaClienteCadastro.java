package visao.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;

public class TelaClienteCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEntreComSeu;
	private JTextField txtEntreComSeu_1;
	private JTextField txtEntreComUma;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteCadastro frame = new TelaClienteCadastro();
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
	public TelaClienteCadastro() {
		
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][][][400px][][][grow]", "[grow][][][][][][][][][][][][][grow]"));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaClienteCadastro.class.getResource("/Imagem/Logo.png")));
		contentPane.add(lblNewLabel_6, "cell 6 0,alignx center");
		
		JLabel lblNewLabel_3 = new JLabel("CRIE UMA CONTA:");
		lblNewLabel_3.setFont(font);
		contentPane.add(lblNewLabel_3, "cell 6 2,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("");
		contentPane.add(lblNewLabel_4, "cell 8 2");
		
		JLabel lblNewLabel_5 = new JLabel("");
		contentPane.add(lblNewLabel_5, "cell 9 2");
		
		JLabel lblNewLabel = new JLabel("Nome: *");
		lblNewLabel.setFont(font);
		contentPane.add(lblNewLabel, "cell 4 4");
		
		JLabel lblNewLabel_7 = new JLabel("Esse campo é obrigatório");
		lblNewLabel_7.setFont(font);
		lblNewLabel_7.setForeground(new Color(224, 83, 76));
		lblNewLabel_7.setEnabled(false);
		contentPane.add(lblNewLabel_7, "cell 6 4");
		

		txtEntreComSeu = new JTextField();
		txtEntreComSeu.setForeground(new Color(130, 130, 130));
		contentPane.add(txtEntreComSeu, "cell 4 5 3 1,growx");
		txtEntreComSeu.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário: *");
		lblNewLabel_1.setFont(font);
		contentPane.add(lblNewLabel_1, "cell 4 6");
		
		JLabel lblNewLabel_8 = new JLabel("Esse campo é obrigatório");
		lblNewLabel_8.setFont(font);
		lblNewLabel_8.setEnabled(false);
		lblNewLabel_8.setForeground(new Color(224, 83, 76));
		contentPane.add(lblNewLabel_8, "cell 6 6");
		
		txtEntreComSeu_1 = new JTextField();
		txtEntreComSeu_1.setForeground(new Color(130, 130, 130));
		contentPane.add(txtEntreComSeu_1, "cell 4 7 3 1,growx");
		txtEntreComSeu_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Senha: *");
		lblNewLabel_2.setFont(font);
		contentPane.add(lblNewLabel_2, "cell 4 8");
		
		JLabel lblNewLabel_9 = new JLabel("Esse campo é obrigatório");
		lblNewLabel_9.setFont(font);
		lblNewLabel_9.setForeground(new Color(224, 83, 76));
		lblNewLabel_9.setEnabled(false);
		contentPane.add(lblNewLabel_9, "cell 6 8");
		
		txtEntreComUma = new JTextField();
		txtEntreComUma.setForeground(new Color(130, 130, 130));
		contentPane.add(txtEntreComUma, "cell 4 9 3 1,growx");
		txtEntreComUma.setColumns(10);
		
		JButton btnNewButton_3 = new RoundButton("Cadastrar");
		btnNewButton_3.setFont(font);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(224, 83, 76));
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(btnNewButton_3, "cell 6 11,alignx center");
		
		JButton btnNewButton_4 = new RoundButton("Cancelar");
		btnNewButton_4.setFont(font);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnNewButton_2 = new RoundButton("Limpar");
		btnNewButton_2.setFont(font);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_2, "cell 7 11");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		contentPane.add(btnNewButton_4, "cell 7 13");
		
		JButton btnNewButton_5 = new RoundButton("Entrar");
		btnNewButton_5.setFont(font);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				///
				
				//hjhuj
				
			}
		});
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_5, "cell 8 13");
	}

}
