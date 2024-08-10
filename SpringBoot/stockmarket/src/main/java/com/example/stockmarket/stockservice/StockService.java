package com.example.stockmarket.stockservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.stockmarket.stockdata.StockData;

@Service
public class StockService {

    private String stockname = "TM";

    public String inputStockName(String stockName) {
        this.stockname = stockName;
        return "Stock name saved successfully";
    }

    public StockData StockDetails() {
        String apiKey = "Pj2sScjXDkRmxrVTEQNMKZv8xpDw2C8J";
        String baseUrl = "https://api.polygon.io/v2/aggs/ticker/" + stockname + "/range/1/day/2024-08-09/2024-08-09";

        String url = baseUrl+"?apikey="+apiKey;

        RestTemplate restTemplate = new RestTemplate();

        StockApiResponse response = restTemplate.getForObject(url, StockApiResponse.class);

        if (response != null && response.results != null && !response.results.isEmpty()) {
            double openPrice = response.results.get(0).getO();
            double closePrice = response.results.get(0).getC();

            StockData stockData = new StockData();
            stockData.setStockName(stockname);
            stockData.setOpenPrice(openPrice);
            stockData.setClosePrice(closePrice);
            
            return stockData;
        } else {
            return null;
        }
    }
}
