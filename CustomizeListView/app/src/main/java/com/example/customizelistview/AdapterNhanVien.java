package com.example.customizelistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdapterNhanVien extends ArrayAdapter {

    private int resource;
    private List<NhanVien> nhanViens;
    private Context activity;

    /**
     *
     * @param context  --> activity context
     * @param resource ---> layout items(item_layout.xml)
     * @param objects---> list Nhân viên
     */
    public AdapterNhanVien(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.nhanViens = objects;
        this.activity =  context;
    }



    /**
     *
     * @param position --> vi trí items trong listview
     * @param convertView --> view của items
     * @param parent--> view của lớp cha
     * @return trả tra view của màn hình
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // lấy lớp layout ìnflate
        LayoutInflater layoutInflater = (LayoutInflater)this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_layout,null);

        // tìm id trong items của listview
        TextView maNV =view.findViewById(R.id.mnv);
        TextView tenNV =view.findViewById(R.id.tenNV);
        TextView sdtNV =view.findViewById(R.id.id_sdt);

        // lấy đối tượng nhân viên thông qua vị trí
        NhanVien nv = nhanViens.get(position);


        //set các thuộc tính nhân viên thông qua các textview
        maNV.setText(nv.getMaNV());
        tenNV.setText(nv.getTenNV());
        sdtNV.setText(nv.getSdt());
        return view;
    }
}
