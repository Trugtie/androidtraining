package vn.edu.stu.customizelistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Listview
    //Adapter

    ListView listView;
    ArrayList<NhanVien> nhanVienArrayList = new ArrayList<>();
    AdapterNhanVien adapterNhanVien;
    ProgressBar pbLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listview  -> String array, ArrayAdapter, listview

        //customize --> object, ArrayAdapter, listview

        init();
        addEvents();
    }

    private void init() {
        listView = findViewById(R.id.id_listview);
        pbLoad = findViewById(R.id.progressBar);
        NhanVien nv1 = new NhanVien("nv1","bao","03124512");
        NhanVien nv2 = new NhanVien("nv2","chau","3124125");
        nhanVienArrayList.add(nv1);
        nhanVienArrayList.add(nv2);
    }

    /**
     * show list view
     */
    private void showListView() {
        // khởi tạo adapter
        adapterNhanVien = new AdapterNhanVien(MainActivity.this, R.layout.item_layout, nhanVienArrayList);

        // set adapter vào listview
        listView.setAdapter(adapterNhanVien);

        //set action dữ liệu adapter thay đổi tự động cập nhật lisjview
        adapterNhanVien.notifyDataSetChanged();
    }

    private void addEvents(){
        CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int current = pbLoad.getProgress();
                pbLoad.setProgress(current+10);
            }

            @Override
            public void onFinish() {
                showListView();
            }
        };
        countDownTimer.start();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("NhanVien",nhanVienArrayList.get(position));
                intent.putExtra("Pos",position);
                startActivityForResult(intent,1001);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Bạn có thực sự muốn xóa nhân viên không");
                builder.setCancelable(true);
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nhanVienArrayList.remove(position);
                        showListView();
                    }
                });
                AlertDialog alert= builder.create();
                alert.show();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menuAdd:
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent,1000);
                break;
            case R.id.menuExit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000)
        {
            if(resultCode == RESULT_OK){
                NhanVien nv = (NhanVien) data.getSerializableExtra("NhanVien");
                nhanVienArrayList.add(nv);
                showListView();
            }
        }
        else if (requestCode == 1001)
        {
            if(resultCode == RESULT_OK){
                NhanVien nv = (NhanVien) data.getSerializableExtra("NhanVien");
                int position = data.getIntExtra("Pos",-1);
                nhanVienArrayList.get(position).setMaNV(nv.getMaNV());
                nhanVienArrayList.get(position).setTenNV(nv.getTenNV());
                nhanVienArrayList.get(position).setSdt(nv.getSdt());
                showListView();
            }
        }
    }
}