import java.sql.*;

public class createdb {

    private static String url = "jdbc:mysql://localhost:3306/";
    private static String username = "root";
    private static String password = "1234";
    public static void main(String[] args) {
        try{

            Connection connection = DriverManager.getConnection(url, username, password);
            // System.out.println("Connected to the database");
            Statement statement = connection.createStatement();

            // String createquery = "create database information";
            // statement.executeUpdate(createquery);
            // System.out.println("Databse created");

            String showdatabse = "show databases like 'information'";
            ResultSet checkdatabase = statement.executeQuery(showdatabse);
            if(checkdatabase.next()){
                String usedatabase = "use information";
                statement.executeUpdate(usedatabase);
                System.out.println("Now we are using information database");

                // String createtablequery = "create table countrywisepopulation(country varchar(50),population long)";
                // statement.executeUpdate(createtablequery);
                // System.out.println("Create table query executed");

                
            }
            else{
                System.out.println("Database not found");
            }

            String showtables = "show tables like'countrywisepopulation'";
            ResultSet checktable = statement.executeQuery(showtables);

            if(checktable.next()){
                // String insertquery = "insert into countrywisepopulation values('India',1500000000),('USA',250000000)";
                // statement.executeUpdate(insertquery);
                // System.out.println("Insert statement has been executed");

                String selectquery = "select * from countrywisepopulation";
                ResultSet viewtable = statement.executeQuery(selectquery);

                while(viewtable.next()){
                    String country = viewtable.getString("country");
                    long population = viewtable.getLong("population");
                    System.out.println("Country: " + country + " | Population: " + population);
                }
            }else{
                System.out.println("Table not found");
            }

            

            


        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
