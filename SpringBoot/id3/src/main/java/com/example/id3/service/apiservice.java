package com.example.id3.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Service;

import com.example.id3.model.apimodel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class apiservice {

    private String cityname;
    
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public apimodel getweatherdetails(){
        try{

            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + cityname + "&appid=1abda653c4c413b0f3be7e69d5ce7e12");
            URLConnection connection = url.openConnection();

            StringBuilder response = new StringBuilder();
            String inputLine;
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.toString());

            JsonNode mainNode = rootNode.path("main");
            double minimumtemperature = mainNode.path("temp_min").asDouble();
            double maximumtemperature = mainNode.path("temp_max").asDouble();
            double pressure = mainNode.path("pressure").asDouble();
            double humidity = mainNode.path("humidity").asDouble();
            double feelslike = mainNode.path("feels_like").asDouble();

            apimodel apimodelobject = new apimodel();

            apimodelobject.setCity(cityname);
            apimodelobject.setMinimumtemperature(minimumtemperature);
            apimodelobject.setMaximumtemperature(maximumtemperature);
            apimodelobject.setPressure(pressure);
            apimodelobject.setHumidity(humidity);
            apimodelobject.setFeelslike(feelslike);
            


            return apimodelobject;


        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
