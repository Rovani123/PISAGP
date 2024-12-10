package visao.Cliente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.event.ActionListener;
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
import javax.swing.DefaultComboBoxModel;
import modelo.enumerador.MetodoPagamento;

public class TelaClienteFormaPagamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelPrincipal;
	private JLabel lblFormaPagamento;
	private JPanel painelFormaPagamento;
	private JLabel lblTotalPagar;
	private JComboBox cbMetodoPagamento;
	private JLabel lblValorTotal;
	private JLabel lblEscolhaMetodoPagamento;
	private RoundButton btLimpar;
	private RoundButton btConfirmar;
	private RoundButton btCancelar;

	
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
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		lblFormaPagamento = new JLabel("FORMA DE PAGAMENTO:");
		lblFormaPagamento.setFont(font);
		painelPrincipal.add(lblFormaPagamento, "cell 0 0,alignx center");
		
		painelFormaPagamento = new JPanel();
		painelPrincipal.add(painelFormaPagamento, "cell 0 1,grow");
		painelFormaPagamento.setLayout(new MigLayout("", "[][][][][grow][][]", "[][][][][][][][]"));
		
		lblTotalPagar = new JLabel("Total à pagar:");
		lblTotalPagar.setFont(font);
		painelFormaPagamento.add(lblTotalPagar, "cell 3 1");
		
		lblValorTotal = new JLabel("0.0");
		lblValorTotal.setFont(font);
		painelFormaPagamento.add(lblValorTotal, "cell 4 1");
		
		lblEscolhaMetodoPagamento = new JLabel("Escolha a forma de pagamento:");
		lblEscolhaMetodoPagamento.setFont(font);
		painelFormaPagamento.add(lblEscolhaMetodoPagamento, "cell 3 3");
		
		cbMetodoPagamento = new JComboBox();
		cbMetodoPagamento.setModel(new DefaultComboBoxModel(MetodoPagamento.values()));
		painelFormaPagamento.add(cbMetodoPagamento, "cell 3 4 2 1,growx");
		
		btLimpar = new RoundButton("Limpar");
		btLimpar.setFont(font);
		btLimpar.setForeground(new Color(245, 245, 245));
		btLimpar.setBackground(new Color(224, 83, 76));
		btLimpar.setActionCommand("btLimpar");
		painelFormaPagamento.add(btLimpar, "cell 5 4");
		
		btConfirmar = new RoundButton("Confirmar");
		btConfirmar.setFont(font);
		btConfirmar.setForeground(new Color(245, 245, 245));
		btConfirmar.setBackground(new Color(224, 83, 76));
		btConfirmar.setActionCommand("btConfirmar");
		painelFormaPagamento.add(btConfirmar, "cell 4 7,alignx right");
		
		btCancelar = new RoundButton("Cancelar");
		btCancelar.setFont(font);
		btCancelar.setForeground(new Color(245, 245, 245));
		btCancelar.setBackground(new Color(0, 0, 0));
		btCancelar.setActionCommand("btCancelar");
		btCancelar.setActionCommand("btCancelar");
		painelFormaPagamento.add(btCancelar, "cell 5 7");
	}
	public void addFormaPagamentoListeners(ActionListener listener) {
		btLimpar.addActionListener(listener);
		btCancelar.addActionListener(listener);
		btConfirmar.addActionListener(listener);
	}
	public void setLblTotal(String s) {
		lblValorTotal.setText(s);		
	}
	public String getCbMetodoPagamento() {
		return cbMetodoPagamento.getSelectedItem().toString();
	}

}
