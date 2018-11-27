package com.prasanth.cryptolist.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import com.prasanth.cryptolist.R;
import com.prasanth.cryptolist.service.SampleBackgroundService;

public class ServiceStarter extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_starter);

        bindService(new Intent(this, SampleBackgroundService.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                SampleBackgroundService.SampleBinder service = (SampleBackgroundService.SampleBinder) iBinder;
                Toast.makeText(ServiceStarter.this, service.getService().getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, BIND_AUTO_CREATE);

    }
}
