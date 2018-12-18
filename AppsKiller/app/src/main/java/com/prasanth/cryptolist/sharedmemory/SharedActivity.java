package com.prasanth.cryptolist.sharedmemory;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.prasanth.cryptolist.R;
import com.prasanth.cryptolist.sharedmemory.client.ShmClientLib;
import com.prasanth.cryptolist.sharedmemory.server.ShmLib;

public class SharedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        ShmLib.OpenSharedMem("sh1", 1000, true);
        ShmLib.setValue("sh1", 10, 200); //sh1[10] = 200
        int v = ShmLib.getValue("sh1", 10);
        Toast.makeText(this, "" + v, Toast.LENGTH_SHORT).show();

        bindService(new Intent("com.example.developer.testashmem.ShmService")
                .setPackage("com.example.developer.testashmem"), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                ISharedMem ShmMemService = ISharedMem.Stub.asInterface(iBinder);
                try {
                    ParcelFileDescriptor p = ShmMemService.OpenSharedMem("sh1", 1000, false);
                    int fd = p.getFd();
                    ShmClientLib.setMap(p.getFd(), 1000);
                    int v = ShmLib.getValue("sh1", 10);
                    Toast.makeText(SharedActivity.this, "" + v, Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, BIND_AUTO_CREATE);


    }
}
