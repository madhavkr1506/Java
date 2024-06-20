import javax.swing.*;
import java.awt.*;
public class JavaButton3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(100,200,500,300);
        
        Container c = frame.getContentPane();
        c.setLayout(new FlowLayout());

        JButton button1 = new JButton();
        button1.setText("Click Me");
        JButton button2 = new JButton();
        button2.setText("Click Me");
        JButton button3 = new JButton();
        button3.setText("Click Me");
        JButton button4 = new JButton();
        button4.setText("Click Me");

        button1.setFont(new Font("Times",Font.BOLD,20));
        button2.setFont(new Font("Times",Font.BOLD,20));
        button3.setFont(new Font("Times",Font.BOLD,20));
        button4.setFont(new Font("Times",Font.BOLD,20));


        button1.setForeground(Color.RED);
        button2.setForeground(Color.RED);
        button3.setForeground(Color.RED);
        button4.setForeground(Color.RED);

        button1.setBackground(Color.BLACK);
        button2.setBackground(Color.BLACK);
        button3.setBackground(Color.BLACK);
        button4.setBackground(Color.BLACK);

        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button2.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        button3.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        button4.setCursor(new Cursor(Cursor.MOVE_CURSOR));

        // button1.setEnabled(false);

        // button1.setVisible(false);

        // ImageIcon icon = new ImageIcon("C:\\Users\\madha\\Downloads\\java.png");

        // JButton button5 = new JButton(icon);
        // button5.setSize(icon.getIconWidth(),icon.getIconHeight());

        
        










        c.add(button1);
        c.add(button2);
        c.add(button3);
        c.add(button4);
        // c.add(button5);







        
    }
}
