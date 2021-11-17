package vn.edu.stu.tuybiengiaodien;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NhanvienAdapter extends ArrayAdapter<Nhanvien> {

    private Activity context;
    private int resource;
    private List<Nhanvien> objects;

    public NhanvienAdapter(Activity context, int resource,List<Nhanvien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource,null);

        TextView txtMa = item.findViewById(R.id.txtMaNV);
        TextView txtTen = item.findViewById(R.id.txtTen);
        TextView txtSDT = item.findViewById(R.id.txtSDT);

        Nhanvien nv = this.objects.get(position);
        txtMa.setText(nv.getMa());
        txtTen.setText(nv.getTen());
        txtSDT.setText(nv.getSdt());
        return item;
    }
}
