package com.example.firstmathproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonPTB1,buttonPTB2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        buttonPTB1 = findViewById(R.id.btnPTB1Activity);
        buttonPTB2= findViewById(R.id.btnPTB2Activity);

        buttonPTB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent (MainActivity.this, PhuongTrinhBacMotActivity.class);
                startActivity(intent);
            }
        });
        buttonPTB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent (MainActivity.this, PhuongTrinhBacHaiActivity.class);
                startActivity(intent);
            }
        });

    }
}