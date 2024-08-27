package com.example.id2.service;

import lombok.Data;

@Data
public class apiresponse {

    
    @Data
    public static class Main{
        private double temp_min;
        private double temp_max;
        private double pressure;
        private double humidity;
        private double feels_like;

    }

    private Main main;


    public Main getMain() {
        return main;
    }


    
}
