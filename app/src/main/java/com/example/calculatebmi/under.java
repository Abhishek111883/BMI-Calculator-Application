package com.example.calculatebmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class under extends AppCompatActivity {


        Toolbar toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under);


        toolbar = findViewById(R.id.toolid1);
//step 1
        setSupportActionBar(toolbar);

        //step 2

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}