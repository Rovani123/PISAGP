package visao.Cliente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class TelaClienteFormaPagamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteFormaPagamento frame = new TelaClienteFormaPagamento();
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
	public TelaClienteFormaPagamento() {
		
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
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JLabel lblNewLabel = new JLabel("FORMA DE PAGAMENTO:");
		lblNewLabel.setFont(font);
		contentPane.add(lblNewLabel, "cell 0 0,alignx center");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[][][][][grow][][]", "[][][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Total à pagar:");
		lblNewLabel_1.setFont(font);
		panel.add(lblNewLabel_1, "cell 3 1");
		
		JLabel lblNewLabel_2 = new JLabel("0.0");
		lblNewLabel_2.setFont(font);
		panel.add(lblNewLabel_2, "cell 4 1");
		
		JLabel lblNewLabel_3 = new JLabel("Escolha a forma de pagamento:");
		lblNewLabel_3.setFont(font);
		panel.add(lblNewLabel_3, "cell 3 3");
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 3 4 2 1,growx");
		
		RoundButton btnNewButton = new RoundButton("Limpar");
		btnNewButton.setFont(font);
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setBackground(new Color(224, 83, 76));
		panel.add(btnNewButton, "cell 5 4");
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel.add(lblNewLabel_4, "cell 6 4");
		
		RoundButton btnNewButton_1 = new RoundButton("Confirmar");
		btnNewButton_1.setFont(font);
		btnNewButton_1.setForeground(new Color(245, 245, 245));
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		panel.add(btnNewButton_1, "cell 4 7,alignx right");
		
		RoundButton btnNewButton_2 = new RoundButton("Cancelar");
		btnNewButton_2.setFont(font);
		btnNewButton_2.setForeground(new Color(245, 245, 245));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton_2, "cell 5 7");
	}

}
