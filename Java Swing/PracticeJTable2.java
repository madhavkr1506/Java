import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PracticeJTable2 {

    private static final String[]column = {"Name","Reg.No","Course"};
    private ArrayList<String[]> dataList = new ArrayList<>();
    private static JTable table;
    private DefaultTableModel tablemodel;
    
    PracticeJTable2(){
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
                dataList.add(data);
                tablemodel.addRow(data);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        


        
    }
    public static void main(String[] args) {
        new PracticeJTable2();
    }
}
