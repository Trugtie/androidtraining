package com.example.customizelistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Listview
    //Adapter

    ListView listView;
    ArrayList<NhanVien> nhanVienArrayList = new ArrayList<>();
    AdapterNhanVien adapterNhanVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listview  -> String array, ArrayAdapter, listview

        //customize --> object, ArrayAdapter, listview

        init();
        showListView();
    }

    private void init() {
        listView = findViewById(R.id.id_listview);
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
                Intent intent = getIntent();
                NhanVien nv = (NhanVien) intent.getSerializableExtra("NhanVien");
                nhanVienArrayList.add(nv);
                showListView();
            }
        }
    }
}