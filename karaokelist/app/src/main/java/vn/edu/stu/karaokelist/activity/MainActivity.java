package vn.edu.stu.karaokelist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.stu.karaokelist.R;
import vn.edu.stu.karaokelist.adapter.BaihatAdapter;
import vn.edu.stu.karaokelist.model.BaiHat;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    BaihatAdapter adapter;
    ArrayList<BaiHat> baiHats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        show();
    }
    private void init(){
        baiHats = new ArrayList<>();
        listView = findViewById(R.id.lstView);
        for(int i = 1; i<=5;i++){
            BaiHat bh = new BaiHat("ms" + i,"bai hat so " + i, "mo ta so " + i);
            baiHats.add(bh);
        }
    }

    private void show(){
        adapter = new BaihatAdapter(MainActivity.this,R.layout.listview_item, baiHats);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}