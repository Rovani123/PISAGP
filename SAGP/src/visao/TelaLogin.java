package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ConexaoBD;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][grow][][][grow]", "[][][][][][][][][][][][][]"));
		
		JLabel lblUsuario = new JLabel("Usuário:");
		contentPane.add(lblUsuario, "cell 4 2");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 4 3,growx");
		textField.setColumns(10);
		
		JButton bntLimpa = new JButton("Limpa");
		contentPane.add(bntLimpa, "cell 5 3");
		
		JLabel lblEmail = new JLabel("Email:");
		contentPane.add(lblEmail, "cell 4 4");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 4 5,growx");
		textField_2.setColumns(10);
		
		JButton btnLimpa_1 = new JButton("Limpa");
		contentPane.add(btnLimpa_1, "cell 5 5");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnCancelar, "cell 4 7");
		
		JButton btnEntre = new JButton("Entrar");
		btnEntre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnEntre, "cell 5 7");
	}

}
