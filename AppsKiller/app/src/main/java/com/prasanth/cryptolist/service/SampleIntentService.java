package com.prasanth.cryptolist.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class SampleIntentService extends IntentService {


    public SampleIntentService() {
        super("SampleIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        System.out.println("XXXXXXXXX Hello Intent");
    }
}
