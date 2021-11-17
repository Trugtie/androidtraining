package com.example.firstmathproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PhuongTrinhBacMotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phuong_trinh_bac_mot);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button btnPTB1 = findViewById(R.id.btnPTB1);

        btnPTB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etxtSoA1= findViewById(R.id.etxtSoA1);
                EditText etxtSoB1= findViewById(R.id.etxtSoB1);
                TextView txtPTB1=findViewById(R.id.txtPTB1);
                if(!etxtSoA1.getText().toString().isEmpty() && !etxtSoB1.getText().toString().isEmpty()){
                    double a= Double.parseDouble(etxtSoA1.getText().toString());
                    double b= Double.parseDouble(etxtSoB1.getText().toString());

                    txtPTB1.setText(String.valueOf(a) +  "x + " + String.valueOf(b) + " = 0" );
                    phuongTrinhBac1(a,b);
                }
            }
        });
    }

    protected void phuongTrinhBac1(double a, double b){
        if(a == 0 && b == 0){
            Toast.makeText(PhuongTrinhBacMotActivity.this,"PTB1 co vo so nghiem", Toast.LENGTH_LONG).show();
        }
        else if(a==0 && b!=0){
            Toast.makeText(PhuongTrinhBacMotActivity.this,"PTB1 vo nghiem", Toast.LENGTH_LONG).show();
        }
        else{
            double c=-b/a;
            Toast.makeText(PhuongTrinhBacMotActivity.this,"PTB1 co nghiem x = " + String.valueOf(c), Toast.LENGTH_LONG).show();
        }
    }
}