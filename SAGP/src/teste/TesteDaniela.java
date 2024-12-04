package teste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TesteDaniela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JMenuItem mAdm;
	private JMenuItem mFuncionario;
	private JMenuItem mGProdutos;
	private JMenuItem mPromocoes;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteDaniela frame = new TesteDaniela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TesteDaniela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 544);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mTelas = new JMenu("Telas");
		menuBar.add(mTelas);
		
		mAdm = new JMenuItem("Administrador ");
		mAdm.setEnabled(false);
		mTelas.add(mAdm);
		mAdm.setActionCommand("mAdm");
//		mAdm.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			TelaGerenciamentoF tf = new TelaGerenciamentoF(tela, f);
//			dispose();
//			tf.setVisible(true);
//		}
//	});
		mTelas.add(mAdm);
		
		mFuncionario = new JMenuItem("Funcionário ");
		mFuncionario.setEnabled(false);
		mFuncionario.setActionCommand("mFuncionario");
		mTelas.add(mFuncionario);
		
		JMenu mOpcoes = new JMenu("Opções");
		menuBar.add(mOpcoes);
		
	    mGProdutos = new JMenuItem("Produtos ");
		mGProdutos.setEnabled(false);
		mOpcoes.add(mGProdutos);
		mGProdutos.setActionCommand("mGProdutos");
		
	    mPromocoes = new JMenuItem("Promoções  ");
		mOpcoes.add(mPromocoes);
		mPromocoes.setActionCommand("mPromocoes");
//		mPromocoes.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TelaPromocoes tp = new TelaPromocoes(telaA, tela, f);
//				tp.setVisible(true);
//				dispose();
//			}
//		});
		
		
		JMenuItem mVoltar = new JMenuItem("Voltar ao início");
		menuBar.add(mVoltar);
//		mVoltar.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			TelaInicial telaI = new TelaInicial();
//			dispose();
//			telaI.setVisible(true);
//		}
//	});
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		

		setContentPane(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel barraLateral = new JPanel();
		barraLateral.setBackground(new Color(167, 208, 214));
		panel.add(barraLateral, BorderLayout.WEST);
		barraLateral.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][][][][]"));
		
		RoundButton btVoltar = new RoundButton("Voltar");
		btVoltar.setText("");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//COLOCAR O BOTÃO DE VOLTAR
			}
		});
		btVoltar.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/volte.png")));
		barraLateral.add(btVoltar, "cell 0 0,alignx left,aligny top");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/LogoPequena.png")));
		barraLateral.add(lblLogo, "cell 0 2,alignx center,aligny center");
		
		JLabel lblIconSalgados = new JLabel("");
		lblIconSalgados.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/biscoitos.png")));
		barraLateral.add(lblIconSalgados, "flowx,cell 0 5");
		
		RoundButton btSalgados = new RoundButton("Salgados");
		btSalgados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//COLOCAR OS SALGADOS
			}
		});
		barraLateral.add(btSalgados, "cell 0 5,growx,aligny center");
		
		JLabel lblIconDoces = new JLabel("");
		lblIconDoces.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/bolinho.png")));
		barraLateral.add(lblIconDoces, "flowx,cell 0 6");
		
		RoundButton btDoces = new RoundButton("Doces");
		btDoces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//colocar os doces
			}
		});
		barraLateral.add(btDoces, "cell 0 6,growx,aligny center");
		
		JLabel lblIconBebidas = new JLabel("");
		lblIconBebidas.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/garrafa-de-agua.png")));
		barraLateral.add(lblIconBebidas, "flowx,cell 0 7");
		
		RoundButton btBebidas = new RoundButton("Bebidas");
		btBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//COLOCAR AS BEBIDAS
			}
		});
		barraLateral.add(btBebidas, "cell 0 7,growx,aligny center");
		
		JLabel lblIconAlterar = new JLabel("");
		lblIconAlterar.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/troca.png")));
		barraLateral.add(lblIconAlterar, "flowx,cell 0 13");
		
		RoundButton btAlterar = new RoundButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//COLOCAR O BOTAO
//				btAlterar.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					try {
//						Produto p = ((ProdutosTableModel) table.getModel()).getItem(table.getSelectedRow());
	//
//						TelaAlteracaoP tap = new TelaAlteracaoP(tela, p, f);
//						dispose();
//						tap.setVisible(true);
//					} catch (Exception e1) {
//						e1.printStackTrace();
//						JOptionPane.showMessageDialog(null, "Selecione um produto");
//					}
//				}
//			});
			
		
		barraLateral.add(btAlterar, "cell 0 13,growx,aligny center");
		
		JLabel lblIconExcluir = new JLabel("");
		lblIconExcluir.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/lixeira.png")));
		barraLateral.add(lblIconExcluir, "flowx,cell 0 14");
		
		RoundButton lblIconRemover = new RoundButton("Remover");
		//btRemover.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					Produto p = ((ProdutosTableModel) table.getModel()).getItem(table.getSelectedRow());
//					ProdutoDAO pdal = new ProdutoDAO();
//					try {
//						pdal.deletarProduto(p);
//						JOptionPane.showMessageDialog(null, "operação realizada com sucesso");
//					} catch (SQLException e1) {
//						e1.printStackTrace();
//						JOptionPane.showMessageDialog(null, "Não é possivel remover esse produto");
//					}
//					if (contS == 1) {
//						getProdutosFiltro(Categoria.categoriaString("salgados"));
//					} else if (contD == 1) {
//						getProdutosFiltro(Categoria.categoriaString("doces"));
//					} else if (contD == 1) {
//						getProdutosFiltro(Categoria.categoriaString("bebidas"));
//					} else {
//						getProdutos();
//					}
//				} catch (Exception e2) {
//					JOptionPane.showMessageDialog(null, "Selecione um produto");
//				}
//			}
//		});
		barraLateral.add(lblIconRemover, "cell 0 14,growx,aligny center");
		
		JLabel lblIconCadastrar = new JLabel("");
		lblIconCadastrar.setIcon(new ImageIcon(TesteDaniela.class.getResource("/Imagem/lupa.png")));
		barraLateral.add(lblIconCadastrar, "flowx,cell 0 15");
		
		RoundButton btCadastrar = new RoundButton("Adicionar");
//		btCadastrar.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//
//			TelaCadastroP tcp = new TelaCadastroP(tela, f);
//			dispose();
//			tcp.setVisible(true);
//		}
//	});
		barraLateral.add(btCadastrar, "cell 0 15,growx,aligny center");
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[]", "[]"));
	}

}
