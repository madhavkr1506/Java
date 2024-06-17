// swing by Association inside constructor

import javax.swing.JButton;
import javax.swing.JFrame;

public class JavaSwing2 {
    JFrame f;
    JavaSwing2(){
        f = new JFrame();
        JButton b = new JButton("Click me!");
        b.setBounds(130,100,100,40);  //--> sets the position of the button
        f.add(b);
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new JavaSwing2();
    }
}
