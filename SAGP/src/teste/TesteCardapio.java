package teste;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import visao.TelaInicial;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class TesteCardapio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel paneCardapio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteCardapio frame = new TesteCardapio();
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
	public TesteCardapio() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagem/Logo.png")));
		panel.add(lblNewLabel);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        BufferedImage image = ImageIO.read(selectedFile);
                		for(int c=0;c<=2;c++)
                		{
                			for(int l=0;l<=2;l++)
                			{
                				paneCardapio.add(new JLabel("Label "+c), "cell "+c+" "+l);
                				
                			}
                		}
                        
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
			}
		});
		panel.add(btOk);
		
		JPanel panePrincipal = new JPanel();
		contentPane.add(panePrincipal, BorderLayout.CENTER);
		panePrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panePesquisa = new JPanel();
		panePrincipal.add(panePesquisa, BorderLayout.NORTH);
		FlowLayout fl_panePesquisa = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panePesquisa.setLayout(fl_panePesquisa);
		
		JLabel lblNewLabel_1 = new JLabel("Pesquisa");
		panePesquisa.add(lblNewLabel_1);
		
		paneCardapio = new JPanel();
		panePrincipal.add(paneCardapio, BorderLayout.CENTER);
		paneCardapio.setLayout(new MigLayout("", "[][][]", "[][][]"));
		
		
		for(int c=0;c<=2;c++)
		{
			for(int l=0;l<=2;l++)
			{
				paneCardapio.add(new JLabel("Label "+c), "cell "+c+" "+l);
			}
		}
	}

}
