import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ComboBoxJava {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));

        String[] Name = {"Madhav","Krishna","Ram","Shyam","Ganesh","Keshav","Raghav"};

        @SuppressWarnings("rawtypes")
        JComboBox comboBox = new JComboBox(Name);

        comboBox.setPreferredSize(new Dimension(100,30));

        JButton b = new JButton("Show");

        JLabel l = new JLabel();
        l.setPreferredSize(new Dimension(120,30));

        b.setPreferredSize(new Dimension(100,30));

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String data = comboBox.getItemAt(comboBox.getSelectedIndex()) + " is selected";
                l.setText(data);
            }
        });

        frame.add(comboBox);
        frame.add(b);
        frame.add(l);
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}
