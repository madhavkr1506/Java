import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;


public class Calculator {
   private static boolean isfirstOperandClicked = false;
   private static int operand1;
   private static int operand2;
   private static int result;
   private static String currentOperation;
    public static void main(String[] args) {
       JFrame frame = new JFrame("Calculator");
       frame.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
       frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
       JPanel buttonPanel = new JPanel();
       buttonPanel.setLayout(new GridLayout(4,3,10,10));
       JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,add,sub,mul,div,equal;
       b1 = new JButton("1");
       b1.setPreferredSize(new Dimension(60,60));
       b1.setFont(new Font("Arial",Font.PLAIN,24));
       b2 = new JButton("2");
       b2.setPreferredSize(new Dimension(60,60));
       b2.setFont(new Font("Arial",Font.PLAIN,24));
       b3 = new JButton("3");
       b3.setPreferredSize(new Dimension(60,60));
       b3.setFont(new Font("Arial",Font.PLAIN,24));
       b4 = new JButton("4");
       b4.setPreferredSize(new Dimension(60,60));
       b4.setFont(new Font("Arial",Font.PLAIN,24));
       b5 = new JButton("5");
       b5.setPreferredSize(new Dimension(60,60));
       b5.setFont(new Font("Arial",Font.PLAIN,24));
       b6 = new JButton("6");
       b6.setPreferredSize(new Dimension(60,60));
       b6.setFont(new Font("Arial",Font.PLAIN,24));
       b7 = new JButton("7");
       b7.setPreferredSize(new Dimension(60,60));
       b7.setFont(new Font("Arial",Font.PLAIN,24));
       b8 = new JButton("8");
       b8.setPreferredSize(new Dimension(60,60));
       b8.setFont(new Font("Arial",Font.PLAIN,24));
       b9 = new JButton("9");
       b9.setPreferredSize(new Dimension(60,60));
       b9.setFont(new Font("Arial",Font.PLAIN,24));
       b10 = new JButton("0");
       b10.setPreferredSize(new Dimension(60,60));
       b10.setFont(new Font("Arial",Font.PLAIN,24));
       add = new JButton("+");
       add.setPreferredSize(new Dimension(60,60));
       add.setFont(new Font("Arial",Font.PLAIN,24));
       sub = new JButton("-");
       sub.setPreferredSize(new Dimension(60,60));
       sub.setFont(new Font("Arial",Font.PLAIN,24));
       mul = new JButton("*");
       mul.setPreferredSize(new Dimension(60,60));
       mul.setFont(new Font("Arial",Font.PLAIN,24));
       div = new JButton("/");
       div.setPreferredSize(new Dimension(60,60));
       div.setFont(new Font("Arial",Font.PLAIN,24));
       equal = new JButton("=");
       equal.setPreferredSize(new Dimension(60,60));
       equal.setFont(new Font("Arial",Font.PLAIN,24));

       JTextField tf = new JTextField();
       tf.setPreferredSize(new Dimension(300,50));
       tf.setFont(new Font("Arial",Font.PLAIN,24));
       

       buttonPanel.add(b1);buttonPanel.add(b2);buttonPanel.add(b3);buttonPanel.add(b4);buttonPanel.add(b5);buttonPanel.add(b6);buttonPanel.add(b7);buttonPanel.add(b8);buttonPanel.add(b9);buttonPanel.add(b10);
       buttonPanel.add(add);buttonPanel.add(sub);
       buttonPanel.add(mul);buttonPanel.add(div);
       buttonPanel.add(equal);
       frame.add(buttonPanel);
      
       frame.add(tf);

       b1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            tf.setText(b1.getText());
         }
       });
       b2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            tf.setText(b2.getText());
         }
       });
       b3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            tf.setText(b3.getText());
         }
       });
       b4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            tf.setText(b4.getText());
         }
       });
       b5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            tf.setText(b5.getText());
         }
       });
       b6.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            tf.setText(b6.getText());
         }
       });
       b7.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            tf.setText(b7.getText());
         }
       });
       b8.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            tf.setText(b8.getText());
         }
       });
       b9.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            tf.setText(b9.getText());
         }
       });
       b10.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            tf.setText(b10.getText());
         }
       });


       
       add.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            currentOperation = "+";
            if(!isfirstOperandClicked){
               operand1 = Integer.parseInt(tf.getText());
               tf.setText("");
               isfirstOperandClicked = true;
            }
         }
       });

       sub.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            currentOperation = "-";
            if(!isfirstOperandClicked){
               operand1 = Integer.parseInt(tf.getText());
               tf.setText("");
               isfirstOperandClicked = true;
            }
         }
       });

       mul.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            currentOperation = "*";
            if(!isfirstOperandClicked){
               operand1 = Integer.parseInt(tf.getText());
               tf.setText("");
               isfirstOperandClicked = true;
            }
         }
       });

       div.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            currentOperation = "/";
            if(!isfirstOperandClicked){
               operand1 = Integer.parseInt(tf.getText());
               tf.setText("");
               isfirstOperandClicked = true;
            }
         }
       });


       equal.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            
            if(currentOperation != null){
               operand2 = Integer.parseInt(tf.getText());
               switch(currentOperation){
                  case "+" : 
                     result = operand1 + operand2;
                     tf.setText("Adding " + operand1 + " and " + operand2 + " = " + String.valueOf(result));
                     isfirstOperandClicked = false;
                     break;
                  case "-" : 
                     result = operand1 - operand2;
                     tf.setText("Adding " + operand1 + " and " + operand2 + " = " + String.valueOf(result));
                     isfirstOperandClicked = false;
                     break;
                  case "*" : 
                     result = operand1 * operand2;
                     tf.setText("Adding " + operand1 + " and " + operand2 + " = " + String.valueOf(result));
                     isfirstOperandClicked = false;
                     break;
                  case "/" : 
                     result = operand1 / operand2;
                     tf.setText("Adding " + operand1 + " and " + operand2 + " = " + String.valueOf(result));
                     isfirstOperandClicked = false;
                     break;
                  
               }
            }     
         }
            
         
       });
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);


    }
}