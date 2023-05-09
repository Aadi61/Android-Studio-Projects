package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyActivity extends AppCompatActivity {

    TextView textView2,textView3;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky);

        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView4);
        btn1=findViewById(R.id.button2);

        Intent i = getIntent();
        String userName= i.getStringExtra("name");

        Toast.makeText(this,"UserName: "+userName, Toast.LENGTH_LONG).show();
        int RandomNumb= GenerateRandomNumber();
        textView3.setText(" "+RandomNumb);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareData(userName,RandomNumb);
            }
        });

    }
    public int GenerateRandomNumber()
    {
        int rand;
        Random rnd=new Random();
        rand=rnd.nextInt(1000);
        return rand;

    }
    public void ShareData(String UserName,int RandNumb)
    {
        //Explicit Intent
        Intent i =new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT, UserName);
        i.putExtra(Intent.EXTRA_TEXT,RandNumb);

        startActivity(Intent.createChooser(i, "Choose a platform: "));

    }

}