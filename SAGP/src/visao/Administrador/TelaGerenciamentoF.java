package visao.Administrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.FuncionarioControle;
import modelo.classes.Funcionario;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.TelaInicial;
import visao.Funcionário.TelaGerenciamentoP;

public class TelaGerenciamentoF extends JFrame {

	private JPanel painel;
	private JTable table;
	private JTextField txtPesquisa;
	private JPanel barraLateral;
	private JLabel lblLogo;
	private JLabel lblTabelaFunc;
	private JButton btPesquisar;
	private JButton btAlterar;
	private JButton btRemover;
	private JButton btAdicionar;
	private JLabel lblIconRemover;
	private JLabel lblIconAlterar;
	private JLabel lblIconAdicionar;
	private JMenuBar menuBar;
	private JMenu mTelas;
	private JMenuItem mAdm;
	private JMenuItem mFuncionario;
	private JMenu mOpcoes;
	private JMenuItem mAnaliseVendas;
	private JMenuItem mGFuncionarios;
	private JMenuItem mVoltar;


	public TelaGerenciamentoF(JFrame telaA,Funcionario f) {
		TelaGerenciamentoF tela = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 553);
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mTelas = new JMenu("Telas");
		menuBar.add(mTelas);
		
		mAdm = new JMenuItem("Administrador");
		mAdm.setEnabled(false);
		mTelas.add(mAdm);
		
		mFuncionario = new JMenuItem("Funcionário");
		mFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerenciamentoP telaG = new TelaGerenciamentoP(tela,f);
				dispose();
				telaG.setVisible(true);
			}
		});
		mTelas.add(mFuncionario);
		
		mOpcoes = new JMenu("Opções");
		menuBar.add(mOpcoes);
		
		mAnaliseVendas = new JMenuItem("Análise de vendas");
		mAnaliseVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAnáliseVendas telaAV = new TelaAnáliseVendas();
				dispose();
				telaAV.setVisible(true);
			}
		});
		mOpcoes.add(mAnaliseVendas);
		
		mGFuncionarios = new JMenuItem(" Funcionarios");
		mGFuncionarios.setEnabled(false);
		mOpcoes.add(mGFuncionarios);
		
		mVoltar = new JMenuItem("Voltar ao inicio");
		mVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaI = new TelaInicial();
				dispose();
				telaI.setVisible(true);
			}
		});
		menuBar.add(mVoltar);
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[grow][][][][][][][][][][grow]", "[][][grow]"));
		
		barraLateral = new JPanel();
		barraLateral.setBackground(new Color(167, 208, 214));
		painel.add(barraLateral, "cell 0 0 1 3,alignx left,growy");
		barraLateral.setLayout(new MigLayout("", "[][][][]", "[][][][grow][][grow][][][][][][grow][][][grow]"));
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaGerenciamentoF.class.getResource("/Imagem/LogoPequena.png")));
		barraLateral.add(lblLogo, "cell 0 1 4 1,alignx center,aligny center");
		
		lblTabelaFunc = new JLabel("TABELA DE FUNCIONARIO");
		barraLateral.add(lblTabelaFunc, "cell 0 4 4 1,alignx center,aligny center");
		
		btAlterar = new RoundButton("ALTERAR");
		btAlterar.setText("Alterar");
		btAlterar.setForeground(new Color(245, 245, 245));
		btAlterar.setBackground(new Color(224, 83, 76));
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Funcionario f = ((FuncionariosTableModel) table.getModel()).getItem(table.getSelectedRow());
					TelaAlteracaoF taf = new TelaAlteracaoF(tela, f);
					dispose();
					taf.setVisible(true);
				}catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Selecione um produto");
				}
			}
		});
		
		lblIconAlterar = new JLabel("");
		lblIconAlterar.setIcon(new ImageIcon(TelaGerenciamentoF.class.getResource("/Imagem/troca.png")));
		barraLateral.add(lblIconAlterar, "cell 1 6,alignx right");
		barraLateral.add(btAlterar, "cell 2 6,growx,aligny center");
		
		lblIconRemover = new JLabel("");
		lblIconRemover.setIcon(new ImageIcon(TelaGerenciamentoF.class.getResource("/Imagem/lixeira.png")));
		barraLateral.add(lblIconRemover, "cell 1 7,alignx right");
		
		btRemover = new RoundButton("DELETAR");
		btRemover.setText("Remover");
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Funcionario f = ((FuncionariosTableModel) table.getModel()).getItem(table.getSelectedRow());
				FuncionarioControle fc = new FuncionarioControle();
				try {
					fc.deletarFuncionario(f);
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não é possivel remover esse funcionário");
				}
				getfuncionarios();
				}catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Selecione um produto");
				}

			}
		});
		btRemover.setForeground(new Color(245, 245, 245));
		btRemover.setBackground(new Color(224, 83, 76));
		barraLateral.add(btRemover, "cell 2 7,growx,aligny center");
		
		lblIconAdicionar = new JLabel("");
		lblIconAdicionar.setIcon(new ImageIcon(TelaGerenciamentoF.class.getResource("/Imagem/lupa.png")));
		barraLateral.add(lblIconAdicionar, "cell 1 8,alignx right");
		
		btAdicionar = new RoundButton("ADICIONAR");
		btAdicionar.setText("Adicionar");
		btAdicionar.setForeground(new Color(245, 245, 245));
		btAdicionar.setBackground(new Color(224, 83, 76));
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					TelaCadastroF tcf = new TelaCadastroF(tela,f);
					dispose();
					tcf.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
					
				}
				
			}
		});
		barraLateral.add(btAdicionar, "cell 2 8,growx,aligny center");
		
		JLabel lblFuncionario = new JLabel("Funcionário");
		painel.add(lblFuncionario, "cell 1 1,alignx center,aligny center");
		
		txtPesquisa = new JTextField();
		painel.add(txtPesquisa, "cell 2 1 8 1,growx,aligny center");
		txtPesquisa.setColumns(10);
		
		btPesquisar = new RoundButton("");
		btPesquisar.setBackground(new Color(230, 230, 230));
		btPesquisar.setIcon(new ImageIcon(TelaGerenciamentoF.class.getResource("/Imagem/lupa.png")));
		painel.add(btPesquisar, "cell 10 1,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		painel.add(scrollPane, "cell 1 2 10 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		getfuncionarios();
	}
	private void getfuncionarios() {
		FuncionarioControle pf = new FuncionarioControle();
		ArrayList<Funcionario> lista = pf.getFuncionarios();
		
		FuncionariosTableModel model = new FuncionariosTableModel (lista);
		table.setModel(model);
	}

}
