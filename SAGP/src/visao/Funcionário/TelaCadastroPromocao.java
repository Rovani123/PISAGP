package visao.Funcionário;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.classes.Funcionario;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class TelaCadastroPromocao extends JFrame {


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

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
       
        textField = new JTextField();
        contentPane.add(textField, "cell 4 6 3 1,growx");
        textField.setColumns(10);
       
        JLabel lblNewLabel_3 = new JLabel("Desconto:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_3, "cell 4 7");
       
        textField_1 = new JTextField();
        contentPane.add(textField_1, "cell 4 8 3 1,growx");
        textField_1.setColumns(10);
       
        JLabel lblNewLabel_4 = new JLabel("Data de Início:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_4, "cell 4 9");
       
        textField_2 = new JTextField();
        contentPane.add(textField_2, "cell 4 10 3 1,growx");
        textField_2.setColumns(10);
       
        JLabel lblNewLabel_5 = new JLabel("Data de término:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_5, "cell 4 11");
       
        textField_3 = new JTextField();
        contentPane.add(textField_3, "cell 4 12 3 1,growx");
        textField_3.setColumns(10);
       
        RoundButton btnNewButton_2 = new RoundButton("Salvar");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.setForeground(new Color(245, 245, 245));
        btnNewButton_2.setBackground(new Color(224, 83, 76));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        contentPane.add(btnNewButton_2, "cell 4 14,alignx right");
       
        RoundButton btnNewButton = new RoundButton("Limpar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setForeground(new Color(245, 245, 245));
        btnNewButton.setBackground(new Color(224, 83, 76));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        contentPane.add(btnNewButton, "cell 6 14");
       
        RoundButton btnNewButton_1 = new RoundButton("Cancelar");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.setForeground(new Color(245, 245, 245));
        btnNewButton_1.setBackground(new Color(0, 0, 0));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        contentPane.add(btnNewButton_1, "cell 7 14");
    }


}
