import javax.swing.*;
import java.awt.*;

public class JavaLabel3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setVisible(true);
        frame.setBounds(100,100,500,500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Hello Java");
        ImageIcon icon = new ImageIcon("C:\\Users\\madha\\Downloads\\java.png");

        frame.setIconImage(icon.getImage());

        Container c = frame.getContentPane();
        c.setLayout(null);
        // c.setBackground(Color.RED);

        // JLabel l1 = new JLabel("Image Icon");
        // l1.setIcon(icon);
        // l1.setBounds(100,100,icon.getIconWidth(),icon.getIconHeight());

        JLabel l1 = new JLabel("Image icon",icon,JLabel.LEFT);
        l1.setBounds(100,100,700,700);

        c.add(l1);
    }
}
