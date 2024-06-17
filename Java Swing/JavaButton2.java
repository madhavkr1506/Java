// displaying image on the button : 

import javax.swing.*;
public class JavaButton2 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Button Example");
        JButton b = new JButton(new ImageIcon("C:\\Users\\madha\\Downloads\\register.png"));
        b.setBounds(100,100,100,40);
        f.add(b);
        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
