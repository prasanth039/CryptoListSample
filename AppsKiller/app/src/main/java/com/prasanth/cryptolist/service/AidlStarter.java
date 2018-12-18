package com.prasanth.cryptolist.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.prasanth.cryptolist.R;

public class AidlStarter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_starter);
        Intent i = new Intent();
        i.setClassName( "com.prasanth.appskiller", "com.prasanth.cryptolist.service.AidlService" );
        bindService(i, serviceConnection, Service.BIND_AUTO_CREATE);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IAdd addService = IAdd.Stub.asInterface(iBinder);
            try {
                Toast.makeText(AidlStarter.this, ""+ addService.addNumbers(300, 500), Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
