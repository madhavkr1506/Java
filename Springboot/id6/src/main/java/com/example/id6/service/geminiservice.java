package com.example.id6.service;

import java.net.*;
import java.io.*;

import org.springframework.stereotype.Service;

import com.example.id6.model.geminimodel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class geminiservice {
    
    private String question;
    private String answer;
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    
    geminimodel modelclassobject = new geminimodel();


    String apiurl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=";

    public geminimodel findAnswer(){
        try{

            URL url = new URL(apiurl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String requestMethod = "{\"contents\":[{\"parts\":[{\"text\":\"" + question + "\"}]}]}";

            try(PrintWriter out = new PrintWriter(connection.getOutputStream(),true)){   
                out.println(requestMethod);
            }

            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();

            if(responseCode == HttpURLConnection.HTTP_OK){
                System.out.println("Response Code: " + responseCode);
                System.out.println("Response Message: " + responseMessage);

                StringBuilder responseString = new StringBuilder();
                String inputLine;
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while ((inputLine = reader.readLine()) != null) {
                    responseString.append(inputLine);
                }
                reader.close();
                connection.disconnect();


                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootnode = objectMapper.readTree(responseString.toString());

                answer = rootnode.get("candidates").get(0).get("content").get("parts").get(0).get("text").asText();

                
                modelclassobject.setQuestion(question);
                modelclassobject.setAnswer(answer);
            }else{
                System.out.println("Response Code : " + responseCode);
                StringBuilder errorMessage = new StringBuilder();
                String errorInput;
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

                while ((errorInput = reader.readLine()) != null) {
                    errorMessage.append(errorInput);
                }
                reader.close();

                connection.disconnect();
                System.out.println("Error Message: " + errorMessage.toString());
            }




        }catch(Exception e){
            e.printStackTrace();
        }
        return modelclassobject;
    }


}
