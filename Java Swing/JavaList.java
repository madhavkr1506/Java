import java.awt.*;

import javax.swing.*;

public class JavaList {

    JFrame frame = new JFrame("Java List");
    DefaultListModel<String> list1 = new DefaultListModel<>();
    JList<String> list = new JList<>(list1);
    JavaList(){
        preparedGui();
        addComponents();
    }
    public void preparedGui(){
        
        frame.setBounds(500,200,450,410);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void addComponents(){
        
        list1.addElement("Madhav");
        list1.addElement("Krishna");
        list1.addElement("Mahadev");
        list1.addElement("Ram");
        list1.addElement("Govind");

        list.setBounds(150,100,80,100);

        frame.add(list);

    }
    public static void main(String[] args) {
        new JavaList();
    }
}
