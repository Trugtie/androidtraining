package com.example.firstmathproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PhuongTrinhBacHaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phuong_trinh_bac_hai);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button btnPTB2 = findViewById(R.id.btnPTB2);
        TextView txtPTB2=findViewById(R.id.txtPTB2);
        txtPTB2.setText(Html.fromHtml("ax<sup>2</sup> + bx + c = 0"));
        btnPTB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etxtSoA2= findViewById(R.id.etxtSoA2);
                EditText etxtSoB2= findViewById(R.id.etxtSoB2);
                EditText etxtSoC= findViewById(R.id.etxtSoC);

                TextView txtPTB2=findViewById(R.id.txtPTB2);

                if(!etxtSoA2.getText().toString().isEmpty() && !etxtSoB2.getText().toString().isEmpty() && !etxtSoC.getText().toString().isEmpty()){
                    double a= Double.parseDouble(etxtSoA2.getText().toString());
                    double b= Double.parseDouble(etxtSoB2.getText().toString());
                    double c= Double.parseDouble(etxtSoC.getText().toString());
                    txtPTB2.setText(Html.fromHtml( String.valueOf(a) +"x<sup>2</sup> + " + String.valueOf(b) + "x + " + String.valueOf(c) + " = 0 " ) );
                    phuongTrinhBac2(a,b,c);
                }
            }
        });
    }

    protected void phuongTrinhBac2(double a, double b, double c){

        if (a+b+c == 0 ){
            double x2 = c/a;
            Toast.makeText(PhuongTrinhBacHaiActivity.this, "PTB2 co 2 nghiem phan biet  x1 = 1"  + ", x2 = " + String.valueOf(x2), Toast.LENGTH_LONG).show();
        }
        else if (a-b+c==0){
            double x2 = -c/a;
            Toast.makeText(PhuongTrinhBacHaiActivity.this, "PTB2 co 2 nghiem phan biet  x1 = -1" + ", x2 = " + String.valueOf(x2), Toast.LENGTH_LONG).show();
        }
        else {
            double delta = Math.pow(b,2) - 4 * a *c ;
            if (delta < 0) {
                Toast.makeText(PhuongTrinhBacHaiActivity.this, "PTB2 vo nghiem", Toast.LENGTH_LONG).show();
            } else if (delta == 0) {
                double x = -b / (2 * a);
                Toast.makeText(PhuongTrinhBacHaiActivity.this, "PTB2 co nghiem kep  x1 = x2 = " + String.valueOf(x), Toast.LENGTH_LONG).show();
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                Toast.makeText(PhuongTrinhBacHaiActivity.this, "PTB2 co 2 nghiem phan biet  x1 = " + String.valueOf(x1) + ", x2 = " + String.valueOf(x2), Toast.LENGTH_LONG).show();
            }
        }
    }
}