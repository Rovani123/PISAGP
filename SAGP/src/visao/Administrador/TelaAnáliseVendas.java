package visao.Administrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import modelo.classes.Funcionario;
import modelo.classes.Vendas;
import modelo.dao.VendaDAO;
import modelo.tableModel.VendasTableModel;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.Funcionário.TelaGerenciamentoP;
import visao.inicio.TelaInicial;

import java.awt.Font;
import java.awt.FontFormatException;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;

public class TelaAnáliseVendas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JMenuBar menuBar;
	private JMenu mTelas;
	private JMenuItem mAdm;
	private JMenuItem mFuncionario;
	private JMenu mOpcoes;
	private JMenuItem mAnaliseVendas;
	private JMenuItem mGFuncionarios;
	private JMenuItem mVoltar;
	private JLabel lblNewLabel;
	
	
	public TelaAnáliseVendas(Funcionario f) {
		
		setTitle("Tela de análise das vendas");
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 566);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mTelas = new JMenu("Telas");
		mTelas.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mTelas);
		
		mAdm = new JMenuItem("Administrador");
		mAdm.setFont(new Font("Arial", Font.PLAIN, 15));
		mAdm.setEnabled(false);
		mTelas.add(mAdm);
		
		mFuncionario = new JMenuItem("Funcionário");
		mFuncionario.setFont(new Font("Arial", Font.PLAIN, 15));
		mFuncionario.setActionCommand("mFuncionario");
		mTelas.add(mFuncionario);
		
		mOpcoes = new JMenu("Opções");
		mOpcoes.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mOpcoes);
		
		mAnaliseVendas = new JMenuItem("Análise de vendas");
		mAnaliseVendas.setFont(new Font("Arial", Font.PLAIN, 15));
		mAnaliseVendas.setEnabled(false);
		mAnaliseVendas.setActionCommand("mAnaliseVendas");
		mOpcoes.add(mAnaliseVendas);
		
		mGFuncionarios = new JMenuItem(" Funcionarios");
		mGFuncionarios.setFont(new Font("Arial", Font.PLAIN, 15));
		mGFuncionarios.setActionCommand("mGFuncionarios");
		mOpcoes.add(mGFuncionarios);
		
		mVoltar = new JMenuItem("Voltar ao inicio");
		mVoltar.setFont(new Font("Arial", Font.PLAIN, 16));
		mVoltar.setActionCommand("mVoltar");
		menuBar.add(mVoltar);;
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][grow]", "[][][][][][][grow]"));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(230, 230, 232));
		lblNewLabel.setIcon(new ImageIcon(TelaAnáliseVendas.class.getResource("/Imagem/Logo.png")));
		contentPane.add(lblNewLabel, "cell 0 0 4 1,alignx center,aligny top");
		
		JLabel lblTabelaVendas = new JLabel("TABELA DE VENDAS:");
		lblTabelaVendas.setFont(new Font("Arial", Font.BOLD, 30));
		//lblTabelaVendas.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblTabelaVendas, "cell 0 1 4 1,alignx center,aligny top");
		
		JScrollPane panelTabelaVendas = new JScrollPane();
		contentPane.add(panelTabelaVendas, "cell 0 2 4 5,grow");
		
		table = new JTable();
		panelTabelaVendas.setViewportView(table);
	}
	public void addAnaliseVendas(ActionListener listener) {
		mFuncionario.addActionListener(listener);
		mVoltar.addActionListener(listener);
		mGFuncionarios.addActionListener(listener);
	}
	
	public void setTabela(VendasTableModel model) {
		table.setModel(model);
	}
	
	public Vendas getItemTabela() {
		return ((VendasTableModel) table.getModel()).getItem(table.getSelectedRow());
	}
	
	public void addTabelaListeners(MouseListener listener) {
		table.addMouseListener(listener);
	}
}
