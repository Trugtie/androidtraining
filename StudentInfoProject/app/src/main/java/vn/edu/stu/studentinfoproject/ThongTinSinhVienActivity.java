package vn.edu.stu.studentinfoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThongTinSinhVienActivity extends AppCompatActivity {

    TextView txtThongTin;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_sinh_vien);
        addControls();
        addEvents();
        getDataFromIntent();
    }

    private void addControls(){
        txtThongTin = findViewById(R.id.txtThongTin);
        btnReturn = findViewById(R.id.btnReturn);
    }

    private void addEvents(){
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getDataFromIntent(){
        Intent intent = getIntent();
        if(intent.hasExtra("SINHVIEN")){
            SinhVien sv = (SinhVien)intent.getSerializableExtra("SINHVIEN");
            txtThongTin.setText(sv.toString());
        }


    }

}