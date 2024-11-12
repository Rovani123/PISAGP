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

public class TelaAvisoFuncionarioAlteradoSucesso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAvisoFuncionarioAlteradoSucesso frame = new TelaAvisoFuncionarioAlteradoSucesso();
					frame.setLocationRelativeTo(null); 
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
	public TelaAvisoFuncionarioAlteradoSucesso() {setTitle("Tela de aviso");
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 363, 165);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(230, 230, 230));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow][][][][grow]", "[grow][][][][][grow]"));
	
	JLabel lblNewLabel = new JLabel("Funcionario alterado com sucesso!");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	contentPane.add(lblNewLabel, "cell 2 1,alignx center,aligny center");
	
	JButton btnNewButton = new RoundButton("New button");
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnNewButton.setBackground(new Color(245, 245, 245));
	btnNewButton.setText("OK");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);

		}
	});
	
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setIcon(new ImageIcon(TelaAvisoProdutoAlteradoSucesso.class.getResource("/Imagem/IconeCorreto.png")));
	contentPane.add(lblNewLabel_1, "cell 3 1");
	contentPane.add(btnNewButton, "cell 2 4,alignx center,aligny center");
}

}
