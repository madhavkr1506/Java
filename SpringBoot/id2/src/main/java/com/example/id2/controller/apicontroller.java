package com.example.id2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.id2.model.apimodel;
import com.example.id2.service.apiservice;

@RestController
public class apicontroller {

    apiservice apiserviceobject;
    
    @Autowired
    public void setApiserviceobject(apiservice apiserviceobject) {
        this.apiserviceobject = apiserviceobject;
    }


    @PostMapping("/inputcity")
    public String inputcity(@RequestBody apimodel apimodel){

        String city = apimodel.getCity();
        apiserviceobject.setCity(city);


        return "City successfully updated";
    }


    @GetMapping("/details")
    public String getDetails(){
        apimodel apimodelobject = apiserviceobject.getweatherdetails();
        if(apimodelobject != null){
            return "City: " + apimodelobject.getCity()+
            "\nMinimumTemp: " + apimodelobject.getMinimumtemperature()+
            "\nMaximumTemp: " + apimodelobject.getMaximumtemperature()+
            "\nPressure: " + apimodelobject.getPressure()+
            "\nHumidity: " + apimodelobject.getHumidity()+
            "\nFeelsLike: " + apimodelobject.getFeelslike();
        }
        else{
            return "There is no record for the input city";
        }
    }
}
