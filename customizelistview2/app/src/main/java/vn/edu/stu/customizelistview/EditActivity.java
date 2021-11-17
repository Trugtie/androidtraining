package vn.edu.stu.customizelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    Button btnAdd;
    EditText edtMa,edtTen,edtSDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        addControls();
        showNhanVien();
        addEvents();
    }

    private void addControls(){
        btnAdd = findViewById(R.id.btnAdd);
        edtMa = findViewById(R.id.edtMa);
        edtTen = findViewById(R.id.edtTen);
        edtSDT = findViewById(R.id.edtSDT);
    }

    private void addEvents(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nv = getNhanVien();
                returnResult(nv);
            }
        });
    }

    private void showNhanVien(){
        Intent intent = getIntent();
        NhanVien nv = (NhanVien) intent.getSerializableExtra("NhanVien");
        edtMa.setText(nv.getMaNV());
        edtTen.setText(nv.getTenNV());
        edtSDT.setText(nv.getSdt());
    }
    private NhanVien getNhanVien(){
        String manv = edtMa.getText().toString();
        String ten = edtTen.getText().toString();
        String sdt = edtSDT.getText().toString();
        NhanVien nv = new NhanVien(manv,ten,sdt);
        return nv;
    }
    private void returnResult(NhanVien nv){
        Intent intent = getIntent();
        int position = intent.getIntExtra("Pos",-1);
        Intent returnIntent = new Intent();
        returnIntent.putExtra("NhanVien",nv);
        returnIntent.putExtra("Pos",position);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}