package com.example.id1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.id1.model.ApiModel;
import com.example.id1.service.ApiService;


@RestController
public class ApiController {

    private ApiService apiService;
    public ApiController(ApiService apiService){
        this.apiService = apiService;
    }
    
    @PostMapping("/inputcity")
    public String inputDetails(@RequestBody ApiModel apimodel){

        String cityName = apimodel.getCity();
        apiService.setCity(cityName);

        return "City updated successfully";
    }

    @GetMapping("/weatherdetails")
    public String getWeatherDetails(){
        ApiModel apiModel = apiService.apiDetails();
        if(apiModel != null){
            return "City: " + apiModel.getCity() + 
            "\nMaximum temperature: " + apiModel.getMaximumtemp() + 
            "\nMinimum temperature: " + apiModel.getMinimumtemp() + 
            "\nPressure: " + apiModel.getPressure() + 
            "\nHumidity: " + apiModel.getHumidity() + 
            "\nFells Like: " + apiModel.getFeelslike();
        }
        else{
            return "No weather details is there";
        }
    }
}
