import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;


public class JavaComboBox {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JFrame frame = new JFrame("JavaComboBox");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        String Name[] = {"Madhav","Krishna","Mahadev","Shyam","Mohan"};

        @SuppressWarnings("rawtypes")
        JComboBox comboBox = new JComboBox(Name);
        comboBox.setBounds(50,50,90,20);

        frame.add(comboBox);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
