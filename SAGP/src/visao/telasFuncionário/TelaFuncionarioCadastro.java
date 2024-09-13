package visao.telasFuncionário;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.ImageLabel;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaFuncionarioCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEntreComSeu;
	private JTextField txtEntreComUma;
	private JTextField txtEntreComSeu_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarioCadastro frame = new TelaFuncionarioCadastro();
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
	public TelaFuncionarioCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 374);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][grow][][][][][][][grow]", "[grow][][][][][][][][][][grow]"));
		
		ImageLabel lblNewLabel = new ImageLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaFuncionarioCadastro.class.getResource("/Imagem/Group 1.png")));
		contentPane.add(lblNewLabel, "cell 3 0 7 2,alignx center,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("CRIE UMA CONTA:");
		contentPane.add(lblNewLabel_1, "cell 4 2 6 1,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("USUARIO:");
		contentPane.add(lblNewLabel_2, "cell 3 3,alignx center");
		
		txtEntreComSeu = new JTextField();
		txtEntreComSeu.setForeground(new Color(128, 128, 128));
		txtEntreComSeu.setText("Coloque o seu usuario para cadastar");
		contentPane.add(txtEntreComSeu, "cell 4 3 6 1,growx");
		txtEntreComSeu.setColumns(10);
		
		JButton btnNewButton = new RoundButton("LIMPAR");
		btnNewButton.setBackground(new Color(224, 83, 76));
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton, "cell 10 3");
		
		JLabel lblNewLabel_4 = new JLabel("NOME:");
		contentPane.add(lblNewLabel_4, "cell 3 5,alignx center");
		
		txtEntreComSeu_1 = new JTextField();
		txtEntreComSeu_1.setForeground(new Color(128, 128, 128));
		txtEntreComSeu_1.setText("Entre com seu nome para cadastar");
		contentPane.add(txtEntreComSeu_1, "cell 4 5 6 1,growx");
		txtEntreComSeu_1.setColumns(10);
		
		JButton btnNewButton_5 = new RoundButton("New button");
		btnNewButton_5.setText("LIMPAR");
		btnNewButton_5.setBackground(new Color(224, 83, 76));
		btnNewButton_5.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_5, "cell 10 5");
		
		JLabel lblNewLabel_3 = new JLabel("SENHA:");
		contentPane.add(lblNewLabel_3, "cell 3 7,alignx center");
		
		txtEntreComUma = new JTextField();
		txtEntreComUma.setForeground(new Color(128, 128, 128));
		txtEntreComUma.setText("Entre com uma senha");
		contentPane.add(txtEntreComUma, "cell 4 7 6 1,growx");
		txtEntreComUma.setColumns(10);
		
		JButton btnNewButton_1 = new RoundButton("LIMPAR");
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		btnNewButton_1.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_1, "cell 10 7");
		
		JButton btnNewButton_2 = new RoundButton("CADASTRAR");
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		btnNewButton_2.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_2, "cell 6 8");
		
		JButton btnNewButton_4 = new RoundButton("CANCELAR");
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_4, "cell 9 9");
		
		JButton btnNewButton_3 = new RoundButton("ENTRAR");
		btnNewButton_3.setBackground(new Color(224, 83, 76));
		btnNewButton_3.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_3, "cell 10 9");
	}

}
