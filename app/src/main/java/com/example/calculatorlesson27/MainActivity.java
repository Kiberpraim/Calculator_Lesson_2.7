package com.example.calculatorlesson27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Double first =0.0, second = 0.0, result = 0.0;
    private Boolean isOperationClick = false;
    private Boolean isEqualDoubleClick = false;
    private String operationClicked = ".";
    private Boolean dotClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.TextView);
    }


    public void onNumberClick(View view) {
        if (textView.getText().toString().equals("0")||isOperationClick){
            textView.setText(((Button)view).getText());
        }else {
            textView.append(((Button)view).getText());
        }
        isOperationClick = false;
    }

    public void clickClear(View view) {
        textView.setText("0");
        first = 0.;
        second = 0.;
        dotClicked = false;
    }

    public void onOperationClick(View view) {
        operationClicked = (((Button)view).getText().toString());
        first = Double.valueOf(textView.getText().toString());
        isOperationClick = true;
        isEqualDoubleClick = false;
        dotClicked = false;
    }

    public void onEquallyClick(View view) {
        if (isEqualDoubleClick){
            first = Double.valueOf(textView.getText().toString());
        }else {
            second = Double.valueOf(textView.getText().toString());
        }
        switch (operationClicked){
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "×":
                result = first * second;
                break;
            case "÷":
                result = first / second;
                if (second == 0.0){
                    Toast.makeText(MainActivity.this,"Ошибка! На ноль делить нелязя!",Toast.LENGTH_LONG).show();
                }
                break;
        }
        if (result % 1 == 0){
            textView.setText(result.toString().replace(".0",""));
        }else {
        textView.setText(result.toString());
        }
        isEqualDoubleClick = true;
        dotClicked = false;
    }

    public void onPercentClick(View view) {
        textView.setText(Double.toString(Double.valueOf(textView.getText().toString()) * 0.01));
    }

    public void onPlusMinusClick(View view) {
        if (textView.getText().toString().contains("-")){
            textView.setText(textView.getText().toString().replace("-",""));
        }else{
            if(!textView.getText().toString().equals("0")&&!textView.getText().toString().equals("0.")&&!textView.getText().toString().equals("0.0")){
                textView.setText( "-" + textView.getText());

            }
        }
    }

    public void onDotClick(View view) {
        if (!dotClicked){
            textView.append(".");
            dotClicked = true;
        }
    }
}