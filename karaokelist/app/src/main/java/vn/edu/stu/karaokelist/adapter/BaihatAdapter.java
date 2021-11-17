package vn.edu.stu.karaokelist.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import vn.edu.stu.karaokelist.R;
import vn.edu.stu.karaokelist.model.BaiHat;

public class BaihatAdapter extends ArrayAdapter {

    private int resource;
    private List<BaiHat> baihats;
    private Context activity;

    public BaihatAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.baihats = objects;
        this.activity =  context;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listview_item,null);

        TextView ma =view.findViewById(R.id.txtMa);
        TextView ten =view.findViewById(R.id.txtTen);
        TextView mota = view.findViewById(R.id.txtMoTa);
        ImageButton like =view.findViewById(R.id.btnLike);
        ImageButton dislike =view.findViewById(R.id.btnDislike);
        ImageButton delete =view.findViewById(R.id.btnXoa);

        BaiHat bh = baihats.get(position);

        ma.setText(bh.getMa());
        ten.setText(bh.getTen());
        mota.setText(bh.getMota());
        like.setImageResource(R.drawable.ic_like);
        dislike.setImageResource(R.drawable.ic_dislike);
        delete.setImageResource(R.drawable.ic_delete);
        return view;
    }
}