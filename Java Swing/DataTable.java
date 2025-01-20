import javax.swing.*;


public class DataTable {

    DataTable(){
        JFrame frame = new JFrame("JavaTable");
        frame.setLayout(null);
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        String[][] data = {{"Madhav","12213356","CSE"},{"Krishna","12213357","ECE"}};
        String[]column = {"Name","Reg.No","Course"};

        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setSize(400,200);
        scrollPane.setLocation(40,10);

        frame.add(scrollPane);

        
    }
    public static void main(String[] args) {
        new DataTable();
    }
}
