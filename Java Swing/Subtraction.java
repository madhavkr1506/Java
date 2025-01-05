import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;



public class Subtraction implements ActionListener{
    public static JTextField tf1;
    public static JButton Sub;
    private int operand1;
    private boolean isfirstoperandentered = false;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Subtraction");
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        tf1 = new JTextField();
        tf1.setPreferredSize(new Dimension(100,100));
        tf1.setFont(new Font("Arial",Font.PLAIN,32));

        Sub = new JButton("Sub");
        Sub.addActionListener(new Subtraction());


        frame.add(tf1);frame.add(Sub);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try{
            if(!isfirstoperandentered){
                operand1 = Integer.parseInt(tf1.getText());
                tf1.setText("");
                isfirstoperandentered = true;
            }
            else{
                int operand2 = Integer.parseInt(tf1.getText());
                int result = operand1 - operand2;
                tf1.setText(String.valueOf(result));
                isfirstoperandentered = false;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
