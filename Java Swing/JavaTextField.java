import javax.swing.*;
import java.awt.*;
public class JavaTextField {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200,100,500,500);
        frame.setTitle("JavaTextField");

        ImageIcon icon = new ImageIcon("C:\\Users\\madha\\Downloads\\java.png");
        frame.setIconImage(icon.getImage());

        Container c = frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        label.setText("Hello Alpha");
        label.setForeground(Color.BLUE);
        label.setSize(200,100);
        label.setBounds(100,0,label.getWidth(),label.getHeight());
        c.add(label);

        Font font = new Font("Times",Font.PLAIN,20);
        label.setFont(font);

        TextField tf = new TextField();
        tf.setBounds(100,100,200,100);
        tf.setBackground(Color.GRAY);
        c.add(tf);


        

    }
}
