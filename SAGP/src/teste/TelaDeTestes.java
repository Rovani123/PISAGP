package teste;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import visao.RoundButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controle.FuncionarioDAO;
import modelo.classes.Produto;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaDeTestes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	TelaDeTestes frame = new TelaDeTestes();
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
    public TelaDeTestes() {
        FuncionarioDAO estoquedao = new FuncionarioDAO();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[grow][][][grow][][][][grow][]", "[grow][][grow][][][][][][][][][][][][][][][]"));

        // Barra de navegação lateral
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(167, 208, 214));
        contentPane.add(navPanel, "cell 0 0 2 18,grow");
        navPanel.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][][][][][][][][][]"));

        JLabel lblLogo = new JLabel("AGP");
        navPanel.add(lblLogo, "cell 0 0");

        JLabel lblCategorias = new JLabel("Categorias:");
        navPanel.add(lblCategorias, "cell 0 1");

        JLabel lblSalgado = new JLabel("Salgado");
        navPanel.add(lblSalgado, "cell 0 2");

        JLabel lblDoce = new JLabel("Doce");
        navPanel.add(lblDoce, "cell 0 3");

        JLabel lblBebidas = new JLabel("Bebidas");
        navPanel.add(lblBebidas, "cell 0 4");

        // Área principal
        JPanel mainPanel = new JPanel();
        contentPane.add(mainPanel, "cell 2 0 8 18,grow");
        mainPanel.setLayout(new MigLayout("", "[grow]", "[][grow]"));

        JLabel lblTitle = new JLabel("Pastéis");
        mainPanel.add(lblTitle, "cell 0 0");

        JScrollPane scrollPane = new JScrollPane();
        mainPanel.add(scrollPane, "cell 0 1,grow");

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"Pastel de Carne", "R$ 5,00"},
                {"Pastel de Frango", "R$ 5,00"},
                {"Pastel de Calabresa", "R$ 5,00"},
                {"Pastel de Pizza", "R$ 5,00"},
            },
            new String[] {
                "Item", "Preço"
            }
        ));
        scrollPane.setViewportView(table);

        RoundButton btnNewButton = new RoundButton("Sair");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        contentPane.add(btnNewButton, "cell 9 17");
    }
}
