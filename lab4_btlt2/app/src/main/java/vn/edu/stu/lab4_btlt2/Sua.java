package vn.edu.stu.lab4_btlt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sua extends AppCompatActivity {

    EditText txtMa,txtTen,txtSDT;
    Button btnSave;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);
        addControls();
        getandshowNV();
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
                returnResult(nv,pos);
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

    private void getandshowNV(){
        Intent intent = getIntent();
        Nhanvien nv = (Nhanvien) intent.getSerializableExtra("NV");
        pos = intent.getIntExtra("pos",-1);
        txtMa.setText(nv.getMa());
        txtTen.setText(nv.getTen());
        txtSDT.setText(nv.getSdt());
    }
    private void returnResult(Nhanvien nv,int pos){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("NV",nv);
        returnIntent.putExtra("pos",pos);
        setResult(RESULT_OK,returnIntent);
        finish();
    }


}