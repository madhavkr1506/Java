package com.example.id2.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



import com.example.id2.model.apimodel;

@Service
public class apiservice {
    
    private String cityname;

    public void setCity(String cityname){
        this.cityname = cityname;
    }

    private apiresponse apiresponseobject;

    public apimodel getweatherdetails(){

        try{

            if(cityname == null ){
                return null;
            }
            String url = "https://api.openweathermap.org/data/2.5/weather?q="+cityname+"&appid=1abda653c4c413b0f3be7e69d5ce7e12";


            RestTemplate restTemplate = new RestTemplate();

            apiresponseobject = restTemplate.getForObject(url, apiresponse.class);

            if(apiresponseobject != null){
                double minimumtemperature = apiresponseobject.getMain().getTemp_min();
                double maximumtemperature = apiresponseobject.getMain().getTemp_max();
                double pressure = apiresponseobject.getMain().getPressure();
                double humidity = apiresponseobject.getMain().getHumidity();
                double feelslike = apiresponseobject.getMain().getFeels_like();


                apimodel apimodelobject = new apimodel();

                apimodelobject.setCity(cityname);
                apimodelobject.setMinimumtemperature(minimumtemperature);
                apimodelobject.setMaximumtemperature(maximumtemperature);
                apimodelobject.setPressure(pressure);
                apimodelobject.setHumidity(humidity);
                apimodelobject.setFeelslike(feelslike);

                return apimodelobject;
                


            }else{
                return null;
            }

            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    

}
