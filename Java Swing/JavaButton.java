import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.*;


public class JavaButton {
    public static void main(String[] args) {
        JFrame f = new JFrame("Button Example");
        // JButton b = new JButton("Click Here");
        // b.setBounds(130,100,100,40);
        // f.add(b);
        // f.setSize(400,500);
        // f.setLayout(null);
        // f.setVisible(true);


        final JTextField tf = new JTextField();
        tf.setBounds(50,50,150,20);
        JButton b = new JButton("Click Here");
        b.setBounds(50,100,95,30);
        
        b.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
            tf.setText("Welcome to Madhav Learning space");
           } 
        });

        f.add(b);
        f.add(tf);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);

    }
}

// the jbutton class is used to create a labeled button that has platform independent implementation. the application result in some action when the button is pused. it inherits abstractbutton class.

// commonly used constructors : 

// JButton() --> it creates a button with no text and icon.
// JButton(String s) --> it creates a button with the specified text.
// JButton(Icon i) -->it creates a button with the specified icon object.

// commonly used methods of abstractbutton class:

// void setText(String s);
// String getText();
// void setEnabled(boolean b);
// void setIcon(Icon b);
// Icon getIcon();
// void setMnemonic(int a);
// void addActionListener(ActionListener a);

