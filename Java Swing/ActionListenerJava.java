// Note : This code also having some parts of addKeyListener

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;


public class ActionListenerJava implements ActionListener{

    JFrame frame = new JFrame("ActionListener");

    JButton btn1 = new JButton("Dangsineul Saranghaeyo");

    JTextArea area = new JTextArea();

    JMenuBar mb = new JMenuBar();
    JMenu file,edit;
    JMenuItem cut,copy,paste,selectAll,New,open,save;


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

        file = new JMenu("File");
        edit = new JMenu("Edit");

        New = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("SelectAll");

        file.add(New);
        file.add(open);
        file.add(save);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);

        mb.add(file);
        mb.add(edit);

        frame.setJMenuBar(mb);

        frame.revalidate();
        frame.repaint();
        

    }

    public void AllActionEvent(){
        btn1.addActionListener(this);
        New.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
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

        if(source == New){
            area.setText("");
        }

        if(source == open){
            area.setText("Open File");
        }
        if(source == save){
            area.setText("Save File");
        }
        if(source == cut){
            area.cut();
        }
        if(source == copy){
            area.copy();
        }
        if(source == paste){
            area.paste();
        }
        if(source == selectAll){
            area.selectAll();
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
