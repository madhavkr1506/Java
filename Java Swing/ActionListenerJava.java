// Note : This code also having some parts of addKeyListener

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;


public class ActionListenerJava implements ActionListener{

    JFrame frame = new JFrame("ActionListener");

    JButton btn1 = new JButton("Dangsineul Saranghaeyo");

    JTextArea area = new JTextArea();

    ActionListenerJava(){
        prepareGui();
        addComponents();
        AllActionEvent();
        addKeyListnertoTextArea();
    }
    public void prepareGui(){
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addComponents(){
        btn1.setBounds(200,50,250,40);
        btn1.setFont(new Font("Arial",Font.BOLD,16));
        btn1.setBackground(Color.RED);
        btn1.setForeground(Color.WHITE);
        frame.add(btn1);

        area.setBounds(120,150,400,100);
        area.setFont(new Font("Arial",Font.BOLD,16));
        area.setBackground(Color.LIGHT_GRAY);
        area.setForeground(Color.BLUE);
        frame.add(area);
        
    }

    public void AllActionEvent(){
        btn1.addActionListener(this);
    }
    public static void main(String[] args) {
        new ActionListenerJava();
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source == btn1){
            frame.getContentPane().setBackground(Color.RED);
            btn1.setBackground(Color.BLACK);
        }
    }

    public void addKeyListnertoTextArea(){
        area.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    area.setText(area.getText().toUpperCase());
                }
            }
        });
    }
}
