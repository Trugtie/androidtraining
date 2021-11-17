package vn.edu.stu.buoi4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init(){
        Button btnLuu = findViewById(R.id.btnLuu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = getUserModel();
                chuyenManHinh(user);
            }
        });
    }

    private User getUserModel(){
        EditText txtHoTen=findViewById(R.id.txtTen);
        EditText txtCMND=findViewById(R.id.txtCMND);
        RadioButton radNam = findViewById(R.id.radNam);
        RadioButton radNu = findViewById(R.id.radNu);
        RadioButton radKhac = findViewById(R.id.radDiff);
        CheckBox chkAn = findViewById(R.id.chkAn);
        CheckBox chkMac = findViewById(R.id.chkMac);
        CheckBox chkChoi = findViewById(R.id.chkChoi);
        EditText txtThongTin = findViewById(R.id.edtThongTin);
        User user = new User();
        user.setHoTen(txtHoTen.getText().toString());
        user.setCMND(txtCMND.getText().toString());
        if(radNam.isChecked())
            user.setNam(true);
        else if(radNu.isChecked())
            user.setNu(true);
        else if(radKhac.isChecked())
            user.setKhac(true);
        if(chkAn.isChecked())
            user.setAnNgon(true);
        if(chkChoi.isChecked())
            user.setChoiGame(true);
        if(chkMac.isChecked())
            user.setMacDep(true);
        user.setMoTa(txtThongTin.getText().toString());
        return user;
    }

    private void chuyenManHinh(User user){
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }

}