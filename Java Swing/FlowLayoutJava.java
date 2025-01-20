package Layout;
import java.awt.*;
import javax.swing.*;

public class FlowLayoutJava {
    FlowLayoutJava(){
        JFrame frame = new JFrame("Java FlowLayout");

        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("7"));
        frame.add(new JButton("8"));
        frame.add(new JButton("9"));

        frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,25));

        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new FlowLayoutJava();
    }
}
