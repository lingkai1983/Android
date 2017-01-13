package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        String[] words = {"One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine", "Ten"};
        for (int i = 0; i < words.length; i++) {
            Log.v("Number Activity", "Word at Index " + i + " is " + words[i]);
        }

    }
}
