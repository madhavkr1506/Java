import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC {

    private static final String dburl = "";
    private static final String user = "";
    private static final String password = "";
    public static void main(String[] args) {

        
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(dburl, user, password);
            System.out.println("Connected to the database successfully");

            String insertquery = "insert into question values(?,?,?,?,?,?)";

            PreparedStatement insertsmt = connection.prepareStatement(insertquery);

            insertsmt.setString(1, "what is the capital of France");
            insertsmt.setString(2, "Berlin");
            insertsmt.setString(3, "Madrid");
            insertsmt.setString(4, "Paris");
            insertsmt.setString(5, "Rome");
            insertsmt.setString(6, "Paris");
            insertsmt.executeUpdate();
            System.out.println("Question added successfully");

            String selectquery = "select * from  question";
            PreparedStatement selectsmt = connection.prepareStatement(selectquery);

            ResultSet resultSet = selectsmt.executeQuery();

            System.out.println("Quiz question: ");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Question: " + resultSet.getString("question"));
                System.out.println("Option A: " + resultSet.getString("optiona"));
                System.out.println("Option B: " + resultSet.getString("optionb"));
                System.out.println("Option C: " + resultSet.getString("optionc"));
                System.out.println("Option D: " + resultSet.getString("optiond"));
                System.out.println("Correct Answer: " + resultSet.getString("correctanswer"));
                System.out.println();
            }

            String updatequery = "update question set question = ? where where id = ?";
            PreparedStatement updatesmt = connection.prepareStatement(updatequery);
            updatesmt.setString(1, "What is is the capital of Germany?");
            updatesmt.setInt(2, 1);
            updatesmt.executeUpdate();
            System.out.println("Question updated successfully");




        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{

                if(connection != null && !connection.isClosed()){
                    connection.close();
                    System.out.println("Connection is closed");
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
