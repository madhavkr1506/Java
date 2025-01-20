// Swing by inheritance

import javax.swing.JButton;
import javax.swing.JFrame;

public class JavaSwing3 extends JFrame {  //--> Inheriting JFrame
    JFrame f;
    JavaSwing3(){
        JButton b = new JButton("Madhav Click Me!");
        b.setBounds(130,100,100,40);
        add(b);
        setSize(400,500);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new JavaSwing3();
    }
}
