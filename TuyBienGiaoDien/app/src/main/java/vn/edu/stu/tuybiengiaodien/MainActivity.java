package vn.edu.stu.tuybiengiaodien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtMa,txtTen,txtSDT;
    Button btnLuu;
    ArrayList<Nhanvien> dsNhanvien;
    NhanvienAdapter adapter;
    ListView lvDSNhanvien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls(){
        txtMa = findViewById(R.id.edtMa);
        txtTen = findViewById(R.id.edtTen);
        txtSDT = findViewById(R.id.edtSDT);
        btnLuu = findViewById(R.id.btnGui);
        dsNhanvien = new ArrayList<>();
        adapter = new NhanvienAdapter(MainActivity.this,R.layout.item_nhanvien,dsNhanvien);
        lvDSNhanvien = findViewById(R.id.lvNhanVien);
        lvDSNhanvien.setAdapter(adapter);
    }

    private void addEvents(){
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = txtMa.getText().toString();
                String ten = txtTen.getText().toString();
                String sdt = txtSDT.getText().toString();
                Nhanvien nv = new Nhanvien(ma,ten,sdt);
                dsNhanvien.add(nv);
                adapter.notifyDataSetChanged();
                txtMa.setText("");
                txtSDT.setText("");
                txtTen.setText("");
                txtMa.requestFocus();
            }
        });
        lvDSNhanvien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(position >= 0 && position < dsNhanvien.size()){
                    Toast.makeText(MainActivity.this,"Nhân viên vừa bị xóa: " + dsNhanvien.get(position).getMa().toString(),Toast.LENGTH_SHORT).show();
                    dsNhanvien.remove(position);
                    adapter.notifyDataSetChanged();
                }
                return false;
            }
        });
    }
}