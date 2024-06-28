import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;


public class Addition implements ActionListener {
    public static JTextField augend,addend,result;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Addition : ");
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);;

        augend = new JTextField();
        augend.setPreferredSize(new Dimension(100,100));
        augend.setFont(new Font("Arial",Font.PLAIN,32));

        addend = new JTextField();
        addend.setPreferredSize(new Dimension(100,100));
        addend.setFont(new Font("Arial",Font.PLAIN,32));

        JButton Add = new JButton("Add");
        Add.setSize(100,50);
        Add.addActionListener(new Addition());

        result = new JTextField();
        result.setPreferredSize(new Dimension(100,100));
        result.setFont(new Font("Arial",Font.PLAIN,32));




        frame.add(augend);frame.add(addend);frame.add(Add);frame.add(result);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try{
            int augendValue = Integer.parseInt(augend.getText());
            int addendValue = Integer.parseInt(addend.getText());
            int sum = augendValue + addendValue;
            result.setText(String.valueOf(sum));
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
