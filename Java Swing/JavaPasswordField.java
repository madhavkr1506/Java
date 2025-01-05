import javax.swing.*;
import java.awt.*;
public class JavaPasswordField {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBounds(100,100,1000,500);

        Container c = frame.getContentPane();
        c.setLayout(null);

        JPasswordField password = new JPasswordField();
        password.setBounds(100,50,120,30);

        // password.setText("1234567890");
        password.setFont(new Font("Arial",Font.PLAIN,10));

        password.setEchoChar('*');

        password.setEchoChar((char)0);

        c.add(password);





    }
}
