package com.prasanth.cryptolist.webservice;

import com.prasanth.cryptolist.datamodel.CryptoSet;
import com.prasanth.cryptolist.datamodel.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Webservice {
    @GET("ticker/")
    Call<CryptoSet> getCurrencies(@Query("limit") int limit);

    @GET("posts/")
    Call<List<Post>> getPosts();
}
