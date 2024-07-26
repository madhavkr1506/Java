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

    JMenu friendsName1, friendsName2;
    JMenuItem krishna1, madhav1, govind1, keshav1, raghav1;
    JMenuItem krishna2, madhav2, govind2, keshav2, raghav2;

    Application1(){
        prepareFrame1();
        prepareFrame2();
        addComponentToframe1();
        addComponentToframe2();
        addMenu();
        friendCircle();
        allActionPerformed();
        
    }

    public void prepareFrame1(){
        frame1.setSize(350,600);
        frame1.setLocation(350,100);
        frame1.getContentPane().setBackground(Color.decode("#FFFFF0"));
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponentToframe1(){
        area1 = new JTextArea();
        area1.setBounds(70,100,200,300);
        area1.setBackground(Color.decode("#FAFAD2"));
        area1.setFont(new Font("Arial",Font.BOLD,12));
        area1.setEditable(false);
        area1.setForeground(Color.decode("#8B4513"));
        area1.setLineWrap(true);
        area1.setWrapStyleWord(true);
        frame1.add(area1);

        senderButton = new JButton("SEND");
        senderButton.setBounds(125,450,80,40);
        senderButton.setBackground(Color.decode("#B8860B"));
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
        frame2.getContentPane().setBackground(Color.decode("#FFFFF0"));
        frame2.setLayout(null);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponentToframe2(){
        area2 = new JTextArea();
        area2.setBounds(70,100,200,300);
        area2.setBackground(Color.decode("#FAFAD2"));
        area2.setFont(new Font("Arial",Font.BOLD,12));
        area2.setEditable(false);
        area2.setForeground(Color.decode("#8B4513"));
        area2.setLineWrap(true);
        area2.setWrapStyleWord(true);
        frame2.add(area2);

        receiverButton = new JButton("SEND");
        receiverButton.setBounds(125,450,80,40);
        receiverButton.setBackground(Color.decode("#B8860B"));
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
        sendermenu = new JMenu("Edit");
        sendercut = new JMenuItem("Cut");
        sendercopy = new JMenuItem("Copy");
        senderpaste = new JMenuItem("Paste");
        senderselectAll = new JMenuItem("SelectAll");

        sendermenu.add(sendercut);sendermenu.add(sendercopy);sendermenu.add(senderpaste);sendermenu.add(senderselectAll);
        sendermb.add(sendermenu);

        receivermb = new JMenuBar();
        receivermenu = new JMenu("Edit");
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

    public void friendCircle(){
        friendsName1 = new JMenu("Friends");
        krishna1 = new JMenuItem("Krishna");
        madhav1 = new JMenuItem("Madhav");
        govind1 = new JMenuItem("Govind");
        keshav1 = new JMenuItem("Keshav");
        raghav1 = new JMenuItem("Raghav");

        friendsName1.add(krishna1);
        friendsName1.add(madhav1);
        friendsName1.add(govind1);
        friendsName1.add(keshav1);
        friendsName1.add(raghav1);

        sendermb.add(friendsName1);

        friendsName2 = new JMenu("Friends");
        krishna2 = new JMenuItem("Krishna");
        madhav2 = new JMenuItem("Madhav");
        govind2 = new JMenuItem("Govind");
        keshav2 = new JMenuItem("Keshav");
        raghav2 = new JMenuItem("Raghav");

        friendsName2.add(krishna2);
        friendsName2.add(madhav2);
        friendsName2.add(govind2);
        friendsName2.add(keshav2);
        friendsName2.add(raghav2);

        receivermb.add(friendsName2);

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

        krishna1.addActionListener(this);
        madhav1.addActionListener(this);
        govind1.addActionListener(this);
        keshav1.addActionListener(this);
        raghav1.addActionListener(this);

        krishna2.addActionListener(this);
        madhav2.addActionListener(this);
        govind2.addActionListener(this);
        keshav2.addActionListener(this);
        raghav2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if (source == senderButton) {
            SenderMessage = senderField.getText();
            if (!SenderMessage.isEmpty()) {
                senderField.setText("");
                area1.append(frame1.getTitle() + ": " + SenderMessage + "\n");;
                area2.append(frame1.getTitle() + ": " + SenderMessage + "\n");
            }
        }

        if (source == receiverButton) {
            ReceiverMessage = receiverField.getText();
            if (!ReceiverMessage.isEmpty()) {
                receiverField.setText("");
                area2.append(frame2.getTitle() + ": " + ReceiverMessage + "\n");
                area1.append(frame2.getTitle() + ": " + ReceiverMessage + "\n");
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

        if(source == krishna1){
            frame2.setTitle("Krishna");
        }
        if(source == madhav1){
            frame2.setTitle("Madhav");
        }
        if(source == govind1){
            frame2.setTitle("Govind");
        }
        if(source == keshav1){
            frame2.setTitle("Keshav");
        }
        if(source == raghav1){
            frame2.setTitle("Raghav");
        }

        if(source == krishna2){
            frame1.setTitle("Krishna");
        }
        if(source == madhav2){
            frame1.setTitle("Madhav");
        }
        if(source == govind2){
            frame1.setTitle("Govind");
        }
        if(source == keshav2){
            frame1.setTitle("Keshav");
        }
        if(source == raghav2){
            frame1.setTitle("Raghav");
        }
    }
}