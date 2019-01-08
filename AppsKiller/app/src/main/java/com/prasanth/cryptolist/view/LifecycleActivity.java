package com.prasanth.cryptolist.view;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.prasanth.cryptolist.R;
import com.prasanth.cryptolist.reciever.SampleReceiver;

public class LifecycleActivity extends AppCompatActivity {
    String msg = "Android : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d(msg, "The onCreate() event");
        findViewById(R.id.opn_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("com.prasanth.sample");
                sendBroadcast(intent);

                //startActivity(new Intent(LifecycleActivity.this, CryptoListActivity.class));
            }
        });

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.prasanth.sample");
        registerReceiver(new SampleReceiver(), filter);
    }

    @Override
    protected void onRestart() {
        Log.d(msg, "The onReStart() event");
        super.onRestart();
    }

    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /**
     * Called when the activity has become visible.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /**
     * Called when another activity is taking focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /**
     * Called just before the activity is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }

}
