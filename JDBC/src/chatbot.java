import java.sql.*;

import org.json.JSONObject;

import java.io.*;
import java.net.*;


public class chatbot {

    private static String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=AIzaSyDhiRc_Rfd2CKOM801d5aoqKnu7q7pbovo";
    private static String dburl = "jdbc:mysql://localhost:3306/";
    private static String username = "root";
    private static String password = "1234";
    private static String userinput,botresponse;

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        while (true) {
        
            try{
                URL apiurl = new URL(url);

                System.out.print("Enter your question: ");
                userinput = System.console().readLine();
                if(userinput.equalsIgnoreCase("exit")){
                    System.out.println("Bot Response: Bye we will meet again");
                    break;
                }

                String requeststring = "{\"contents\":[{\"parts\":[{\"text\":\"" + userinput + "\"}]}]}";

                HttpURLConnection apiconnection = (HttpURLConnection) apiurl.openConnection();

                apiconnection.setRequestMethod("POST");
                apiconnection.setRequestProperty("Content-Type", "application/json");
                apiconnection.setDoOutput(true);

                try(PrintWriter out = new PrintWriter(apiconnection.getOutputStream(),true)){
                    out.write(requeststring);
                }

                int reponsecode = apiconnection.getResponseCode();
                String responsemessage = apiconnection.getResponseMessage();

                System.out.println("Response Code: " + reponsecode);
                System.out.println("Response Message: " + responsemessage);


                

                StringBuilder responsestring = new StringBuilder();
                String inputline;
                BufferedReader in = new BufferedReader(new InputStreamReader(apiconnection.getInputStream()));

                while ((inputline = in.readLine()) != null) {
                    responsestring.append(inputline);
                }

                JSONObject jsonObject = new JSONObject(responsestring.toString());

                botresponse = jsonObject.getJSONArray("candidates").getJSONObject(0)
                        .getJSONObject("content").getJSONArray("parts").getJSONObject(0)
                        .getString("text");

                System.out.println("Bot Response: " + botresponse);

            }catch(Exception e){
                e.printStackTrace();
            }

            try(Connection connection = DriverManager.getConnection(dburl, username, password);
            Statement statement = connection.createStatement()){
                System.out.println("Connected to Mysql");
                String createdatabasequery = "create database if not exists chatbot";
                statement.executeUpdate(createdatabasequery);

                System.out.println("Database is created or already existed");

                String usedatabasequery = "use chatbot";
                statement.executeUpdate(usedatabasequery);
                System.out.println("Chatbot database is in used");

                String createtablequery = "create table if not exists chathistory(question varchar(1000),answer varchar(10000))";
                statement.executeUpdate(createtablequery);
                System.out.println("Table is created or already existed");

                String insertquery = "insert into chathistory(question,answer) values (?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertquery);

                preparedStatement.setString(1, userinput);
                preparedStatement.setString(2, botresponse);
                preparedStatement.executeUpdate();


            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
