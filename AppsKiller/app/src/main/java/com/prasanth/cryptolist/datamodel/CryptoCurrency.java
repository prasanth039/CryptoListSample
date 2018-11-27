package com.prasanth.cryptolist.datamodel;

import java.util.LinkedHashMap;

public class CryptoCurrency {
    private int id;
    private String name;
    private String symbol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    private LinkedHashMap<String, Quote> quotes;

    public LinkedHashMap<String, Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(LinkedHashMap<String, Quote> quotes) {
        this.quotes = quotes;
    }
}
