import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class JavaTable implements ActionListener{

    private static HashMap<String,String> loginDetails = new HashMap<>();

    JFrame frame = new JFrame("JavaTable");
    JTextField textField = new JTextField();
    JPasswordField password = new JPasswordField();
    JLabel l1 = new JLabel("USERNAME");
    JLabel l2 = new JLabel("PASSWORD");
    JLabel l3 = new JLabel();
    int Years;
    int Sems;
    
    JButton loginButton = new JButton("Click");
    JButton year1 = new JButton("1st Year");
    JButton year2 = new JButton("2nd Year");
    JButton year3 = new JButton("3rd Year");
    JButton year4 = new JButton("4th Year");

    JButton sem1 = new JButton("1st sem");
    JButton sem2 = new JButton("2nd sem");
    JButton sem3 = new JButton("3rd sem");
    JButton sem4 = new JButton("4th sem");
    JButton sem5 = new JButton("5th sem");
    JButton sem6 = new JButton("6th sem");
    JButton sem7 = new JButton("7th sem");
    JButton sem8 = new JButton("8th sem");

    String[][] data;
    String[] column;
    JTable jt;
    JScrollPane sp;

    JavaTable(){
        preparedGui();
        login();
        addActionEvent();

    }

    public void preparedGui(){
        
        frame.setSize(350,520);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void login(){
        l1.setLocation(10,150);
        l1.setSize(110,30);
        l1.setForeground(Color.WHITE);
        textField.setBounds(120,150,160,30);
        textField.setBackground(Color.WHITE);
        textField.setEditable(true);
        textField.setFont(new Font("Arial",Font.BOLD,12));
        frame.add(l1);
        frame.add(textField);

        l2.setLocation(10,220);
        l2.setSize(110,30);
        l2.setForeground(Color.WHITE);
        password.setBounds(120,220,160,30);
        password.setBackground(Color.WHITE);
        password.setEditable(true);
        password.setFont(new Font("Arial",Font.BOLD,12));
        frame.add(l2);
        frame.add(password);

        loginButton.setBounds(125,300,100,30);
        loginButton.setBackground(Color.RED);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(loginButton);
    }

    public void addActionEvent(){
        loginButton.addActionListener(this);
        year1.addActionListener(this);
        year2.addActionListener(this);
        year3.addActionListener(this);
        year4.addActionListener(this);
        sem1.addActionListener(this);
        sem2.addActionListener(this);
        sem3.addActionListener(this);
        sem4.addActionListener(this);
        sem5.addActionListener(this);
        sem6.addActionListener(this);
        sem7.addActionListener(this);
        sem8.addActionListener(this);

        
    }


    public static void main(String[] args) {
        new JavaTable();

        loginDetails.put("Madhav", "Lenskart1@");
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == loginButton){
            String userId = textField.getText();
            String passWord = new String(password.getPassword());
            if(CheckValidUser(userId,passWord)){
                
                displayYears();
            }else{
                l3.setText("Invalid Credentials");
                l3.setFont(new Font("Arial",Font.BOLD,20));
                l3.setBounds(80,400,200,30);
                l3.setForeground(Color.WHITE);
                frame.add(l3);
            }
        }
        if(source == year1){
            Years = 1;
            displaySem();
        }
        if(source == year2){
            Years = 2;
            displaySem();
        }
        if(source == year3){
            Years = 3;
            displaySem();
        }
        if(source == year4){
            Years = 4;
            displaySem();
        }
        if(source == sem1){
            Sems = 1;
            displayResult();
        }
        if(source == sem2){
            Sems = 2;
            displayResult();
        }
        if(source == sem3){
            Sems = 3;
            displayResult();
        }
        if(source == sem4){
            Sems = 4;
            displayResult();
        }
    }

    public boolean CheckValidUser(String userId,String passString){
        if(loginDetails.containsKey(userId)){
            if(passString.equals(loginDetails.get(userId))){
                return true;
            }            
        }
        return false;
    }

    public void displayYears(){
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.getContentPane().setBackground(Color.RED);
        year1.setBounds(110,100,120,30);
        year1.setFont(new Font("Arial",Font.BOLD,16));
        year2.setBounds(110,200,120,30);
        year2.setFont(new Font("Arial",Font.BOLD,16));
        year3.setBounds(110,300,120,30);
        year3.setFont(new Font("Arial",Font.BOLD,16));
        year4.setBounds(110,400,120,30);
        year4.setFont(new Font("Arial",Font.BOLD,16));

        frame.add(year1);
        frame.add(year2);
        frame.add(year3);
        frame.add(year4);

        frame.revalidate();
        frame.repaint();

    }

    public void displaySem(){
        switch (Years) {
            case 1:
                frame.getContentPane().removeAll();
                frame.repaint();
                frame.getContentPane().setBackground(Color.GREEN);

                sem1.setBounds(110,150,110,30);
                sem1.setFont(new Font("Arial",Font.BOLD,16));
                sem2.setBounds(110,200,110,30);
                sem2.setFont(new Font("Arial",Font.BOLD,16));

                frame.add(sem1);
                frame.add(sem2);
                
                break;

            case 2:
                frame.getContentPane().removeAll();
                frame.repaint();
                frame.getContentPane().setBackground(Color.GREEN);

                sem3.setBounds(110,150,110,30);
                sem3.setFont(new Font("Arial",Font.BOLD,16));
                sem4.setBounds(110,200,110,30);
                sem4.setFont(new Font("Arial",Font.BOLD,16));

                frame.add(sem3);
                frame.add(sem4);
                
                break;


            case 3:
                frame.getContentPane().removeAll();
                frame.repaint();
                frame.getContentPane().setBackground(Color.GREEN);

                sem5.setBounds(110,150,110,30);
                sem5.setFont(new Font("Arial",Font.BOLD,16));
                sem6.setBounds(110,200,110,30);
                sem6.setFont(new Font("Arial",Font.BOLD,16));

                frame.add(sem5);
                frame.add(sem6);
                
                break;

            case 4:
                frame.getContentPane().removeAll();
                frame.repaint();
                frame.getContentPane().setBackground(Color.GREEN);

                sem7.setBounds(110,150,110,30);
                sem7.setFont(new Font("Arial",Font.BOLD,16));
                sem8.setBounds(110,200,110,30);
                sem8.setFont(new Font("Arial",Font.BOLD,16));

                frame.add(sem7);
                frame.add(sem8);
                
                break;
        
            default:
                break;
        }
    }

    public void displayResult(){
        switch (Sems) {
            case 1:
                data = new String[][]{{"CSE111","O"},{"CSE326","A+"},{"INT108","O"},{"MEC135","B+"},{"MTH174","A+"},{"PES318","A"},{"PHY110","A+"}};
                column = new String[]{"Course Id","Grade"};

                jt = new JTable(data,column);
                sp = new JScrollPane(jt);
                sp.setBounds(75,40,200,170);

                frame.getContentPane().removeAll();
                frame.repaint();
                frame.getContentPane().setBackground(Color.black);
                frame.setLayout(null);

                
                frame.add(sp);
                frame.revalidate();
                frame.repaint();

                
                break;

            case 2:
                data = new String[][]{
                    {"CHE110","A+"},{"CSE101","A+"},{"CSE121","A+"},
                    {"CSE320","A"},{"ECE249","A"},{"ECE279","O"},{"INT306","A"},{"MTH401","A"},{"PEL130","A"}

                };
                column = new String[]{
                    "Course Id","Grade"
                };

                jt = new JTable(data,column);
                sp = new JScrollPane(jt);
                sp.setBounds(75,40,200,200);

                frame.getContentPane().removeAll();
                frame.repaint();
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setLayout(null);

                frame.add(sp);
                frame.revalidate();
                frame.repaint();

                break;

            case 3:
                data = new String[][]{
                    {"CSE202","O"},{"CSE205","A"},{"CSE211","A+"},
                    {"CSE306","A+"},{"CSE307","A"},{"CSE316","A+"},{"CSE325","O"},{"GEN231","A+"},{"PEL136","B+"}

                };
                column = new String[]{
                    "Course Id","Grade"
                };

                jt = new JTable(data,column);
                sp = new JScrollPane(jt);
                sp.setBounds(75,40,200,200);

                frame.getContentPane().removeAll();
                frame.repaint();
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setLayout(null);

                frame.add(sp);
                frame.revalidate();
                frame.repaint();

                break;
                
            case 4:
                data = new String[][]{
                    {"CSE310","O"},{"CSE408","A"},{"INT217","A+"},
                    {"INT232","A+"},{"INT426","A"},{"MTH302","A"},{"PEA305","A"}

                };
                column = new String[]{
                    "Course Id","Grade"
                };

                jt = new JTable(data,column);
                sp = new JScrollPane(jt);
                sp.setBounds(75,40,200,200);

                frame.getContentPane().removeAll();
                frame.repaint();
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setLayout(null);

                frame.add(sp);
                frame.revalidate();
                frame.repaint();

                break;
        
            default:
                break;
        }
    }
}
