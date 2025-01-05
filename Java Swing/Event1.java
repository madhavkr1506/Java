import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Event1 extends JFrame implements ActionListener{
    JFrame frame;
    Container c;
    Event1(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,500,300);
        frame.setLayout(new FlowLayout());

        JButton button1 = new JButton("Button1");
        
        c = frame.getContentPane();

        c.add(button1);
        button1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        c = frame.getContentPane();
        c.setBackground(Color.RED);
    }
    public static void main(String[] args) {
        new Event1();
    }
}
