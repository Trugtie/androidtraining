package vn.edu.stu.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] arrDSLop;
    ArrayAdapter<String> adapter;
    ListView lvDSLop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls(){
        arrDSLop =getResources().getStringArray(R.array.arr_ds_lop);
       for(int i = 0 ; i< arrDSLop.length; i++){
           String replace = arrDSLop[i].replace(" - ","\n");
           arrDSLop[i]=replace;
       }
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_single_choice,arrDSLop);
        lvDSLop = findViewById(R.id.lvDSLop);
        lvDSLop.setAdapter(adapter);
    }

    private void addEvents(){
        lvDSLop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Bạn nhấn một cái tại "+ arrDSLop[position],Toast.LENGTH_SHORT).show();
            }
        });
        lvDSLop.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Bạn nhấn lâu tại "+ arrDSLop[position],Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}