package Layout;
import javax.swing.*;
import java.awt.*;

class GridLayoutJava {

    GridLayoutJava(){
        JFrame frame = new JFrame("GridLayout");

        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("7"));
        frame.add(new JButton("8"));
        frame.add(new JButton("9"));

        frame.setLayout(new GridLayout(3,3,20,25));
        frame.setSize(300,300);
        frame.setVisible(true);


    }
    public static void main(String[] args) {
        new GridLayoutJava();
    }
}