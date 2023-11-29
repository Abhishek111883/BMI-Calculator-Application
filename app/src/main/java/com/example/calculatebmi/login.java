package com.example.calculatebmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {


    private EditText editTextName;
    private EditText editTextMobile;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextName = findViewById(R.id.editTextName);
        editTextMobile = findViewById(R.id.editTextMobile);
        buttonRegister = findViewById(R.id.buttonRegister);

        Intent ilogin = new Intent(login.this,MainActivity.class);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String mobile = editTextMobile.getText().toString().trim();

                if (name.isEmpty() || mobile.isEmpty()) {
                    Toast.makeText(login.this, "Please enter your details", Toast.LENGTH_SHORT).show();
                    return;
                }else if (mobile.length() < 10||mobile.length() > 10) {
                    Toast.makeText(login.this, "Mobile number should be  10 digits", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    // Perform registration logic here
                    Toast.makeText(login.this,"Welcome to BMI",Toast.LENGTH_SHORT).show();
                    startActivity(ilogin);

                }
            }
        });
    }
}