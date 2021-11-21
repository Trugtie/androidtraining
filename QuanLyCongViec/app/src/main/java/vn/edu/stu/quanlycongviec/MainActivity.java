package vn.edu.stu.quanlycongviec;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import vn.edu.stu.quanlycongviec.model.Congviec;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fabThem;
    ArrayAdapter<Congviec> adapter;
    ListView lvCongviec;
    Congviec chon;
    int requestCode=113, resultCode=115;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls(){
        fabThem = findViewById(R.id.fabThem);
        lvCongviec = findViewById(R.id.lvCongvien);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        lvCongviec.setAdapter(adapter);
        chon=null;
    }

    private void addEvents(){
        fabThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemSua.class);
                startActivityForResult(intent,requestCode);
            }
        });

        lvCongviec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position >=0 && position < adapter.getCount()){
                    Intent intent = new Intent(MainActivity.this,ThemSua.class);
                    chon = adapter.getItem(position);
                    intent.putExtra("CHON",chon);
                    startActivityForResult(intent,requestCode);
                }
            }
        });
        lvCongviec.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(position>=0 && position < adapter.getCount()){
                    chon = adapter.getItem(position);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Xác nhận xóa " + chon.getTen());
                    builder.setMessage("Bạn có chắc muốn xóa " + chon.getTen());
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            adapter.remove(chon);
                            adapter.notifyDataSetChanged();
                            dialog.dismiss();
                        }
                    });
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();

                }
                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==this.requestCode){
            if(resultCode==this.resultCode){
                if(data.hasExtra("TRA")){
                    Congviec tra = (Congviec) data.getSerializableExtra("TRA");
                    if(chon==null){
                        adapter.add(tra);
                    }
                    else{
                        chon.setTen(tra.getTen());
                        chon.setHan(tra.getHan());
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        }
        chon=null;
    }
}