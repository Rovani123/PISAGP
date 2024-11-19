package visao.Administrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class TelaAnáliseVendas extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public TelaAnáliseVendas(JFrame telaA, Funcionario f) {
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
		
		JMenu mnNewMenu = new JMenu("Telas");
		mnNewMenu.setBackground(new Color(245, 245, 245));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Adminstrador");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Funcionario");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				TelaGerenciamentoP TelaP = new TelaGerenciamentoP(tela, f);
				dispose();
				TelaP.setVisible(true);
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Opções");
		mnNewMenu_1.setBackground(new Color(245, 245, 245));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Análise de vendas");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem(" funcionarios");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaGerenciamentoF TelaG = new TelaGerenciamentoF(tela, f);
				dispose();
				TelaG.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Voltar para a Tela Inicial");
		mntmNewMenuItem_4.setBackground(new Color(245, 245, 245));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				TelaInicial telaI = new TelaInicial();
				dispose();
				telaI.setVisible(true);
			
			}
		});
		menuBar.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][grow]"));
		
		JLabel lblNewLabel = new JLabel("TABELA DE VENDAS:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel, "cell 0 0 2 1,alignx center,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1 2 2,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
