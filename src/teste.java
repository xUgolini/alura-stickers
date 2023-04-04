import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class teste extends JPanel {
    
    public teste() {
        JLabel label = new JLabel("Hello, World!");
        label.setFont(new Font("Arial", Font.PLAIN, 36));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(label);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Margin Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        teste panel = new teste();
        panel.setBackground(Color.GRAY);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}

