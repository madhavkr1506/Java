import javax.swing.*;
import java.awt.*;
public class JavaLabel2 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100,100,500,500);

        Container c = f.getContentPane();
        c.setLayout(null);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(100,50,200,30);
        l1.setText("Password");

        Font font = new Font("Arial",Font.ITALIC,30);
        l1.setFont(font);
        c.add(l1);


    }
}
