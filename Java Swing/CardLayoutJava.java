import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CardLayoutJava implements ActionListener{
    JFrame frame = new JFrame("JavaCardLayout");

    CardLayout crd;

    JButton btn1,btn2,btn3;

    Container c;

    CardLayoutJava(){
        c = frame.getContentPane();

        crd = new CardLayout(); // --> default constructor is used. therefore, components will cover the whole area.

        c.setLayout(crd);

        btn1 = new JButton("Apple");
        btn2 = new JButton("Boy");
        btn3 = new JButton("Cat");

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        c.add("a", btn1);
        c.add("b",btn2);
        c.add("c", btn3);

        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        crd.next(c);
    }
    public static void main(String[] args) {
        new CardLayoutJava();
    }
}