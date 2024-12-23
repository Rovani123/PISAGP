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
import javax.swing.ImageIcon;

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
	private JLabel lblNewLabel;

	public TelaClienteFormaPagamento() {
		setTitle("Forma de Pagamento");
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 310);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(230, 230, 230));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(new MigLayout("", "[grow]", "[][grow 50][][grow 50][grow]"));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaClienteFormaPagamento.class.getResource("/Imagem/LogoMediaMedia.png")));
		painelPrincipal.add(lblNewLabel, "cell 0 0,alignx center,aligny center");
		
		lblFormaPagamento = new JLabel("FORMA DE PAGAMENTO:");
		lblFormaPagamento.setFont(new Font("Arial", Font.BOLD, 25));
		painelPrincipal.add(lblFormaPagamento, "cell 0 3,alignx center");
		
		painelFormaPagamento = new JPanel();
		painelFormaPagamento.setBackground(new Color(230, 230, 230));
		painelPrincipal.add(painelFormaPagamento, "cell 0 4,grow");
		painelFormaPagamento.setLayout(new MigLayout("", "[][][][][grow][][]", "[][][][][][][][]"));
		
		lblTotalPagar = new JLabel("Total à pagar:");
		lblTotalPagar.setBackground(new Color(230, 230, 230));
		lblTotalPagar.setFont(new Font("Arial", Font.PLAIN, 20));
		painelFormaPagamento.add(lblTotalPagar, "cell 3 1");
		
		lblValorTotal = new JLabel("0.0");
		lblValorTotal.setBackground(new Color(230, 230, 230));
		lblValorTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		painelFormaPagamento.add(lblValorTotal, "cell 4 1");
		
		lblEscolhaMetodoPagamento = new JLabel("Escolha a forma de pagamento:");
		lblEscolhaMetodoPagamento.setBackground(new Color(230, 230, 230));
		lblEscolhaMetodoPagamento.setFont(new Font("Arial", Font.PLAIN, 20));
		painelFormaPagamento.add(lblEscolhaMetodoPagamento, "cell 3 3");
		
		cbMetodoPagamento = new JComboBox();
		cbMetodoPagamento.setBackground(new Color(230, 230, 230));
		cbMetodoPagamento.setFont(new Font("Arial", Font.PLAIN, 20));
		cbMetodoPagamento.setModel(new DefaultComboBoxModel(MetodoPagamento.values()));
		painelFormaPagamento.add(cbMetodoPagamento, "cell 3 4 2 1,growx");
		
		btLimpar = new RoundButton("Limpar");
		btLimpar.setFont(new Font("Arial", Font.PLAIN, 20));
		btLimpar.setForeground(new Color(245, 245, 245));
		btLimpar.setBackground(new Color(224, 83, 76));
		btLimpar.setActionCommand("btLimpar");
		painelFormaPagamento.add(btLimpar, "cell 5 4");
		
		btConfirmar = new RoundButton("Confirmar");
		btConfirmar.setFont(new Font("Arial", Font.PLAIN, 20));
		btConfirmar.setForeground(new Color(245, 245, 245));
		btConfirmar.setBackground(new Color(224, 83, 76));
		btConfirmar.setActionCommand("btConfirmar");
		painelFormaPagamento.add(btConfirmar, "cell 4 7,alignx right");
		
		btCancelar = new RoundButton("Cancelar");
		btCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
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
