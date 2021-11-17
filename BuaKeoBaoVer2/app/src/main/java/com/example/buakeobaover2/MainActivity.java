package com.example.buakeobaover2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnBua, btnKeo, btnBao;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1000){
            if(resultCode==RESULT_OK){
                txtResult = findViewById(R.id.txtResult);
                String result = data.getStringExtra("returnString");
                txtResult.setText(result);
            }
        }
    }

    private void init(){
        btnKeo = findViewById(R.id.btnKeo);
        btnBao = findViewById(R.id.btnBao);
        btnBua = findViewById(R.id.btnBua);

        btnKeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("data",1);
                startActivityForResult(intent,1000);
            }
        });

        btnBua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("data",0);
                startActivityForResult(intent,1000);
            }
        });

        btnBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("data",2);
                startActivityForResult(intent,1000);
            }
        });
    }
}