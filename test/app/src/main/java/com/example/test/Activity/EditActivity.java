package com.example.test.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.test.Model.User;
import com.example.test.R;

public class EditActivity extends AppCompatActivity {

    EditText txtHoTen,txtCMND,txtKhac;
    Button btnSave;
    RadioGroup radioGroup;
    RadioButton radNam,radNu,radKhongXacDinh,radGioiTinh;
    CheckBox chkAn, chkMac, chkChoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        init();
        load();
        setEvent();
    }

    /**
     * khởi tạo
     */
    private void init(){
        txtHoTen = findViewById(R.id.txtHoTen);
        txtCMND = findViewById(R.id.txtCMND);
        radioGroup = findViewById(R.id.id_group);
        chkAn = findViewById(R.id.ckbAnNgon);
        chkMac = findViewById(R.id.ckbMacDep);
        chkChoi = findViewById(R.id.ckbChoiGame);
        txtKhac = findViewById(R.id.txtThongTinKhac);
        btnSave = findViewById(R.id.btn_save);
        radNam = findViewById(R.id.rdbNam);
        radNu = findViewById(R.id.rdbNu);
        radKhongXacDinh = findViewById(R.id.rdbKhongXacDinh);

    }

    private void load(){
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("USER");
        txtHoTen.setText(user.getHoTen());
        txtCMND.setText(user.getCMND());
        if(user.getGioiTinh().equals("Nam"))
            radNam.setChecked(true);
        else if(user.getGioiTinh().equals("Nữ"))
            radNu.setChecked(true);

        txtKhac.setText(user.getMoTa());
        if(user.isAnNgon()) chkAn.setChecked(true);
        if(user.isChoiGame()) chkChoi.setChecked(true);
        if(user.isMacDep())chkMac.setChecked(true);
    }
    /**
     * set event
     */
    private void setEvent(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = getUserEdit();
                returnUserMain(user);
            }
        });
    }


    /**
     * get user edit
     * @return
     */
    private User getUserEdit(){
        User user = new User();
        user.setHoTen(txtHoTen.getText().toString());
        user.setCMND(txtCMND.getText().toString());
        int i = radioGroup.getCheckedRadioButtonId();
        radGioiTinh = findViewById(i);
        user.setGioiTinh(radGioiTinh.getText().toString());
        if(chkAn.isChecked())
            user.setAnNgon(true);
        if(chkChoi.isChecked())
            user.setChoiGame(true);
        if(chkMac.isChecked())
            user.setMacDep(true);
        user.setMoTa(txtKhac.getText().toString());
        return user;
    }

    /**
     * return user và đóng màn hình
     */
    private void returnUserMain(User user){
        Intent intent = new Intent();
        intent.putExtra("user",user);
        setResult(RESULT_CANCELED,intent);
        finish();
    }
}