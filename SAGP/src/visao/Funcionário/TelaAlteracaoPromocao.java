package visao.Funcionário;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaAlteracaoPromocao extends JFrame {


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaAlteracaoPromocao frame = new TelaAlteracaoPromocao();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the frame.
     */
    public TelaAlteracaoPromocao() {
        setBackground(new Color(230, 230, 230));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setBounds(100, 100, 681, 520);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[][][][][grow][]", "[][][][][][][][][][][][][][]"));
       
        JLabel lblNewLabel_3 = new JLabel("ALTERAÇÃO DA PROMOÇÃO:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_3, "cell 4 4,alignx center");
       
        JLabel lblNewLabel = new JLabel("Desconto:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel, "cell 4 6");
       
        textField = new JTextField();
        contentPane.add(textField, "cell 4 7,growx");
        textField.setColumns(10);
       
        JLabel lblNewLabel_1 = new JLabel("Data de Início:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_1, "cell 4 8");
       
        textField_1 = new JTextField();
        contentPane.add(textField_1, "cell 4 9,growx");
        textField_1.setColumns(10);
       
        JLabel lblNewLabel_2 = new JLabel("Data de término:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_2, "cell 4 10");
       
        textField_2 = new JTextField();
        contentPane.add(textField_2, "cell 4 11,growx");
        textField_2.setColumns(10);
       
        RoundButton btnNewButton = new RoundButton("Salvar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        btnNewButton.setBackground(new Color(224, 83, 76));
        btnNewButton.setForeground(new Color(230, 230, 230));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(btnNewButton, "cell 4 13,alignx center");
       
        RoundButton btnNewButton_1 = new RoundButton("Cancelar");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        btnNewButton_1.setBackground(new Color(0, 0, 0));
        btnNewButton_1.setForeground(new Color(230, 230, 230));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(btnNewButton_1, "cell 5 13");
    }


}
