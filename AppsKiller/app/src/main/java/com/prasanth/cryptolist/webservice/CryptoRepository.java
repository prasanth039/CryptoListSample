package com.prasanth.cryptolist.webservice;

import android.arch.lifecycle.MutableLiveData;

import com.prasanth.cryptolist.datamodel.CryptoSet;
import com.prasanth.cryptolist.datamodel.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CryptoRepository {
    private Webservice webservice;
    private Webservice localWebservice;

    private static final String TAG = CryptoRepository.class.getSimpleName();

    public CryptoRepository() {
        this.webservice = RetroRequest.getRequest().getRetrofit().create(Webservice.class);
        this.localWebservice = RetroRequest.getRequest().getLocalRetrofit().create(Webservice.class);
    }

    public MutableLiveData<CryptoSet> getCryptoList() {

        final MutableLiveData<CryptoSet> data = new MutableLiveData<>();
        webservice.getCurrencies(20).enqueue(new Callback<CryptoSet>() {
            @Override
            public void onResponse(Call<CryptoSet> call, Response<CryptoSet> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CryptoSet> call, Throwable t) {
            }
        });
        return data;
    }

    public MutableLiveData<List<Post>> getPosts() {
        final MutableLiveData<List<Post>> data = new MutableLiveData<>();
        localWebservice.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
        return data;
    }
}
