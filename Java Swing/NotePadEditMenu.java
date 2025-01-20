import javax.swing.*;
import java.awt.event.*;

public class NotePadEditMenu implements ActionListener {
    JFrame frame = new JFrame("NotePad");
    JMenu file,edit,help;
    JMenuItem cut,copy,paste,selectAll;
    JMenuBar mb;
    JTextArea ta;
    NotePadEditMenu(){

        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");

        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("SelectAll");

        

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);

        mb = new JMenuBar();

        mb.add(file);mb.add(edit);mb.add(help);

        ta = new JTextArea();
        ta.setBounds(5,5,360,320);
        frame.add(mb);frame.add(ta);
        frame.setJMenuBar(mb);
        frame.setLayout(null);
        frame.setSize(400,400);
        frame.setVisible(true);


    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == cut){
            ta.cut();
        }
        if(e.getSource() == copy){
            ta.copy();
        }
        if(e.getSource() == paste){
            ta.paste();
        }
        if(e.getSource() == selectAll){
            ta.selectAll();
        }
    }

    public static void main(String[] args) {
        new NotePadEditMenu();
    }
}
