import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RegistrationForm {

    JFrame frame = new JFrame("RegistrationForm");
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2;
    JTextArea a1,a2;
    JRadioButton rb1,rb2;
    JButton btn1;

    RegistrationForm(){
        prepareGui();
        addComponent();
    }

    public void prepareGui(){
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addComponent(){
        l1 = new JLabel("Registration Form");
        l1.setBounds(275, 10, 200, 30);
        l1.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(l1);

        l2 = new JLabel("Name");
        l2.setBounds(10, 60, 150, 30);
        l2.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(l2);

        t1 = new JTextField();
        t1.setBounds(160,60,120,30);
        t1.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(t1);

        l3 = new JLabel("Mobile");
        l3.setBounds(10, 110, 150, 30);
        l3.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(l3);

        t2 = new JTextField();
        t2.setBounds(160,110,120,30);
        t2.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(t2);

        l4 = new JLabel("Gender");
        l4.setBounds(10, 160, 150, 30);
        l4.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(l4);

        rb1 = new JRadioButton("Male");
        rb1.setBounds(160, 160, 70, 30);
        
        rb2 = new JRadioButton("Female");
        rb2.setBounds(240, 160, 70, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);bg.add(rb2);
        frame.add(rb1);
        frame.add(rb2);

        l5 = new JLabel("Address");
        l5.setBounds(10, 210, 150, 30);
        l5.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(l5);

        

        frame.revalidate();
        frame.repaint();


    }
    public static void main(String[] args) {
        new RegistrationForm();
    }
}
