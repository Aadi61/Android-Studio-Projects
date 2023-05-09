package com.example.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GPA extends AppCompatActivity {
    RecyclerView recyclerView;
    ItemAdapter adapter;
    List<CourseModel> itemList=new ArrayList<CourseModel>();
    ArrayList<String> creditsValues= new ArrayList<String>();
    ItemAdapter obj=new ItemAdapter(itemList);
    String c="";
    TextView sum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);
        sum=findViewById(R.id.sum);
        Intent i=getIntent();
        String num=i.getStringExtra("courses");

        int n=Integer.parseInt(num);
        sum.setText(Sum(creditsValues,n));
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for(int j=0;j<n;j++){
            itemList.add(new CourseModel("Credits","Grade",new String[]{"1","1.5","2","3","4","5","20"},new String[]{"S","A","B","C","D","E","F","N"},0,0));

        }
        adapter=new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);




    }
    public String Sum(ArrayList<String> Credits,int n){
        Credits=obj.getSelectedCreditValues();
        String c="";
        if (Credits.size()==0){
            return "AD";
        }
        for(int j=0;j<Credits.size();j++){
            c+=Credits.get(j);
        }
        return c;
    }
}