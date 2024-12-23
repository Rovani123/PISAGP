package visao.Funcionário;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.tableModel.FuncionariosTableModel;
import modelo.tableModel.ProdutosTableModel;

import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaGerenciamentoP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JMenuItem mAdm;
	private JMenuItem mFuncionario;
	private JMenuItem mGProdutos;
	private JMenuItem mCliente;
	private JTextField txtPesquisar;
	private JTable table;
	private JMenuItem mVoltar;
	private RoundButton btSalgados;
	private RoundButton btDoces;
	private RoundButton btBebidas;
	private RoundButton btAlterar;
	private RoundButton btRemover;
	private RoundButton btCadastrar;
	private RoundButton btPesquisar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenciamentoP frame = new TelaGerenciamentoP(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaGerenciamentoP (Funcionario f) {
		setTitle("Tela de Gerenciamento de Produto");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 955, 544);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mTelas = new JMenu("Telas");
		mTelas.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mTelas);
		
		mAdm = new JMenuItem("Administrador ");
		mAdm.setEnabled(false);
		mTelas.add(mAdm);
		mAdm.setActionCommand("mAdm");
		
		mFuncionario = new JMenuItem("Funcionário ");
		mFuncionario.setEnabled(false);
		mFuncionario.setActionCommand("mFuncionario");
		mTelas.add(mFuncionario);
		
		JMenu mOpcoes = new JMenu("Opções");
		mOpcoes.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mOpcoes);
		
	    mGProdutos = new JMenuItem("Produtos ");
		mGProdutos.setEnabled(false);
		mOpcoes.add(mGProdutos);
		mGProdutos.setActionCommand("mGProdutos");
		
	    mCliente = new JMenuItem("Cliente");
	    mCliente.setFont(new Font("Arial", Font.PLAIN, 16));
		mOpcoes.add(mCliente);
		mCliente.setActionCommand("mCliente");
		
		
	    mVoltar = new JMenuItem("Voltar ao início");
	    mVoltar.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mVoltar);
		mVoltar.setActionCommand("mVoltar");
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		

		setContentPane(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel barraLateral = new JPanel();
		barraLateral.setBackground(new Color(167, 208, 214));
		panel.add(barraLateral, BorderLayout.WEST);
		barraLateral.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][][][][]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(167, 208, 214));
		lblLogo.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/Logo.png")));
		barraLateral.add(lblLogo, "cell 0 2,alignx center,aligny center");
		
		JLabel lblIconSalgados = new JLabel("");
		lblIconSalgados.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/biscoitos.png")));
		barraLateral.add(lblIconSalgados, "flowx,cell 0 5");
		
		btSalgados = new RoundButton("Salgados");
		btSalgados.setFont(new Font("Arial", Font.PLAIN, 16));
		btSalgados.setForeground(new Color(0, 0, 0));
		btSalgados.setBackground(new Color(245, 245, 245));
		barraLateral.add(btSalgados, "cell 0 5,growx,aligny center");
		btSalgados.setActionCommand("btSalgados");
		
		
		JLabel lblIconDoces = new JLabel("");
		lblIconDoces.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/bolinho.png")));
		barraLateral.add(lblIconDoces, "flowx,cell 0 6");
		
		btDoces = new RoundButton("Doces");
		btDoces.setFont(new Font("Arial", Font.PLAIN, 16));
		btDoces.setForeground(new Color(0, 0, 0));
		btDoces.setBackground(new Color(245, 245, 245));
		barraLateral.add(btDoces, "cell 0 6,growx,aligny center");
		btDoces.setActionCommand("btDoces");
		
		JLabel lblIconBebidas = new JLabel("");
		lblIconBebidas.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/garrafa-de-agua.png")));
		barraLateral.add(lblIconBebidas, "flowx,cell 0 7");
		
	    btBebidas = new RoundButton("Bebidas");
	    btBebidas.setFont(new Font("Arial", Font.PLAIN, 16));
	    btBebidas.setForeground(new Color(0, 0, 0));
		btBebidas.setBackground(new Color(245, 245, 245));
		barraLateral.add(btBebidas, "cell 0 7,growx,aligny center");
		btBebidas.setActionCommand("btBebidas");
		
		JLabel lblIconAlterar = new JLabel("");
		lblIconAlterar.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/troca.png")));
		barraLateral.add(lblIconAlterar, "flowx,cell 0 13");
		
		btAlterar = new RoundButton("Alterar");
		btAlterar.setFont(new Font("Arial", Font.PLAIN, 16));
		btAlterar.setActionCommand("btAlterar");
		
		btAlterar.setBackground(new Color(245, 245, 245));	
		
		barraLateral.add(btAlterar, "cell 0 13,growx,aligny center");
		
		JLabel lblIconExcluir = new JLabel("");
		lblIconExcluir.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/lixeira.png")));
		barraLateral.add(lblIconExcluir, "flowx,cell 0 14");
		
		btRemover = new RoundButton("Remover");
		btRemover.setFont(new Font("Arial", Font.PLAIN, 16));
		btRemover.setBackground(new Color(245, 245, 245));
		btRemover.setActionCommand("btRemover");
		
		barraLateral.add(btRemover, "cell 0 14,growx,aligny center");
		
		JLabel lblIconCadastrar = new JLabel("");
		lblIconCadastrar.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/postagem-no-instagramCorreto.png")));
		barraLateral.add(lblIconCadastrar, "flowx,cell 0 15");
		
		btCadastrar = new RoundButton("Adicionar");
		btCadastrar.setFont(new Font("Arial", Font.PLAIN, 16));
		btCadastrar.setBackground(new Color(245, 245, 245));
		btCadastrar.setActionCommand("btCadastrar");
		barraLateral.add(btCadastrar, "cell 0 15,growx,aligny center");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 230));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[grow]", "[][][grow]"));
		
		JPanel panelPesquisa = new JPanel();
		panelPesquisa.setBackground(new Color(230, 230, 230));
		panel_1.add(panelPesquisa, "cell 0 0,grow");
		panelPesquisa.setLayout(new MigLayout("", "[][][][grow]", "[]"));
		
		JLabel lblIconEstoque = new JLabel("Estoque");
		lblIconEstoque.setFont(new Font("Arial", Font.PLAIN, 16));
		panelPesquisa.add(lblIconEstoque, "cell 0 0 3 1,alignx right,aligny center");
		
		btPesquisar = new RoundButton("");
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btPesquisar.setActionCommand("btPesquisar");
		btPesquisar.setText("");
		
		btPesquisar.setBackground(new Color(245, 245, 245));
		btPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtPesquisar = new JTextField();
		txtPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPesquisa.add(txtPesquisar, "flowx,cell 3 0 2 1,growx");
		txtPesquisar.setColumns(10);
		btPesquisar.setIcon(new ImageIcon(TelaGerenciamentoP.class.getResource("/Imagem/lupa.png")));
		panelPesquisa.add(btPesquisar, "cell 3 0 2 1,alignx right,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 0 1 1 2,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);

		
	}
	
	public void addGerenciamentoPListner(ActionListener listener) {
		mVoltar.addActionListener(listener);
		mGProdutos.addActionListener(listener);
		mCliente.addActionListener(listener);
		mAdm.addActionListener(listener);
		mFuncionario.addActionListener(listener);
		btSalgados.addActionListener(listener);
		btDoces.addActionListener(listener);
		btBebidas.addActionListener(listener);
		btAlterar.addActionListener(listener);
		btRemover.addActionListener(listener);
		btCadastrar.addActionListener(listener);
		btPesquisar.addActionListener(listener);
	}
	
	public void setTabela(ProdutosTableModel tm) {
		table.setModel(tm);
	}
	
	public void setmenuAdm(boolean b) {
		mAdm.setEnabled(b);		
	}
	public void setBackgroundcolor(String botao, Color color) {
		switch (botao) {
		case "btSalgados":
			btSalgados.setBackground(color);
			break;
		case "btDoces":
			btDoces.setBackground(color);
			break;
		case "btBebidas":
			btBebidas.setBackground(color);
			break;
		}
	}

	public Produto getItemTabela() {
		return ((ProdutosTableModel) table.getModel()).getItem(table.getSelectedRow());
	}
	
	public String getPesquisa() {
		return txtPesquisar.getText();
	}
}