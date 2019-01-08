package com.prasanth.cryptolist.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SampleReceiver extends BroadcastReceiver {
    public SampleReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Action: " + intent.getAction(), Toast.LENGTH_SHORT).show();
    }
}

