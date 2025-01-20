import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event3 {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        final Container c = frame.getContentPane();
        c.setLayout(new FlowLayout());

        JButton b1 = new JButton("Green");
        
        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                c.setBackground(Color.GREEN);
                c.repaint();
            }
        });

        frame.add(b1);

    }
}