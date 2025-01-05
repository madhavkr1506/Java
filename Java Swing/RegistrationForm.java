import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RegistrationForm implements ActionListener{

    JFrame frame = new JFrame("RegistrationForm");
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2;
    JTextArea a1,a2;
    JRadioButton rb1,rb2;
    JButton btn1;
    @SuppressWarnings("rawtypes")
    JComboBox date,month,year;
    String Date[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String Month[] = {"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sept","Oct","Nov","Dec"};
    String Year[] = {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024"};

    JCheckBox cb1;

    RegistrationForm(){
        prepareGui();
        addComponent();
    }

    public void prepareGui(){
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addComponent(){
        l1 = new JLabel("Registration Form");
        l1.setBounds(275, 10, 200, 30);
        l1.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(l1);

        l2 = new JLabel("Name");
        l2.setBounds(10, 60, 150, 30);
        l2.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(l2);

        t1 = new JTextField();
        t1.setBounds(160,60,120,30);
        t1.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(t1);

        l3 = new JLabel("Mobile");
        l3.setBounds(10, 110, 150, 30);
        l3.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(l3);

        t2 = new JTextField();
        t2.setBounds(160,110,120,30);
        t2.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(t2);

        l4 = new JLabel("Gender");
        l4.setBounds(10, 160, 150, 30);
        l4.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(l4);

        rb1 = new JRadioButton("Male");
        rb1.setBounds(160, 160, 70, 30);
        
        rb2 = new JRadioButton("Female");
        rb2.setBounds(240, 160, 70, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);bg.add(rb2);
        frame.add(rb1);
        frame.add(rb2);

        l5 = new JLabel("DOB");
        l5.setBounds(10, 210, 150, 30);
        l5.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(l5);

        date = new JComboBox<>(Date);
        month = new JComboBox<>(Month);
        year = new JComboBox<>(Year);

        date.setBounds(160,210,50,30);
        date.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(date);

        month.setBounds(220,210,70,30);
        month.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(month);

        year.setBounds(300,210,70,30);
        year.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(year);


        l6 = new JLabel("Address");
        l6.setBounds(10, 260, 150, 30);
        l6.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(l6);

        a1 = new JTextArea();
        a1.setBounds(160, 260, 150, 40);
        a1.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(a1);

        a2 = new JTextArea();
        a2.setBounds(390, 60, 220, 280);
        a2.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(a2);

        cb1 = new JCheckBox("Please Accept Terms and Conditions");
        cb1.setBounds(40,320,330,30);
        cb1.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(cb1);


        btn1 = new JButton("Submit");
        btn1.setBounds(170,360,100,30);
        btn1.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(btn1);
        btn1.addActionListener(this);

        l7 = new JLabel();
        l7.setBounds(140,400,200,30);
        l7.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(l7);
        

        frame.revalidate();
        frame.repaint();

    }


    public static void main(String[] args) {
        new RegistrationForm();
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == btn1){
            if(cb1.isSelected()){
                String gender = "";
                if(rb1.isSelected()){
                    gender = "Male";
                }
                if(rb2.isSelected()){
                    gender = "Female";
                }
                a2.setText("Name : " + t1.getText() + "\n" + "Mobile : " + t2.getText() + "\nGender : " + gender + "\nDOB : " + date.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem() + "\nAddress : " + a1.getText());
                l7.setText("Registration Successful!!");
            }else{
                JOptionPane.showMessageDialog(frame, "Please Accept The Terms And Conditions", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
