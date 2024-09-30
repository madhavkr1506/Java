package com.example.id1.model;

import lombok.Data;

@Data
public class ApiModel {
    private String city;
    private String minimumtemp;
    private String maximumtemp;
    private String pressure;
    private String feelslike;
    private String humidity;
}
