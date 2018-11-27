package com.prasanth.cryptolist.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetroRequest {

    private static final RetroRequest request = new RetroRequest();

    private RetroRequest() {
    }

    public static RetroRequest getRequest() {
        return request;
    }

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.coinmarketcap.com/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    private Retrofit localRetrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.43.73:3000/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public Retrofit getLocalRetrofit() {
        return localRetrofit;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
