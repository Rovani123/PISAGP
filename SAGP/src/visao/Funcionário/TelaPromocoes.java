package visao.Funcionário;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.dao.ProdutoDAO;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TelaPromocoes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;


	public TelaPromocoes(JFrame telaA, JFrame telaC, Funcionario f) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1125, 607);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Telas");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Administrador ");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Funcionário ");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Opções");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Produtos ");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Promoções  ");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Voltar ao início");
		menuBar.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][][][][][][][][][grow]", "[grow][][grow][][grow][][grow]"));
		
		JPanel barraLateral = new JPanel();
		barraLateral.setBackground(new Color(167, 208, 214));
		contentPane.add(barraLateral, "cell 0 0 1 7,alignx left,growy");
		barraLateral.setLayout(new MigLayout("", "[]", "[][][][grow][][grow][][][grow][][][grow][][grow][]"));
		
		JButton btVoltar = new RoundButton("");
		btVoltar.setBackground(new Color(245, 245, 245));
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btVoltar.setIcon(new ImageIcon(TelaPromocoes.class.getResource("/Imagem/volte.png")));
		barraLateral.add(btVoltar, "cell 0 0,alignx left,aligny center");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPromocoes.class.getResource("/Imagem/Logo.png")));
		barraLateral.add(lblNewLabel, "cell 0 1");
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_5.setIcon(new ImageIcon(TelaPromocoes.class.getResource("/Imagem/etiqueta-de-desconto.png")));
		barraLateral.add(lblNewLabel_5, "flowx,cell 0 3");
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaPromocoes.class.getResource("/Imagem/troca.png")));
		barraLateral.add(lblNewLabel_2, "flowx,cell 0 5");
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaPromocoes.class.getResource("/Imagem/lixeira.png")));
		barraLateral.add(lblNewLabel_3, "flowx,cell 0 7");
		
		JLabel lblNewLabel_1 = new JLabel("OFERTAS:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setToolTipText("");
		barraLateral.add(lblNewLabel_1, "cell 0 3,alignx center,aligny center");
		
		JButton btAlterar = new RoundButton("ALTERAR");
		btAlterar.setForeground(new Color(245, 245, 245));
		btAlterar.setBackground(new Color(224, 83, 76));
		btAlterar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btAlterar.addActionListener(new ActionListener() {
			
				
		});
		barraLateral.add(btAlterar, "cell 0 5,alignx center,aligny center");
		
		JButton btRemover = new RoundButton("DELETAR");
		btRemover.setForeground(new Color(245, 245, 245));
		btRemover.setBackground(new Color(224, 83, 76));
		btRemover.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Produto p = ((ProdutosTableModel) table.getModel()).getItem(table.getSelectedRow());
					ProdutoDAO pdal = new ProdutoDAO();
					try {
						pdal.deletarProduto(p);
						JOptionPane.showMessageDialog(null, "operação realizada com sucesso");
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Não é possivel remover esse produto");
					}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Selecione um produto");
			}
		}
	});
		barraLateral.add(btRemover, "cell 0 7,alignx center,aligny center");
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(TelaPromocoes.class.getResource("/Imagem/lupa.png")));
		barraLateral.add(lblNewLabel_4, "flowx,cell 0 9");
		
		JButton btCadastrar = new RoundButton("ADICIONAR");
		btCadastrar.setForeground(new Color(245, 245, 245));
		btCadastrar.setBackground(new Color(224, 83, 76));
		btCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastroPromocao tcp = new TelaCadastroPromocao (telaC, f);
				dispose();
				tcp.setVisible(true);
			}
		});
		barraLateral.add(btCadastrar, "cell 0 9,alignx center,aligny center");
		
		JLabel lblNewLabel_6 = new JLabel("PRODUTOS EM PROMOÇÃO");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_6, "cell 1 0 21 1");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 1 22 6,grow");
		
		table = new JTable();
		table.setBackground(new Color(230, 230, 230));
		scrollPane.setViewportView(table);
	}

}
