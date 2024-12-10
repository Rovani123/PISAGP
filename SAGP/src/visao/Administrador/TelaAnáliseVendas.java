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
import modelo.dao.VendaDAO;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import visao.TelaInicial;
import visao.Funcionário.TelaGerenciamentoP;
import java.awt.Font;
import java.awt.FontFormatException;

public class TelaAnáliseVendas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JMenuItem mFuncionarios;
	private JMenuItem mVoltarTelaInicial;
	private JMenuBar menuBar;
	private JMenu mTelas;
	private JMenuItem mAdm;
	private JMenuItem mFuncionario;
	private JMenu mOpcoes;
	private JMenuItem mAnaliseVendas;
	private JMenuItem mGFuncionarios;
	private JMenuItem mVoltar;
	
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
		setResizable(false);
		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 566);
		
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
		mAnaliseVendas.setEnabled(false);
		mAnaliseVendas.setFont(font);
		mAnaliseVendas.setActionCommand("mAnaliseVendas");
		mOpcoes.add(mAnaliseVendas);
		
		mGFuncionarios = new JMenuItem(" Funcionarios");
		mGFuncionarios.setFont(font);
		mGFuncionarios.setActionCommand("mGFuncionarios");
		mOpcoes.add(mGFuncionarios);
		
		mVoltar = new JMenuItem("Voltar ao inicio");
		mVoltar.setFont(font);
		mVoltar.setActionCommand("mVoltar");
		menuBar.add(mVoltar);;
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][grow]"));
		
		JLabel lblTabelaVendas = new JLabel("TABELA DE VENDAS:");
		//lblTabelaVendas.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblTabelaVendas, "cell 0 0 2 1,alignx center,aligny center");
		
		JScrollPane panelTabelaVendas = new JScrollPane();
		contentPane.add(panelTabelaVendas, "cell 0 1 2 2,grow");
		
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
}
