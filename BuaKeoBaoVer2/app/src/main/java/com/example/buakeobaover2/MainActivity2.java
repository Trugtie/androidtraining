package com.example.buakeobaover2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView txtPlayer,txtComputer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        int data = intent.getIntExtra("data",0);
        init(data);
    }
    private void init(int data){
        txtPlayer=findViewById(R.id.txtPlayer);
        txtComputer=findViewById(R.id.txtComputer);
        int random = random();

        if(data == 0)  txtPlayer.setText("Búa");
        else if(data==1) txtPlayer.setText("Kéo");
        else txtPlayer.setText("Bao");

        if(random == 0)  txtComputer.setText("Búa");
        else if(random==1) txtComputer.setText("Kéo");
        else txtComputer.setText("Bao");

        String result = compare(data,random);
        returnResult(result);

    }

    private void returnResult(String result){
        Intent intent = new Intent();
        intent.putExtra("returnString",result);
        setResult(RESULT_OK,intent);
        finish();
    }

    // 0-bua, 1-keo, 2-bao
    private String compare(int data, int random){
        if (data == random){
            return "Hòa";
        }
        else if((data == 0 && random == 1)||(data == 1 && random == 2)||(data == 2 && random==0)){
            return "Bạn thắng!";
        }
        else{
            return "Thua";
        }
    }


    private int random(){
        int random = (int) Math.floor ((Math.random() * 3));
        return random;
    }
}