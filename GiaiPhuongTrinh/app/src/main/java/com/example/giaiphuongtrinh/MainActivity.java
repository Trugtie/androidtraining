package com.example.giaiphuongtrinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lấy id
        TextView titlePtBac2;
        titlePtBac2=findViewById(R.id.tVTitlePtBac2);

        //Set Title phương trình bậc 2
        SpannableString noidungspanned = new SpannableString("x2+bx+c=0");
        noidungspanned.setSpan(new SuperscriptSpan(),1,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        titlePtBac2.setText(noidungspanned);


        //Giải phương trình bậc 1
        try {
            Button btnPtBac1=findViewById(R.id.btnKetQuaBac1);
            btnPtBac1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                      //Lấy EditText số a,b
                      EditText editTextA=findViewById(R.id.eTBac1A);
                      EditText editTextB=findViewById(R.id.eTBac1B);
                      //kiểm tra có giá tri true là ko có,flase là có
                    if(editTextA.getText().toString().isEmpty()==false&&editTextB.getText().toString().isEmpty()==false){
                        double  a=Double.parseDouble(editTextA.getText().toString());
                        double  b=Double.parseDouble(editTextB.getText().toString());
                        //Gọi hàm tính phương trình bậc 1
                        String ketqua=giaiPhuongTrinhBac1(a,b);
                        //Gán kết quả vào text view
                        TextView tVKetqua=findViewById(R.id.tVKetQuaBac1);
                        tVKetqua.setText(ketqua);
                    }
                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //Giải phương trình bậc 2
        try {
            Button btnPtBac2=findViewById(R.id.btnKetQuaBac2);
            btnPtBac2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Lấy EditText số a,b,c
                    EditText editTextA=findViewById(R.id.eTBac2A);
                    EditText editTextB=findViewById(R.id.eTBac2B);
                    EditText editTextC=findViewById(R.id.eTBac2C);
                    //kiểm tra có giá tri true là ko có,flase là có
                    if(editTextA.getText().toString().isEmpty()==false&&editTextB.getText().toString().isEmpty()==false
                            &&editTextC.getText().toString().isEmpty()==false){
                        double a=Double.parseDouble(editTextA.getText().toString());
                        double b=Double.parseDouble(editTextB.getText().toString());
                        double c=Double.parseDouble(editTextC.getText().toString());
                        //Gọi hàm tính phương trình bậc 2
                        String ketqua=giaiPhuongTrinhBac2(a,b,c);
                        //Gắn kết quả vào text view
                        TextView tVKetqua=findViewById(R.id.tVKetQuabac2);
                        tVKetqua.setText(ketqua);
                    }
                }
            });
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    protected String giaiPhuongTrinhBac1(double a,double b){
        if(a==0&&b==0){
            return "vô số nghiệm";
        }else if(a==0&&b!=0){
            return "vô nghiệm";
        }
        return String.valueOf((-b)/a);
    }
    protected  String giaiPhuongTrinhBac2(double a,double b,double c){
            String ketqua;
            if(a==0){
                ketqua= giaiPhuongTrinhBac1(b,c);
            }else{
                if(a+b+c==0){
                    ketqua="x1=1,x2="+String.valueOf(c/a);
                }else if(a-b+c==0){
                    ketqua="x1=-1,x2="+String.valueOf(-c/a);
                }else{
                    double deta=Math.pow(b,2)-4*a*c;
                    if(deta<0){
                        ketqua="vô nghiệm";
                    }else if(deta==0){
                        ketqua="x1=x2="+String.valueOf(-b/(2*a));
                    }else{
                        double x1,x2;
                        x1=(-b+Math.sqrt(deta))/(2*a);
                        x2=(-b-Math.sqrt(deta))/(2*a);
                        ketqua="x1="+String.valueOf(x1)+"\nx2="+String.valueOf(x2);
                    }
                }
            }
            return ketqua;
    }


}