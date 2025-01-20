import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login{
    public static JFrame frame;
    public static JButton b;
    public static JTextField tf;
    public static JLabel l1,l2,l3;

    public static void main(String[] args) {
        frame = new JFrame("Login Details : ");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);


        l1 = new JLabel("UserName : ");
        l1.setFont(new Font("Arial",Font.PLAIN,24));
        l1.setBounds(500,50,190,30);
    
        tf = new JTextField();
        tf.setBounds(750,50,190,30);


        l2 = new JLabel("Password : ");
        l2.setFont(new Font("Arial",Font.PLAIN,24));
        l2.setBounds(500,100,190,30);


        JPasswordField pVField = new JPasswordField();
        pVField.setBounds(750,100,190,30);

        b = new JButton("Click Submit");
        b.setBounds(650,200,120,50);

        l3 = new JLabel();
        l3.setFont(new Font("Arial", Font.PLAIN, 24));
        l3.setBounds(500, 300, 500, 30);
        
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                l3.setText("Details :\n Username : " + tf.getText() + " Password : " + new String(pVField.getPassword()));
            }
        });


        frame.add(l1);frame.add(tf);frame.add(l2);frame.add(pVField);frame.add(b);frame.add(l3);

        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}