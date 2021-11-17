package vn.edu.stu.buoi4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        Toast.makeText(MainActivity2.this,"Ho ten: " + user.getHoTen(),Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity2.this,"CMND: " + user.getCMND(),Toast.LENGTH_SHORT).show();
        if(user.isNam())
            Toast.makeText(MainActivity2.this,"Gioi tinh: Nam",Toast.LENGTH_SHORT).show();
        else if(user.isNu())
            Toast.makeText(MainActivity2.this,"Gioi tinh: Nữ",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity2.this,"Gioi tinh: Không xác định",Toast.LENGTH_SHORT).show();
        if(user.isAnNgon())
            Toast.makeText(MainActivity2.this,"So thich: An ngon",Toast.LENGTH_SHORT).show();
        if(user.isChoiGame())
            Toast.makeText(MainActivity2.this,"So thich: Choi game",Toast.LENGTH_SHORT).show();
        if(user.isMacDep())
            Toast.makeText(MainActivity2.this,"So thich: Mac dep",Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity2.this,"Thong tin khac: " + user.getMoTa(),Toast.LENGTH_SHORT).show();
    }



}