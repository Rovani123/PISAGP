package visao.Administrador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.Funcionário.ProdutosTableModel;

import java.awt.Font;
import java.awt.FontFormatException;

public class TelaGerenciamentoF extends JFrame {
	

	private JPanel painel;
	private JTextField txtPesquisa;
	private JTable table;
	private JMenuBar menuBar;
	private JMenu mTelas;
	private JMenuItem mAdm;
	private JMenuItem mFuncionario;
	private JMenu mOpcoes;
	private JMenuItem mAnaliseVendas;
	private JMenuItem mGFuncionarios;
	private JMenuItem mVoltar;
	private RoundButton btAlterar;
	private RoundButton btRemover;
	private RoundButton btAdicionar;
	private RoundButton btPesquisar;
	

	public TelaGerenciamentoF(Funcionario f) {
		
		Font font = new Font("Tahoma", Font.PLAIN, 11);;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Poppins-SemiBold.ttf"));
			
			font = font.deriveFont(Font.PLAIN, 11); // Definir o tamanho da fonte
	
		} catch (FontFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		TelaGerenciamentoF tela = this;
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 519);
		
		// inico menu
		menuBar = new JMenuBar();
		menuBar.setFont(font);
		setJMenuBar(menuBar);
		
		mTelas = new JMenu("Telas");
		mTelas.setFont(font);
		menuBar.add(mTelas);
		
		mAdm = new JMenuItem("Administrador");
		mAdm.setFont(font);
		mAdm.setEnabled(false);
		mTelas.add(mAdm);
		
		mFuncionario = new JMenuItem("Funcionário");
		mFuncionario.setFont(font);
		mFuncionario.setActionCommand("mFuncionario");
		mTelas.add(mFuncionario);
		
		mOpcoes = new JMenu("Opções");
		mOpcoes.setFont(font);
		menuBar.add(mOpcoes);
		
		mAnaliseVendas = new JMenuItem("Análise de vendas");
		mAnaliseVendas.setFont(font);
		mAnaliseVendas.setActionCommand("mAnaliseVendas");
		mOpcoes.add(mAnaliseVendas);
		
		mGFuncionarios = new JMenuItem(" Funcionarios");
		mGFuncionarios.setFont(font);
		mGFuncionarios.setEnabled(false);
		mOpcoes.add(mGFuncionarios);
		
		mVoltar = new JMenuItem("Voltar ao inicio");
		mVoltar.setFont(font);
		mVoltar.setActionCommand("mVoltar");
		menuBar.add(mVoltar);
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		//Fim do menu
	
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new BorderLayout(0, 0));
		
		JPanel BarraLateral = new JPanel();
		BarraLateral.setBackground(new Color(167, 208, 214));
		painel.add(BarraLateral, BorderLayout.WEST);
		BarraLateral.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][grow][]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaGerenciamentoF.class.getResource("/Imagem/LogoPequena.png")));
		BarraLateral.add(lblLogo, "cell 0 1,alignx left,aligny center");
		
		JLabel lblTabelaFunc = new JLabel("TABELA DE FUNCIONÁRIO:");
		//lblTabelaFunc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BarraLateral.add(lblTabelaFunc, "cell 0 3,alignx left,aligny center");
		
		JLabel lblIconAlterar = new JLabel("");
		lblIconAlterar.setIcon(new ImageIcon(TelaGerenciamentoF.class.getResource("/Imagem/troca.png")));
		BarraLateral.add(lblIconAlterar, "flowx,cell 0 4,alignx left,aligny center");
		
		JLabel lblIconRemover = new JLabel("");
		lblIconRemover.setIcon(new ImageIcon(TelaGerenciamentoF.class.getResource("/Imagem/lixeira.png")));
		BarraLateral.add(lblIconRemover, "flowx,cell 0 5");
		
		JLabel lblIconAdicionar = new JLabel("");
		lblIconAdicionar.setIcon(new ImageIcon(TelaGerenciamentoF.class.getResource("/Imagem/lupa.png")));
		BarraLateral.add(lblIconAdicionar, "flowx,cell 0 6");
		
		btAdicionar = new RoundButton("ADICIONAR");
		btAdicionar.setFont(font);
		//btAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btAdicionar.setText("Adicionar");
		btAdicionar.setForeground(new Color(0, 0, 0));
		btAdicionar.setBackground(new Color(245, 245, 245));
		btAdicionar.setActionCommand("btAdicionar");
//		btAdicionar.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//				
//				try {
//					TelaCadastroF tcf = new TelaCadastroF(tela,f);
//					dispose();
//					tcf.setVisible(true);
//		            } catch (Exception e2) {
//		            e2.printStackTrace();
//			}
//		}});
		BarraLateral.add(btAdicionar, "cell 0 6,alignx left,aligny center");
		
		btRemover = new RoundButton("DELETAR");
		btRemover.setFont(font);
		//btRemover.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btRemover.setText("Remover");
		btRemover.setActionCommand("btRemover");
//		btRemover.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//				Funcionario f = ((FuncionariosTableModel) table.getModel()).getItem(table.getSelectedRow());
//				FuncionarioControle fc = new FuncionarioControle();
//				try {
//					fc.deletarFuncionario(f);
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//					JOptionPane.showMessageDialog(null, "Não é possivel remover esse funcionário");
//				}
//				getfuncionarios();
//				}catch (Exception e1) {
//					e1.printStackTrace();
//					JOptionPane.showMessageDialog(null, "Selecione um produto");
//				}
//
//			}
//		});
		btRemover.setForeground(new Color(0, 0, 0));
		btRemover.setBackground(new Color(245, 245, 245));
		BarraLateral.add(btRemover, "cell 0 5,alignx left,aligny center");
		
		btAlterar = new RoundButton("ALTERAR");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btAlterar.setFont(font);
		//btAlterar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btAlterar.setText("Alterar");
		btAlterar.setForeground(new Color(0, 0, 0));
		btAlterar.setBackground(new Color(245, 245, 245));
		btAlterar.setActionCommand("btAlterar");
	//	btAlterar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//		            TelaCadastroF tcf = new TelaCadastroF(tela,f);
//					dispose();
//					tcf.setVisible(true);
//		            } catch (Exception e2) {
//		            e2.printStackTrace();
//			}
//		}});
		BarraLateral.add(btAlterar, "cell 0 4");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 230));
		painel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPesquisa = new JPanel();
		panelPesquisa.setBackground(new Color(230, 230, 230));
		panel_2.add(panelPesquisa, BorderLayout.NORTH);
		panelPesquisa.setLayout(new MigLayout("", "[][][][grow][][][][][][][][][][][][][][][][][][][1px][]", "[][1px]"));
		
		JLabel lblFuncionario = new JLabel("Funcionário:");
		//lblFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPesquisa.add(lblFuncionario, "cell 1 0");
		
		txtPesquisa = new JTextField();
		//txtPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPesquisa.add(txtPesquisa, "cell 3 0 16 1,growx");
		txtPesquisa.setColumns(10);
		
		btPesquisar = new RoundButton("");
		btPesquisar.setFont(font);
		btPesquisar.setActionCommand("btPesquisar");
		//btPesquisar.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
			//}
		//});
		//btPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btPesquisar.setIcon(new ImageIcon(TelaGerenciamentoF.class.getResource("/Imagem/lupa.png")));
		panelPesquisa.add(btPesquisar, "cell 19 0");
		
		JScrollPane panelTabelaFuncionario = new JScrollPane();
		panel_2.add(panelTabelaFuncionario, BorderLayout.CENTER);
			
		table = new JTable();
		panelTabelaFuncionario.setViewportView(table);
		
	}
//	private void getfuncionarios() {
//		FuncionarioControle pf = new FuncionarioControle();
//		ArrayList<Funcionario> lista = pf.getFuncionarios();
//		
//		FuncionariosTableModel model = new FuncionariosTableModel (lista);
//		table.setModel(model);
//	}
	public void addGerenciamentoFListener(ActionListener listener) {
		mFuncionario.addActionListener(listener);
		mAnaliseVendas.addActionListener(listener);
		mVoltar.addActionListener(listener);
		btAlterar.addActionListener(listener);
		btRemover.addActionListener(listener);
		btAdicionar.addActionListener(listener);
		btPesquisar.addActionListener(listener);
	}
	
	public void setTabela(FuncionariosTableModel tm) {
		table.setModel(tm);
	}
	
	public Funcionario getItemTabela() {
		return ((FuncionariosTableModel) table.getModel()).getItem(table.getSelectedRow());
	}
	
	public String getPesquisa() {
		
		return txtPesquisa.getText();
		
	}

}
