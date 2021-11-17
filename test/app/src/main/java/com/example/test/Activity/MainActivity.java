package com.example.test.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.test.Model.User;
import com.example.test.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //biến màn hình
    ArrayList<User> userArrayList = new ArrayList<>();
    ListView lstView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User("Tai", "123", "Nam", true, false, true, "blabla");
        User user1 = new User("Vinh", "456", "Nam", true, false, true, "bleble");
        userArrayList.add(user);
        userArrayList.add(user1);
        init();
        showListView();
        setEvent();
    }

    /**
     * khởi tạo
     */
    private void init(){
    lstView = findViewById(R.id.lvDSLop);
    }

    /**
     * set event
     */
    private void setEvent(){
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = userArrayList.get(position);
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("USER",user);
                userArrayList.remove(position);
                startActivityForResult(intent,1002);
            }
        });

        lstView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                userArrayList.remove(position);
                showListView();
                return false;
            }
        });
    }

    /**
     * show listview
     */
    private void showListView(){
    if(userArrayList !=null){
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_single_choice,
                convertArrayToString(userArrayList));
        lstView.setAdapter(arrayAdapter);
    }
    }

    private ArrayList<String> convertArrayToString(ArrayList<User> arrayList){
        ArrayList<String> arrayListString = new ArrayList<>();
        for(int i = 0 ; i<arrayList.size();i++){
            String str = arrayList.get(i).toString();
            arrayListString.add(str);
        }
        return arrayListString;
    }
    /**
     * nhận giá trị trả về của màn hình add/ edit
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000){
            if(resultCode == RESULT_CANCELED) {
                User user = (User) data.getSerializableExtra("user");
                userArrayList.add(user);
                showListView();
            }
        }
        else if(requestCode==1002){
            if(resultCode == RESULT_CANCELED) {
                User user = (User) data.getSerializableExtra("user");
                userArrayList.add(user);
                showListView();
            }
        }
    }

    private void chuyenManHinhSave(){
        Intent intent = new Intent(MainActivity.this,AddActivity.class);
        startActivityForResult(intent,1000);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // khi click vao menu add -->AddActivity startActivityForResult
        switch (item.getItemId()){
            case R.id.add:
                chuyenManHinhSave();
                break;
            case R.id.quit:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}