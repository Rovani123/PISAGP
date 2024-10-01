package visao.Funcionário;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAlteracaoProduto extends JFrame {

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
					TelaAlteracaoProduto frame = new TelaAlteracaoProduto();
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
	public TelaAlteracaoProduto() {
		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][grow][][][][]", "[][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel_4 = new JLabel("ALTERAÇÃO DO PRODUTO:");
		contentPane.add(lblNewLabel_4, "cell 4 2,alignx center");
		
		JLabel lblNewLabel = new JLabel("Nome do Produto:");
		contentPane.add(lblNewLabel, "cell 4 4");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 4 5,growx");
		textField.setColumns(10);
		
		RoundButton btnNewButton = new RoundButton("Limpar");
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton, "cell 5 5");
		
		JLabel lblNewLabel_1 = new JLabel("Preço:");
		contentPane.add(lblNewLabel_1, "cell 4 6");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 4 7,growx");
		textField_1.setColumns(10);
		
		RoundButton btnNewButton_1 = new RoundButton("Limpar");
		btnNewButton_1.setForeground(new Color(245, 245, 245));
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton_1, "cell 5 7");
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		contentPane.add(lblNewLabel_2, "cell 4 8");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 4 9,growx");
		textField_2.setColumns(10);
		
		RoundButton btnNewButton_2 = new RoundButton("Limpar");
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		btnNewButton_2.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_2, "cell 5 9");
		
		JLabel lblNewLabel_3 = new JLabel("Categoria:");
		contentPane.add(lblNewLabel_3, "cell 4 10");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(245, 245, 245));
		contentPane.add(comboBox, "cell 4 11,growx");
		
		RoundButton btnNewButton_3 = new RoundButton("Limpar");
		btnNewButton_3.setBackground(new Color(224, 83, 76));
		btnNewButton_3.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_3, "cell 5 11");
		
		RoundButton btnNewButton_4 = new RoundButton("Salvar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBackground(new Color(224, 83, 76));
		btnNewButton_4.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_4, "cell 4 14,alignx center");
		
		RoundButton btnNewButton_5 = new RoundButton("Cancelar");
		btnNewButton_5.setBackground(new Color(0, 0, 0));
		btnNewButton_5.setForeground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_5, "cell 5 14");
	}

}
