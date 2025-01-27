package visao.TelasDeAviso;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import modelo.classes.Vendas;
import modelo.tableModel.CarrinhoTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MensagemViewProdutos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table;

	
	// Método para mensagens de perguntas
	public MensagemViewProdutos(Vendas v, CarrinhoTableModel model) {
		setTitle("Mensagem");
		setModal(true);

		// Criar Panel
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		getContentPane().add(panel);

		JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

		JButton btOk = new JButton("Ok");
		// Tamanho do botao
		btOk.setPreferredSize(new Dimension(100, 30));
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		painelSul.add(btOk);

		painelSul.setBorder(new EmptyBorder(10, 10, 10, 10));

		panel.add(painelSul, BorderLayout.SOUTH);
		
		JLabel lblNome = new JLabel("");
		lblNome.setText(String.valueOf("Venda "+v.getIdVenda()));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNome, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.WEST);
		
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);

		setSize(400, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
