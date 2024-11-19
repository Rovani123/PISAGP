package visao.Cliente;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controle.CarrinhoControle;
import controle.ProdutoControle;
import controle.VendaControle;
import modelo.classes.Carrinho;
import modelo.dao.VendaDAO;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

public class TelaClienteCarrinho extends JFrame {
	private JPanel painelProdutos;
	private ArrayList<Carrinho> listaCarrinhos;
	
	public TelaClienteCarrinho(JFrame telaA,ArrayList<Carrinho> listaCarrinhos) {
		
		//Font font = new Font("Tahoma", Font.PLAIN, 11);;
		//try {
			//font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Poppins-SemiBold.ttf"));
			
			//font = font.deriveFont(Font.PLAIN, 11); // Definir o tamanho da fonte
				
		//} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		//} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		//}
		
		TelaClienteCarrinho tela = this;
		
		this.listaCarrinhos = listaCarrinhos;
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(100, 100, 985, 625);
		setBackground(new Color(230, 230, 230));
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(new MigLayout("", "[grow][][][][][][][grow][][][][][][][][][][][][][][grow][][][][]", "[grow][grow][][][][][][][][][][][][][][][][][grow][]"));
//		getContentPane().setLayout(new MigLayout("", "[grow][][][][][][][grow][][][][][][][][][][][][][][grow][][][][]", "[grow][grow][][][][][][][][][][][][][][][][][grow][]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(167, 208, 214));
		painelPrincipal.add(panel_1, "cell 0 0 7 20,alignx left,growy");
		panel_1.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][][][][]"));
		
		RoundButton btnNewButton_2 = new RoundButton("");
		//btnNewButton_2.setFont(font);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/volte.png")));
		panel_1.add(btnNewButton_2, "cell 1 0");
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/LogoPequena.png")));
		panel_1.add(lblNewLabel_2, "cell 1 2");
		
		JLabel lblNewLabel_3 = new JLabel("Categorias:");
		//lblNewLabel_3.setFont(font);
		panel_1.add(lblNewLabel_3, "cell 1 5");
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/biscoitos.png")));
		panel_1.add(lblNewLabel_4, "cell 0 6");
		
		RoundButton btnNewButton_3 = new RoundButton("Salgado");
		//btnNewButton_3.setFont(font);
		panel_1.add(btnNewButton_3, "cell 1 6");
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/bolinho.png")));
		panel_1.add(lblNewLabel_5, "cell 0 7");
		
		RoundButton btnNewButton_4 = new RoundButton("Doce");
		//btnNewButton_4.setFont(font);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_1.add(btnNewButton_4, "cell 1 7");
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/garrafa-de-agua.png")));
		panel_1.add(lblNewLabel_6, "cell 0 8");
		
		RoundButton btnNewButton_5 = new RoundButton("Bebidas");
		//btnNewButton_5.setFont(font);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_1.add(btnNewButton_5, "cell 1 8");
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/etiqueta-de-desconto.png")));
		panel_1.add(lblNewLabel_7, "cell 0 9");
		
		RoundButton btnNewButton_6 = new RoundButton("Ofertas");
		//btnNewButton_6.setFont(font);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_1.add(btnNewButton_6, "cell 1 9");
		
		JPanel panel_2 = new JPanel();
		painelPrincipal.add(panel_2, "cell 7 0 19 1,alignx left,growy");
		
		RoundButton btnNewButton = new RoundButton("");
		btnNewButton.setIcon(new ImageIcon(TelaClienteCarrinho.class.getResource("/Imagem/carrinho-de-compras.png")));
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Carrinho:");
		//lblNewLabel.setFont(font);
		panel_2.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		painelPrincipal.add(scrollPane, "cell 7 1 19 17,grow");
		
		painelProdutos = new JPanel();
		scrollPane.setViewportView(painelProdutos);
		
		JPanel panel_3 = new JPanel();
		painelPrincipal.add(panel_3, "cell 7 18 19 2,alignx right,growy");
		
		JLabel lblNewLabel_1 = new JLabel("Total a pagar: ");
		//lblNewLabel_1.setFont(font);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblTotalPagar = new JLabel("");
		lblTotalPagar.setText(String.valueOf(calcTotal()));
		panel_3.add(lblTotalPagar);
		
		RoundButton btnNewButton_1 = new RoundButton("Finalizar compra");
		//btnNewButton_1.setFont(font);
		panel_3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizarVenda();
				finalizarCarrinho();
			}
		});
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		getProdutos();
	}
	private void getProdutos() {

		painelProdutos.removeAll();
		ProdutoControle pc = new ProdutoControle();

		int c = 0;
		int l = 0;

		ProdutoControle pc2 = new ProdutoControle();
		for(Carrinho carrinho :listaCarrinhos) {
			PainelProduto pp = new PainelProduto(pc2.getProdutoId(carrinho.getIdProduto()), carrinho);
			painelProdutos.add(pp, "cell " + l + " " + c);
			l++;
			if (l % 3 == 0) {
				c++;
				l = 0;
			}
		}
		
	}
	
	private float calcTotal() {
		float reultado=0;
		ProdutoControle pc = new ProdutoControle();
		for (Carrinho carrinho : listaCarrinhos) {
			reultado += carrinho.getQuantidade()*pc.getProdutoId(carrinho.getIdProduto()).getPreco();
		}
		return reultado;
	}

	private void finalizarVenda() {
		VendaControle vc = new VendaControle();
		try {
			vc.cadastrarVenda(1,1,"DébitoA",calcTotal());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void finalizarCarrinho() {
		CarrinhoControle cc = new CarrinhoControle();
		try {
			VendaControle vc = new VendaControle();
			for(int i=0;i<listaCarrinhos.size();i++) {
				listaCarrinhos.get(i).setIdVenda(vc.getIdVenda());
			}
			cc.cadastrarCarrinho(listaCarrinhos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void test() {
		for(int i=0;i<listaCarrinhos.size();i++) {
			String m = "ID Carrinho: "+String.valueOf(listaCarrinhos.get(i).getIdCarrinho()+"  ID Produto: "+String.valueOf(listaCarrinhos.get(i).getIdProduto())+"  ID Venda: "+String.valueOf(listaCarrinhos.get(i).getIdVenda())+"  Quantidade: "+String.valueOf(listaCarrinhos.get(i).getQuantidade()));
			JOptionPane.showMessageDialog(null, m);
		}
	}
	
}
