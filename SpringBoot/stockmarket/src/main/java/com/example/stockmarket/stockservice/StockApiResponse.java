package com.example.stockmarket.stockservice;

import java.util.List;


public class StockApiResponse {

    List<StockResult> results;

    public List<StockResult> getResults() {
        return results;
    }

    public void setResults(List<StockResult> results) {
        this.results = results;
    }

    public static class StockResult {

        private double o;

        private double c;

        public double getO() {
            return o;
        }

        public void setO(double o) {
            this.o = o;
        }

        public double getC() {
            return c;
        }

        public void setC(double c) {
            this.c = c;
        }
    }
}
