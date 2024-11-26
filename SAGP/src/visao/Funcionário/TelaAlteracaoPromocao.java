package visao.Funcionário;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.funcionario.ProdutoControle;
import controle.funcionario.PromocaoControle;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.classes.ProdutosPromocao;
import modelo.enumerador.Categoria;

import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;


public class TelaAlteracaoPromocao extends JFrame {


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtDesconto;
    private JTextField txtDataI;
    private JTextField txtDataT;
    

    
    public TelaAlteracaoPromocao(JFrame telaA, Funcionario f, ProdutosPromocao promo) {
    	
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
    	
    	TelaAlteracaoPromocao tela = this; 
        setBackground(new Color(230, 230, 230));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setBounds(100, 100, 681, 520);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[][][][][grow][]", "[][][][][][][][][][][][][][]"));
       
        JLabel lblNewLabel_3 = new JLabel("ALTERAÇÃO DA PROMOÇÃO:");
        lblNewLabel_3.setFont(font);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_3, "cell 4 4,alignx center");
       
        JLabel lblNewLabel = new JLabel("Desconto:");
        lblNewLabel.setFont(font);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel, "cell 4 6");
       
        txtDesconto = new JTextField();
        contentPane.add(txtDesconto, "cell 4 7,growx");
        txtDesconto.setColumns(10);
       
        JLabel lblNewLabel_1 = new JLabel("Data de Início:");
        lblNewLabel_1.setFont(font);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_1, "cell 4 8");
       
        txtDataI = new JTextField();
        contentPane.add(txtDataI, "cell 4 9,growx");
        txtDataI.setColumns(10);
       
        JLabel lblNewLabel_2 = new JLabel("Data de término:");
        lblNewLabel_2.setFont(font);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_2, "cell 4 10");
       
        txtDataT = new JTextField();
        contentPane.add(txtDataT, "cell 4 11,growx");
        txtDataT.setColumns(10);
       
        RoundButton btnNewButton = new RoundButton("Salvar");
        btnNewButton.setFont(font);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				float desconto = 0;
				 LocalDate dataI = null;
	             LocalDate dataT = null;
	            
	            LocalDate dataInicio =  dataI.plusDays(1);
				LocalDate dataTermino = dataT.plusDays(2);
				try {
					desconto = Float.parseFloat(txtDesconto.getText());
					//dataI
					//dataT
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (txtDesconto.getText().isEmpty()) { //LocalDate
					JOptionPane.showMessageDialog(null, "Todos os campos precisam ser preenchidos");
				} else {
					try {
						alterarPromocao(promo, (int) desconto); //LocalDate
						TelaGerenciamentoP telaGerenciamentoP = new TelaGerenciamentoP(f);
						dispose();
						telaGerenciamentoP.setVisible(true);
						JOptionPane.showMessageDialog(null, "Alteração feita com sucesso");
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Não foi possivel alterar esse produto");
					}
				}
			}
        });
        btnSalvarA.setBackground(new Color(224, 83, 76));
        btnSalvarA.setForeground(new Color(230, 230, 230));
        btnSalvarA.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(btnSalvarA, "cell 4 13,alignx center");
       
        RoundButton btnNewButton_1 = new RoundButton("Cancelar");
        btnNewButton_1.setFont(font);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TelaGerenciamentoP telaE = new TelaGerenciamentoP(f);
				dispose();
				telaE.setVisible(true);
            }
        });
        btnCancelarA.setBackground(new Color(0, 0, 0));
        btnCancelarA.setForeground(new Color(230, 230, 230));
        btnCancelarA.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(btnCancelarA, "cell 5 13");
    }
    public void setText(ProdutosPromocao promo) {

    	txtDesconto.setText(String.valueOf(promo.getDesconto()));
    	txtDataI.setText(String.valueOf(promo.getDataI()));
    	txtDataT.setText(String.valueOf(promo.getDataT()));
	}

	private void alterarPromocao(ProdutosPromocao promo, int desconto) //LocalDate
			throws SQLException {
;
		promo.setDesconto(desconto);
		PromocaoControle promoc = new PromocaoControle();
		promoc.alterarPromocao(promo);

	}

}
