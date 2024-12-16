package visao.TelasDeAviso;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class MensagemViewSenha extends JDialog {

	private static final long serialVersionUID = 1L;
	private String senha;
	private JPasswordField txtSenha;

	
	// Método para mensagens de perguntas
	public MensagemViewSenha() {
		setTitle("Mensagem");
		setModal(true);

		// Criar Panel
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		getContentPane().add(panel);
		String iconPath;
		iconPath = "/src/imagem/erro.png";

		JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

		JButton btOk = new JButton("Ok");
		// Tamanho do botao
		btOk.setPreferredSize(new Dimension(100, 30));
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senha = String.valueOf(txtSenha.getPassword());
				setVisible(false);
			}
		});

		painelSul.add(btOk);
		
		JLabel lblNewLabel = new JLabel("Insira a Senha");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		txtSenha = new JPasswordField();
		panel.add(txtSenha, BorderLayout.CENTER);

		painelSul.setBorder(new EmptyBorder(10, 10, 10, 10));

		panel.add(painelSul, BorderLayout.SOUTH);

		setSize(400, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public String getSenha() {
		return senha;
	}
}
