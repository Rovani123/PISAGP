package visao.Funcionário;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDeFuncionario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeFuncionario frame = new TelaDeFuncionario();
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
	public TelaDeFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][][][][][][][grow]", "[][][grow]"));
		
		panel = new JPanel();
		panel.setBackground(new Color(167, 208, 214));
		contentPane.add(panel, "cell 0 0 1 3,alignx left,growy");
		panel.setLayout(new MigLayout("", "[][][][]", "[][][][grow][][grow][][][][][][grow][][][grow]"));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaDeFuncionario.class.getResource("/Imagem/LogoPequena.png")));
		panel.add(lblNewLabel_1, "cell 0 1 4 1,alignx center,aligny center");
		
		lblNewLabel_2 = new JLabel("TABELA DE FUNCIONARIO");
		panel.add(lblNewLabel_2, "cell 0 4 4 1,alignx center,aligny center");
		
		btnNewButton_2 = new RoundButton("ALTERAR");
		btnNewButton_2.setForeground(new Color(245, 245, 245));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaDeFuncionario.class.getResource("/Imagem/troca.png")));
		panel.add(lblNewLabel_5, "cell 1 6,alignx right");
		panel.add(btnNewButton_2, "cell 2 6,alignx left,aligny center");
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(TelaDeFuncionario.class.getResource("/Imagem/lixeira.png")));
		panel.add(lblNewLabel_4, "cell 1 7,alignx right");
		
		btnNewButton_3 = new RoundButton("DELETAR");
		btnNewButton_3.setForeground(new Color(245, 245, 245));
		btnNewButton_3.setBackground(new Color(224, 83, 76));
		panel.add(btnNewButton_3, "cell 2 7,alignx left,aligny center");
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaDeFuncionario.class.getResource("/Imagem/lupa.png")));
		panel.add(lblNewLabel_6, "cell 1 8,alignx right");
		
		btnNewButton_4 = new RoundButton("ADICIONAR");
		btnNewButton_4.setForeground(new Color(245, 245, 245));
		btnNewButton_4.setBackground(new Color(224, 83, 76));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_4, "cell 2 8,alignx left,aligny center");
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaDeFuncionario.class.getResource("/Imagem/volte.png")));
		panel.add(lblNewLabel_3, "cell 1 13");
		
		btnNewButton = new RoundButton("VOLTAR");
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setBackground(new Color(224, 83, 76));
		panel.add(btnNewButton, "cell 2 13,alignx left,aligny center");
		
		JLabel lblNewLabel = new JLabel("FUNCIONARIO");
		contentPane.add(lblNewLabel, "cell 1 1,alignx center,aligny center");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 2 1 7 1,growx,aligny center");
		textField.setColumns(10);
		
		btnNewButton_1 = new RoundButton("");
		btnNewButton_1.setBackground(new Color(230, 230, 230));
		btnNewButton_1.setIcon(new ImageIcon(TelaDeFuncionario.class.getResource("/Imagem/lupa.png")));
		contentPane.add(btnNewButton_1, "cell 9 1,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 2 10 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
