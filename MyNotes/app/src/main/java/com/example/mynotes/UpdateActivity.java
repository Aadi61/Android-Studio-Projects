package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText titleText2,contentText2;
    Button updateButton;
    String id,title,content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        titleText2=findViewById(R.id.titleText2);
        contentText2=findViewById(R.id.contentText2);
        updateButton=findViewById(R.id.updateButton);
        getIntentAndSetData();
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            MyDatabaseHelper myDB=new MyDatabaseHelper(UpdateActivity.this);
            title =titleText2.getText().toString().trim();
            content=contentText2.getText().toString().trim();
                myDB.Update(id,title,content);
            }
        });
    }

    void getIntentAndSetData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("content")){
            id=getIntent().getStringExtra("id");
            title=getIntent().getStringExtra("title");
            content=getIntent().getStringExtra("content");

            titleText2.setText(title);
            contentText2.setText(content);
        }
        else{
            Toast.makeText(UpdateActivity.this,"No Data",Toast.LENGTH_SHORT).show();
        }
    }

}