package visao.Cliente;

import java.awt.Color;
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
	private JLabel lblIconOfertas;
	private RoundButton btOfertas;
	private JPanel painelCima;
	private JLabel lblCarrinho;
	private JScrollPane scrollPane;
	private JPanel painelBaixo;
	private JLabel lblTotalPagar;
	private JLabel lblValorTotal;
	private RoundButton btFinalizarCompra;
	private ArrayList<Carrinho> listaCarrinhos;
	
	public TelaClienteCarrinho(ArrayList<Carrinho> listaCarrinhos) {
		
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
		
		//TelaClienteCarrinho tela = this;
		
		this.listaCarrinhos = listaCarrinhos;
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(100, 100, 985, 625);
		setBackground(new Color(230, 230, 230));
		
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(new MigLayout("", "[grow][][][][][][][grow][][][][][][][][][][][][][][grow][][][][]", "[grow][grow][][][][][][][][][][][][][][][][][grow][]"));
		
		menuLateral = new JPanel();
		menuLateral.setBackground(new Color(167, 208, 214));
		painelPrincipal.add(menuLateral, "cell 0 0 7 20,alignx left,growy");
		menuLateral.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][][][][]"));
		
		btSair = new RoundButton("");
		btSair.setText("Sair");
		btSair.setFont(font);
		btSair.setActionCommand("btVoltar");
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
		btSair.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/volte.png")));
		menuLateral.add(btSair, "cell 1 0");
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/LogoPequena.png")));
		menuLateral.add(lblLogo, "cell 1 2");
		
		lblCategorias = new JLabel("Categorias:");
		lblCategorias.setFont(font);
		menuLateral.add(lblCategorias, "cell 1 5");
		
		lblIconSalgado = new JLabel("");
		lblIconSalgado.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/biscoitos.png")));
		menuLateral.add(lblIconSalgado, "cell 0 6");
		
		btSalgado = new RoundButton("Salgado");
		btSalgado.setFont(font);
		btSalgado.setActionCommand("btSalgado");
		menuLateral.add(btSalgado, "cell 1 6");
		
		lblIconDoce = new JLabel("");
		lblIconDoce.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/bolinho.png")));
		menuLateral.add(lblIconDoce, "cell 0 7");
		
		btDoce = new RoundButton("Doce");
		btDoce.setFont(font);
		btDoce.setActionCommand("btDoce");
//		btDoce.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
		menuLateral.add(btDoce, "cell 1 7");
		
		lblIconBebidas = new JLabel("");
		lblIconBebidas.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/garrafa-de-agua.png")));
		menuLateral.add(lblIconBebidas, "cell 0 8");
		
		btBebidas = new RoundButton("Bebidas");
		btBebidas.setFont(font);
		btBebidas.setActionCommand("btBebidas");
//		btBebidas.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
		menuLateral.add(btBebidas, "cell 1 8");
		
		lblIconOfertas = new JLabel("");
		lblIconOfertas.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/etiqueta-de-desconto.png")));
		menuLateral.add(lblIconOfertas, "cell 0 9");
		
		btOfertas = new RoundButton("Ofertas");
		btOfertas.setFont(font);
		btOfertas.setActionCommand("btOfertas");
		menuLateral.add(btOfertas, "cell 1 9");
		
		painelCima = new JPanel();
		painelPrincipal.add(painelCima, "cell 7 0 19 1,alignx left,growy");
		
		RoundButton btNO = new RoundButton("");
		btNO.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/carrinho-de-compras.png")));
		painelCima.add(btNO);
		
		lblCarrinho = new JLabel("Carrinho:");
		lblCarrinho.setFont(font);
		painelCima.add(lblCarrinho);
		
		scrollPane = new JScrollPane();
		painelPrincipal.add(scrollPane, "cell 7 1 19 17,grow");
		
		painelProdutos = new JPanel();
		scrollPane.setViewportView(painelProdutos);
		
		painelBaixo = new JPanel();
		painelPrincipal.add(painelBaixo, "cell 7 18 19 2,alignx right,growy");
		
		lblTotalPagar = new JLabel("Total a pagar: ");
		lblTotalPagar.setFont(font);
		painelBaixo.add(lblTotalPagar);
		
		lblValorTotal = new JLabel("");
		lblValorTotal.setText("");
		painelBaixo.add(lblValorTotal);
		
		btFinalizarCompra = new RoundButton("Finalizar compra");
		btFinalizarCompra.setForeground(new Color(245, 245, 245));
		btFinalizarCompra.setFont(font);
		btFinalizarCompra.setActionCommand("btFinalizarCompra");
		painelBaixo.add(btFinalizarCompra);
//		btFinalizarCompra.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				finalizarVenda();
//				finalizarCarrinho();
//			}
//		});
		btFinalizarCompra.setBackground(new Color(224, 83, 76));
		
	}
	
	public void addCarrinhoListeners(ActionListener listener) {
		btSair.addActionListener(listener);
		btSalgado.addActionListener(listener);
		btDoce.addActionListener(listener);
		btBebidas.addActionListener(listener);
		btOfertas.addActionListener(listener);
		btFinalizarCompra.addActionListener(listener);
	}
	
	public void addPainelProdutos(PainelProduto pp, int l, int c) {
		painelProdutos.add(pp, "cell " + l + " " + c);
	}
	
	public void setLblValorTotal(String s) {
		lblValorTotal.setText(s);
	}
	
//	private void getProdutos() {
//
//		painelProdutos.removeAll();
//		ProdutoControle pc = new ProdutoControle();
//		
//		int cont=0;
//		int c = 0;
//		int l = 0;
//
//		ProdutoControle pc2 = new ProdutoControle();
//		for(Carrinho carrinho :listaCarrinhos) {
//			PainelProduto pp = new PainelProduto(listaCarrinhos.get(cont).getProduto(),listaCarrinhos.get(cont));
//			painelProdutos.add(pp, "cell " + l + " " + c);
//			cont++;
//			l++;
//			if (l % 3 == 0) {
//				c++;
//				l = 0;
//			}
//		}
//		
//	}
	
//	private float calcTotal() {
//		float reultado=0;
//		ProdutoControle pc = new ProdutoControle();
//		for (Carrinho carrinho : listaCarrinhos) {
//			reultado += carrinho.getQuantidade()*pc.getProdutoId(carrinho.getIdProduto()).getPreco();
//		}
//		return reultado;
//	}
//
//	private void finalizarVenda() {
//		VendaControle vc = new VendaControle();
//		try {
//			vc.cadastrarVenda(1,1,"DébitoA",calcTotal());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void finalizarCarrinho() {
//		CarrinhoControle cc = new CarrinhoControle();
//		try {
//			VendaControle vc = new VendaControle();
//			for(int i=0;i<listaCarrinhos.size();i++) {
//				listaCarrinhos.get(i).setIdVenda(vc.getIdVenda());
//			}
//			cc.cadastrarCarrinho(listaCarrinhos);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void test() {
//		for(int i=0;i<listaCarrinhos.size();i++) {
//			String m = "ID Carrinho: "+String.valueOf(listaCarrinhos.get(i).getIdCarrinho()+"  ID Produto: "+String.valueOf(listaCarrinhos.get(i).getIdProduto())+"  ID Venda: "+String.valueOf(listaCarrinhos.get(i).getIdVenda())+"  Quantidade: "+String.valueOf(listaCarrinhos.get(i).getQuantidade()));
//			JOptionPane.showMessageDialog(null, m);
//		}
//	}
	
}
