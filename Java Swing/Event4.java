import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Event implements ActionListener{
    private Container c;
    public Event(Container c){
        this.c = c;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Red")){
            c.setBackground(Color.RED);
        }
        if(e.getActionCommand().equals("Green")){
            
            c.setBackground(Color.GREEN);
        }
        if(e.getActionCommand().equals("Black")){
            
            c.setBackground(Color.BLACK);
        }
    }
}
public class Event4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JButton red = new JButton("Red");
        JButton green = new JButton("Green");
        JButton black = new JButton("Black");

        Container c = frame.getContentPane();
        frame.add(red);
        frame.add(green);
        frame.add(black);

        red.addActionListener(new Event(c));
        green.addActionListener(new Event(c));
        black.addActionListener(new Event(c));

    }
}
