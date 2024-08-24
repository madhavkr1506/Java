import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.security.MessageDigest;
import java.util.HashMap;


public class JavaFrame implements ActionListener{
    public JFrame frameGui = new JFrame("GUI");
    public JPanel jPanel = new JPanel();
    public JButton login = new JButton("LOGIN");
    public JButton signup = new JButton("SIGN UP");
    public JLabel welcomeNote = new JLabel();
    public JTextArea signArea = new JTextArea();
    public JButton enterKeysignUp = new JButton("Enter");
    public JLabel usernameForSignIn = new JLabel("Username: ");
    public JLabel passwordforSignIn = new JLabel("Password: ");
    public JTextField userFieldSignIn = new JTextField();
    public JTextField passwordFieldSignIn = new JTextField();
    public JTextArea madhavHomePage = new JTextArea();
    public JButton madhavTimeTable = new JButton("Time Table");

    String columns[] = {"Weekday","Time","Subject"};
    public DefaultTableModel tablemodel = new DefaultTableModel(columns,0);
    public JTable tabel;

    public static HashMap<String,String> UserDetails = new HashMap<>();


    JavaFrame(){
        prepareGui(frameGui);
        AllActionPerformed();
    }

    public void prepareGui(JFrame frame){
        frame.setSize(550,300);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.decode("#FDEBF3"));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(addJPanel(jPanel));
        jPanel.add(welcomeDesign(welcomeNote));
        frame.add(loginbuttonDesign(login));
        frame.add(signbuttonDesign(signup));

        frame.revalidate();
        frame.repaint();
    }

    public JPanel addJPanel(JPanel panel){
        panel.setSize(400,200);
        panel.setLocation(10,10);
        panel.setBackground(Color.decode("#FCE4EC"));
        panel.setLayout(null);
        return panel;
    }

    public JButton loginbuttonDesign(JButton loginButton){
        loginButton.setSize(100,30);
        loginButton.setLocation(420, 10);
        loginButton.setBackground(Color.decode("#FFB6C1"));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial",Font.ITALIC,12));

        return loginButton;
    }

    public JButton signbuttonDesign(JButton signButton){
        signButton.setSize(100,30);
        signButton.setLocation(420, 50);
        signButton.setBackground(Color.decode("#FF69B4"));
        signButton.setForeground(Color.WHITE);
        signButton.setFont(new Font("Arial",Font.ITALIC,12));

        return signButton;
    }

    public JLabel welcomeDesign(JLabel wLabel){
        wLabel.setText("<HTML>Hi, This is a Gui application interface</HTML>");
        wLabel.setSize(250,100);
        wLabel.setLocation(110,30);
        wLabel.setFont(new Font("Arial",Font.BOLD,20));
        wLabel.setForeground(Color.decode("#8B4513"));
        return wLabel;
    }

    public JTextArea signUpPage(JTextArea signupArea){
        signupArea.setSize(380,100);
        signupArea.setLocation(10,60);
        signupArea.add(userFieldDesign(userFieldSignIn));
        signupArea.add(passFieldDesign(passwordFieldSignIn));
        signupArea.add(userJLabel(usernameForSignIn));
        signupArea.add(passJLabel(passwordforSignIn));
        signupArea.setEditable(false);

        return signupArea;
    }

    public JButton enterKeyForSign(JButton enterButton){
        enterButton.setSize(100,30);
        enterButton.setLocation(150,170);
        enterButton.setBackground(Color.decode("#FF69B4"));
        enterButton.setForeground(Color.WHITE);
        enterButton.setFont(new Font("Arial",Font.BOLD,12));
        return enterButton;
    }

    public JTextField userFieldDesign(JTextField userField){
        userField.setSize(120,30);
        userField.setLocation(200,10);
        userField.setBackground(Color.decode("#FA8072"));
        userField.setForeground(Color.decode("#800080"));

        return userField;
    }

    public JLabel userJLabel(JLabel usertext){
        usertext.setSize(100,30);
        usertext.setLocation(60,10);
        usertext.setFont(new Font("Arial",Font.ITALIC,16));
        return usertext;
    }
    public JTextField passFieldDesign(JTextField passField){
        passField.setSize(120,30);
        passField.setLocation(200,50);
        passField.setBackground(Color.decode("#FA8072"));
        passField.setForeground(Color.decode("#800080"));
        return passField;
    }

    public JLabel passJLabel(JLabel passtext){
        passtext.setSize(100,30);
        passtext.setLocation(60,50);
        passtext.setFont(new Font("Arial",Font.ITALIC,16));
        return passtext;
    }
    public static void main(String[] args) {
        new JavaFrame();
    }

    public void AllActionPerformed(){
        signup.addActionListener(this);
        enterKeysignUp.addActionListener(this);
        madhavTimeTable.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source == signup){
            signArea = signUpPage(signArea);
            welcomeNote.setText("");
            jPanel.add(signArea);
            jPanel.add(enterKeyForSign(enterKeysignUp));
            jPanel.revalidate();
            jPanel.repaint();
        }
        else if(source == enterKeysignUp){
            String userNameString = userFieldSignIn.getText();
            userFieldSignIn.setText("");
            String passWordString = passwordFieldSignIn.getText();
            passwordFieldSignIn.setText("");
            String hextUserString = HashAlogoSHA_256(userNameString);
            String hexPassWordString = HashAlogoSHA_256(passWordString);

            if(UserDetails.containsKey(hextUserString)){
                JOptionPane.showMessageDialog(frameGui, "This username has been taken already. Please try new User name.","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                UserDetails.put(hextUserString, hexPassWordString);
                jPanel.removeAll();
                jPanel.add(designMadhavHome(madhavHomePage));
                jPanel.revalidate();
                jPanel.repaint();
                JOptionPane.showMessageDialog(frameGui, "User registered successfully","Alert",JOptionPane.WARNING_MESSAGE);
            }

        }
        else if(source == madhavTimeTable){
            madhavHomePage.removeAll();
            madhavHomePage.revalidate();
            madhavHomePage.repaint();
            jPanel.removeAll();
            jPanel.revalidate();
            jPanel.repaint();

            tabel = new JTable(tablemodel);

            JScrollPane scrollPane = new JScrollPane(tabel);
            scrollPane.setBounds(10,10,400,200);
            jPanel.add(scrollPane);
            while (true) {
                String weekday = JOptionPane.showInputDialog(frameGui,"Input weekday: ");
                String inputTime = JOptionPane.showInputDialog(frameGui,"Input Time: ");
                String inputSub = JOptionPane.showInputDialog(frameGui,"Input Subject: ");

                String[] rowData = {weekday,inputTime,inputSub};
                tablemodel.addRow(rowData);

                int decision = JOptionPane.showConfirmDialog(frameGui,"Are we here for more information: ");
                if(decision == JOptionPane.NO_OPTION){
                    break;
                    
                }
            }
            jPanel.revalidate();
            jPanel.repaint();
        
        }

    }

    public JTable tableStructure(JTable table){
        table.setSize(400,300);
        table.setLocation(0,0);
        return table;
    }

    public JTextArea designMadhavHome(JTextArea area){
        area.setSize(380,100);
        area.setLocation(10,60);
        area.setEditable(false);
        madhavHomePage.add(TimeTable(madhavTimeTable));
        return area;
    }

    public JButton TimeTable(JButton button){
        button.setSize(120,30);
        button.setLocation(130,20);
        return button;
    }

    public String HashAlogoSHA_256(String string){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(string.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for(byte b : hash){
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1){
                    hexString.append("0");
                }
                hexString.append(hex);
            }

            return hexString.toString();

        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
