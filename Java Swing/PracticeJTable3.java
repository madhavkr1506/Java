
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PracticeJTable3 {

    private static final String[]column = {"Name","Reg.No","Course"};
    private static JTable table;
    private DefaultTableModel tablemodel;
    static String[][] data = new String[0][3];
    static int rowcount=0;

    PracticeJTable3(){
        JFrame frame = new JFrame("JavaTable");
        frame.setLayout(null);
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tablemodel = new DefaultTableModel(column,0);
        table = new JTable(tablemodel);

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setSize(400,200);
        scrollPane.setLocation(40,10);

        frame.add(scrollPane);

        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            String inputData;
            while (((inputData = in.readLine()) != null) && !inputData.trim().equals("")) {
                String[] data = inputData.split(" ");
                addrowfunction(data);
                tablemodel.addRow(data);
            }

        }catch(IOException e){
            e.printStackTrace();
        }


    }


    private static void addrowfunction(String[] rowdata){
        if(rowcount >= data.length){
            String[][] newdata = new String[data.length + 1][3];
            System.arraycopy(data, 0, newdata, 0, data.length);
            data = newdata;
        }
        data[rowcount] = rowdata;
        rowcount++;

    }
    public static void main(String[] args) {
        new PracticeJTable3();
    }
}
