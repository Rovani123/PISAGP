package teste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.FuncionarioControle;
import modelo.classes.Funcionario;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.TelaInicial;
import visao.Administrador.TelaGerenciamentoF;
import visao.Funcionário.TelaGerenciamentoP;
import java.awt.Font;

public class TelaDeTes2 extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeTes2 frame = new TelaDeTes2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel painel;
	private JTextField txtPesquisa;
	private JTable table;
	private JMenuBar menuBar;
	private JMenu mTelas;
	private JMenuItem mAdm;
	private JMenuItem mFuncionario;
	private JMenu mOpcoes;
	

	public TelaDeTes2(JFrame telaA,Funcionario f) {
		TelaGerenciamentoF tela = this;
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 519);
		
		// inico menu
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
		
		JMenu mnNewMenu_1 = new JMenu("Opções");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mAnaliseVendas = new JMenuItem("Análise de vendas");
		mnNewMenu_1.add(mAnaliseVendas);
		
		JMenuItem mGFuncionarios = new JMenuItem("Funcionarios");
		mGFuncionarios.setEnabled(false);
		mnNewMenu_1.add(mGFuncionarios);
		
		JMenuItem mVoltar = new JMenuItem("Voltar ao inicio");
		menuBar.add(mVoltar);
		
		//Fim do menu
		painel = new JPanel();
		painel.setBackground(new Color(230, 230, 230));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(167, 208, 214));
		painel.add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][grow][]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaDeTes2.class.getResource("/Imagem/LogoPequena.png")));
		panel.add(lblLogo, "cell 0 1,alignx left,aligny center");
		
		JLabel lblTabelaFunc = new JLabel("TABELA DE FUNCIONÁRIO");
		lblTabelaFunc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblTabelaFunc, "cell 0 3,alignx left,aligny center");
		
		JLabel lblIconAlterar = new JLabel("");
		lblIconAlterar.setIcon(new ImageIcon(TelaDeTes2.class.getResource("/Imagem/troca.png")));
		panel.add(lblIconAlterar, "flowx,cell 0 4,alignx left,aligny center");
		
		JLabel lblIconRemover = new JLabel("");
		lblIconRemover.setIcon(new ImageIcon(TelaDeTes2.class.getResource("/Imagem/lixeira.png")));
		panel.add(lblIconRemover, "flowx,cell 0 5");
		
		JLabel lblIconAdicionar = new JLabel("");
		lblIconAdicionar.setIcon(new ImageIcon(TelaDeTes2.class.getResource("/Imagem/lupa.png")));
		panel.add(lblIconAdicionar, "flowx,cell 0 6");
		
		JButton btAdicionar = new RoundButton("ADICIONAR");
		btAdicionar.setForeground(new Color(245, 245, 245));
		btAdicionar.setBackground(new Color(224, 83, 76));
		panel.add(btAdicionar, "cell 0 6,alignx left,aligny center");
		
		JButton btRemover = new RoundButton("REMOVER");
		btRemover.setForeground(new Color(245, 245, 245));
		btRemover.setBackground(new Color(224, 83, 76));
		panel.add(btRemover, "cell 0 5,alignx left,aligny center");
		
		JButton btAlterar = new RoundButton("ALTERAR");
		btAlterar.setForeground(new Color(245, 245, 245));
		btAlterar.setBackground(new Color(224, 83, 76));
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btAlterar, "cell 0 4");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 230));
		painel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPesquisa = new JPanel();
		panelPesquisa.setBackground(new Color(230, 230, 230));
		panel_2.add(panelPesquisa, BorderLayout.NORTH);
		panelPesquisa.setLayout(new MigLayout("", "[][][][grow][][][][][][][][][][][][][][][][][][][1px][]", "[][1px]"));
		
		JLabel lblFuncionario = new JLabel("Funcionário");
		lblFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPesquisa.add(lblFuncionario, "cell 1 0");
		
		txtPesquisa = new JTextField();
		txtPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPesquisa.add(txtPesquisa, "cell 3 0 16 1,growx");
		txtPesquisa.setColumns(10);
		
		JButton btPesquisar = new RoundButton("");
		btPesquisar.setBackground(new Color(230, 230, 230));
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btPesquisar.setIcon(new ImageIcon(TelaDeTes2.class.getResource("/Imagem/lupa.png")));
		panelPesquisa.add(btPesquisar, "cell 19 0");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
