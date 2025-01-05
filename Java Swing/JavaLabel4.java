import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaLabel4 implements ActionListener{
    public static JFrame frame; public static JTextField tf; public static JLabel l1;
    public static void main(String[] args) {
        frame = new JFrame("IP finder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLocation(100,200);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        
        tf = new JTextField();
        tf.setPreferredSize(new Dimension(190,30));
        frame.add(tf);

        l1 = new JLabel();
        frame.add(l1);

        JButton b = new JButton("Find ip");
        b.setSize(20,20);
        b.addActionListener(new JavaLabel4());
        frame.add(b);


        frame.setVisible(true);


        


    }
    public void actionPerformed(ActionEvent e){
        try{
            String host = tf.getText();
            String ip = java.net.InetAddress.getByName(host).getHostAddress();
            l1.setText("Ip of " + host + " is : " + ip);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
