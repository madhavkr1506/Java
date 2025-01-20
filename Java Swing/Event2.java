import javax.swing.*;
import java.awt.*;

public class Event2{
    JFrame frame;
    Container c;
    Event2(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setLocation(100,200);

        JButton button1 = new JButton("Button1");
        JButton button2 = new JButton("Button2");
        JButton button3 = new JButton("Button3");
        JButton button4 = new JButton("Button4");
        JButton button5 = new JButton("Button5");
        JButton button6 = new JButton("Button6");

        c = frame.getContentPane();
        c.setLayout(new FlowLayout());

        c.add(button1);
        c.add(button2);
        c.add(button3);
        c.add(button4);
        c.add(button5);
        c.add(button6);

        button1.addActionListener(e -> c.setBackground(Color.RED));
        button2.addActionListener(e -> c.setBackground(Color.BLACK));
        button3.addActionListener(e -> c.setBackground(Color.BLUE));
        button4.addActionListener(e -> c.setBackground(Color.GRAY));
        button5.addActionListener(e -> c.setBackground(Color.GREEN));
        button6.addActionListener(e -> c.setBackground(Color.YELLOW));

    }

    

    public static void main(String[] args) {
        new Event2();
    }
}
