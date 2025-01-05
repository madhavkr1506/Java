package Layout;
import javax.swing.*;
import java.awt.*;

public class BorderLayoutJava {

    BorderLayoutJava(){
        JFrame frame = new JFrame("Border Layout");

        JButton b1,b2,b3,b4,b5;
        b1 = new JButton("North");
        b2 = new JButton("South");
        b3 = new JButton("East");
        b4 = new JButton("West");
        b5 = new JButton("Center");

        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2,BorderLayout.SOUTH);
        frame.add(b3,BorderLayout.EAST);
        frame.add(b4,BorderLayout.WEST);
        frame.add(b5,BorderLayout.CENTER);

        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new BorderLayoutJava();
    }
}


// Note : if we not specified the area than each button covers the whole area. however, latest button that is added to the frame will be shown.


