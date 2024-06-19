import javax.swing.*;
public class JavaLabel {

    public static void main(String[] args) {
        JFrame f = new JFrame("Label Example");
        JLabel l1,l2;
        l1 = new JLabel("First Label");
        l1.setBounds(50,50,100,30);
        l2 = new JLabel("Second Label");
        l2.setBounds(50,100,100,30);
        f.add(l1);
        f.add(l2);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }
}
/*
 * commonly used constructors :
 * 
 * JLabel()
 * JLabel(String s)
 * JLabel(Icon i)
 * JLabel(String s, Icon i, int horizontalAlignment)
 * 
 * commonly used methods : 
 * 
 * String getText()
 * void setText(String text)
 * void setHorizontalAlignment(int alignment)
 * Icon getIcon()
 * int getHorizontalAlignment()
 * 
 */