package com.example.id1.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ApiResponse {


    private Main main;

    @Data
    public static class Main{
        @JsonProperty("temp_max")
        private String maxtemp;
        @JsonProperty("temp_min")
        private String mintemp;
        @JsonProperty("pressure")
        private String pressure;
        @JsonProperty("humidity")
        private String humidity;
        @JsonProperty("feels_like")
        private String feelslike;
    }

}
