import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Application1 implements ActionListener{

    JFrame frame1 = new JFrame("Madhav");
    JFrame frame2 = new JFrame("Krishna");
    JTextArea area1,area2;
    JButton senderButton,receiverButton;
    String SenderMessage,ReceiverMessage;

    JTextField senderField,receiverField;

    JMenuBar sendermb,receivermb;
    JMenu sendermenu,receivermenu;
    JMenuItem sendercut,sendercopy,senderpaste,senderselectAll,receivercut,receivercopy,receiverpaste,receiverselectAll;

    Application1(){
        prepareFrame1();
        prepareFrame2();
        addComponentToframe1();
        addComponentToframe2();
        allActionPerformed();
        addMenu();
    }

    public void prepareFrame1(){
        frame1.setSize(350,600);
        frame1.setLocation(350,100);
        frame1.getContentPane().setBackground(Color.BLACK);
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponentToframe1(){
        area1 = new JTextArea();
        area1.setBounds(70,100,200,300);
        area1.setBackground(Color.RED);
        area1.setFont(new Font("Arial",Font.BOLD,12));
        area1.setEditable(false);
        frame1.add(area1);

        senderButton = new JButton("SEND");
        senderButton.setBounds(125,450,80,40);
        senderButton.setBackground(Color.RED);
        senderButton.setForeground(Color.WHITE);
        senderButton.setFont(new Font("Arial",Font.BOLD,16));
        frame1.add(senderButton);

        senderField = new JTextField();
        senderField.setBounds(70,410,200,30);
        frame1.add(senderField);

        frame1.revalidate();
        frame1.repaint();
    }

    public void prepareFrame2(){
        frame2.setSize(350,600);
        frame2.setLocation(900,100);
        frame2.getContentPane().setBackground(Color.BLACK);
        frame2.setLayout(null);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponentToframe2(){
        area2 = new JTextArea();
        area2.setBounds(70,100,200,300);
        area2.setBackground(Color.RED);
        area2.setFont(new Font("Arial",Font.BOLD,12));
        area2.setEditable(false);
        frame2.add(area2);

        receiverButton = new JButton("SEND");
        receiverButton.setBounds(125,450,80,40);
        receiverButton.setBackground(Color.RED);
        receiverButton.setForeground(Color.WHITE);
        receiverButton.setFont(new Font("Arial",Font.BOLD,16));
        frame2.add(receiverButton);

        receiverField = new JTextField();
        receiverField.setBounds(70,410,200,30);
        frame2.add(receiverField);

        frame2.revalidate();
        frame2.repaint();

    }

    public void addMenu(){
        sendermb = new JMenuBar();
        sendermenu = new JMenu("Menu");
        sendercut = new JMenuItem("Cut");
        sendercopy = new JMenuItem("Copy");
        senderpaste = new JMenuItem("Paste");
        senderselectAll = new JMenuItem("SelectAll");

        sendermenu.add(sendercut);sendermenu.add(sendercopy);sendermenu.add(senderpaste);sendermenu.add(senderselectAll);
        sendermb.add(sendermenu);

        receivermb = new JMenuBar();
        receivermenu = new JMenu("Menu");
        receivercut = new JMenuItem("Cut");
        receivercopy = new JMenuItem("Copy");
        receiverpaste = new JMenuItem("Paste");
        receiverselectAll = new JMenuItem("SelectAll");

        receivermenu.add(receivercut);receivermenu.add(receivercopy);receivermenu.add(receiverpaste);receivermenu.add(receiverselectAll);
        receivermb.add(receivermenu);

        frame1.setJMenuBar(sendermb);
        frame2.setJMenuBar(receivermb);

        frame1.revalidate();
        frame1.repaint();
        frame2.revalidate();
        frame2.repaint();
    }
    public static void main(String[] args) {
        new Application1();
    }

    public void allActionPerformed(){
        senderButton.addActionListener(this);
        receiverButton.addActionListener(this);
        sendercut.addActionListener(this);
        sendercopy.addActionListener(this);
        senderpaste.addActionListener(this);
        senderselectAll.addActionListener(this);
        receivercut.addActionListener(this);
        receivercopy.addActionListener(this);
        receiverpaste.addActionListener(this);
        receiverselectAll.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if (source == senderButton) {
            SenderMessage = senderField.getText();
            if (!SenderMessage.isEmpty()) {
                senderField.setText("");
                area1.append("Madhav: " + SenderMessage + "\n");;
                area2.append("Madhav: " + SenderMessage + "\n");
            }
        }

        if (source == receiverButton) {
            ReceiverMessage = receiverField.getText();
            if (!ReceiverMessage.isEmpty()) {
                receiverField.setText("");
                area2.append("Krishna: " + ReceiverMessage + "\n");
                area1.append("Krishna: " + ReceiverMessage + "\n");
            }
        }

        if(source == sendercut){
            area1.cut();
        }
        if(source == sendercopy){
            area1.copy();
        }
        if(source == senderpaste){
            area1.paste();
        }
        if(source == senderselectAll){
            area1.selectAll();
        }

        if(source == receivercut){
            area2.cut();
        }
        if(source == receivercopy){
            area2.copy();
        }
        if(source == receiverpaste){
            area2.paste();
        }
        if(source == receiverselectAll){
            area2.selectAll();
        }
    }
}