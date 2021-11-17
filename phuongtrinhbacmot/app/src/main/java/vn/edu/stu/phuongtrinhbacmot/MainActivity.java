package vn.edu.stu.phuongtrinhbacmot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtSoA,txtSoB;
    Button btnTim;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls(){
        txtSoA = findViewById(R.id.txtSoA);
        txtSoB = findViewById(R.id.txtSoB);
        btnTim = findViewById(R.id.btnTim);
        txtKetQua = findViewById(R.id.txtKetQua);
    }

    private void addEvents(){
        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(txtSoA.getText().toString());
                double b = Double.parseDouble(txtSoB.getText().toString());
                if(a==0){
                    if(b!=0)txtKetQua.setText("Phương trình vô nghiệm");
                    else txtKetQua.setText("Phương trình có vô số nghiệm");
                }else
                    txtKetQua.setText("Phương trình có nghiệm x= " + (-b/a));
            }
        });
    }
}