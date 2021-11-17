package vn.edu.stu.studentinfoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtMSV,txtHoTen,txtNamSinh;
    Button btnGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls(){
        txtMSV = findViewById(R.id.txtMa);
        txtHoTen = findViewById(R.id.txtHoTen);
        txtNamSinh = findViewById(R.id.txtNamSinh);
        btnGui = findViewById(R.id.btnGui);
    }

    private void addEvents(){
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msv = txtMSV.getText().toString();
                String hoTen=txtHoTen.getText().toString();
                int namSinh = Integer.parseInt(txtNamSinh.getText().toString());
                SinhVien sv = new SinhVien(msv,hoTen,namSinh);
                Intent intent = new Intent(MainActivity.this,ThongTinSinhVienActivity.class);
                intent.putExtra("SINHVIEN",sv);
                startActivity(intent);
            }
        });
    }
}