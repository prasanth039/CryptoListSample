package com.prasanth.cryptolist.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.prasanth.cryptolist.R;

public class MessengerStartActivity extends AppCompatActivity {

    private Messenger messenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger_start);
        Intent i = new Intent();
        i.setClassName("com.prasanth.appskiller", "com.prasanth.cryptolist.service.MessengerService");
        bindService(i, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                messenger = new Messenger(iBinder);
                Message message = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString("data", "google");
                message.replyTo = new Messenger(new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        Toast.makeText(MessengerStartActivity.this,
                                "" + msg.getData().getString("result"),
                                Toast.LENGTH_SHORT).show();
                    }
                });
                try {
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Service.BIND_AUTO_CREATE);
    }
}
