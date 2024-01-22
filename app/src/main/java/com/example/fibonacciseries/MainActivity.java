package com.example.fibonacciseries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText positionEditText;
    private TextView numberResult, sumResult;
    private Button obtainButton, sumButton;
    private final Fibonacci fibonacci = new Fibonacci();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initItems();
        initListeners();
    }

    public void initItems() {
        positionEditText = findViewById(R.id.position_number);
        numberResult = findViewById(R.id.number_result_text);
        sumResult = findViewById(R.id.sum_result_text);
        obtainButton = findViewById(R.id.obtain_button);
        sumButton = findViewById(R.id.sum_button);
    }

    public void initListeners() {
        obtainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(positionEditText.getText().toString());

                if (position > 0) {
                    long number = calculateNumber(position);
                    String result = "El número que ocupa la posición " + position + " en la serie de Fibonacci es el " + number;
                    numberResult.setText(result);
                    numberResult.setVisibility(View.VISIBLE);
                } else {
                    positionEditText.setError(getText(R.string.number_error));
                }

            }
        });

        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(positionEditText.getText().toString());

                if (position > 0) {
                    int sum = sumNumbers();
                    String result = "La suma de los " + position + " primeros números de Fibonacci es " + sum;
                    sumResult.setText(result);
                    sumResult.setVisibility(View.VISIBLE);
                } else {
                    positionEditText.setError(getText(R.string.number_error));
                }
            }
        });
    }

    public long calculateNumber(int position) {
        return fibonacci.calculate(position);
    }

    public int sumNumbers() {
        return fibonacci.sum();
    }
}