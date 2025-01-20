import javax.swing.*;
// import java.awt.*;
import java.awt.event.*;

public class RadioButtoon implements ActionListener{
    public static JFrame frame;
    public static JRadioButton b1,b2;
    public static ButtonGroup bg;
    public static JButton button;
    public static void main(String[] args) {
        frame = new JFrame("Radio Button : ");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        b1 = new JRadioButton("A) Madhav");
        b1.setBounds(600,200,150,50);
        b2 = new JRadioButton("B) Krishna");
        b2.setBounds(600,300,150,50);

        bg = new ButtonGroup();

        button = new JButton("Click Me");
        button.setBounds(650,400,120,30);
        button.addActionListener(new RadioButtoon());

        bg.add(b1);
        bg.add(b2);
        frame.add(b1);
        frame.add(b2);
        frame.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(b1.isSelected()){
            JOptionPane.showMessageDialog(frame,"You are Madhav");
        }
        if(b2.isSelected()){
            JOptionPane.showMessageDialog(frame,"You are krishna");
        }
    }
}
