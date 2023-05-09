package com.example.gpacalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<CourseModel> listData;
    private ArrayList<String> selectedCreditValues;
    private ArrayList<String> selectedGradeValues;
    public ItemAdapter(List<CourseModel> listData){
        this.listData=listData;
        this.selectedCreditValues = new ArrayList<>();
        this.selectedGradeValues = new ArrayList<>();
    }




    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater=LayoutInflater.from((parent.getContext()));
       View listItem=inflater.inflate(R.layout.recyclerview_item,parent,false);
       ItemViewHolder viewHolder=new ItemViewHolder(listItem);
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        CourseModel item=listData.get(position);
        holder.textView1.setText(item.getCredits());
        holder.textView2.setText(item.getGrade());

        ArrayAdapter<String> spinnerAdapter1=new ArrayAdapter<>(holder.itemView.getContext(), android.R.layout.simple_spinner_item,item.getCreditSpinner());
        spinnerAdapter1.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        holder.spinner1.setAdapter(spinnerAdapter1);
        holder.spinner1.setSelection(item.getCreditSpinnerSelection());
        holder.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item.setCreditSpinnerSelection(position);
                if (position >= selectedCreditValues.size()) {
                    // Add empty values to the array until the position is valid
                    while (selectedCreditValues.size() <= position) {
                        selectedCreditValues.add("");
                    }
                }
                selectedCreditValues.set(position, item.getCredits());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> spinnerAdapter2=new ArrayAdapter<String>(holder.itemView.getContext(),android.R.layout.simple_spinner_item,item.getGradeSpinner());
        spinnerAdapter2.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        holder.spinner2.setAdapter(spinnerAdapter2);
        holder.spinner2.setSelection(item.getGradeSpinnerSelection());
        holder.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item.setGradeSpinnerSelection(position);
                selectedGradeValues.set(position, item.getGrade());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public ArrayList<String> getSelectedCreditValues() {
        return selectedCreditValues;
    }

    public ArrayList<String> getSelectedGradeValues() {
        return selectedGradeValues;
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView textView1;
        public TextView textView2;
        public Spinner spinner1;
        public Spinner spinner2;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textView1=itemView.findViewById(R.id.textView2);
            this.textView2=itemView.findViewById(R.id.textView3);
            this.spinner1=itemView.findViewById(R.id.spinner1);
            this.spinner2=itemView.findViewById(R.id.spinner2);
        }
    }



}
