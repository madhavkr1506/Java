package com.example.id5.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import java.sql.*;
import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.id5.model.ChatModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ChatService {
    
    
    ChatModel chatModel = new ChatModel();

    private String dburl = "";
    private String username = "";
    private String password = "";

    
    public String question;
    public String answer;
    public String imageread;



    public void getQuestion(String question){
        this.question = question;
    }

    public MultipartFile imagefile;
    public void setImagefile(MultipartFile imagefile) {
        this.imagefile = imagefile;
    }

    private String stringurl = new String("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=");

    public ChatModel getAnswer(){
        try{
            URL url = new URL(stringurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // String requestinput = "{\"contents\":[{\"parts\":[{\"text\":\"" + question + "\"}]}]}";

            StringBuilder requestinput = new StringBuilder();
            requestinput.append("{\"contents\":[{\"parts\":[{\"text\":\"");
            requestinput.append(question).append("\"}");
            if(imagefile != null  && !imagefile.isEmpty()){
                byte[] imagebyte = imagefile.getBytes();
                String imageBase64 = Base64.getEncoder().encodeToString(imagebyte);
                requestinput.append(",{\"inline_data\":{\"mime_type\":\"image/jpeg\",\"data\":\"")
                .append(imageBase64)
                .append("\"}}");
            }

            requestinput.append("]}]}");

            try(PrintWriter out = new PrintWriter(connection.getOutputStream(),true)){
                out.write(requestinput.toString());
            }

            int responsecode = connection.getResponseCode();
            String responsemessage = connection.getResponseMessage();

            if(responsecode == HttpURLConnection.HTTP_OK){

                System.out.println("response code: " + responsecode);
                System.out.println("response message: " + responsemessage);

                StringBuilder responsestring = new StringBuilder();
                String inputline;
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));


                while ((inputline = in.readLine()) != null) {
                    responsestring.append(inputline);
                }

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootnode = objectMapper.readTree(responsestring.toString());

                JsonNode content = rootnode.path("candidates").get(0).path("content").path("parts").get(0);

                answer = content.path("text").asText();

                JsonNode imagecontent = rootnode.path("candidates").get(0).path("content").path("image");

                if(imagecontent != null && imagecontent.has("url")){
                    imageread = imagecontent.path("url").asText();
                }



                ChatModel chatModel = new ChatModel();
                chatModel.setQuestion(question);
                chatModel.setAnswer(answer);

                chatModel.setImageread(imageread);
                savehistory();

                return chatModel;

            }
            else{
                answer = "Response Code: " + responsecode;
                return null;
            }
            


        }catch(Exception e){
            answer = "Failed to connect through API";
            
            e.printStackTrace();
            return null;
        }


        

    }

    public void savehistory(){
        try(Connection connection = DriverManager.getConnection(dburl,username,password);
        Statement statement = connection.createStatement()){

            

            String createdatabasequery = "create database if not exists chatbot";
            statement.executeUpdate(createdatabasequery);
            String usedatabasequery = "use chatbot";
            statement.executeUpdate(usedatabasequery);

            String createtablequery = "create table if not exists chathistory(question varchar(1000), answer varchar(10000))";
            statement.executeUpdate(createtablequery);

            PreparedStatement insertstatement = connection.prepareStatement("insert into chathistory (question, answer) values (?,?)");
            insertstatement.setString(1, question);
            insertstatement.setString(2, answer);
            insertstatement.executeUpdate();

            System.out.println("Chat history Updated");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
