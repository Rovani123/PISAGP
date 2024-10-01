package visao.Administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaAlteracaoF extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlteracaoF frame = new TelaAlteracaoF();
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
	public TelaAlteracaoF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][][][][][][grow]", "[grow][][grow][][][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaAlteracaoF.class.getResource("/Imagem/logoGrande.png")));
		contentPane.add(lblNewLabel, "cell 6 1,growx,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("NOME DO FUNCIORARIO:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1, "cell 1 3,alignx right,aligny center");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 2 3 6 1,growx,aligny center");
		textField.setColumns(10);
		
		JButton btnNewButton = new RoundButton("LIMPAR");
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setBackground(new Color(224, 83, 76));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton, "cell 8 3");
		
		JLabel lblNewLabel_2 = new JLabel("USÚARIO:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_2, "cell 1 5,alignx right,aligny center");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 2 5 6 1,growx,aligny center");
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new RoundButton("LIMPAR");
		btnNewButton_1.setForeground(new Color(245, 245, 245));
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton_1, "cell 8 5");
		
		JLabel lblNewLabel_3 = new JLabel("SENHA:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_3, "cell 1 7,alignx right,aligny center");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 2 7 6 1,growx,aligny center");
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new RoundButton("LIMPAR");
		btnNewButton_2.setForeground(new Color(245, 245, 245));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton_2, "cell 8 7");
		
		JButton btnNewButton_3 = new RoundButton("SALVAR");
		btnNewButton_3.setForeground(new Color(245, 245, 245));
		btnNewButton_3.setBackground(new Color(224, 83, 76));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_3, "cell 6 10,alignx right,aligny center");
		
		JButton btnNewButton_4 = new RoundButton("CANCELAR");
		btnNewButton_4.setForeground(new Color(245, 245, 245));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton_4, "cell 8 10,alignx center,aligny center");
	}

}
