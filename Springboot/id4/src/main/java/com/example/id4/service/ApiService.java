package com.example.id4.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiService {

    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=AIzaSyCN1tipRwzeZMFEG427lwEG9hhFaGzirps";

    public String[] getAnswer(String userInput, MultipartFile imageFile) {
        String[] answer = {"", ""}; 

        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            StringBuilder requestBody = new StringBuilder();
            requestBody.append("{")
                        .append("\"contents\":[{")
                        .append("\"parts\":[{\"text\":\"").append(userInput).append("\"}");

            if (imageFile != null && !imageFile.isEmpty()) {
                byte[] imageBytes = imageFile.getBytes();
                String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
                requestBody.append(",{\"inline_data\":{\"mime_type\":\"image/jpeg\",\"data\":\"")
                            .append(imageBase64)
                            .append("\"}}");
            }

            requestBody.append("]}]}");

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            BufferedReader reader;

            if (responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                answer[0] = "Response Code: " + responseCode;
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line.trim());
            }
            reader.close();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.toString());

            JsonNode textNode = rootNode.path("candidates").get(0).path("content").path("parts").get(0).path("text");
            answer[0] = textNode.asText().replaceAll("\\*\\*(.*?)\\*\\*", "$1");


            JsonNode imageNode = rootNode.path("candidates").get(0).path("content").path("image");
            if (imageNode != null && imageNode.has("url")) {
                answer[1] = imageNode.path("url").asText();
            }

        } catch (Exception e) {
            answer[0] = "Error: failed to connect through API";
            e.printStackTrace();
        }

        return answer;
    }
}
