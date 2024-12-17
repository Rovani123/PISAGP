package visao.Cliente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import modelo.classes.Carrinho;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.Administrador.TelaGerenciamentoF;
import java.awt.event.ActionEvent;

public class TelaClienteCarrinho extends JFrame {
	
	
	private JPanel painelPrincipal;
	private JPanel menuLateral;
	private JPanel painelProdutos;
	private RoundButton btSair;
	private JLabel lblLogo;
	private JLabel lblCategorias;
	private JLabel lblIconSalgado;
	private RoundButton btSalgado;
	private JLabel lblIconDoce;
	private RoundButton btDoce;
	private JLabel lblIconBebidas;
	private RoundButton btBebidas;
	private JPanel painelCima;
	private JLabel lblCarrinho;
	private JScrollPane scrollPane;
	private JPanel painelBaixo;
	private JLabel lblTotalPagar;
	private JLabel lblValorTotal;
	private RoundButton btFinalizarCompra;
	private ArrayList<Carrinho> listaCarrinhos;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteCarrinho frame = new TelaClienteCarrinho(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public TelaClienteCarrinho(ArrayList<Carrinho> listaCarrinhos) {
		
		
		//TelaClienteCarrinho tela = this;
		
		this.listaCarrinhos = listaCarrinhos;
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(100, 100, 985, 625);
		setBackground(new Color(230, 230, 230));
		
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(230, 230, 230));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(new MigLayout("", "[grow][][][][][][][grow][][][][][][][][][][][][][][grow][][][][]", "[grow][grow][][][][][][][][][][][][][][][][][grow][]"));
		
		menuLateral = new JPanel();
		menuLateral.setBackground(new Color(167, 208, 214));
		painelPrincipal.add(menuLateral, "cell 0 0 7 20,alignx left,growy");
		menuLateral.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][][][][]"));
		
		btSair = new RoundButton("");
		btSair.setBackground(new Color(245, 245, 245));
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btSair.setFont(new Font("Arial", Font.PLAIN, 16));
		btSair.setText("Sair");
		btSair.setActionCommand("btVoltar");
		//		btnNewButton_2.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//				
		//			}
		//		});
				btSair.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/volte.png")));
				menuLateral.add(btSair, "cell 0 0");
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/Logo.png")));
		menuLateral.add(lblLogo, "cell 0 2");
		
		lblCategorias = new JLabel("Categorias:");
		lblCategorias.setFont(new Font("Arial", Font.PLAIN, 16));
		menuLateral.add(lblCategorias, "cell 0 5");
		
		lblIconSalgado = new JLabel("");
		lblIconSalgado.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/biscoitos.png")));
		menuLateral.add(lblIconSalgado, "flowx,cell 0 6");
		
		lblIconDoce = new JLabel("");
		lblIconDoce.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/bolinho.png")));
		menuLateral.add(lblIconDoce, "flowx,cell 0 7");
		
		lblIconBebidas = new JLabel("");
		lblIconBebidas.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/garrafa-de-agua.png")));
		menuLateral.add(lblIconBebidas, "flowx,cell 0 8");
		
		btSalgado = new RoundButton("Salgado");
		btSalgado.setBackground(new Color(245, 245, 245));
		btSalgado.setFont(new Font("Arial", Font.PLAIN, 15));
		btSalgado.setActionCommand("btSalgado");
		menuLateral.add(btSalgado, "cell 0 6");
		
		btDoce = new RoundButton("Doce");
		btDoce.setBackground(new Color(245, 245, 245));
		btDoce.setFont(new Font("Arial", Font.PLAIN, 15));
		btDoce.setActionCommand("btDoce");
		//		btDoce.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//				
		//			}
		//		});
				menuLateral.add(btDoce, "cell 0 7");
				
				btBebidas = new RoundButton("Bebidas");
				btBebidas.setBackground(new Color(245, 245, 245));
				btBebidas.setFont(new Font("Arial", Font.PLAIN, 15));
				btBebidas.setActionCommand("btBebidas");
				//		btBebidas.addActionListener(new ActionListener() {
				//			public void actionPerformed(ActionEvent e) {
				//				
				//			}
				//		});
						menuLateral.add(btBebidas, "cell 0 8");
		
		painelCima = new JPanel();
		painelPrincipal.add(painelCima, "cell 7 0 19 1,grow");
		
		RoundButton btNO = new RoundButton("");
		btNO.setBackground(new Color(245, 245, 245));
		btNO.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/carrinho-de-compras.png")));
		painelCima.add(btNO);
		
		lblCarrinho = new JLabel("Carrinho:");
		lblCarrinho.setFont(new Font("Arial", Font.BOLD, 16));
		painelCima.add(lblCarrinho);
		
		scrollPane = new JScrollPane();
		painelPrincipal.add(scrollPane, "cell 7 1 19 17,grow");
		
		painelProdutos = new JPanel();
		scrollPane.setViewportView(painelProdutos);
		
		painelBaixo = new JPanel();
		painelPrincipal.add(painelBaixo, "cell 7 18 19 2,grow");
		
		lblTotalPagar = new JLabel("Total a pagar: ");
		lblTotalPagar.setBackground(new Color(230, 230, 230));
		lblTotalPagar.setFont(new Font("Arial", Font.BOLD, 16));
		painelBaixo.add(lblTotalPagar);
		
		lblValorTotal = new JLabel("");
		lblValorTotal.setText("");
		painelBaixo.add(lblValorTotal);
		
		btFinalizarCompra = new RoundButton("Finalizar compra");
		btFinalizarCompra.setFont(new Font("Arial", Font.PLAIN, 16));
		btFinalizarCompra.setForeground(new Color(245, 245, 245));
		btFinalizarCompra.setActionCommand("btFinalizarCompra");
		painelBaixo.add(btFinalizarCompra);
		btFinalizarCompra.setBackground(new Color(224, 83, 76));
		
	}
	
	public void addCarrinhoListeners(ActionListener listener) {
		btSair.addActionListener(listener);
		btSalgado.addActionListener(listener);
		btDoce.addActionListener(listener);
		btBebidas.addActionListener(listener);

		btFinalizarCompra.addActionListener(listener);
	}
	
	public void addPainelProdutos(PainelProduto pp, int l, int c) {
		painelProdutos.add(pp, "cell " + l + " " + c);
	}
	
	public void setLblValorTotal(String s) {
		lblValorTotal.setText(s);
	}
	
	
}
