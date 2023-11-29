package com.example.calculatebmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    // Alert dialog box
    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitdialog = new AlertDialog.Builder(this,R.style.CustomAlertDialogTheme);

        exitdialog.setTitle("Exit");
        exitdialog.setMessage("Are you sure?");
        exitdialog.setIcon(R.drawable.baseline_exit_to_app_24);

        exitdialog.setPositiveButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             Toast.makeText(MainActivity.this,"Welcome back",Toast.LENGTH_SHORT).show();
             dialog.cancel();
            }
        });

        exitdialog.setNegativeButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });

        exitdialog.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"THANKS FOR CANCELLING",Toast.LENGTH_SHORT).show();
            }
        });

        exitdialog.show();
    }

    public void onclick(View view){

            EditText ed0 = findViewById(R.id.edtwt);
            EditText ed1 = findViewById(R.id.edthe);
            EditText ed2 = findViewById(R.id.edtin);

            TextView tx = findViewById(R.id.textView);
            Button bt = findViewById(R.id.button);
            LinearLayout ll = findViewById(R.id.llid);

        int wt = 0;
        int ft = 0;
        int in = 0;
        String inputText = ed0.getText().toString().trim();

// Check if the input value is empty or not an integer
        if (inputText.isEmpty()) {
            Toast.makeText(MainActivity.this, "Weight value is empty", Toast.LENGTH_SHORT).show();
            return;
        } else {
            try {
             //   int wt = Integer.parseInt(inputText);
                 wt = Integer.parseInt(ed0.getText().toString());
                // Input value is not empty and is an integer
                // You can perform further validation or processing here
                if(wt == 0 || wt > 150){
                    Toast.makeText(MainActivity.this, "Please enter a valid weight", Toast.LENGTH_SHORT).show();
                    return; // Stop further execution
                }

            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid input. Please enter an integer.", Toast.LENGTH_SHORT).show();
                return;
            }
        }

            //int wt = Integer.parseInt(ed0.getText().toString());

        String inputText1 = ed1.getText().toString().trim();

// Check if the input value is empty or not an integer
        if (inputText1.isEmpty()) {
            Toast.makeText(MainActivity.this, "Height value is empty", Toast.LENGTH_SHORT).show();
            return;
        } else {
            try {
                //int inputValue = Integer.parseInt(inputText);
                 ft = Integer.parseInt(ed1.getText().toString());
                if(ft == 0 || ft > 15){
                    Toast.makeText(MainActivity.this, "Please enter a valid height", Toast.LENGTH_SHORT).show();
                    return; // Stop further execution
                }
                // Input value is not empty and is an integer
                // You can perform further validation or processing here
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid input. Please enter an integer.", Toast.LENGTH_SHORT).show();
            }
        }


       // int ft = Integer.parseInt(ed1.getText().toString());


        String inputText2 = ed2.getText().toString().trim();

// Check if the input value is empty or not an integer
        if (inputText2.isEmpty()) {
            Toast.makeText(MainActivity.this, "inches value is empty", Toast.LENGTH_SHORT).show();
            return;
        } else {
            try {
                //int inputValue = Integer.parseInt(inputText);
                in = Integer.parseInt(ed2.getText().toString());
                if(in == 0 || in > 12){
                    Toast.makeText(MainActivity.this, "Please enter a valid inches", Toast.LENGTH_SHORT).show();
                    return; // Stop further execution
                }
                // Input value is not empty and is an integer
                // You can perform further validation or processing here
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid input. Please enter an integer.", Toast.LENGTH_SHORT).show();
            }
        }

        Toast.makeText(getApplicationContext(),"Calculating BMI......",Toast.LENGTH_SHORT).show();
            //int in = Integer.parseInt(ed2.getText().toString());



            int totalin = ft*12 + in;

            double totalcm = totalin * 2.53;
            double totalmeter = totalcm/100;

            double BMI = wt/(totalmeter*totalmeter);

            if (BMI > 25){

                Intent iover = new Intent(MainActivity.this, over.class);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(iover);
                    }
                }, 1000);
//                tx.setText("You're OVERWEIGHTED!");
//                ll.setBackgroundColor(getResources().getColor(R.color.overweight));
            } else if (BMI < 18) {
//                tx.setText("You're UNDERWEIGHTED!");
//                ll.setBackgroundColor(getResources().getColor(R.color.underweight));
                Intent iunder = new Intent(MainActivity.this, under.class);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(iunder);
                    }
                }, 1000);

            } else {
//                tx.setText("You're PERFECT!");
//                ll.setBackgroundColor(getResources().getColor(R.color.perfect));
                Intent iper = new Intent(MainActivity.this, per.class);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(iper);
                    }
                }, 1000);
            }


        }
}