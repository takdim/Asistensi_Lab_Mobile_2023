package com.example.tuprak_2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnTambah, btnKurang, btnHapus, btnKali, btnBagi, btnReset, btnHasil;
    EditText editText;
    String process, res;
    Boolean operator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editText);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnBagi = findViewById(R.id.btnBagi);
        btnKali = findViewById(R.id.btnKali);

        btnReset = findViewById(R.id.btnReset);
        btnHapus = findViewById(R.id.btnHapus);

        btnHasil = findViewById(R.id.btnHasil);

        process = "";
        res = "";


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                displayOne();
                displayTwo();
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty()){
                    clear();
                    process = process + "0";
                    displayOne();
                } else {
                    if (process.equals("0")){
                        process = "0";
                        displayOne();
                    }else {
                        process = process + "0";
                        displayOne();
                    }

                }
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty()){
                    clear();
                    process = process + "1";
                    displayOne();
                } else {
                    if (process.equals("0")){
                        process = "";
                        process += "1";
                        displayOne();
                    } else {
                        process += "1";
                        displayOne();
                    }
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty()){
                    clear();
                    process = process + "2";
                    displayOne();
                } else {
                    if (process.equals("0")){
                        process = "";
                        process = process + "2";
                        displayOne();
                    } else {
                        process = process + "2";
                        displayOne();
                    }
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty()){
                    clear();
                    process = process + "3";
                    displayOne();
                } else {
                    if (process.equals("0")){
                        process = "";
                        process = process + "3";
                        displayOne();
                    } else {
                        process = process + "3";
                        displayOne();
                    }
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty()){
                    clear();
                    process = process + "4";
                    displayOne();
                } else {
                    if (process.equals("0")){
                        process = "";
                        process = process + "4";
                        displayOne();
                    } else {
                        process = process + "4";
                        displayOne();
                    }
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty()){
                    clear();
                    process = process + "5";
                    displayOne();
                } else {
                    if (process.equals("0")){
                        process = "";
                        process = process + "5";
                        displayOne();
                    } else {
                        process = process + "5";
                        displayOne();
                    }
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty()){
                    clear();
                    process = process + "6";
                    displayOne();
                } else {
                    if (process.equals("0")){
                        process = "";
                        process = process + "6";
                        displayOne();
                    } else {
                        process = process + "6";
                        displayOne();
                    }
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty()){
                    clear();
                    process = process + "7";
                    displayOne();
                } else {
                    if (process.equals("0")){
                        process = "";
                        process = process + "7";
                        displayOne();
                    } else {
                        process = process + "7";
                        displayOne();
                    }
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty()){
                    clear();
                    process = process + "8";
                    displayOne();
                } else {
                    if (process.equals("0")){
                        process = "";
                        process = process + "8";
                        displayOne();
                    } else {
                        process = process + "8";
                        displayOne();
                    }
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty()){
                    clear();
                    process = process + "9";
                    displayOne();
                } else {
                    if (process.equals("0")){
                        process = "";
                        process = process + "9";
                        displayOne();
                    } else {
                        process = process + "9";
                        displayOne();
                    }
                }
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator == false){
                    process = process + " + ";
                    operator = true;
                }
                displayOne();
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator == false){
                    process = process + " - ";
                    operator = true;
                }
                displayOne();
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator == false){
                    process = process + " x ";
                    operator = true;
                }
                displayOne();
            }
        });


        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator == false){
                    process = process + " ÷ ";
                    operator = true;
                }
                displayOne();
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                del();
                displayOne();
            }
        });

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator == true && !process.substring(process.length()-1, process.length()).equals("")){
                    String [] tokens = process.split(" ");
                    switch (tokens[1].charAt(0)){
                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;
                        case '÷':
                            res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;
                        case 'x':
                            res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;
                    }
                    displayTwo();
                }
            }
        });
    }

    private void del() {
        if (!process.substring(process.length()-1, process.length()).equals(" ")){
            process = process.substring(0, process.length()-1);
            operator = false;
        } else {
            process = process.substring(0, process.length()-1);
        }
    }

    public void displayOne(){

        editText.setText(process);
    }
    public void displayTwo(){

        editText.setText(res);
    }
    public void clear(){
        res = "";
        process = "";
        operator = false;
    }
}