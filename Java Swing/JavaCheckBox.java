import javax.swing.*;
import java.awt.event.*;
public class JavaCheckBox{
    public static JFrame frame;
    public static JCheckBox checkBox1, checkBox2;
    public static JLabel l1;
    public static void main(String[] args) {
        frame = new JFrame("CheckBox Creation");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        l1 = new JLabel();
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setLocation(600,100);
        l1.setSize(400,100);

        checkBox1 = new JCheckBox("Madhav");
        checkBox1.setBounds(600,200,150,50);

        checkBox2 = new JCheckBox("Krishna");
        checkBox2.setBounds(600,300,150,50);


        frame.add(l1);
        frame.add(checkBox1);
        frame.add(checkBox2);

        checkBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
               l1.setText("Madhav CheckBox : " + (e.getStateChange() == 1 ? "Checked" : "Unchecked"));
            }
        });

        checkBox2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
               l1.setText("Krishna CheckBox : " + (e.getStateChange() == 1 ? "Checked" : "Unchecked"));
            }
        });

        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}