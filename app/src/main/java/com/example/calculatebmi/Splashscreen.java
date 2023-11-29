package com.example.calculatebmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Intent ih = new Intent(Splashscreen.this, login.class);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(ih);
                finish();
            }
        }, 3000);
    }
}