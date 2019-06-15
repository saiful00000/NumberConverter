package com.example.numberconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner inputSpinner, outputSpinner;
    private EditText inputEt;
    private EditText decimalOutputTv, binaryOutputTv, octalOutputTv, hexOutputTv;
    private Button convertBtn;

    private String inputType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // spinner contents
        final String[] spinnerList = {"Decimal", "Binary", "Octal", "Hex"};

        inputSpinner = findViewById(R.id.input_spinner_id);
        inputEt = findViewById(R.id.input_et_id);
        convertBtn = findViewById(R.id.convert_btn_id);
        decimalOutputTv = findViewById(R.id.decimal_output_et_id);
        binaryOutputTv = findViewById(R.id.binary_output_et_id);
        octalOutputTv = findViewById(R.id.octal_output_et_id);
        hexOutputTv = findViewById(R.id.hexa_output_et_id);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        inputSpinner.setAdapter(adapter);

        inputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputType = spinnerList[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputNumber = inputEt.getText().toString();
                if (inputType == "Decimal"){
                    int n = NumberConverter.ifDecimal(inputNumber);
                    if (NumberConverter.sign == "-") {
                        decimalOutputTv.setText("-" + Integer.toString(n));
                        binaryOutputTv.setText("-" + Integer.toBinaryString(n));
                        octalOutputTv.setText("-" + Integer.toOctalString(n));
                        hexOutputTv.setText("-" + Integer.toHexString(n));
                    }else {
                        decimalOutputTv.setText(Integer.toString(n));
                        binaryOutputTv.setText(Integer.toBinaryString(n));
                        octalOutputTv.setText(Integer.toOctalString(n));
                        hexOutputTv.setText(Integer.toHexString(n));
                    }
                    NumberConverter.sign = "";
                }
            }
        });


    }

}

































