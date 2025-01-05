package com.example.id1.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.id1.model.ApiModel;

import lombok.Data;

@Service
@Data
public class ApiService {
    
    private String city;

    private ApiResponse apiResponse;

    public ApiModel apiDetails(){
        try{
            if(city == null){
                return null;
            }
            else{
                String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + ",IN&appid=";

                RestTemplate restTemplate = new RestTemplate();

                apiResponse = restTemplate.getForObject(url, ApiResponse.class);

                if(apiResponse != null){
                    ApiModel apiModel = new ApiModel();
                    double minimumtemp = Double.parseDouble(apiResponse.getMain().getMintemp());
                    double maximumtemp = Double.parseDouble(apiResponse.getMain().getMaxtemp());
                    double pressure = Double.parseDouble(apiResponse.getMain().getPressure());
                    double humidity = Double.parseDouble(apiResponse.getMain().getHumidity());
                    double feelslike = Double.parseDouble(apiResponse.getMain().getFeelslike());

                    apiModel.setCity(city);
                    apiModel.setMinimumtemp(String.format("%.2f", minimumtemp));
                    apiModel.setMaximumtemp(String.format("%.2f", maximumtemp));
                    apiModel.setPressure(String.format("%.2f", pressure));
                    apiModel.setHumidity(String.format("%.2f", humidity));
                    apiModel.setFeelslike(String.format("%.2f", feelslike));
                    return apiModel;
                }
                else{
                    return null;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
