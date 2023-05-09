package com.example.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num=editText.getText().toString();
                int n =Integer.parseInt(num);
                if(n>60){
                    Toast.makeText(getApplicationContext(),"No. of courses should be less than 10", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent i = new Intent(getApplicationContext(),GPA.class);
                    i.putExtra("courses",num);
                    startActivity(i);
                }
            }
        });
    }
}