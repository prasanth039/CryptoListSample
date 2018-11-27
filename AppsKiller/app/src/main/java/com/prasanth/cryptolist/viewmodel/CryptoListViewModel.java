package com.prasanth.cryptolist.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.prasanth.cryptolist.datamodel.CryptoSet;
import com.prasanth.cryptolist.webservice.CryptoRepository;

public class CryptoListViewModel extends ViewModel {

    private CryptoRepository cryptoRepository;

    public CryptoListViewModel() {
        cryptoRepository = new CryptoRepository();
    }

    private MutableLiveData<CryptoSet> cryptoList;

    public MutableLiveData<CryptoSet> getCryptoList() {
        initList();
        return cryptoList;
    }

    public void initList() {
        if (cryptoList != null) {
            return;
        }
        cryptoList = cryptoRepository.getCryptoList();
    }

}
