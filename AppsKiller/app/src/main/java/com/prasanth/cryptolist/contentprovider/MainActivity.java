package com.prasanth.cryptolist.contentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.prasanth.cryptolist.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.ret).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRetrieveStudents(view);
            }
        });
    }

    public void onClickAddName(View view) {

    }

    public void onClickRetrieveStudents(View view) {
        // Retrieve student records
        String URL = "content://com.example.MyApplication.StudentsProvider";

        Uri students = Uri.parse(URL);
        Cursor c = getContentResolver().query(students, null, null, null, "name");

        if (c.moveToFirst()) {
            do {
                Toast.makeText(this,
                        c.getString(c.getColumnIndex("_id")) +
                                ", " + c.getString(c.getColumnIndex("item")),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }
}

