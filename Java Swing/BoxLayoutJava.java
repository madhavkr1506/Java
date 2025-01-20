package Layout;
// import java.awt.*;
import javax.swing.*;

public class BoxLayoutJava {

    BoxLayoutJava(){
        JFrame frame = new JFrame("BoxLayout");

        frame.add(new JButton("btn1"));
        frame.add(new JButton("btn2"));
        frame.add(new JButton("btn3"));
        frame.add(new JButton("btn4"));
        frame.add(new JButton("btn5"));


        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

        frame.setSize(400,400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new BoxLayoutJava();
    }
}