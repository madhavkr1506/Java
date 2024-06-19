import javax.swing.*;
import java.awt.*;

public class FirstFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // f.setSize(300,300);
        // f.setLocation(100,100);

        f.setBounds(300,300,1000,500);

        f.setTitle("My Frame");
        
        ImageIcon icon = new ImageIcon("C:\\Users\\madha\\Downloads\\java.png");

        f.setIconImage(icon.getImage());

        Container c = f.getContentPane();
        c.setBackground(Color.GREEN);

        f.setResizable(false);



    }
}
