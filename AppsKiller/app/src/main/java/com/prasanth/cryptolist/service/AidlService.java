package com.prasanth.cryptolist.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;


public class AidlService extends Service {

    private IAdd.Stub mBinder = new IAdd.Stub() {
        @Override
        public int addNumbers(int num1, int num2) throws RemoteException {
            return num1 + num2;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
