package com.example.id3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.id3.model.apimodel;
import com.example.id3.service.apiservice;

@RestController
public class apicontroller {
    apiservice apiserviceobject;
    @Autowired
    public void setApiserviceobject(apiservice apiserviceobject) {
        this.apiserviceobject = apiserviceobject;
    }
    @PostMapping("/inputcity")
    public String setCity(@RequestBody apimodel apimodelobject){
        
        String city = apimodelobject.getCity();
        apiserviceobject.setCityname(city);

        return "City updated successfully";
    }

    @GetMapping("/details")
    public String getDetails(){
        apimodel apimodelobject = apiserviceobject.getweatherdetails();
        if(apimodelobject != null){
            return "City: " + apimodelobject.getCity()
            +"\nMinimumTemp: " + apimodelobject.getMinimumtemperature()+
            "\nMaximumTemp: " + apimodelobject.getMaximumtemperature()+
            "\nPressure: " + apimodelobject.getPressure()+
            "\nHumidity: " + apimodelobject.getHumidity()+
            "\nFeels Like: " + apimodelobject.getFeelslike();
        }
        else{
            return "There is no any details about this city";
        }
    }
}
