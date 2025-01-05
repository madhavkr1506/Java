import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemLitsenerJava implements ItemListener {

    JFrame frame = new JFrame("ItemListener");
    @SuppressWarnings("rawtypes")
    JComboBox cb;
    JTextArea ta;
    ItemLitsenerJava(){
        prepareGui();
        addComponents();
    }

    public void prepareGui(){
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(400,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addComponents(){
        String[] Name = {"Madhav","Krishna","Govind","Ravi","Mahadev"};
        cb = new JComboBox<>(Name);
        cb.setBounds(50,50,100,30);
        cb.setFont(new Font("Arial",Font.ITALIC,16));
        frame.add(cb);
        cb.addItemListener(this);

        ta = new JTextArea();
        ta.setBounds(170,50,150,200);
        ta.setEditable(false);
        frame.add(ta);
        

        frame.revalidate();
        frame.repaint();

    }


    public static void main(String[] args) {
        new ItemLitsenerJava();
    }

    public void itemStateChanged(ItemEvent e){
        String item = cb.getSelectedItem().toString();
        ta.setFont(new Font("Arial",Font.BOLD,16));
        ta.setText("Selected Item : " + item);
    }
}
