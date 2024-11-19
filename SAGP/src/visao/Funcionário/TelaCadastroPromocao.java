package visao.Funcionário;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ProdutoControle;
import controle.PromocaoControle;
import modelo.classes.Funcionario;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class TelaCadastroPromocao extends JFrame {


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtDesconto;
    private JTextField txtDataInicio;
    private JTextField txtDataTermino;

    public TelaCadastroPromocao(JFrame telaC, Funcionario f) {
    	TelaCadastroPromocao tela= this;
        setBackground(new Color(230, 230, 230));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setBounds(100, 100, 670, 482);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[][][][][grow][grow][][]", "[][][][][][][][][][][][][][][]"));
       
        JLabel lblNewLabel_1 = new JLabel("CADASTRO DE PROMOÇÃO:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_1, "cell 4 2,alignx right");
       
        JLabel lblNewLabel = new JLabel("Produto em promoção:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel, "cell 4 5");
        
        JComboBox comboBoxProduto = new JComboBox();
        contentPane.add(comboBoxProduto, "cell 4 6 3 1,growx");
       
        JLabel lblNewLabel_3 = new JLabel("Desconto:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_3, "cell 4 7");
       
        txtDesconto = new JTextField();
        contentPane.add(txtDesconto, "cell 4 8 3 1,growx");
        txtDesconto.setColumns(10);
       
        JLabel lblNewLabel_4 = new JLabel("Data de Início:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_4, "cell 4 9");
       
        txtDataInicio = new JTextField();
        contentPane.add(txtDataInicio, "cell 4 10 3 1,growx");
        txtDataInicio.setColumns(10);
       
        JLabel lblNewLabel_5 = new JLabel("Data de término:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_5, "cell 4 11");
       
        txtDataTermino = new JTextField();
        contentPane.add(txtDataTermino, "cell 4 12 3 1,growx");
        txtDataTermino.setColumns(10);
       
        RoundButton btnSalvarC = new RoundButton("Salvar");
        btnSalvarC.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSalvarC.setForeground(new Color(245, 245, 245));
        btnSalvarC.setBackground(new Color(224, 83, 76));
        btnSalvarC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String produtoPromocao = null;
               float desconto= 0;
               LocalDate dataI = null;
               LocalDate dataT = null;
            
               
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
               
               
               try {
            	   produtoPromocao = (txtProdutoP.getText());
            	   desconto = (Float.parseFloat(txtDesconto.getText()));
            	  

                   if (txtProdutoP.getText().isEmpty() || txtDesconto.getText().isEmpty() || txtDataInicio.getText().isEmpty() || txtDataTermino.getText().isEmpty()){
    				   JOptionPane.showMessageDialog(null, "Todos os campos precisam ser preenchidos");
                       dataI = LocalDate.parse(txtDataInicio.getText(), formatter);
                       dataT = LocalDate.parse(txtDataTermino.getText(), formatter);
                   }
               
            	   LocalDate dataInicio =  dataI.plusDays(1);
                   LocalDate dataTermino = dataT.plusDays(2);
                  

               
                   if (produtoPromocao.isEmpty() || txtDesconto.getText().isEmpty() || txtDataInicio.getText().isEmpty() || txtDataTermino.getText().isEmpty()) {
                       JOptionPane.showMessageDialog(null, "Todos os campos precisam ser preenchidos");
                   } else {
                      
                       cadastrarPromocao(produtoPromocao, desconto, dataInicio, dataTermino);
                       TelaPromocoes telaPromocoes = new TelaPromocoes(telaC, telaC, f);
                       dispose();
                       telaPromocoes.setVisible(true);
                       JOptionPane.showMessageDialog(null, "Promoção cadastrada com sucesso");
                   }
                       
               }catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
        contentPane.add(btnSalvarC, "cell 4 14,alignx right");
       
        RoundButton btnNewButton = new RoundButton("Limpar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setForeground(new Color(245, 245, 245));
        btnNewButton.setBackground(new Color(224, 83, 76));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	txtProdutoP.setText("");
            	txtDesconto.setText("");
            	txtDataInicio.setText("");
            	txtDataTermino.setText("");
            }
        });
        contentPane.add(btnNewButton, "cell 6 14");
       
        RoundButton btnCancelarC = new RoundButton("Cancelar");
        btnCancelarC.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCancelarC.setForeground(new Color(245, 245, 245));
        btnCancelarC.setBackground(new Color(0, 0, 0));
        btnCancelarC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TelaPromocoes telaE = new TelaPromocoes(telaC, telaC, f);
				dispose();
				telaE.setVisible(true);
            }
        });
        contentPane.add(btnCancelarC, "cell 7 14");
    }

    protected void cadastrarPromocao(String produtoPromocao, float desconto,LocalDate dataInicio,LocalDate dataTermino) throws SQLException {//LocalDate
		PromocaoControle promo = new PromocaoControle();
		promo.cadastrarPromocao(produtoPromocao, desconto, dataInicio , dataTermino); //LocalDate

	}
}
