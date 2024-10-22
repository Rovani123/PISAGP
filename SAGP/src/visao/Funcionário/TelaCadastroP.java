package visao.Funcionário;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.ProdutoControle;
import modelo.enumerador.Categoria;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import javax.swing.JButton;

public class TelaCadastroP extends JFrame {
	
    private JLabel lblFoto;
    private Image imagemProduto;

	private JPanel painelPrincipal;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	JComboBox cbCategoria;
	FileInputStream fin;

	
	public TelaCadastroP(JFrame telaA) {
		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 434);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(new MigLayout("", "[][][][grow][][][][]", "[][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblCadastroProduto = new JLabel("CADASTRO DE PRODUTO:");
		painelPrincipal.add(lblCadastroProduto, "cell 3 2,alignx center");
		
		JLabel lblNome = new JLabel("Nome do Produto:");
		painelPrincipal.add(lblNome, "cell 3 3");
		
		txtNome = new JTextField();
		painelPrincipal.add(txtNome, "cell 3 4,growx");
		txtNome.setColumns(10);
		
		RoundButton btnNewButton = new RoundButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
			}
		});
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setBackground(new Color(224, 83, 76));
		painelPrincipal.add(btnNewButton, "cell 5 4");
		
		JLabel lblPreco = new JLabel("Preço:");
		painelPrincipal.add(lblPreco, "cell 3 5");
		
		txtPreco = new JTextField();
		painelPrincipal.add(txtPreco, "cell 3 6,growx");
		txtPreco.setColumns(10);
		
		RoundButton btnNewButton_1 = new RoundButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setForeground(new Color(245, 245, 245));
		btnNewButton_1.setBackground(new Color(224, 83, 76));
		painelPrincipal.add(btnNewButton_1, "cell 5 6");
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		painelPrincipal.add(lblQuantidade, "cell 3 7");
		
		txtQuantidade = new JTextField();
		painelPrincipal.add(txtQuantidade, "cell 3 8,growx");
		txtQuantidade.setColumns(10);
		
		RoundButton btnNewButton_2 = new RoundButton("Limpar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setForeground(new Color(245, 245, 245));
		btnNewButton_2.setBackground(new Color(224, 83, 76));
		painelPrincipal.add(btnNewButton_2, "cell 5 8");
		
		RoundButton btnNewButton_3 = new RoundButton("Limpar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel lblImagemProduto = new JLabel("Imagem Produto:");
		painelPrincipal.add(lblImagemProduto, "cell 3 10");
		
		JButton btnSeleionaImagem = new JButton("Selecione uma imagem");
		btnSeleionaImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        imagemProduto = ImageIO.read(selectedFile);
                        lblFoto.setIcon(new ImageIcon(imagemProduto.getScaledInstance(100, 100, 10)));
                        fin = new FileInputStream(selectedFile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
			}
		});
		painelPrincipal.add(btnSeleionaImagem, "cell 3 11");
		
		lblFoto = new JLabel("");
		painelPrincipal.add(lblFoto, "cell 4 11");
		btnNewButton_3.setForeground(new Color(245, 245, 245));
		btnNewButton_3.setBackground(new Color(224, 83, 76));
		painelPrincipal.add(btnNewButton_3, "cell 5 11");
		
		RoundButton btnNewButton_5 = new RoundButton("Cancelar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerenciamentoP telaE = new TelaGerenciamentoP();
				dispose();
				telaE.setVisible(true);
			}
		});
		
		RoundButton btnNewButton_4 = new RoundButton("Salvar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome =(txtNome.getText());
				float preco =(Float.parseFloat(txtPreco.getText()));
				int quantidade =(Integer.parseInt(txtQuantidade.getText()));
				Categoria categoriaC = (Categoria) cbCategoria.getSelectedItem();
				String categoria = String.valueOf(categoriaC);
				try {
					cadastrarProduto(nome, preco, quantidade, categoria,fin);
					TelaGerenciamentoP telaGerenciamentoP = new TelaGerenciamentoP();
					dispose();
					telaGerenciamentoP.setVisible(true);
					JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não foi possivel adicionar esse produto");

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblCategoria = new JLabel("Categoria:");
		painelPrincipal.add(lblCategoria, "cell 3 13");
		
		cbCategoria = new JComboBox();
		cbCategoria.setModel(new DefaultComboBoxModel(Categoria.values()));
		painelPrincipal.add(cbCategoria, "cell 3 14,growx");
		btnNewButton_4.setForeground(new Color(245, 245, 245));
		btnNewButton_4.setBackground(new Color(224, 83, 76));
		painelPrincipal.add(btnNewButton_4, "cell 3 16,alignx center");
		btnNewButton_5.setForeground(new Color(245, 245, 245));
		btnNewButton_5.setBackground(new Color(0, 0, 0));
		painelPrincipal.add(btnNewButton_5, "cell 5 16");
	}
	private void cadastrarProduto(String nome,float preco,int quantidade,String categoria, FileInputStream foto) throws SQLException, IOException {
		ProdutoControle pc = new ProdutoControle();
		pc.cadastrarProduto(nome, preco, quantidade, categoria, foto);

	}

}
