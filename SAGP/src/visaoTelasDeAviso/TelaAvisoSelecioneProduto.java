package visaoTelasDeAviso;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

public class TelaAvisoSelecioneProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAvisoSelecioneProduto frame = new TelaAvisoSelecioneProduto();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAvisoSelecioneProduto() {
		setBackground(new Color(230, 230, 230));
		setResizable(false);
		setTitle("Tela de aviso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 165);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][grow]", "[grow][][][][][grow]"));
		
		JButton btnNewButton = new RoundButton("Clouse");
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaAvisoSelecioneProduto.class.getResource("/Imagem/IconeAtencao.png")));
		contentPane.add(lblNewLabel_1, "cell 1 2");
		
		JLabel lblNewLabel = new JLabel("Selecione um produto!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, "cell 2 2 2 1,alignx center,aligny center");
		btnNewButton.setText("OK");
		btnNewButton.setBackground(new Color(224, 83, 76));
		contentPane.add(btnNewButton, "cell 1 4 3 1,alignx center,aligny center");
	}

}