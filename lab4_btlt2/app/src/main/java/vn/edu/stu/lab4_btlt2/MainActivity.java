package vn.edu.stu.lab4_btlt2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtMa,txtTen,txtSDT;
    Button btnLuu,btnSua;
    ArrayList<Nhanvien> dsNhanvien;
    NhanvienAdapter adapter;
    ListView lvDSNhanvien;
    int index=-1;
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
        btnSua = findViewById(R.id.btnSua);
        dsNhanvien = new ArrayList<>();
        adapter = new NhanvienAdapter(MainActivity.this,R.layout.item_nhanvien,dsNhanvien);
        lvDSNhanvien = findViewById(R.id.lvNhanVien);
        lvDSNhanvien.setAdapter(adapter);
    }

    private void addEvents(){
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nhanvien nv = new Nhanvien();
                Intent intent = new Intent(MainActivity.this,Thongtin.class);
                startActivityForResult(intent,1000);
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index!=-1){
                    String ma = txtMa.getText().toString();
                    String ten = txtTen.getText().toString();
                    String sdt=txtSDT.getText().toString();
                    Nhanvien nv = new Nhanvien(ma,ten,sdt);
                    Intent intent = new Intent(MainActivity.this,Sua.class);
                    intent.putExtra("NV",nv);
                    intent.putExtra("pos",index);
                    startActivityForResult(intent,1001);
                }
                else{
                    Toast.makeText(MainActivity.this, "Chưa chọn nhân viên cần sửa", Toast.LENGTH_SHORT).show();
                }

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
        lvDSNhanvien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position>=0 && position < dsNhanvien.size()){
                    txtMa.setText(dsNhanvien.get(position).getMa().toString());
                    txtTen.setText(dsNhanvien.get(position).getTen().toString());
                    txtSDT.setText(dsNhanvien.get(position).getSdt().toString());
                    index = position;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000){
            if(resultCode==RESULT_OK){
                Nhanvien nv = (Nhanvien) data.getSerializableExtra("NV");
                dsNhanvien.add(nv);
                adapter.notifyDataSetChanged();
            }
        }
        else if(requestCode==1001){
            if(resultCode==RESULT_OK){
                Nhanvien nv = (Nhanvien) data.getSerializableExtra("NV");
                int pos = data.getIntExtra("pos",-1);
                dsNhanvien.get(pos).setMa(nv.getMa());
                dsNhanvien.get(pos).setTen(nv.getTen());
                dsNhanvien.get(pos).setSdt(nv.getSdt());
                txtMa.setText(nv.getMa().toString());
                txtTen.setText(nv.getTen().toString());
                txtSDT.setText(nv.getSdt().toString());
                adapter.notifyDataSetChanged();
            }
        }
    }
}