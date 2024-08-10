package com.example.stockmarket.stockcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

import com.example.stockmarket.stockdata.StockData;
import com.example.stockmarket.stockservice.StockService;

@RestController
@RequiredArgsConstructor
public class StockController{

    private final StockService stockService;

    @PostMapping("/stockname")
    public String PostStockName(@RequestBody StockData stockData){
        String stockName = stockData.getStockName();
        stockService.inputStockName(stockName);
        return "Stock name updated successfully";
    }

    @SuppressWarnings("null")
    @GetMapping("/stockdetails")
    public String getStockDetails() {
        StockData stockData = stockService.StockDetails();
        if (stockData != null) {
            return "Stock Name: " + stockData.getStockName() +
                   "\nOpening Price: " + stockData.getOpenPrice() +
                   "\nClosing Price: " + stockData.getClosePrice();
        } else {
            return "No data available for the stock: " + stockData.getStockName();
        }
    }

    
}