package com.prasanth.cryptolist.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class SampleBackgroundService extends Service {
    private final IBinder mBinder = new SampleBinder();

    public class SampleBinder extends Binder {
        public SampleBackgroundService getService() {
            return SampleBackgroundService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "onStartCommand", Toast.LENGTH_SHORT).show();
        return Service.START_NOT_STICKY;
    }

    public String getText() {
        return SampleBackgroundService.class.getSimpleName();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
