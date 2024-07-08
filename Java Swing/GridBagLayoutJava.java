import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;


public class GridBagLayoutJava {

    JFrame frame = new JFrame("GridBagLayout");
    GridBagLayout bagLayout = new GridBagLayout();
    GridBagConstraints gc = new GridBagConstraints();
    JPanel panel = new JPanel();

    JButton btn1 = new JButton("btn1");
    JButton btn2 = new JButton("btn2");
    JButton btn3 = new JButton("btn3");
    JButton btn4 = new JButton("btn4");
    JButton btn5 = new JButton("btn5");

    GridBagLayoutJava(){
        prepareGui();
    }

    public void prepareGui(){
        frame.setSize(310,510);
        frame.setLayout(new BorderLayout());

        panel.setLayout(bagLayout);

        gc.gridx = 0;gc.gridy = 0;
        panel.add(btn1,gc);
        gc.gridx = 1;gc.gridy = 0;
        panel.add(btn2,gc);
        gc.gridx = 0;gc.gridy = 1;
        panel.add(btn3,gc);
        gc.gridx = 1;gc.gridy = 1;
        panel.add(btn4,gc);
        gc.gridx = 0;gc.gridy = 2;
        panel.add(btn5,gc);

        frame.add(panel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String[] args) {
        new GridBagLayoutJava();
    }
}
