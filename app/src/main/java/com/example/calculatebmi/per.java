package com.example.calculatebmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class per extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per);

        toolbar = findViewById(R.id.toolid2);
//step 1
        setSupportActionBar(toolbar);

        //step 2

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}