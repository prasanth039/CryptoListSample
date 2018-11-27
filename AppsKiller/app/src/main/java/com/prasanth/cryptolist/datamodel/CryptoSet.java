package com.prasanth.cryptolist.datamodel;

import java.util.LinkedHashMap;

public class CryptoSet {

//    private ArrayList<CryptoCurrency> data;
//
//    public ArrayList<CryptoCurrency> getData() {
//        return this.data;
//    }
//
//    public void setData(ArrayList<CryptoCurrency> data) {
//        this.data = data;
//    }


    private LinkedHashMap<String, CryptoCurrency> data;

    public LinkedHashMap<String, CryptoCurrency> getData() {
        return data;
    }

    public void setData(LinkedHashMap<String, CryptoCurrency> data) {
        this.data = data;
    }
}
