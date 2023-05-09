package com.example.mynotes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    MyDatabaseHelper db;
    ArrayList<String> notes_id;
    ArrayList<String> notes_title,notes_content;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        floatingActionButton=findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i =new Intent(MainActivity.this,AddActivity.class);
            startActivity(i);
            }
        });
        db=new MyDatabaseHelper(MainActivity.this);
        notes_id=new ArrayList<>();
        notes_title=new ArrayList<>();
        notes_content=new ArrayList<>();

        storeDataInArrays();
        customAdapter=new CustomAdapter(MainActivity.this,notes_id,notes_title,notes_content,this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor= db.readAllDate();
        if(cursor.getCount()==0){
            Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                notes_id.add(cursor.getString(0));
                notes_title.add(cursor.getString(1));
                notes_content.add(cursor.getString(2));
            }
        }
    }

}