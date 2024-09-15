package teste;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicaoLabel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dynamic Labels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel(new MigLayout());
        
        JTextField textField = new JTextField(10);
        JButton button = new JButton("Add Labels");
        
        panel.add(new JLabel("Enter number of labels:"), "wrap");
        panel.add(textField, "wrap");
        panel.add(button, "wrap");
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(new JLabel("Enter number of labels:"), "wrap");
                panel.add(textField, "wrap");
                panel.add(button, "wrap");
                
                try {
                    int numLabels = Integer.parseInt(textField.getText());
                    for (int i = 1; i <= numLabels; i++) {
                        panel.add(new JLabel("Label " + i), "wrap");
                    }
                } catch (NumberFormatException ex) {
                    panel.add(new JLabel("Please enter a valid number"), "wrap");
                }
                
                panel.revalidate();
                panel.repaint();
            }
        });
        
        frame.add(panel);
        frame.setVisible(true);
    }
}