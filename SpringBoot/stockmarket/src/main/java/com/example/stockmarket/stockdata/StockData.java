package com.example.stockmarket.stockdata;

import lombok.Data;

@Data
public class StockData{
    private String stockName;
    private double openPrice;
    private double closePrice;
}