package visao.Funcionário;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.funcionario.ProdutoControle;

import javax.imageio.ImageIO;

import modelo.classes.Funcionario;
import modelo.enumerador.Categoria;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import javax.swing.JButton;

public class TelaCadastroP extends JFrame {

	private JPanel painel;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	private JLabel lblFoto;
    private Image imagemProduto;
    FileInputStream fin;

	public TelaCadastroP(JFrame telaA, Funcionario f) {
		
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

		setBackground(new Color(230, 230, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 434);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(new MigLayout("", "[][][][grow][][][][]", "[][][][][][][][][][][][][][][]"));

		JLabel lblCadastroProduto = new JLabel("CADASTRO DE PRODUTO:");
		lblCadastroProduto.setFont(font);
		painel.add(lblCadastroProduto, "cell 3 2,alignx center");

		JLabel lblNome = new JLabel("Nome do Produto:");
		lblNome.setFont(font);
		painel.add(lblNome, "cell 3 4");

		txtNome = new JTextField();
		painel.add(txtNome, "cell 3 5 2 1,growx");
		txtNome.setColumns(10);

		RoundButton btLimpa1 = new RoundButton("Limpar");
		btLimpa1.setFont(font);
		btLimpa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
			}
		});
		btLimpa1.setForeground(new Color(245, 245, 245));
		btLimpa1.setBackground(new Color(224, 83, 76));
		painel.add(btLimpa1, "cell 5 5");

		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(font);
		painel.add(lblPreco, "cell 3 6");

		txtPreco = new JTextField();
		painel.add(txtPreco, "cell 3 7 2 1,growx");
		txtPreco.setColumns(10);

		RoundButton btLimpa2 = new RoundButton("Limpar");
		btLimpa2.setFont(font);
		btLimpa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btLimpa2.setForeground(new Color(245, 245, 245));
		btLimpa2.setBackground(new Color(224, 83, 76));
		painel.add(btLimpa2, "cell 5 7");

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(font);
		painel.add(lblQuantidade, "cell 3 8");

		txtQuantidade = new JTextField();
		painel.add(txtQuantidade, "cell 3 9 2 1,growx");
		txtQuantidade.setColumns(10);

		RoundButton btLimpa3 = new RoundButton("Limpar");
		btLimpa3.setFont(font);
		btLimpa3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btLimpa3.setForeground(new Color(245, 245, 245));
		btLimpa3.setBackground(new Color(224, 83, 76));
		painel.add(btLimpa3, "cell 5 9");

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(font);
		painel.add(lblCategoria, "cell 3 10");

		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setModel(new DefaultComboBoxModel(Categoria.values()));
		painel.add(cbCategoria, "cell 3 11,growx");

		RoundButton btLimpa4 = new RoundButton("Limpar");
		btLimpa4.setFont(font);
		btLimpa4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btLimpa4.setForeground(new Color(245, 245, 245));
		btLimpa4.setBackground(new Color(224, 83, 76));
		painel.add(btLimpa4, "cell 5 11");
		
				RoundButton btSalvar = new RoundButton("Salvar");
				btSalvar.setFont(font);
				btSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nome = null;
						float preco = 0;
						int quantidade = 0;
						Categoria categoria = null;
						try {
						nome = (txtNome.getText());
						preco = (Float.parseFloat(txtPreco.getText()));
						quantidade = (Integer.parseInt(txtQuantidade.getText()));
						categoria = (Categoria) cbCategoria.getSelectedItem();
						}catch (Exception e1) {
							e1.printStackTrace();
						}
						if (txtNome.getText().isEmpty() || txtPreco.getText().isEmpty() || txtQuantidade.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Todos os campos precisam ser preenchidos");
						} else {
							try {
								cadastrarProduto(nome, preco, quantidade, categoria.toString(),fin);
								TelaGerenciamentoP telaGerenciamentoP = new TelaGerenciamentoP(telaA, f);
								dispose();
								telaGerenciamentoP.setVisible(true);
								JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
							} catch (SQLException e1) {
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "Não foi possivel adicionar esse produto");

							}
						}
					}
				});
				
				JButton btFile = new JButton("Selecionar Imagem");
				btFile.setFont(font);
				btFile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fileChooser = new JFileChooser();
		                int result = fileChooser.showOpenDialog(null);
		                if (result == JFileChooser.APPROVE_OPTION) {
		                    File selectedFile = fileChooser.getSelectedFile();
		                    try {
		                        imagemProduto = ImageIO.read(selectedFile);
		                        fin = new FileInputStream(selectedFile);
		                        if(fin ==null) {
		                        	JOptionPane.showInternalMessageDialog(null,"ta nulo");
		                        }
		                    } catch (IOException ex) {
		                        ex.printStackTrace();
		                    }
		                }
					}
				});
				painel.add(btFile, "cell 3 12,alignx center,aligny center");
				btSalvar.setForeground(new Color(245, 245, 245));
				btSalvar.setBackground(new Color(224, 83, 76));
				painel.add(btSalvar, "cell 3 14,alignx center");
				
						RoundButton btCancelar = new RoundButton("Cancelar");
						btCancelar.setFont(font);
						btCancelar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								TelaGerenciamentoP telaE = new TelaGerenciamentoP(telaA, f);
								dispose();
								telaE.setVisible(true);
							}
						});
						btCancelar.setForeground(new Color(245, 245, 245));
						btCancelar.setBackground(new Color(0, 0, 0));
						painel.add(btCancelar, "cell 5 14");
	}

	private void cadastrarProduto(String nome, float preco, int quantidade, String categoria,FileInputStream foto) throws SQLException {
		ProdutoControle pc = new ProdutoControle();
		pc.cadastrarProduto(nome, preco, quantidade, categoria,foto);

	}

}
