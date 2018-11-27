package com.prasanth.cryptolist.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.prasanth.cryptolist.datamodel.Post;
import com.prasanth.cryptolist.webservice.CryptoRepository;

import java.util.List;

public class PostsListViewModel extends ViewModel {

    private CryptoRepository cryptoRepository;

    public PostsListViewModel() {
        cryptoRepository = new CryptoRepository();
    }

    private MutableLiveData<List<Post>> posts;

    public MutableLiveData<List<Post>> getPosts() {
        initList();
        return posts;
    }

    public void initList() {
        if (posts != null) {
            return;
        }
        posts = cryptoRepository.getPosts();
    }

}
