import java.awt.event.*;

import javax.swing.*;

public class JavaJOptionPane extends WindowAdapter{
    
    JFrame frame = new JFrame("JOptionPane");

    JavaJOptionPane(){
        // JOptionPane.showMessageDialog(frame,"Hello Madhav Kumar");

        // JOptionPane.showMessageDialog(frame, "Hello Madhav Kumar You Are A Good Boy", "Hello", JOptionPane.PLAIN_MESSAGE);

        // JOptionPane.showInputDialog("Madhav");


        // JOptionPane.showInputDialog(frame, "Enter Name : ");

        frame.addWindowListener(this);
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
    }

    public void windowClosing(WindowEvent e){
        int a = JOptionPane.showConfirmDialog(frame, "Are you sure?");
        if(a == JOptionPane.YES_OPTION){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }
    public static void main(String[] args) {
        new JavaJOptionPane();
    }
}
