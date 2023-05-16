package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Boolean lastNumericValue=false;
    Boolean lastDecimalValue=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void digit(View view){
        textView=findViewById(R.id.textView);
        Button btn=(Button) view;
        lastNumericValue=true;

        textView.append(btn.getText());
    }

    public  void onClear(View view){
        textView.setText("");
        lastDecimalValue=false;
        lastNumericValue=false;
    }
    public void onDecimalPoint(View view){
        if(!lastDecimalValue && lastNumericValue){
            textView.append(".");
            lastNumericValue=false;
            lastDecimalValue=true;
        }


    }

    public void onOperator(View view){
        if(lastNumericValue && !isOperatorAdded(textView.getText().toString())){
            Button btn=(Button) view;
            lastNumericValue=false;
            lastDecimalValue=false;
            textView.append(btn.getText());
        }
    }

    public void onEqual(View view){
        if(lastNumericValue){
            String txtval=textView.getText().toString();
            String prefix="";
            if(txtval.startsWith("-")){
                prefix="-";
                txtval=txtval.substring(1);

            }
            if (txtval.contains("-")) {
                String values[] = txtval.split("-");
                String one = values[0];
                String two = values[1];

                if (!prefix.isEmpty()) {
                    one = one + prefix;
                }
                Double operand1 = Double.parseDouble(one);
                Double operand2 = Double.parseDouble(two);
                Double result = operand1 - operand2;
                textView.setText(removeZero(Double.toString(result)));
            }
            else if(txtval.contains("X")) {
                String values[] = txtval.split("X");
                String one = values[0];
                String two = values[1];

                if (!prefix.isEmpty()) {
                    one = one + prefix;
                }
                Double operand1 = Double.parseDouble(one);
                Double operand2 = Double.parseDouble(two);
                Double result = operand1 * operand2;
                textView.setText(removeZero(Double.toString(result)));
            }
            else if(txtval.contains("/")) {
                String values[] = txtval.split("/");
                String one = values[0];
                String two = values[1];

                if (!prefix.isEmpty()) {
                    one = one + prefix;
                }
                Double operand1 = Double.parseDouble(one);
                Double operand2 = Double.parseDouble(two);
                Double result = operand1 / operand2;
                textView.setText(removeZero(Double.toString(result)));
            }

            else if(txtval.contains("+")) {
                String values[] = txtval.split("\\+");
                String one = values[0];
                String two = values[1];

                if (!prefix.isEmpty()) {
                    one = one + prefix;
                }
                Double operand1 = Double.parseDouble(one);
                Double operand2 = Double.parseDouble(two);
                Double result = operand1 + operand2;
                textView.setText(removeZero(Double.toString(result)));
            }
        }
    }


    private Boolean isOperatorAdded(String value){
        if(value.startsWith("-")){
            return false;
        }
        else{
            return (value.contains("+")|| value.contains("-")|| value.contains("/") || value.contains("X"));
        }
    }

    private String removeZero(String val){
        if(val.contains(".0")){
            val=val.substring(0,val.length()-2);
        }
        return val;
    }


}