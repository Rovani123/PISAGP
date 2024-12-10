package visao.Administrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.TelaInicial;
import visao.Funcionário.TelaGerenciamentoP;
import java.awt.Font;
import java.awt.FontFormatException;

public class TelaAnáliseVendas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JMenuItem mFuncionario;
	private JMenuItem mAnaliseVendas;
	private JMenuItem mFuncionarios;
	private JMenuItem mVoltarTelaInicial;
	
	public TelaAnáliseVendas(Funcionario f) {
		
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
		
		setTitle("Tela de análise das vendas");
		setExtendedState(MAXIMIZED_BOTH);
		TelaAnáliseVendas tela = this;
		setResizable(false);
		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 566);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(230, 230, 230));
		setJMenuBar(menuBar);
		
		JMenu mTelas = new JMenu("Telas");
		mTelas.setFont(font);
		mTelas.setBackground(new Color(245, 245, 245));
		menuBar.add(mTelas);
		
		JMenuItem mAdm = new JMenuItem("Adminstrador");
		mAdm.setFont(font);
		mTelas.add(mAdm);
		
		mFuncionario = new JMenuItem("Funcionario");
		mFuncionario.setActionCommand("mFuncionario");
		mFuncionario.setFont(font);
//		mntmNewMenuItem_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			
//				TelaGerenciamentoP TelaP = new TelaGerenciamentoP(tela, f);
//				dispose();
//				TelaP.setVisible(true);
//			
//			}
//		});
		mTelas.add(mFuncionario);
		
		JMenu mOpcoes = new JMenu("Opções");
		mTelas.setBackground(new Color(245, 245, 245));
		menuBar.add(mTelas);
		
		JMenuItem mAnaliseVendas = new JMenuItem("Análise de vendas");
		mTelas.setFont(font);
		mTelas.add(mAnaliseVendas);
		
	    mFuncionarios = new JMenuItem(" funcionarios");
	    mFuncionarios.setActionCommand("mFuncionarios");
		
	    mFuncionarios.setFont(font);
//		mntmNewMenuItem_3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				TelaGerenciamentoF TelaG = new TelaGerenciamentoF(tela, f);
//				dispose();
//				TelaG.setVisible(true);
//				
//			}
//		});
		mTelas.add(mFuncionarios);
		
		mVoltarTelaInicial = new JMenuItem("Voltar para a Tela Inicial");
		mVoltarTelaInicial.setBackground(new Color(245, 245, 245));
		mVoltarTelaInicial.setActionCommand("mVoltarTelaInicial");
//		mntmNewMenuItem_4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			
//				TelaInicial telaI = new TelaInicial();
//				dispose();
//				telaI.setVisible(true);
//			
//			}
//		});
		menuBar.add(mVoltarTelaInicial);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][grow]"));
		
		JLabel lblTabelaVendas = new JLabel("TABELA DE VENDAS:");
		lblTabelaVendas.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblTabelaVendas, "cell 0 0 2 1,alignx center,aligny center");
		
		JScrollPane panelTabelaVendas = new JScrollPane();
		contentPane.add(panelTabelaVendas, "cell 0 1 2 2,grow");
		
		table = new JTable();
		panelTabelaVendas.setViewportView(table);
	}
	public void addAnaliseVendas(ActionListener listener) {
		mFuncionario.addActionListener(listener);
		mFuncionarios.addActionListener(listener);
		mVoltarTelaInicial.addActionListener(listener);
	}
}
