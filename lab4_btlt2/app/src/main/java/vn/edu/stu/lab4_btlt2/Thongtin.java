package vn.edu.stu.lab4_btlt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Thongtin extends AppCompatActivity {

    EditText txtMa,txtTen,txtSDT;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);
        addControls();
        addEvents();
    }

    private void addControls(){
        txtMa = findViewById(R.id.txtMa);
        txtTen = findViewById(R.id.txtTenNV);
        txtSDT= findViewById(R.id.txtSDTNv);
        btnSave = findViewById(R.id.btnSave);
    }

    private void addEvents(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nhanvien nv = getNV();
                returnResult(nv);
            }
        });
    }

    private Nhanvien getNV(){
        String ma = txtMa.getText().toString();
        String ten = txtTen.getText().toString();
        String sdt=txtSDT.getText().toString();
        Nhanvien nv = new Nhanvien(ma,ten,sdt);
        return nv;
    }

    private void returnResult(Nhanvien nv){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("NV",nv);
        setResult(RESULT_OK,returnIntent);
        finish();
    }

}